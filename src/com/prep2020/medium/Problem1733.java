package com.prep2020.medium;
import java.util.*;
public class Problem1733 {
	 /**
    Algorithm:

        1. We will initialize the variable 'minimumUsers' = total users, and it will store the minimum number of users that needs to learn the common language.
        2. Maintain a user Map, which stores users who cannot communicate with their friends.
            Check if users 'user1' and 'user2' shares a common language.
            If both users do not share a common language, then insert both users in the Map.
        3. Iterate thru the list of languages,
            We will set the variable 'totalUsers' as 0, which will store the total number of users need to learn a common languge.
            Iterate it over the user MAP
                Check if the user at it cannot speak a language, then increment 'totalUsers' by 1.
            If 'minimumUsers' is more than 'totalUsers', then update 'minimumUsers' with 'totalUsers'.
        4. Return the variable 'minimumUsers'.

Time Complexity: O(NxM)
	* 	N: number of languages
	* 	M: number of users
Space Complexity: O(NxM)
    **/
    
    
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        //minimumUsers first start with all users
        //and will be updated to store the minimum number of users to teach
        int minimumUsers = friendships.length;
        
        //Map to store User and the Languagues that user can speak. 
        Map<Integer,Set<Integer>> user_languages = new HashMap<>();
        for(int user = 0; user < languages.length; user++) {
            Set<Integer> lst_languages = new HashSet<>();
            for(int language = 0; language < languages[user].length; language++) {
                lst_languages.add(languages[user][language]);
            }
            user_languages.put(user+1, lst_languages); //user+1 because the no. of users start with 1 rather than 0
        }
                        
        //Map to store User and the his friends who he cant communicate with. 
        Map<Integer,Set<Integer>> user_friends = new HashMap<>();
        for(int i = 0; i < friendships.length; i++){
            int[] friends = friendships[i];
            int user1 = friends[0];
            int user2 = friends[1];

            if(!canCommunicate(user_languages.get(user1), user_languages.get(user2))) {
                //store user1 
                user_friends.putIfAbsent(user1, new HashSet<>());
                user_friends.get(user1).add(user2);

                //store user2 
                user_friends.putIfAbsent(user2, new HashSet<>());
                user_friends.get(user2).add(user1);
            }
           
        }

        //loop thru every language and check to see if a user need to learn a common langue
        for(int language = 1; language <= n; language++) {
            //the variable 'totalUsers' as 0, 
            //which will store the total number of users needs to learn a common language
            int totalUsers = 0;
            for(int user : user_friends.keySet()) {
                if(!user_languages.get(user).contains(language)) {
                    totalUsers++;
                } 
            }    
            minimumUsers = Math.min(minimumUsers,totalUsers);
        }    
        return minimumUsers;
        
    }
    
    private boolean canCommunicate(Set<Integer> user1_languages, Set<Integer> user2_languages) {
        for(int user2_language : user2_languages){
            if(user1_languages.contains(user2_language)){
                return true;
            }
        }
        return false;
    }
}
