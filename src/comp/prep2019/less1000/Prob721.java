package comp.prep2019.less1000;
import java.util.*;
public class Prob721 {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
	    List<List<String>> result = new ArrayList<>();
	    if(accounts == null || accounts.size() < 1) return result;
	    Map<String, String> parentMap = new HashMap<>();
	    Map<String, String> owner = new HashMap<>();
	    Map<String, TreeSet<String>> unions = new HashMap<>();
	    for(List<String> account : accounts){
	      for(int i = 1; i < account.size(); i++){
	        parentMap.put(account.get(i), account.get(i));
	        owner.put(account.get(i), account.get(0));
	      }
	    }

	    for(List<String> account : accounts){
	      String parent = find(parentMap, account.get(1));
	      for(int i = 2; i < account.size(); i++){
	        parentMap.put(find(parentMap, account.get(i)), parent);
	      }
	    }
	    for(List<String> account : accounts){
	      String emailId = find(parentMap, account.get(1));
	      if(!unions.containsKey(emailId))unions.put(emailId, new TreeSet<>());
	      for(int i = 1; i < account.size(); i++){
	        unions.get(emailId).add(account.get(i));
	      }
	    }
	    for(String parent : unions.keySet()){
	      List<String> emailIds = new ArrayList<>(unions.get(parent));
	      emailIds.add(0, owner.get(parent));
	      result.add(emailIds);
	    }
	    return result;
	  }

	  public String find(Map<String, String> parent, String emailId){
	    return parent.get(emailId).equals(emailId) ? emailId : find(parent, parent.get(emailId));
	  }
}
