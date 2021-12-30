package P2;

public class InternalClass {
    int m = 0;
class InternalClass2{

}
static class InternalClass3{

}

    public static void main(String[] args) {
        class InternalClass4{
            void run(){
                System.out.println("InternalClass4 run()");
            }
        }
        InternalClass3 internalClass3 = new InternalClass3();

        InternalClass internalClass = new InternalClass();
        InternalClass2 internalClass2 = internalClass.new InternalClass2();

        SomeSubClass someSubClass = makeSomeSubClass();

        someSubClass.launch();
        someSubClass.run();
    }
    static SomeSubClass makeSomeSubClass(){
    return new SomeSubClass(){
        public void launch() {
            System.out.println("InternalClass makeSomeSubClass()");
        }
        public void run() {
            System.out.println("InternalClass run()");
        }
    };
    }
}
    class InternalClass1 {

    }