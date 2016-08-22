package com.testDisruptor.two;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class HandlerInitial implements WorkHandler<LongEvent>{
//public class HandlerInitial implements EventHandler<LongEvent>{
	
	private static int num = 1;
	
	public HandlerInitial() {
		System.out.println("Initial "+num++);
	}
	
//	@Override
//	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
		
//	System.out.println("No1. --> Event: "+event+"; sequence="+sequence+";   endOfBatch="+endOfBatch);
//	}

	public static HandlerInitial[] getHandleList(int size){
		HandlerInitial[] resultHandleList = new HandlerInitial[size];
		for(int i = 0;i<size;i++){
			HandlerInitial one = new HandlerInitial();
			resultHandleList[i] = one;
		}
		return resultHandleList;
	}

	@Override
	public void onEvent(LongEvent event) throws Exception {
		System.out.println(event.getValue()+" No1. --> Event: "+event.getValue());
	}
}
