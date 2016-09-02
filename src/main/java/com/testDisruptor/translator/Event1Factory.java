package com.testDisruptor.translator;

import com.lmax.disruptor.EventFactory;

public class Event1Factory implements EventFactory<Step1Event>{

	@Override
	public Step1Event newInstance() {
		System.out.println("Initiall one!");
		return new Step1Event();
	}
	
	
	
}
