package main;

//�� ������ ��ϵ� �ֽİ����� ��� �迭 prices�� �Ű������� �־��� ��, ������ �������� ���� �Ⱓ�� �� �������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
//
//���ѻ���
//prices�� �� ������ 1 �̻� 10,000 ������ �ڿ����Դϴ�.
//prices�� ���̴� 2 �̻� 100,000 �����Դϴ�.

public class Solution {
	public int[] solution(int[] prices) {
		int target;
        int[] answer = new int[prices.length];
        
        for(int sur = 0 ; sur < prices.length ; sur++){
        	target = prices[sur];
        	
        	for(int roop = sur + 1; roop < prices.length ; roop++){
//        		
//        		//test
//            	System.out.println("target = " + target + ", roop = "+prices[roop]);
        		
        		answer[sur]++;
        		if(target <= prices[roop]){}
        		else if(roop != prices.length - 1 && answer[sur]==1){
        			break;
        		}
        		else{
        			break;
        		}
        	}
//        	
//        	//test
//        	System.out.println("================");
        }
        
//        for(int sur = 0 ; sur < prices.length ; sur++){
//        	System.out.println(answer[sur]);
//        }
        
        return answer;
    }
}
