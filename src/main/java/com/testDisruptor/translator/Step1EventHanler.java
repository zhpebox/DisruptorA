package com.testDisruptor.translator;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import com.testDisruptor.translator2.DisruptorTranslator;
//EventHandler<Step1Event> WorkHandler<Step1Event>
public class Step1EventHanler implements EventHandler<Step1Event>{

	@Override
	public void onEvent(Step1Event event, long seq, boolean arg2)
			throws Exception {
		System.out.println("event = "+ event +" seq = "+seq);
		System.out.println(event.toString());
		DisruptorTranslator disTranslator = new DisruptorTranslator();
		disTranslator.onData(event);
		
	}

//	public void onEvent(Step1Event event) throws Exception {
//		System.out.println("event = "+ event);
//		System.out.println(event.getName());
//		DisruptorTranslator disTranslator = new DisruptorTranslator();
//		disTranslator.onData(event);
//	}

}
