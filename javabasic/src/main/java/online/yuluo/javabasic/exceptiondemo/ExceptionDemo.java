package online.yuluo.javabasic.exceptiondemo;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            test1();
        } catch (ArithmeticException e) {
            System.err.println("1:" + e);
            System.out.println("------------");
            System.err.println("2:" + e.getMessage());
            System.out.println("------------");
            System.err.println("3:" + e.getStackTrace().toString());
            System.out.println("------------");
        }
    }

    static void test1() throws ArithmeticException {
        try {
            int a = 1 / 0;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("除数为零");
        }
    }
}
