package regex;

/**
 * Created by ayanc on 2/13/18.
 */
public class StringMatcher {
  public boolean isTrue(String s) {
    return s.matches("true");
  }

  public boolean isTrueVersion2(String s){
    return s.matches("[tT]rue");
  }

  public boolean isTrueOrYes(String s){
    return s.matches("[tT]rue|[yY]es");
  }

  public boolean containsTrue(String s){
    return s.matches(".*true.*");
  }

  public boolean isThreeLetters(String s){
    return s.matches("[a-zA-Z]{3}");
  }

  public boolean isNoNumberAtBeginning(String s){
    return s.matches("^[^\\d].*");

  }

  public boolean isIntersection(String s){
    return s.matches("([\\w&&[^b]])*");
  }

  public boolean isLessThenThreeHundred(String s){
    return s.matches("[^0-9]*[1,2]?[0-9]{1,2}[^0-9]*");
  }
}

