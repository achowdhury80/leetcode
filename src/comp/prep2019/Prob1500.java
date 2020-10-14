package comp.prep2019;
import java.util.*;
public class Prob1500 {
	private Set<Integer>[] chunkMap;
	private Queue<Integer> unUsed;
	private Map<Integer, Set<Integer>> userChunk;
	
	public Prob1500(int m) {
		chunkMap = new Set[m + 1];
		for (int i = 1; i <= m; i++) {
			chunkMap[i] = new HashSet<>();
        }
		unUsed = new PriorityQueue<>();
		unUsed.offer(1);
		userChunk = new HashMap<>();
    }
    
    public int join(List<Integer> ownedChunks) {
        int id = unUsed.poll();
        if (unUsed.isEmpty()) {
        	unUsed.offer(id + 1);
        }
        userChunk.put(id, new HashSet<>());
        if (ownedChunks != null && !ownedChunks.isEmpty()) {
        	userChunk.get(id).addAll(ownedChunks);       	
        	for (int chunk : ownedChunks) {
    			chunkMap[chunk].add(id);
    		}
    	}
        return id;
    }
    
    public void leave(int userID) {
    	unUsed.offer(userID);
    	Set<Integer> chunks = userChunk.get(userID);
    	if (chunks != null) {
    		for (int chunk : chunks) {
    			chunkMap[chunk].remove(userID);
    		}
    	}
    	userChunk.remove(userID);
    }
    
    public List<Integer> request(int userID, int chunkID) {
    	Set<Integer> set = chunkMap[chunkID];
    	if (set == null || set.isEmpty()) return new ArrayList<>();
    	List<Integer> result = new ArrayList<>(set);
    	Collections.sort(result);
    	set.add(userID);
    	userChunk.get(userID).add(chunkID);
    	return result;
    }
    
    
    public static void main(String[] args) {
    	Prob1500 prob = new Prob1500(4);
    	System.out.println(prob.join(Arrays.asList(1, 2)));
    	System.out.println(prob.join(Arrays.asList(2, 3)));
    	System.out.println(prob.join(Arrays.asList(4)));
    	System.out.println(prob.request(1, 3));
    	System.out.println(prob.request(2, 2));
    	prob.leave(1);
    	System.out.println(prob.request(2, 1));
    	prob.leave(2);
    	System.out.println(prob.join(new ArrayList<>()));
    	
    }
}
