import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("1. e is the most common letter:");
        Task1 t1 = new Task1();
        t1.mostCommon();

        System.out.println();
        System.out.println("2. e is the second most common letter:");
        Task2 t2 = new Task2();
        t2.secondMostCommon();

        System.out.println();
        System.out.println("3. e is the third most common letter:");
        Task3 t3 = new Task3();
        t3.thirdMostCommonLetter();

        System.out.println();
        System.out.println("4. t is the most common letter:");
        Task4 t4 = new Task4();
        t4.mostCommon();
    }
}