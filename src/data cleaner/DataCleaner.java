import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataCleaner {
  // Attributes
  private String fileName;
  File file;
  Scanner scanner;
  StringCleaner stringCleaner;

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
        stringCleaner.cleanString(accumulatedData);
        accumulatedData = currentData;
      } else {
        // Add a space to replace the \n char
        accumulatedData += ' ' + currentData;
      }
    }
    stringCleaner.cleanString(accumulatedData);

    scanner.close();
  }
}
