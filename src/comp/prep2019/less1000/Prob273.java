package comp.prep2019.less1000;

public class Prob273 {
	public String numberToWords(int num) {
        String[] thousands = new String[] {"", "Thousand", "Million", "Billion"};
        String[] under_twenty = new String[] {"", "One", "Two", "Three", "Four",
        		"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
        		"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
        		"Eighteen", "Nineteen"
        		};
        String[] tens = new String[] {"Ten", "Twenty", "Thirty", "Forty", "Fifty",
        		"Sixty", "Seventy", "Eighty", "Ninety"};
        if (num == 0) return "Zero";
        String result = "";
        int thouIndex = -1;
        while(num > 0) {
        	thouIndex++;
        	int rem = num % 1000;
        	num = num / 1000;
        	if (rem == 0) continue;
        	String s = "";
        	int lastTwo = rem % 100;
        	if (lastTwo > 0) {
        		if (lastTwo < 20) {
        			s = under_twenty[lastTwo];
        		} else {
        			s = tens[lastTwo / 10 - 1] + ((lastTwo % 10 == 0) ? "" 
        					: " " + under_twenty[lastTwo % 10]);
        		}
        	}
        	if (rem > 99) {
        		s = under_twenty[(rem /100)] + " Hundred" 
        				+ ("".equals(s) ? "" : " ") + s;
        	}
        	result = s + (thouIndex == 0 ? "" : " ") + thousands[thouIndex] 
        			+ ("".equals(result) ? "" : " ") + result;
        	
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob273 prob = new Prob273();
		System.out.println(prob.numberToWords(1000));
	}
	
	
}
