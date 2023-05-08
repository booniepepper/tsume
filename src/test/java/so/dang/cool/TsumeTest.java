package so.dang.cool;

public class TsumeTest {
    void verifyHello() {
        if (!"Hello World!".equals(new TsumeLib().getMessage())) {
            throw new AssertionError();
        } else {
            System.out.println("Succeeded");
        }
    }

    public static void main(String[] args) {
        new TsumeTest().verifyHello();
    }
}