package edu.helen.other;

public class Producer extends Thread {
	private GoDown goDown;
	private int needNum;

	public Producer() {
		// TODO Auto-generated constructor stub
	}
	
	public Producer(int needNum,GoDown goDown){
		this.goDown = goDown;
		this.needNum = needNum;
	}
	
	public void run(){
		goDown.produce(needNum);
	}

}
