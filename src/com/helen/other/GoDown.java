package com.helen.other;

public class GoDown {
	private static final int MAX_SIZE = 100;
	private int currNum;

	public GoDown() {
		// TODO Auto-generated constructor stub
	}

	public GoDown(int currNum) {
		this.currNum = currNum;
	}

	public synchronized void produce(int needNum) {
		while (currNum + needNum > MAX_SIZE) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currNum += needNum;
			 System.out.println("have produced" + needNum + " products and now storage is " + currNum); 
			notifyAll();
		}
	}

	public synchronized void consume(int needNum) {
		while (currNum < needNum ) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currNum -= needNum;
			 System.out.println("have consumed" + needNum + " products and now storage is " + currNum); 
			notifyAll();
		}
	}

	public static void main(String[] args) {
		 GoDown godown = new GoDown(30); 
         Consumer c1 = new Consumer(50, godown); 
         Consumer c2 = new Consumer(20, godown); 
         Consumer c3 = new Consumer(30, godown); 
         Producer p1 = new Producer(10, godown); 
         Producer p2 = new Producer(10, godown); 
         Producer p3 = new Producer(10, godown); 
         Producer p4 = new Producer(10, godown); 
         Producer p5 = new Producer(10, godown); 
         Producer p6 = new Producer(10, godown); 
         Producer p7 = new Producer(80, godown); 

         c1.start(); 
         c2.start(); 
         c3.start(); 
         p1.start(); 
         p2.start(); 
         p3.start(); 
         p4.start(); 
         p5.start(); 
         p6.start(); 
         p7.start();
	}

}
