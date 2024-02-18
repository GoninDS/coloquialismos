import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataCleaner {
  // Attributes
  private String fileName;
  private File file;
  private Scanner scanner;
  private StringCleaner stringCleaner;
  private CleanFileWriter fileWriter;

  // Constants
  // Allows everything but the Spanish alphabet characters in the sequence
  private final String regex = "[^A-Za-z\\u00C0-\\u00FF ]";
  private final String encoding = "UTF-8";

  // Methods
  public DataCleaner(String fileName) {
    this.fileName = fileName;
    this.stringCleaner = new StringCleaner();
    this.fileWriter = new CleanFileWriter("clean_data.txt", encoding);
  }

  public void cleanFile() {
    try {
      this.file = new File(this.fileName);
      this.scanner = new Scanner(this.file, this.encoding);
      this.processFile();
    } catch (FileNotFoundException exception) {
      System.out.println("An error occurred.");
      exception.printStackTrace();
    }
  }

  private void processFile() {
    String accumulatedData = "";
    String buffer = "";
    
    while (this.scanner.hasNextLine()) {
      String currentData = this.scanner.nextLine();

      if (currentData.startsWith("|")) {
        buffer = stringCleaner.cleanString(accumulatedData, this.regex, true);
        this.fileWriter.write(buffer);
        this.fileWriter.write("\n");
        accumulatedData = currentData;
      } else {
        // Add a space to replace the \n char
        accumulatedData += ' ' + currentData;
      }
    }

    buffer = stringCleaner.cleanString(accumulatedData, this.regex, true);
    this.fileWriter.write(buffer);
    this.fileWriter.write("\n");

    this.fileWriter.closeFile();
    this.scanner.close();
  }
}
