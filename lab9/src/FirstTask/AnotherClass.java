package FirstTask;

public class AnotherClass {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();


        myClass.publicMethod(10);


        for (int i = 0; i < 3; i++) {
            myClass.protectedMethod(i);
        }

        myClass.privateMethod(20);
    }
}

