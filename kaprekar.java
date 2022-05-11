import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class kaprekar {
    public kaprekar() {
        for (int i = 9; i < 65000; i++) {
            int sq = i * i;
            String sqStr = Integer.toString(sq);
            int len = sqStr.length();
            int len2 = len / 2;
            String left = sqStr.substring(0, len2);
            String right  = sqStr.substring(len2);
            int leftInt = Integer.parseInt(left);
            int rightInt = Integer.parseInt(right);
            int sum = leftInt + rightInt;
            if (sum == i) {
                writeFile("number.txt", sum);
            }
        }
        int numLines;
        try {
            numLines = Files.readAllLines(Paths.get("number.txt")).size();
            System.out.println(numLines + " numbers found");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void writeFile(String fileName, int i) {
        try {
            Files.write(Paths.get(fileName), (i + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new kaprekar();
    }

}