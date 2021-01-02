package main;

public class main {

	public static void main(String[] args) {
		Solution test = new Solution();
		
		String[][] input = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(test.solution(input));
		
		String[][] input2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(test.solution(input2));
	}

}
