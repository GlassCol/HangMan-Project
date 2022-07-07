import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Word {
    String wordFilePath ="src/RandomWords";
    String word;

    public String getWord() {
        return word;
    }

    /**
     * Standard constructor for pc generated word. Has access to 115 words
     */
    public Word() {
        ArrayList words = new ArrayList();
       try {
           Stream<String> stream = Files.lines(Paths.get(wordFilePath));
           words = (ArrayList<String>) stream
                   .collect(Collectors.toList());
       }catch(Exception e){System.out.println("File could not be found");}
        Random rng = new Random();
        this.word = (String) words.get(rng.nextInt(words.size()));
    }

    /**
     * alternate constructor for unit testing
     * @param word
     */
    public Word(String word){
        this.word = word;
    }
}
