package main;

import java.util.ArrayList;
import java.util.Collections;

//�ſ� ���� �����ϴ� Leo�� ��� ������ ���ں� ������ K �̻����� ����� �ͽ��ϴ�. ��� ������ ���ں� ������ K �̻����� ����� ���� Leo�� ���ں� ������ ���� ���� �� ���� ������ �Ʒ��� ���� Ư���� ������� ���� ���ο� ������ ����ϴ�.
//
//���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
//Leo�� ��� ������ ���ں� ������ K �̻��� �� ������ �ݺ��Ͽ� �����ϴ�.
//Leo�� ���� ������ ���ں� ������ ���� �迭 scoville�� ���ϴ� ���ں� ���� K�� �־��� ��, ��� ������ ���ں� ������ K �̻����� ����� ���� ����� �ϴ� �ּ� Ƚ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		
public class Solution {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        int target = 0;
        
        int count = 0;
        
        ArrayList<Integer> scovilleArray = new ArrayList<>();
        
        for(int sur = 0 ; sur < scoville.length ; sur++){
        	scovilleArray.add(scoville[sur]);
        }
        
        for(int sur = 0 ; sur < scovilleArray.size() ; sur++){
        	Collections.sort(scovilleArray);
        	
        	//test
        	count++;
        	System.out.println("ȸ�� : " + count + ", scovilleArray : " + scovilleArray);
        	
        	if(scovilleArray.get(sur) < K){
        		scovilleArray.set(sur, (scovilleArray.get(sur) + (2*scovilleArray.get(sur + 1))));
        		scovilleArray.remove(sur + 1);
        		answer++;
        		
        		sur = -1;
        	}
        }
        
        return answer;
    }
}
