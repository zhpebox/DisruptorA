package com.testDisruptor.translator2;

import com.lmax.disruptor.EventFactory;

public class Event2Factory implements EventFactory<Step2Event>{

	@Override
	public Step2Event newInstance() {
		return new Step2Event();
	}

}
