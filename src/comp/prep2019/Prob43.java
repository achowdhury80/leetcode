package comp.prep2019;

public class Prob43 {
	public String multiply(String num1, String num2) {
	    if(num1 == null || num1.equals("0") || num2 == null || num2.equals("0")) return "0";
	    int maxLength = num1.length();
	    int zerosToAdd = 0;
	    if(num2.length() > maxLength){
	      zerosToAdd = num2.length() - num1.length();
	      for(int i = 0; i < zerosToAdd; i++){
	        num1 = '0' + num1;
	      }
	    } else {
	      zerosToAdd = num1.length() - num2.length();
	      for(int i = 0; i < zerosToAdd; i++){
	        num2 = '0' + num2;
	      }
	    }
	    int[] pos = new int[num1.length() + num2.length()];
	    for(int i = num1.length() - 1; i > -1; i-- ){
	      for(int j = num2.length() - 1; j > -1; j--){
	        int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
	        int sum = pos[i + j + 1] + mult;
	        pos[i + j + 1] = sum % 10;
	        pos[i + j] += sum / 10;
	      }
	    }
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < pos.length; i++){
	      if(!(pos[i] == 0 && sb.length() == 0)) sb.append(pos[i]);
	    }
	    return sb.toString();
	  }
}
