import java.util.HashMap;

public class WordPostings {
  // Attributes
  HashMap<Integer, Integer> postings;

  // Methods
  public WordPostings(){
    this.postings = new HashMap<Integer, Integer>();
  }

  public void IncreaseCount(int document) {
    int occurrenceCount = postings.getOrDefault(document, 0);
    this.postings.put(document, ++occurrenceCount);
  }
}
