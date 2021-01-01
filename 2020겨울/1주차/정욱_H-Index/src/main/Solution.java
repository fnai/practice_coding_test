package main;

/*
 * � �����ڰ� ��ǥ�� �� n�� ��, h�� �̻� �ο�� ���� h�� �̻��̰� ������ ���� h�� ���� �ο�Ǿ��ٸ� h�� �ִ��� �� �������� H-Index�Դϴ�.
 *� �����ڰ� ��ǥ�� ���� �ο� Ƚ���� ���� �迭 citations�� �Ű������� �־��� ��, �� �������� H-Index�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 */

public class Solution {
	public int solution(int[] citations) {
        int answer = 0;
        int count1;             //h���̻� �ο�� �� ī��Ʈ
        int count2;             //h������ �ο�� �� ī��Ʈ
        
        //target�� 1���� ����
        for(int target = 1 ; target < citations.length + 1 ; target++){
        	count1 = 0;
        	count2 = 0;
        	
        	//target���̻� �ο����� ī��Ʈ
        	for(int roop = 0 ; roop < citations.length ; roop++){
        		if(target <= citations[roop]){
        			count1++;
        		}
        		else{
        			count2++;
        		}
        	}
        	
        	//target���̻� �ο�� ���� ���� target�� ���ų� ũ��, target������ �ο�� ���� ���� target�� ���ų� ������� answer�� ����
        	if(count1 >= target && count2 <= target){
        		answer = target;
        		
        	}
        }
        
        return answer;
    }
}
