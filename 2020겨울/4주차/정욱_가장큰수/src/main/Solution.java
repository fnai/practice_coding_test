package main;

import java.util.ArrayList;

public class Solution {	
//	//1,3,5,6번 시가노과
//	public String solution(int[] numbers) {
//        String answer = "";
//        int check = 0;
//        
//        ArrayList<String> numString = new ArrayList<>();
//        ArrayList<String> numArray = new ArrayList<>();
//        
//        for(int sur = 0 ; sur < numbers.length ; sur++){
//        	numString.add(Integer.toString(numbers[sur]));
//      	}
//        
//        numArray.add(numString.get(0));
//        
//        for(int sur = 1 ; sur < numString.size() ; sur++){
//        	check = 0;
//        	
//        	for(int roop = 0 ; roop < numArray.size() ; roop++){
//        		if(check == 1){
//        			check = 0;
//        			break;
//        		}
//        		
//        		//마지막위치인경우 start-----------------
//        		if(roop == numArray.size() - 1){
//        			if(numString.get(sur).length() > numArray.get(roop).length()){
//        				
//        				for(int target = 0 ; target < 2 * numString.get(sur).length() ; target++){
//        					
//        					if(numString.get(sur).charAt(target%numString.get(sur).length()) == numArray.get(roop).charAt(target%numArray.get(roop).length())){
//        						if(target == (2*numString.get(sur).length()) - 1){
//        							numArray.add(roop, numString.get(sur));
//        							
//        							check = 1;
//        							break;
//        						}
//        					}
//        					else if(numString.get(sur).charAt(target%numString.get(sur).length()) > numArray.get(roop).charAt(target%numArray.get(roop).length())){
//        						numArray.add(roop, numString.get(sur));
//
//        						check = 1;
//        						break;
//        					}
//        					else{
//        						numArray.add(roop + 1, numString.get(sur));
//        						
//        						check = 1;
//        						break;
//        					}
//        				}
//        			}
//        			
//        			else{
//        				for(int target = 0 ; target < 2 * numArray.get(roop).length() ; target++){
//        					if(numString.get(sur).charAt(target%numString.get(sur).length()) == numArray.get(roop).charAt(target%numArray.get(roop).length())){
//        						if(target == (2*numArray.get(roop).length()) - 1){
//        							numArray.add(roop, numString.get(sur));
//        							
//        							check = 1;
//        							break;
//        						}
//        					}
//        					else if(numString.get(sur).charAt(target%numString.get(sur).length()) > numArray.get(roop).charAt(target%numArray.get(roop).length())){
//        						numArray.add(roop, numString.get(sur));
//        						
//        						check = 1;
//        						break;
//        					}
//        					else{
//        						numArray.add(roop + 1, numString.get(sur));
//        						
//        						check = 1;
//        						break;
//        					}
//        				}
//        			}
//        			break;
//        		}
//        		//마지막위치인경우 end-----------------------
//        		
//        		if(numString.get(sur).length() > numArray.get(roop).length()){
//    				
//        			for(int target = 0 ; target < 2 * numString.get(sur).length() ; target++){
//        				if(numString.get(sur).charAt(target%numString.get(sur).length()) == numArray.get(roop).charAt(target%numArray.get(roop).length())){
//    						if(target == (2*numString.get(sur).length()) - 1){
//    							numArray.add(roop, numString.get(sur));
//    							
//    							check = 1;
//    							break;
//    						}
//    					}
//    					else if(numString.get(sur).charAt(target%numString.get(sur).length()) > numArray.get(roop).charAt(target%numArray.get(roop).length())){
//    						numArray.add(roop, numString.get(sur));
//    						
//    						check = 1;
//    						break;
//    					}
//    					else{
//    						break;
//    					}
//    				}
//    			}
//    			
//    			else{
//    				for(int target = 0 ; target < 2 * numArray.get(roop).length() ; target++){
//    					if(numString.get(sur).charAt(target%numString.get(sur).length()) == numArray.get(roop).charAt(target%numArray.get(roop).length())){
//    						if(target == (2*numArray.get(roop).length()) - 1){
//    							numArray.add(roop, numString.get(sur));
//    							
//    							check = 1;
//    							break;
//    						}
//    					}
//    					else if(numString.get(sur).charAt(target%numString.get(sur).length()) > numArray.get(roop).charAt(target%numArray.get(roop).length())){
//    						numArray.add(roop, numString.get(sur));
//    						
//    						check = 1;
//    						break;
//    					}
//    					else{
//    						break;
//    					}
//    				}
//    			}
//        	}
//        }
//        
//        for(int sur = 0 ; sur < numArray.size() ; sur++){
//    		answer += numArray.get(sur);
//    	}
//        
//        if(numArray.get(0).equals("0")){
//        	return "0";
//        }
//        return answer;
//    }
	
	//1,2,3,5,6 시간초과
	public String solution(int[] numbers) {
        String answer = "";
        
        int max = 0;
        int check = 0;
        
        ArrayList<String> numArray = new ArrayList<>();
        
        numArray.add(Integer.toString(numbers[0]));
        
        for(int sur = 1 ; sur < numbers.length ; sur++){
        	check = 0;
        	
        	for(int target = 0 ; target < numArray.size() ; target++){
        		if(Integer.parseInt(numArray.get(target)+Integer.toString(numbers[sur])) <= Integer.parseInt(Integer.toString(numbers[sur])+numArray.get(target))){
        			numArray.add(target, Integer.toString(numbers[sur]));
        			
        			break;
        		}
        		check++;
        	}
        	
        	if (check == numArray.size()){
				numArray.add(check, Integer.toString(numbers[sur]));
			}
        }
        
        for(int sur = 0 ; sur < numArray.size() ; sur++){
    		answer += numArray.get(sur);
    	}
        
        if(numArray.get(0).equals("0")){
        	return "0";
        }
        	
        return answer;
    }
}
