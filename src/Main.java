
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Main {
    public static void main(String[] args) throws IOException {
        //counters
        int characters = 0;
        int words = 0;
        int lines = 0;

        Scanner fileScanner = null;

        File selectedFile = null;
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            fileScanner = new Scanner(selectedFile);
        }

        while (fileScanner.hasNextLine()) {
            lines++;
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            while(lineScanner.hasNext()) {
                words++;
                String word = lineScanner.next();
                characters += word.length();
            }

            lineScanner.close();
        }

        System.out.println("File Name is: " + selectedFile);
        System.out.println("# of characters is : " + characters);
        System.out.println("# of words is: " + words);
        System.out.println("# of lines is: " + lines);

        fileScanner.close();
    }
}