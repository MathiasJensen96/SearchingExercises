import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Functions {
    public int getValueFromChar(char[] alphabet, char c) {
        int ourValue = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) {
                ourValue = i + 1;
            }
        }
        return ourValue;
    }
    public char getCharFromValue(char[] alphabet, int value) {
        if (value > 26) {
            value = value - 26;

        } else if (value <= 0) {
            value = value + 26;
        }
        char ourChar = alphabet[value - 1];
        return ourChar;
    }

    public char findMostUsedChar(List<String> list) {
        HashMap<Character, Integer> crypt1 = new HashMap<>();
        for (String s: list) {
            for (int i = 0; i < s.length(); i++) {
                if (crypt1.containsKey(s.charAt(i))) {
                    crypt1.put(s.charAt(i), crypt1.get(s.charAt(i)) + 1);
                } else {
                    crypt1.put(s.charAt(i), 1);
                }
            }
        }
        //TODO: Make this a parameter!!!
        char mostComChar = '-';
        int highestValue = 0;
        for (Map.Entry<Character, Integer> set : crypt1.entrySet()) {
            if (set.getValue() > highestValue) {
                mostComChar = set.getKey();
                highestValue = set.getValue();
            }
        }
        //System.out.println("Highest value is " + highest + " which is the letter " + c);
        return mostComChar;
    }

    public char findSecondMostUsedChar(List<String> list) {
        HashMap<Character, Integer> crypt1 = new HashMap<>();
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                if (crypt1.containsKey(s.charAt(i))) {
                    crypt1.put(s.charAt(i), crypt1.get(s.charAt(i)) + 1);
                } else {
                    crypt1.put(s.charAt(i), 1);
                }
            }
        }
        //TODO: Make this a parameter!!!
        char mostComChar = '-';
        int highestValue = 0;
        char secMostComChar = '-';
        int secHighestValue = 0;
        for (Map.Entry<Character, Integer> set : crypt1.entrySet()) {
            if (set.getValue() > highestValue) {
                secMostComChar = mostComChar;
                secHighestValue = highestValue;
                mostComChar = set.getKey();
                highestValue = set.getValue();
            }
        }
        //System.out.println("Highest value is " + highest + " which is the letter " + c);
        return secMostComChar;
    }

    public char findThirdMostUsedChar(List<String> list) {
        HashMap<Character, Integer> crypt = new HashMap<>();
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                if (crypt.containsKey(s.charAt(i))) {
                    crypt.put(s.charAt(i), crypt.get(s.charAt(i)) + 1);
                } else {
                    crypt.put(s.charAt(i), 1);
                }
            }
        }
        //TODO: Make this a parameter!!!
        char mostComChar = '-';
        int highestValue = 0;
        char secMostComChar = '-';
        int secHighestValue = 0;
        char thirdMostComChar = '-';
        int thirdHighestValue = 0;
        for (Map.Entry<Character, Integer> set : crypt.entrySet()) {
            if (set.getValue() > highestValue) {
                thirdMostComChar = secMostComChar;
                thirdHighestValue = secHighestValue;
                secMostComChar = mostComChar;
                secHighestValue = highestValue;
                mostComChar = set.getKey();
                highestValue = set.getValue();
            }
        }
        //System.out.println("Highest value is " + highest + " which is the letter " + c);
        return thirdMostComChar;
    }

    public List<String> decodeCrypt(Character charFromCrypt, Character mostCommonLetter, List<String> list) {
        Functions functions = new Functions();
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int ourValue = functions.getValueFromChar(alphabet, charFromCrypt);
        int targetValue = functions.getValueFromChar(alphabet, mostCommonLetter);

        //Check distance from encoded letter to most common letter in decrypted text
        int dist = ourValue - targetValue;
        //System.out.println("Distance to e = " + dist);

        //Decode crypt
        List<String> decodedCrypt = new ArrayList<>();
        if (dist < 0) {     //This means e is to the left of the most common letter in the encrypted text
            int absDist = Math.abs(dist);

            for (String s: list) {
                String newText = "";
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '.') {
                        newText = newText + ".";
                    } else {
                        int oldValue = functions.getValueFromChar(alphabet, s.charAt(i));
                        int newValue = oldValue + absDist;
                        newText = newText + functions.getCharFromValue(alphabet, newValue);
                    }
                }
                decodedCrypt.add(newText);
            }
        } else if (dist > 0) {      //This means e is to the right of the most common letter in the encrypted text
            for (String s : list) {
                String newText = "";
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '.') {
                        newText = newText + ".";
                    } else if (s.charAt(i) == '!') {
                        newText = newText + "!";
                    } else if (s.charAt(i) == ',') {
                        newText = newText + ",";
                    } else {
                        int oldValue = functions.getValueFromChar(alphabet, s.charAt(i));
                        int newValue = oldValue - dist;
                        newText = newText + functions.getCharFromValue(alphabet, newValue);
                    }
                }
                decodedCrypt.add(newText);
            }
        }
        return decodedCrypt;
    }
}
