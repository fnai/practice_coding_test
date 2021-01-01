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

public class Solution {
	 public String solution(String p) {
	        String answer = "";
	                
	        if(p.length() == 0){
	        	return answer;
	        }
	        answer = fixString(p);
	        
	        return answer;
	    }

	private String fixString(String input) {
		int countLeft = 0;
		int countRight = 0;		
		int check = 0;
		int sur;
		int devide;
		String u = "";
		String v = "";
		String result = "";
		
		if(input.length() == 0){
    		return "";
    	}
    	
		u += input.charAt(0);
		
		if(input.charAt(0) == '('){
			countLeft++;
		}
		else {
			countRight++;
			
			check = 1;
		}
		
    	for(sur = 1 ; sur < input.length() ; sur++){
    		u += input.charAt(sur);
    		
    		if(input.charAt(sur) == '('){
    			countLeft++;
    		}
    		else {
				countRight++;
			}
    		if(countLeft < countRight){
    			check = 1;
    		}
    		else if(countLeft == countRight){
    			break;
    		}
    	}
    	
    	devide = sur + 1;
    	
    	for(sur++ ;sur < input.length() ; sur++){
    		v += input.charAt(sur);
    	}
    	
    	if(check == 1){
    		result += '(';
    		result += this.fixString(v);
    		result += ')';
    		
    		ArrayList<Character> target = new ArrayList<>();
    		
    		for(int roop = 0 ; roop < devide; roop++){
        		target.add(input.charAt(roop));
        	}
    		
    		target.remove(0);
    		target.remove(target.size() - 1);
    		
    		for(int roop = 0 ; roop < target.size(); roop++){
        		if(target.get(roop) == '('){
        			result += ')';
        		}
        		else {
        			result += '(';
    			}
        	}
    	}
    	
    	else{
    		result += u;
    		result += this.fixString(v);
    	}
		
		return result;
	}
}
