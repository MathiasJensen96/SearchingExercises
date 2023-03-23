import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    Functions functions = new Functions();
    public void mostCommon() throws FileNotFoundException {
        ReadFile readFile = new ReadFile();
        Character c = '-';

        //Crypt1
        System.out.println("----------------------------- Crypt1 -----------------------------");
        List<String> crypt1 = new ArrayList<>();
        List<String> crypt1Decoded = new ArrayList<>();

        crypt1 = readFile.fileReader("Crypt1.txt");
        c = functions.findMostUsedChar(crypt1);
        crypt1Decoded = functions.decodeCrypt(c, 'e', crypt1);
        System.out.println(crypt1Decoded);
        System.out.println("------------------------------------------------------------------");


        //Crypt2
        System.out.println("----------------------------- Crypt2 -----------------------------");
        List<String> crypt2 = new ArrayList<>();
        List<String> crypt2Decoded = new ArrayList<>();

        crypt2 = readFile.fileReader("Crypt2.txt");
        c = functions.findMostUsedChar(crypt2);
        crypt2Decoded = functions.decodeCrypt(c, 'e', crypt2);
        System.out.println(crypt2Decoded);
        System.out.println("------------------------------------------------------------------");

        //Crypt3
        System.out.println("----------------------------- Crypt3 -----------------------------");
        List<String> crypt3 = new ArrayList<>();
        List<String> crypt3Decoded = new ArrayList<>();

        crypt3 = readFile.fileReader("Crypt3.txt");
        c = functions.findMostUsedChar(crypt3);
        crypt3Decoded = functions.decodeCrypt(c, 'e', crypt3);
        System.out.println(crypt3Decoded);
        System.out.println("------------------------------------------------------------------");
    }
}
