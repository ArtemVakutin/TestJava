package reflection2;

public class Main1Test {
    public static void main(String[] args) {
        Gear gear = new ManualGear();
        Engine engine = new Engine();
        engine.setPower(200);
        gear.setCount(1);
        gear.setType("Manual");

        Car car = new Car();
        car.setEngine(engine);
        car.setGear(gear);
        System.out.println(car.toString()); // Это один из видов Dependencies Injection. ДЛя маленьких проектов. Он лучше, чем напрямую создавать всякую лабуду в классе Car
    }
}
