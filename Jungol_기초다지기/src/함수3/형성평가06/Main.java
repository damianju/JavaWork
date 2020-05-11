package 함수3.형성평가06;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {
    public String solution(int[] numbers, String hand) {
    	String answer = "";
    	int L = 0;
    	int R = 0;
    			
    		
        for(int i = 0; i < numbers.length; i++) {
        	
        		
        		if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
        			answer += "L";
        			L = numbers[i];
        		} else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
        			answer += "R";
        			R = numbers[i];
        		} else if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 ){
        				if((R== 2||R== 5||R==8) && Math.abs(numbers[i]- R) ==3 ) {
        					R = L;
        				} else if((L== 2||L== 5||L==8) && Math.abs(numbers[i]- L) ==3 ) {
        					L = R;
        				}
        			
        			
        			
	        			if(Math.abs(numbers[i]- L)<Math.abs(numbers[i]- R)) {
	        				answer += "L";
	        				L = numbers[i];
	        			} else if(Math.abs(numbers[i]- L)>Math.abs(numbers[i]- R)) {
	        				answer += "R";
	        				R = numbers[i];
	        			} else { 
	        				if(hand == "right") {
		        				answer += "R";
		        				R = numbers[i];
	        				} else{
	        					answer += "L";
	        					L = numbers[i];
	        				}
	        			}
        				
    			} else if(numbers[i] == 0) {
    				if(Math.abs(numbers[i]- L)>Math.abs(numbers[i]- R)) {
        				answer += "L";
        				L = numbers[i];
        			} else if(Math.abs(numbers[i]- L)<Math.abs(numbers[i]- R)) {
        				answer += "R";
        				R = numbers[i];
        			} else { 
        				if(hand == "right") {
	        				answer += "R";
	        				R = numbers[i];
        				} else {
        					answer += "L";
        					L = numbers[i];
        				}
        			}
    			}
        			
        }
    	
    	
        return answer;
    }
}
