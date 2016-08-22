package com.testDisruptor.two;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class HandlerInitialTwo implements WorkHandler<LongEvent>{
//public class HandlerInitial implements EventHandler<LongEvent>{
	
	private static int num = 1;
	
	public HandlerInitialTwo() {
		System.out.println("Initial2 "+num++);
	}
	
//	@Override
//	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
		
//	System.out.println("No1. --> Event: "+event+"; sequence="+sequence+";   endOfBatch="+endOfBatch);
//	}

	public static HandlerInitialTwo[] getHandleList(int size){
		HandlerInitialTwo[] resultHandleList = new HandlerInitialTwo[size];
		for(int i = 0;i<size;i++){
			HandlerInitialTwo one = new HandlerInitialTwo();
			resultHandleList[i] = one;
		}
		return resultHandleList;
	}

	@Override
	public void onEvent(LongEvent event) throws Exception {
		System.out.println(event.getValue()+" No2. --> Event: "+event.getValue());
	}
}
