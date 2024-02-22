import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordReader {
  // Attributes
  private String fileName;
  private File file;
  private Scanner scanner;
  private String[] words;
  private int currentWord;
  private int currentLine;

  // Constants
  private final String encoding = "UTF-8";

  // Methods
  public WordReader(String filename) {
    // Start at -1 so that it will be set to 0 in the readNextLine method
    this.currentLine = -1;
    this.currentWord = -1;
    try {
      this.fileName = filename;
      this.file = new File(this.fileName);
      this.scanner = new Scanner(this.file, this.encoding);
      // Read the first line of the file
      this.readNextLine();
    } catch (FileNotFoundException exception) {
      System.out.println("An error occurred.");
      exception.printStackTrace();
    }
  }

  public String nextWord() {
    if (this.currentWord == this.words.length) {
      this.readNextLine();
    }
    // If there is a current word, return it
    return (this.currentWord != -1) ? this.words[this.currentWord++] : "";
  }

  private void readNextLine() {
    // Assume that there are no more lines
    this.currentWord = -1;
    if (this.scanner.hasNextLine()) {
      this.updateWordsArray();  
    }
  }

  private void updateWordsArray() {
    String line = this.scanner.nextLine().trim(); 
    this.words = line.split(" +");
    this.currentWord = 0;
    ++this.currentLine;
  }

  public int getCurrentLine() {
    return this.currentLine;
  }
}
