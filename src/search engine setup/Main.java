public class Main {
  public static void main(String arg[]){
    WordReader reader = new WordReader("../../data/clean_data.txt");
    String answer = reader.nextWord();
    while (!answer.equals("")) {
      System.out.print("Current line: ");
      System.out.println(reader.getCurrentLine());
      System.out.println(answer);
      System.out.println();
      answer = reader.nextWord();
    }
  }    
}
