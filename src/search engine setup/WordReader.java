import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordReader {
  // Attributes
  private String fileName;
  private File file;
  private Scanner scanner;

  // Constants
  private final String encoding = "UTF-8";

  // Methods
  public WordReader(String filename) {
    try {
      this.fileName = filename;
      this.file = new File(this.fileName);
      this.scanner = new Scanner(this.file, this.encoding);
    } catch (FileNotFoundException exception) {
      System.out.println("An error occurred.");
      exception.printStackTrace();
    }
  }

  public String nextWord() {
    return this.scanner.hasNext() ? this.scanner.next() : "";
  }
}
