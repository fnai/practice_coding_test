package main;

//������ ��� A�� �ʱ�ȭ�Ǿ�����

/*
�� - ���� ���ĺ�
�� - ���� ���ĺ� (A���� �Ʒ������� �̵��ϸ� Z��)
�� - Ŀ���� �������� �̵� (ù ��° ��ġ���� �������� �̵��ϸ� ������ ���ڿ� Ŀ��)
�� - Ŀ���� ���������� �̵�
*/

/*
- ù ��° ��ġ���� ���̽�ƽ�� ���� 9�� �����Ͽ� J�� �ϼ��մϴ�.
- ���̽�ƽ�� �������� 1�� �����Ͽ� Ŀ���� ������ ���� ��ġ�� �̵���ŵ�ϴ�.
- ������ ��ġ���� ���̽�ƽ�� �Ʒ��� 1�� �����Ͽ� Z�� �ϼ��մϴ�.
���� 11�� �̵����� "JAZ"�� ���� �� �ְ�, �̶��� �ּ� �̵��Դϴ�.
 */

class Solution {
    public int solution(String name) {
    	char[] nameArray = name.toCharArray();
    	
        int answer = 0;				//return ��
        int checkTriger = 0;        //���ӵ� A���� Ȯ���ϴ� ����. 1�̸� ������, 0�̸� �������� �ƴ�
        int returnCheck = 0;        //�������� �ǵ��� ���°��� �� ���� �� A�� ������ �̾����ִ��� index�� üũ
        int countHold = 0;          //A�� ��� ���޾� ���Դ��� �����ϴ� ����
        int countA = 0;             //A�� ��� ���޾� ���Դ��� üũ�ϴ� ����
        int sur = 0;                //index Ȯ��
        
        for(char checkChar : nameArray){
        	answer += this.calChar(checkChar);
        	
        	//-----------------���̽�ƽ �¿� Ƚ�� ���---------
        	if(checkChar == 'A' && checkTriger < 2){
        		checkTriger = 1;
        		countA++;
        	}
        	else if(checkChar != 'A' && checkTriger == 1){
        		checkTriger = 0;
        		
        		if(countA >= sur - countA){
					returnCheck = sur - 1;
					
					countHold = countA;
				}
        		
        		countA = 0;
        	}
        	//--------------------------------------
        	
        	
        	sur++;
        }
       
        answer += name.length() - 1 - countHold + (returnCheck - countHold);
        
        return answer;
    }
    
    //���̽�ƽ ���Ʒ� Ƚ�� ���
    public int calChar(char checkChar){
    	int answer = 0;
    	
    	if(checkChar < 79){
			answer = (checkChar - 65);
		}
		else{
			answer = (90 - checkChar) + 1;
		}
    	
    	return answer;
    }
}

/*
 �빮��A = 65
 �߰��� = 77.5
 �빮��Z = 90
 */

/*
 
 baab
 
 
 */

