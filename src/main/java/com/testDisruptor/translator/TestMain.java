package com.testDisruptor.translator;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.testDisruptor.two.LongEvent;

public class TestMain {
	public static void main(String[] args) {
		Disruptor1Factory factory1 = new Disruptor1Factory();
		Disruptor<Step1Event> disruptor = factory1.getDisruptor1();
		RingBuffer<Step1Event> ringbuffer = disruptor.getRingBuffer();

		for(int i=0;i<1;i++){
			long seq = ringbuffer.next();
			try {
				Step1Event step1 = ringbuffer.get(seq);
				step1.setId(68+i);
				step1.setName("zhp");
			} finally {
				ringbuffer.publish(seq);
			}
		}
		disruptor.shutdown();
		
	}
}
