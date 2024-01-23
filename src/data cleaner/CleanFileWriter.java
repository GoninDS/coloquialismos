import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CleanFileWriter {
  // Attributes
  private File file;
  private FileOutputStream outputStream;
  private OutputStreamWriter writer;

  // Methods
  public CleanFileWriter(String filename) {
    try {
      this.file = new File(filename);
      this.outputStream = new FileOutputStream(this.file);
      this.writer = new OutputStreamWriter(this.outputStream, "UTF-8");
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void closeFile() {
    try {
      this.writer.close();
      this.outputStream.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void write(String content) {
    try {
      this.writer.write(content);
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
