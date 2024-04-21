package FirstTask;

public class MyClass {

    @Repeat(value = 3)
    public void publicMethod(int param) {
        System.out.println("Public method: " + param);
    }


    protected void protectedMethod(int param) {
        System.out.println("Protected method: " + param);
    }

    private void privateMethod(int param) {
        System.out.println("Private method: " + param);
    }
}

