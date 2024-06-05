import java.lang.reflect.Method;

public class Invoker {

    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass();
        invokeAnnotatedMethods(myClass);
    }

    public static void invokeAnnotatedMethods(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(InvokeTimes.class)) {
                InvokeTimes annotation = method.getAnnotation(InvokeTimes.class);
                int times = annotation.value();
                method.setAccessible(true);

                for (int i = 0; i < times; i++) {
                    if (method.getParameterCount() == 1) {
                        if (method.getParameterTypes()[0] == int.class) {
                            method.invoke(obj, 42);  // Пример параметра
                        } else if (method.getParameterTypes()[0] == String.class) {
                            method.invoke(obj, "Hello");  // Пример параметра
                        }
                    }
                }
            }
        }
    }
}
