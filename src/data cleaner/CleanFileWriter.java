import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CleanFileWriter {
  // Attributes
  private File file;
  private FileWriter fileWriter;

  // Methods
  public CleanFileWriter(String filename) {
    try {
      this.file = new File(filename);
      if (this.file.createNewFile()) {
        System.out.println("File created: " + this.file.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void openFile() {
    try {
      this.fileWriter = new FileWriter(this.file.getName());
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void closeFile() {
    try {
      this.fileWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void write(String content) {
    try {
      this.fileWriter.write(content);
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
