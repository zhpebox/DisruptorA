package com.testDisruptor.translator;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class Disruptor1Factory {

	// 执行器，用于构造消费者线程Executors.newCachedThreadPool()newSingleThreadExecutor;
	public Executor executor = Executors.newCachedThreadPool();
	// 事件工厂
	public Event1Factory event1Factory = new Event1Factory();

	// 指定ringbuffer大小
	private int bufferSize = 4;//
	// 指定消费者数量
	private int numberofconsumer = 2;

	public Disruptor<Step1Event> disruptor;
	
	public Disruptor<Step1Event> getDisruptor1(){
		if(disruptor==null){
			newInstance();
		}
		return disruptor;
	}
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public void newInstance() {
//		disruptor = new Disruptor<Step1Event>(
//				event1Factory, bufferSize, executor, ProducerType.SINGLE,
//				new YieldingWaitStrategy());
		//test java8
		disruptor = new Disruptor<Step1Event>(Step1Event::new, bufferSize, executor);
		

//		Step1EventHanler[] step1EventHandlers = new Step1EventHanler[numberofconsumer];
		Step1EventHanler step1EventHandler = new Step1EventHanler();
		
		disruptor.handleEventsWith(step1EventHandler);
		//test java8
//		disruptor.handleEventsWith((event,sequence,endOfBatch)->System.out.println("Eventa:"+event));
		
		
		disruptor.start();

		System.out.println("step1 disruptor start……");

	}
	
	
}
