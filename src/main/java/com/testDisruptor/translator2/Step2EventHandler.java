package com.testDisruptor.translator2;

import com.lmax.disruptor.EventHandler;

public class Step2EventHandler implements EventHandler<Step2Event>{

	@Override
	public void onEvent(Step2Event event, long seq, boolean arg2)
			throws Exception {
		System.out.println("step2 event = "+ event +" seq = "+seq);
		System.out.println(event.toString());	
	}

}
