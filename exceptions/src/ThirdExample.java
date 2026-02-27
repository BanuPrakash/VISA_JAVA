import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;

public class ThirdExample {
    public static void main(String[] args) throws FileNotFoundException {
        Comparator
        System.out.println("Start");
        first();
        System.out.println("End");
    }

    private static void first() throws FileNotFoundException {
        System.out.println("First");
        second();
        System.out.println("End First");
    }

    private static void second() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("a.txt");
    }
}
