package comp.prep2019.less1000;

public class Prob824 {
	public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        String[] arr = S.split(" ");
        StringBuilder append = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
        	append.append('a');
        	if ("aeiou".indexOf(Character.toLowerCase(arr[i].charAt(0))) > -1) {
        		sb.append(arr[i] + "ma");
        	} else {
        		sb.append(arr[i].substring(1) + arr[i].charAt(0) + "ma");
        	}
        	sb.append(append.toString());
        	sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
