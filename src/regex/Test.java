package regex;

/**
 * Created by ayanc on 2/13/18.
 */
public class Test {
  public static void main(String[] args) {
    String str = "this is good  , i must learn this   .";
    System.out.println(str.replaceAll("(\\w)(\\s+)([\\.,])", "$1$3"));

  }
}
