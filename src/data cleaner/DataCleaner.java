import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataCleaner {
  // Attributes
  private String fileName;
  private File file;
  private Scanner scanner;
  private StringCleaner stringCleaner;
  private final String regex = "[^A-Za-z]";

  // Methods
  public DataCleaner(String fileName) {
    this.fileName = fileName;
    this.stringCleaner = new StringCleaner();
  }

  public void cleanFile() {
    try {
      this.file = new File(this.fileName);
      this.scanner = new Scanner(file);
      this.processFile();
    } catch (FileNotFoundException exception) {
      System.out.println("ERROR: File not found " + fileName);
      exception.printStackTrace();
    }
  }

  private void processFile() {
    String accumulatedData = "";

    while (scanner.hasNextLine()) {
      String currentData = scanner.nextLine();

      if (currentData.startsWith("|")) {
        System.out.println(stringCleaner.cleanString(accumulatedData, this.regex));
        accumulatedData = currentData;
      } else {
        // Add a space to replace the \n char
        accumulatedData += ' ' + currentData;
      }
    }
    System.out.println(stringCleaner.cleanString(accumulatedData, this.regex));

    scanner.close();
  }
}
