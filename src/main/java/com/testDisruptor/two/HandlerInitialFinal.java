package com.testDisruptor.two;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class HandlerInitialFinal implements WorkHandler<LongEvent>{
//public class HandlerInitial implements EventHandler<LongEvent>{
	
	private static int num = 1;
	
	public HandlerInitialFinal() {
		System.out.println("Initial3 "+num++);
	}
	
//	@Override
//	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
		
//	System.out.println("No1. --> Event: "+event+"; sequence="+sequence+";   endOfBatch="+endOfBatch);
//	}

	public static HandlerInitialFinal[] getHandleList(int size){
		HandlerInitialFinal[] resultHandleList = new HandlerInitialFinal[size];
		for(int i = 0;i<size;i++){
			HandlerInitialFinal one = new HandlerInitialFinal();
			resultHandleList[i] = one;
		}
		return resultHandleList;
	}

	@Override
	public void onEvent(LongEvent event) throws Exception {
		System.out.println(event.getValue()+" No3. --> Event: "+event.getValue());
	}
}
