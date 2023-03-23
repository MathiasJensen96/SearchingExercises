import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {
    public List<String> fileReader(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        List<String> list = new ArrayList<>();

        while (input.hasNext()) {
            list.add(input.next());
        }
        //System.out.println(list);
        return list;
    }
}