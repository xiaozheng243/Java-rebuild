package javabasic;

public class EnumTest {
    public static void main(String[] args) {
        EnumDemo enumDemo = EnumDemo.DONE;
        System.out.println(enumDemo.ordinal());
        System.out.println(enumDemo.name());
    }
}
