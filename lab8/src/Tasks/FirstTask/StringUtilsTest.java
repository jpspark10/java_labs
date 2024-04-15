package Tasks.FirstTask;

public class StringUtilsTest {
    public static void stringUtilsCheck(){
        String str1 = "Hello";
        String str2 = "";
        System.out.println("word: " + str1);
        System.out.println("StringUtils.isNotNull().test(str1): " + StringUtils.isNotNull().test(str1));
        System.out.println("StringUtils.isNotEmpty().test(str1): " + StringUtils.isNotEmpty().test(str1));
        System.out.println("StringUtils.isNotNullAndNotEmpty().test(str1): " + StringUtils.isNotNullAndNotEmpty().test(str1));

        System.out.println("word: " + str2);
        System.out.println("StringUtils.isNotNull().test(str2): " + StringUtils.isNotNull().test(str2));
        System.out.println("StringUtils.isNotEmpty().test(str2): " + StringUtils.isNotEmpty().test(str2));
        System.out.println("StringUtils.isNotNullAndNotEmpty().test(str2): " + StringUtils.isNotNullAndNotEmpty().test(str2));


    }
}
