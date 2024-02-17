import java.util.HashMap;

public class WordPostings {
  // Attributes
  HashMap<Integer, Integer> postings;

  // Methods
  public WordPostings(){
    this.postings = new HashMap<Integer, Integer>();
  }

  public void IncreaseCount(int document) {
    int occurrenceCount = 1;
    // Update the occurrence count if it has already been inserted
    if (this.postings.containsKey(document)) {
      occurrenceCount = this.postings.get(document);
      ++occurrenceCount;
    }
    this.postings.put(document, occurrenceCount);
  }
}
