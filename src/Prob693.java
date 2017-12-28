/**
 * Created by ayanc on 10/20/17.
 */
public class Prob693 {
  public boolean hasAlternatingBits(int n) {
    if(n < 2) return true;
    int x = n % 2 == 0 ? 1 : 0;
    while(n > 1){
      if(n % 2 == x){
        return false;
      }
      x = n % 2;
      n = n / 2;
    }
    if(n == x) return false;
    return true;
  }

  public static void main(String[] args){
    Prob693 prob693 = new Prob693();
    System.out.println(prob693.hasAlternatingBits(5));
    System.out.println(prob693.hasAlternatingBits(7));
    System.out.println(prob693.hasAlternatingBits(11));
    System.out.println(prob693.hasAlternatingBits(10));
  }
}
