package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class main_misc {

	

	
	public static void main(String[] args) {
	
		List<Integer> l0 = new ArrayList<>(Arrays.asList(0,1,0,1));
		List<Integer> l1 = new ArrayList<>(Arrays.asList(1,1,1,0));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(1,0,1,0));
		List<Integer> l3 = new ArrayList<>(Arrays.asList(1,1,1,1));
	
		List<List<Integer>> m = new ArrayList<>(Arrays.asList(l0,l1,l2,l3));
		
		max_square(m);
		
		
		//System.out.println(valid_square(m,1,0,3));
		
	}
	private static boolean valid_square(List<List<Integer>> matrix,int a,int b,int n){
		
		
		//avoid out of bounds
		
		if(a+n > matrix.size() || b+n > matrix.get(0).size()){
			return false;
		}
		
		
		//(a,b) --> (a,b+(n-1))
		for(int i = b;i < b+n;i++){
			if(matrix.get(a).get(i) == 0){
				return false;
			}
		}
		
		//(a,b) --> (a+n-1,b)
		for(int i = a;i < a+n;i++){
			
			if(matrix.get(i).get(b) == 0){
				return false;
			}
		}
		
		//(a,b+(n-1)) --> (a+(n-1),b+(n-1))
		for(int i = a;i < a+n;i++){
			
			if(matrix.get(i).get(b+(n-1)) == 0){
				return false;
			}
				
		}
		
		//(a+(n-1),b) --> (a+(n-1),b+(n-1))
		for(int i = b;i < b+n;i++){
			
			if(matrix.get(a+(n-1)).get(i) == 0) {
				return false;
			}
			
		}
		return true;
		
	}
	
	private static List<List<Integer>> max_square(List<List<Integer>> matrix){
		
		int n = matrix.size();
		
		int a = -1;
		int b = -1;
		
		int c = n;
		boolean go = true;
		while(c >= 1 && go){
			
			for(int i = 0;i < n;i++){
				for(int j = 0;j < n;j++){
					
					if(matrix.get(i).get(j) != 0){
						if(valid_square(matrix,i,j,c)){
							a = i;
							b = j;
							go = false;
						}
					}
					
				}
			}
			c--;
		}
		
		
		if(a == -1 || b == -1) {
			return null;
		}
		
		
		List<List<Integer>> square = new ArrayList<>();
		
		for(int i = a;i <= a+c;i++){
			square.add(new ArrayList<>());
			for(int j = b;j <= b+c;j++){
				square.get(i-a).add(matrix.get(i).get(j));
			}
		}
		
		
		for(int i = 0;i < square.size();i++){
			System.out.println(square.get(i));
		}
		
		return square;
		
	}
	
}
