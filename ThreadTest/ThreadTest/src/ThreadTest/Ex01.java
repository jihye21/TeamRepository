package ThreadTest;

import java.util.Iterator;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long beforeTime = System.currentTimeMillis();
		int sum = 0;
		for(int i = 0; i <300000; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime)/1000;
		System.out.println("시간차이: " + secDiffTime);
	}

}
