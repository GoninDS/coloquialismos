import java.util.TreeMap;

public class SearchEngineSetup {
  // Attributes
  private WordReader reader;
  private TreeMap<String, WordPostings> tree;

  // Constants
  private final int MAX_WORDS = 15;
  // For debugging purposes in VS Code replace with data/clean_data.txt 
  private final String FILE_PATH = "../../data/clean_data.txt";

  // Methods
  public SearchEngineSetup(){
    this.reader = new WordReader(this.FILE_PATH);
    this.tree = new TreeMap<String, WordPostings>();
  }

  public void run() {
    for (int i = 0; i < this.MAX_WORDS; ++i) {
      String word = this.reader.nextWord();
      int document = this.reader.getCurrentLine();
      WordPostings postings;
      if (this.tree.containsKey(word)) {
        postings = this.tree.get(word);
      } else {
        postings = new WordPostings();
      }
      postings.InsertPosting(document);
      this.tree.put(word, postings);
    }
  }
}
