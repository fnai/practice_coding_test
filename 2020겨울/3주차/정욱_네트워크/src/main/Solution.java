package main;

import java.util.ArrayList;

//��Ʈ��ũ�� ��ǻ�� ��ȣ ���� ������ ��ȯ�� �� �ֵ��� ����� ���¸� �ǹ��մϴ�.
//���� ���, ��ǻ�� A�� ��ǻ�� B�� ���������� ����Ǿ��ְ�, ��ǻ�� B�� ��ǻ�� C�� ���������� ����Ǿ� ���� �� ��ǻ�� A�� ��ǻ�� C�� ���������� ����Ǿ� ������ ��ȯ�� �� �ֽ��ϴ�.
//���� ��ǻ�� A, B, C�� ��� ���� ��Ʈ��ũ �� �ִٰ� �� �� �ֽ��ϴ�.

//��ǻ���� ���� n, ���ῡ ���� ������ ��� 2���� �迭 computers�� �Ű������� �־��� ��, ��Ʈ��ũ�� ������ return �ϵ��� solution �Լ��� �ۼ��Ͻÿ�.

//���ѻ���
//��ǻ���� ���� n�� 1 �̻� 200 ������ �ڿ����Դϴ�.
//�� ��ǻ�ʹ� 0���� n-1�� ������ ǥ���մϴ�.
//i�� ��ǻ�Ϳ� j�� ��ǻ�Ͱ� ����Ǿ� ������ computers[i][j]�� 1�� ǥ���մϴ�.
//computer[i][i]�� �׻� 1�Դϴ�.


public class Solution {
	
	//������ bfs�� ����. bfs�� ��ġ�鼭 checkComputer�� �鷶���� �ȵ鷶���� üũ, �ȵ鸥���� bfs�� �ٽ� �����Ͽ� ���ο� ��Ʈ��ũ�� ���.
	//check�� �̹� 1�̶�� �� ���� ������ �̹� �� ����Ȱ͵��� üũ �Ǿ����Ƿ� ���� Ȯ�� ���ص� ��
	public int solution(int n, int[][] computers) {
        int answer = 0;
        int targetComputer;
        int[] checkComputer = new int[n];
        ArrayList<Integer> queueComputer = new ArrayList<>();
        
        //�迭Ȯ��
        //this.checkMatrix(n, computers);
        
        for(int sur = 0 ; sur < n ; sur++){
        	if(checkComputer[sur] == 0){
        		checkComputer[sur] = 1;
        		
        		for(int roop = 0 ; roop < n ; roop++){
        			//check�� �̹� 1�̶�� �� ���� ������ �̹� �� üũ�� �Ǿ������Ƿ� ���� Ȯ�� ���ص� ��
        			if(computers[sur][roop] == 1 && checkComputer[roop] == 0){
        				checkComputer[roop] = 1;
        				queueComputer.add(roop);
        			}
        		}
        		        		
        		while(!queueComputer.isEmpty()){
        			targetComputer = queueComputer.get(0);
        			queueComputer.remove(0);
        			
        			for(int roop = 0 ; roop < n ; roop++){
        				if(roop == targetComputer){
        					//computer[i][i]�� ��� üũ ���ϰ� �н�
        				}
        				else if(computers[targetComputer][roop] == 1 && checkComputer[roop] == 0){
            				checkComputer[roop] = 1;
            				queueComputer.add(roop);
            			}
            		}
        		}
        		
        		answer++;
        	}
        }
        return answer;
    }
	
	//�Էµ� �迭 Ȯ��
	public void checkMatrix(int n, int[][] computers){
		for(int sur = 0 ; sur < n ; sur++){
        	for(int roop = 0 ; roop < n ; roop++){
        		System.out.print(computers[sur][roop]+" ");
        	}
        	System.out.println();
        }
	}
}
