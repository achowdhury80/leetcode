package regex;

import java.util.stream.IntStream;

/**
 * Created by ayanc on 2/13/18.
 */
public class RegexTestStrings {
  public static final String EXAMPLE_TEST = "This is my small  example "
      + "string which I'm going to " + "use for pattern matching.";
  public static void main(String[] args) {
    System.out.println(EXAMPLE_TEST.matches("\\w.*"));
    String[] arr = EXAMPLE_TEST.split("\\s+");
    IntStream.range(0, arr.length).forEach(x -> System.out.print( arr[x] + ","));
    System.out.println();
    String st = EXAMPLE_TEST.replaceAll("\\s+", "\t");
    System.out.println(st);
  }
}
