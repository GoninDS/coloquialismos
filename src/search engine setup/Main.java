public class Main {
  public static void main(String arg[]){
    WordReader reader = new WordReader("testdata.txt");
    String answer = "a";
    while (!answer.equals("")) {
      answer = reader.nextWord();
      System.out.print("Current line: ");
      System.out.println(reader.getCurrentLine());
      System.out.println(answer);
      System.out.println();
    }
  }    
}
