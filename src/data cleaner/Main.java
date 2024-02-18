public class Main{
  public static void main(String arg[]){
    DataCleaner cleaner = new DataCleaner("../../data/corpus.txt");
    cleaner.cleanFile();
  }
}