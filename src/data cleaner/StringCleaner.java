import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCleaner {
  // Methods
  public StringCleaner() {}

  public String cleanString(String dirtyString, String regex) {
    // Return an empty string if the string is empty
    if (dirtyString.equals("")) {
      return "";
    }

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(dirtyString);

    return matcher.replaceAll("");
  }

  public String cleanString(String dirtyString, String regex, boolean lowerCase) {
    String cleanString = this.cleanString(dirtyString, regex);
    return lowerCase ? cleanString : cleanString.toLowerCase();
  }
}