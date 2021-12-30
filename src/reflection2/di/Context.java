package reflection2.di;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import reflection2.Car;
import reflection2.Gear;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

import static reflection2.di.ValueType.REF;
import static reflection2.di.ValueType.VALUE;

public class Context {
    Map<String, Object> objectByID = new HashMap<>();
    List<Bean> beans = new ArrayList<>();


    public Context(String xmlPath) throws IOException, SAXException, ParserConfigurationException, InvalidConfigurationException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
        parseOurXml(xmlPath);
        instantiateBeans();

    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, InvalidConfigurationException, IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchFieldException {

        Class<?> aClass = Class.forName("reflection2.Gear");
        System.out.println(aClass.getDeclaredField("type").getType().getSimpleName());
        Context context = new Context("src/reflection2/di/config.xml");
        System.out.println(context.beans);
        Set<String> strings = context.objectByID.keySet();
        for (String str : strings) {
            System.out.println(context.objectByID.get(str));
        }

    }

    private Object getBean(String beanName) {
        return objectByID.get(beanName);
    }

    private void parseOurXml(String xmlPath) throws IOException, SAXException, ParserConfigurationException, InvalidConfigurationException {
        DOMParser parser = new DOMParser(); //Можно через другие парсеры. Например, через DocumentBuilderFactory.newInstance().newDocumentBuilder().parse
        parser.parse(xmlPath);
        Document document = parser.getDocument();
//        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlPath);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if ("bean" == node.getNodeName()) {
                parseBean(node);
            }
        }
    }

    private void parseBean(Node bean) throws InvalidConfigurationException {
        NamedNodeMap attributes = bean.getAttributes();
        String id = "";
        String className = "";
        Map<String, Property> properties = new HashMap<>();
        for (int i = 0; i < attributes.getLength(); i++) {//можно обойтись без цикла. Просто через id.getNamedItem("имя айтема"), возвращает Node
            Node node = attributes.item(i);
            if (node.getNodeName().equals("id")) {
                id = node.getNodeValue();
            } else if (node.getNodeName().equals("class")) {
                className = node.getNodeValue();
            } else {
                throw new InvalidConfigurationException("Node name failed");
            }
        }
        NodeList childNodes = bean.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if ("property" == node.getNodeName()) {
                Property property = parseProperty(node);
                properties.put(property.getName(), property);
            }
        }
        beans.add(new Bean(id, className, properties));
    }

    private Property parseProperty(Node property) throws InvalidConfigurationException {
        NamedNodeMap attributes = property.getAttributes();
        String name = "";
        String value = "";
        ValueType valueType = VALUE;
        for (int i = 0; i < attributes.getLength(); i++) {
            Node node = attributes.item(i);
            if (node.getNodeName().equals("name")) {
                name = node.getNodeValue();
            } else if (node.getNodeName().equals("value")) {
                value = node.getNodeValue();
                valueType = VALUE;
            } else if (node.getNodeName().equals("ref")) {
                value = node.getNodeValue();
                valueType = ValueType.REF;
            } else {
                throw new InvalidConfigurationException("Node name failed");
            }
        }
        return new Property(name, value, valueType);
    }

    private void instantiateBeans() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, InvalidConfigurationException {
        for (Bean bean : beans) {
            System.out.println(bean);
            Class<?> aClass = Class.forName((bean.getClassName()));
            Object object = aClass.newInstance();
            objectByID.put(bean.getClassName(), object);
//            processingAnnotations(aClass, objectByID.get(bean.getClassName()));
            for (String id : bean.getProperties().keySet()) {
                Field field = getField(aClass, id);
                if (field == null) {
                    throw new InvalidConfigurationException("No such field");
                }
                field.setAccessible(true);

                Property property = bean.getProperties().get(id);
                if (property.getType() == VALUE) {
//                    field.set(object, property.getValue());//Вот это не катит, ибо тип данных Object
                    System.out.println(field.getType().getSimpleName());
                    field.set(object, convertType(field.getType().getSimpleName(), property.getValue()));
                } else if (property.getType().equals(ValueType.REF)) {
                    if (property.getType() == REF) {
                        field.set(object, objectByID.get(property.getValue()));
                    } else {
                        throw new InvalidConfigurationException("Invalid Class Tree" + id);
                    }
                } else {
                    throw new InvalidConfigurationException("No such ValueType");
                }

            }
            processingAnnotations(aClass, objectByID.get(bean.getClassName()));
        }

    }

    private void processingAnnotations(Class<?> aClass, Object instance) throws InvalidConfigurationException, IllegalAccessException {
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Auto.class)) {
                Auto auto = field.getAnnotation(Auto.class);
                if (auto.isRequired()) {
                    if (field.getType().isInstance(objectByID.get(field.getType().getName()))) {
                        Object ob = objectByID.get(field.getType().getName());
                        field.setAccessible(true);
                        field.set(instance, ob);
//                        System.out.println("---------" + instance);
//                        System.out.println("---------" + ob);
                    } else if (checkType(field)) {
                        Object ob = objectByID.get("reflection2.ManualGear");
                        field.setAccessible(true);
                        field.set(instance, ob);
                        System.out.println("---------" + instance);
                        System.out.println("---------" + ob);
                    }
                }


            }
        }

    }

    private boolean checkType(Field field) {
        String name = field.getType().getSimpleName();
        for (Bean bean : beans) {
            if (bean.getId().equals(name)) {
                if (objectByID.containsKey(bean.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }


    private Object convertType(String typeName, String value) throws InvalidConfigurationException {
        String name = "String";
        if (typeName.equals("int") | typeName.equals("Integer")) {
            return Integer.valueOf(value);
        } else if (typeName.equals("Boolean") | typeName.equals("boolean")) {
            return Boolean.valueOf(value);
        } else if (typeName.equals("char") || typeName.equals("Character")) {
            return value.charAt(0);
        } else if (typeName.equals("String")) {
            return value; //todo
        } else {
            throw new InvalidConfigurationException("Invalid type");
        }
    }

    private Field getField(Class<?> aClass, String property) throws NoSuchFieldException {
        try {
            return aClass.getDeclaredField(property);
        } catch (NoSuchFieldException e) {
            if (aClass.getSuperclass() == null) {
                throw e;
            } else {
                return getField(aClass.getSuperclass(), property);
            }
        }
    }


}
