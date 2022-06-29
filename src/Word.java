import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Word {
    String wordFilePath ="src/RandomWords";
    Scanner scanner = new Scanner(wordFilePath);
    String word;

    public String getWord() {
        return word;
    }

    /**
     * Standard constructor for pc generated word has access to 115 words
     */
    public Word() {
        ArrayList<String> words = new ArrayList();
       try {
           Stream<String> stream = Files.lines(Paths.get(wordFilePath));
           words = (ArrayList<String>) stream
                   .collect(Collectors.toList());
       }catch(Exception e){System.out.println("File could not be found");}
        Random rng = new Random();
        this.word = words.get(rng.nextInt(words.size()));
    }
}
