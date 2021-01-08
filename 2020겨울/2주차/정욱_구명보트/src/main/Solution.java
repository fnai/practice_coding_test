package main;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public int solution(int[] people, int limit) {
        int answer = 0;
        int weight = 0;
        
        ArrayList<Integer> sortPeople = new ArrayList<>();
        
        for(int sur = 0; sur < people.length ; sur++){
        	sortPeople.add(people[sur]);
        }
        
        sortPeople.sort(Collections.reverseOrder());
        
        for(int sur = 0 ; sur < sortPeople.size() ; sur++){
        	weight = sortPeople.get(0);
        	sortPeople.remove(0);
        	sur--;
        	
        	for(int roop = 0 ; roop < sortPeople.size() ; roop++){
        		if((weight + sortPeople.get(roop)) <= limit){
        			sortPeople.remove(roop);
        			
        			break;
        		}
        	}
        	answer++;
        }
        
        return answer;
    }
}
