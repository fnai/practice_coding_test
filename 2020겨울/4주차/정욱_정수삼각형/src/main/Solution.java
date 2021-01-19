package main;


//위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다.
//아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.
//
//삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.
//
//제한사항
//삼각형의 높이는 1 이상 500 이하입니다.
//삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.


public class Solution {
	public int solution(int[][] triangle) {
        int answer = 0;
        int height = 0;
        
        height = triangle.length;
        
        //맨 아랫줄부터 인접한 두개씩 크기 비교를 한 후 큰놈을 중간위에거에 더하는 것을 반복, 결과적으로 triangle[0][0]에 더했을때 가장 큰 값이 저장됨
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
