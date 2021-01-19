package main;


//���� ���� �ﰢ���� ����⿡�� �ٴڱ��� �̾����� ��� ��, ���İ� ������ ���� ���� ū ��츦 ã�ƺ����� �մϴ�.
//�Ʒ� ĭ���� �̵��� ���� �밢�� �������� �� ĭ ������ �Ǵ� �������θ� �̵� �����մϴ�. ���� ��� 3������ �� �Ʒ�ĭ�� 8 �Ǵ� 1�θ� �̵��� �����մϴ�.
//
//�ﰢ���� ������ ��� �迭 triangle�� �Ű������� �־��� ��, ���İ� ������ �ִ��� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
//
//���ѻ���
//�ﰢ���� ���̴� 1 �̻� 500 �����Դϴ�.
//�ﰢ���� �̷�� �ִ� ���ڴ� 0 �̻� 9,999 ������ �����Դϴ�.


public class Solution {
	public int solution(int[][] triangle) {
        int answer = 0;
        int height = 0;
        
        height = triangle.length;
        
        //�� �Ʒ��ٺ��� ������ �ΰ��� ũ�� �񱳸� �� �� ū���� �߰������ſ� ���ϴ� ���� �ݺ�, ��������� triangle[0][0]�� �������� ���� ū ���� �����
        for(int sur = height - 1 ; sur >= 0 ; sur--){
        	for(int roop = 0 ; roop < sur ; roop++){
        		if(triangle[sur][roop] < triangle[sur][roop+1]){
        			triangle[sur - 1][roop] += triangle[sur][roop+1];
        		}
        		else{
        			triangle[sur - 1][roop] += triangle[sur][roop];
        		}
        	}
        }
        
        answer = triangle[0][0];
        
        return answer;
    }
}
