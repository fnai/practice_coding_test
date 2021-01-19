package main;

import java.util.ArrayList;

public class Solution {
	//첫 숫자로 먼저 1~9까지 배분을 하고 이후에  정렬 로직을 사용하여 큰 수 찾기
	public String solution(int[] numbers) {
        String answer = "";
        
        ArrayList<String> numString = new ArrayList<>();
        
        ArrayList<String>[] numArray = new ArrayList[9];
        
        for(int sur = 0 ; sur < 9 ; sur++){
        	numArray[sur] = new ArrayList<>();
        }
        
        for(int sur = 0 ; sur < numbers.length ; sur++){
        	numString.add(Integer.toString(numbers[sur]));
        }
        
        for(int sur = 0 ; sur < numString.size() ; sur++){
        	System.out.println(numString.get(sur).charAt(0) - 49 +", "+ numString.get(sur).charAt(0));
        	numArray[numString.get(sur).charAt(0) - 49].add(numString.get(sur));
        }
        
        for(int sur = 8 ; sur >= 0 ; sur--){
        	if(numArray[sur].isEmpty()){
        		continue;
        	}
        	
        	//정렬하는 로직이 들어가야함;;
        	//----------------
        	//----------------
        	
        	for(int roop = 0 ; roop < numArray[sur].size() ; roop++){
        		answer += numArray[sur].get(roop);
        	}
        }
        
        return answer;
    }
}
