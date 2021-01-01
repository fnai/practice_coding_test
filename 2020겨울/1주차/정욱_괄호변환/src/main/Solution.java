package main;

import java.util.ArrayList;


//'(' 와 ')' 로만 이루어진 문자열이 있을 경우, '(' 의 개수와 ')' 의 개수가 같다면 이를 균형잡힌 괄호 문자열이라고 부릅니다.
//그리고 여기에 '('와 ')'의 괄호의 짝도 모두 맞을 경우에는 이를 올바른 괄호 문자열이라고 부릅니다.

/*
1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
  4-3. ')'를 다시 붙입니다. 
  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
  4-5. 생성된 문자열을 반환합니다.
*/

class Solution {
    public String solution(String p) {
        String answer = "";
        
        char[] input = p.toCharArray();
        
        if(input.length == 0){
        	System.out.println("0임니다");
        	return answer;
        }
        answer = fixString(p);
        
        return answer;
    }
    
    //String 재배열 함수
    public String fixString(String input){
    	int checkLength = 0;          //길이 체크
    	ArrayList<Character> target = new ArrayList<>();
    	ArrayList<Character> result = new ArrayList<>();
    	ArrayList<Character> split = new ArrayList<>();
    	String giveSplit = "";
    	String output = "";
    	String answer = "";
    	
    	if(input.length() == 0){
    		return "";
    	}
    	
    	for(int sur = 0 ; sur < input.length(); sur ++){
    		target.add(input.charAt(sur));
    		result.add('?');
    		split.add(input.charAt(sur));
    	}
    	
    	if(input.charAt(0) == ')'){
    		checkLength = 0;
    		
    		ArrayList<Character> newSplit = new ArrayList<>();
    		
    		for(int sur = 0 ; sur < input.length() ; sur++){
        		newSplit.add(input.charAt(sur));
        	}
    		split.set(0, '(');
    		split.set(input.length() - 1, ')');
    		result.set(0, '(');
    		result.set(result.size() - 1, ')');
    		newSplit.remove(newSplit.size() - 1);
    		newSplit.remove(0);
    		
    		for(int sur = 0 ; sur < newSplit.size() ; sur++){
    			if(newSplit.get(sur) == '('){
    				giveSplit += ')';
    			}
    			else if(newSplit.get(sur) == ')'){
    				giveSplit += '(';
    			}
        	}
        	
        	output = fixString(giveSplit);
        	
        	for(int sur = 0 ; sur < result.size() ; sur ++){
        		if(result.get(sur) == '?'){
        			result.set(sur, output.charAt(checkLength));
        			
        			checkLength++;
        		}
        	}
        	
    		for(int sur = 0 ; sur < input.length() ; sur++){
        		answer += result.get(sur);
        	}
    		
    		return answer;
    	}
    	
    	for(int sur = 0 ; sur < input.length() - 1 ; sur ++){
    		if(target.get(sur) == '(' && target.get(sur + 1) == ')'){
    			split.remove(sur - checkLength);
    			split.remove(sur - checkLength);
    			
    			result.set(sur, target.get(sur));
    			result.set(sur + 1, target.get(sur + 1));
    			
    			checkLength += 2;
    			sur++;
    		}
    	}
    	
    	checkLength = 0;
    	
    	for(int sur = 0 ; sur < split.size() ; sur++){
    		giveSplit += split.get(sur);
    	}
    	
    	output = fixString(giveSplit);
    	
    	for(int sur = 0 ; sur < input.length() ; sur ++){
    		if(result.get(sur) == '?'){
    			result.set(sur, output.charAt(checkLength));
    			
    			checkLength++;
    		}
    	}
    	
    	for(int sur = 0 ; sur < input.length() ; sur++){
    		answer += result.get(sur);
    	}
    	return answer;
    	
    }
    
//  //test함수
//  public String fixString(String input){
//  	ArrayList<Character> result = new ArrayList<>();
//  	String answer = "";
//  	
//  	for(int sur = 0 ; sur < input.length() ; sur++){
//  		result.add(input.charAt(sur));
//  	}
//  	
//  	result.remove(0);
//  	result.remove(0);
//  	
//  	for(int sur = 0 ; sur < result.size() ; sur++){
//  		answer += result.get(sur);
//  	}
//  	
//  	return answer;
//  }
    
}