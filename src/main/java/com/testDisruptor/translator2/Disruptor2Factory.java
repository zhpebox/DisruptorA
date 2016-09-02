package com.testDisruptor.translator2;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class Disruptor2Factory {

	// 执行器，用于构造消费者线程
	public static Executor executor = Executors.newCachedThreadPool();
	// 事件工厂
	public static Event2Factory event2Factory = new Event2Factory();
	// 指定ringbuffer大小
	private int bufferSize = 2 ^ 3;
	// 指定消费者数量
	private int numberofconsumer = 2;

	Disruptor<Step2Event> disruptor;

	public Disruptor<Step2Event> startDis2() {
		if (disruptor == null) {
			newInstance();
		}
		return disruptor;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public void newInstance() {
		disruptor = new Disruptor<Step2Event>(event2Factory, bufferSize,
				executor, ProducerType.SINGLE, new YieldingWaitStrategy());

//		Step2EventHandler[] step2EventHandlers = new Step2EventHandler[numberofconsumer];
		Step2EventHandler step2EventHandlers = new Step2EventHandler();
		
		disruptor.handleEventsWith(step2EventHandlers);
		disruptor.start();

		System.out.println("step2 disruptor start……");

	}
}
