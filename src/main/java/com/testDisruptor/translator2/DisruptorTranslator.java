package com.testDisruptor.translator2;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.testDisruptor.translator.Step1Event;

public class DisruptorTranslator {

	Disruptor2Factory dis2factory = new Disruptor2Factory();
	
	private static final EventTranslatorOneArg<Step2Event, Step1Event> translator = 
			new EventTranslatorOneArg<Step2Event, Step1Event>() {
		
		@Override
		public void translateTo(Step2Event step2, long arg1, Step1Event step1) {
			step2.setId(step1.getId());
			step2.setName(step1.getName());
			step2.setMessage("传输成功");
		}
	};
	
	public void onData(Step1Event event1){
		Disruptor<Step2Event> disruptor2 = dis2factory.startDis2();
		RingBuffer<Step2Event> ringBuffer = disruptor2.getRingBuffer();
//		ringBuffer.publishEvent(translator, event1);
		//test java8
		ringBuffer.publishEvent((event,sequence,buffer)->event.setMessage("sss"));
		disruptor2.shutdown();
	}
	
}
