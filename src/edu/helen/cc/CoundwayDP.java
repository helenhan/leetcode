package edu.helen.cc;

public class CoundwayDP {

	public CoundwayDP() {
		// TODO Auto-generated constructor stub
	}

	public static int coundwaydp(int n, int[] map) {
		/*
		if (n < 0) {
			System.out.println("n==-1");
			return 0;
		} else if (n == 0) {
			System.out.println("n==0");
			return 1;
		} else if (map[n] > -1) {
			System.out.println("map[" + n + "]:" + map[n]);
			return map[n];
		} else {
			map[n] = coundwaydp(n - 1, map) + coundwaydp(n - 2, map)
					+ coundwaydp(n - 3, map);
			System.out.println("count map[" + n + "]:" + map[n]);
			return map[n];
		}*/
		
		
		if (n < 0) {
			 return 0;
			 } else if (n == 0) {
			 return 1;
			 } else if (map[n] > -1) {
			 return map[n];
			 } else {
			 map[n] = coundwaydp(n - 1, map) +
					 coundwaydp(n - 2, map) +
			 coundwaydp(n - 3, map);
			return map[n];
			 }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] map = new int[1024];
		int number = CoundwayDP.coundwaydp(7, map);
		System.out.println("result : " + number);
	}

}
