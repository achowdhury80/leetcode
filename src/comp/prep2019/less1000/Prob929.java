package comp.prep2019.less1000;
import java.util.*;
public class Prob929 {
	/**
	 * O(N)
	 * @param emails
	 * @return
	 */
	public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
        	int atIndex = -1;
        	String domain = email.substring((atIndex = email.indexOf('@')));
        	String localName = email.substring(0, atIndex);
        	int plusIndex = localName.indexOf('+');
        	if(plusIndex > -1) localName = localName.substring(0, plusIndex);
        	localName = localName.replaceAll("\\.", "");
        	set.add(localName + domain);
        }
        return set.size();
    }	
	
	public static void main(String[] args) {
		Prob929 prob = new Prob929();
		System.out.println(prob.numUniqueEmails(new String[] 
				{"testemail@leetcode.com","testemail1@leetcode.com",
						"testemail+david@lee.tcode.com"}));
	}
}
