package edu.helen.other;

public class Consumer extends Thread {
	private GoDown goDown;
	private int needNum;

	public Consumer() {
		// TODO Auto-generated constructor stub
	}
	
	public Consumer(int needNum,GoDown goDown){
		this.goDown = goDown;
		this.needNum = needNum;
	}
	
	public void run(){
		goDown.consume(needNum);
	}

}
