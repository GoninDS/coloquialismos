import java.util.TreeMap;

public class SearchEngineSetup {
  // Attributes
  private WordReader reader;
  private TreeMap<String, WordPostings> tree;

  // Constants
  private final int MAX_WORDS = 10;

  // Methods
  public SearchEngineSetup(){
    this.reader = new WordReader("../data/corspus.txt");
    this.tree = new TreeMap<String, WordPostings>();
  }

  public void run() {
    for (int i = 0; i < MAX_WORDS; ++i) {
      String word = reader.nextWord();
      int document = reader.getCurrentLine();

    }
  }
}
