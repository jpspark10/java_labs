public class MyClass {

    // Публичные методы
    public void publicMethod1() {
        System.out.println("Public Method 1");
    }

    public void publicMethod2() {
        System.out.println("Public Method 2");
    }

    // Защищённые методы
    @InvokeTimes(3)
    protected void protectedMethod1(int param) {
        System.out.println("Protected Method 1 with param: " + param);
    }

    @InvokeTimes(2)
    protected void protectedMethod2(int param) {
        System.out.println("Protected Method 2 with param: " + param);
    }

    // Приватные методы
    @InvokeTimes(4)
    private void privateMethod1(String message) {
        System.out.println("Private Method 1 with message: " + message);
    }

    @InvokeTimes(1)
    private void privateMethod2(String message) {
        System.out.println("Private Method 2 with message: " + message);
    }
}
