import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataCleaner {
  // Attributes
  private String fileName;
  File file;
  Scanner scanner;

  // Methods
  public DataCleaner(String fileName) {
    this.fileName = fileName;
  }

  public void cleanFile() {
    try {
      this.file = new File(this.fileName);
      this.scanner = new Scanner(file);
      this.readFile();
    } catch (FileNotFoundException exception) {
      System.out.println("ERROR: File not found " + fileName);
      exception.printStackTrace();
    }
  }

  private void readFile() {
    while (scanner.hasNextLine()) {
      String currentData = scanner.nextLine();
      System.out.println(currentData);
    }
    scanner.close();
  }
}
