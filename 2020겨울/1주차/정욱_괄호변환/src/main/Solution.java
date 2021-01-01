package main;

import java.util.ArrayList;


//'(' �� ')' �θ� �̷���� ���ڿ��� ���� ���, '(' �� ������ ')' �� ������ ���ٸ� �̸� �������� ��ȣ ���ڿ��̶�� �θ��ϴ�.
//�׸��� ���⿡ '('�� ')'�� ��ȣ�� ¦�� ��� ���� ��쿡�� �̸� �ùٸ� ��ȣ ���ڿ��̶�� �θ��ϴ�.

/*
1. �Է��� �� ���ڿ��� ���, �� ���ڿ��� ��ȯ�մϴ�. 
2. ���ڿ� w�� �� "�������� ��ȣ ���ڿ�" u, v�� �и��մϴ�. ��, u�� "�������� ��ȣ ���ڿ�"�� �� �̻� �и��� �� ����� �ϸ�, v�� �� ���ڿ��� �� �� �ֽ��ϴ�. 
3. ���ڿ� u�� "�ùٸ� ��ȣ ���ڿ�" �̶�� ���ڿ� v�� ���� 1�ܰ���� �ٽ� �����մϴ�. 
  3-1. ������ ��� ���ڿ��� u�� �̾� ���� �� ��ȯ�մϴ�. 
4. ���ڿ� u�� "�ùٸ� ��ȣ ���ڿ�"�� �ƴ϶�� �Ʒ� ������ �����մϴ�. 
  4-1. �� ���ڿ��� ù ��° ���ڷ� '('�� ���Դϴ�. 
  4-2. ���ڿ� v�� ���� 1�ܰ���� ��������� ������ ��� ���ڿ��� �̾� ���Դϴ�. 
  4-3. ')'�� �ٽ� ���Դϴ�. 
  4-4. u�� ù ��°�� ������ ���ڸ� �����ϰ�, ������ ���ڿ��� ��ȣ ������ ����� �ڿ� ���Դϴ�. 
  4-5. ������ ���ڿ��� ��ȯ�մϴ�.
*/

class Solution {
    public String solution(String p) {
        String answer = "";
        
        char[] input = p.toCharArray();
        
        if(input.length == 0){
        	System.out.println("0�Ӵϴ�");
        	return answer;
        }
        answer = fixString(p);
        
        return answer;
    }
    
    //String ��迭 �Լ�
    public String fixString(String input){
    	int checkLength = 0;          //���� üũ
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
    
//  //test�Լ�
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