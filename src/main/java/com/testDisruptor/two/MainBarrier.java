package com.testDisruptor.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.Sequencer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * 多消费者并行，串行
 * @author Administrator
 *
 */
public class MainBarrier {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//启动Disruptor
		EventFactory<LongEvent> eventFactory = new LongEventFactory();
		
		/*
		 *  Disruptor 通过 java.util.concurrent.ExecutorService 提供的线程来触发 Consumer 的事件处理。例如：
		 *	ExecutorService executor = Executors.newCachedThreadPool();
		 */
		ExecutorService executor = Executors.newCachedThreadPool();//newSingleThreadExecutor();
//		int ringBufferSize = 1024 * 1024; // RingBuffer 大小，必须是 2 的 N 次方；
		int ringBufferSize = 8;
		
		Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory,
		                ringBufferSize, executor, ProducerType.SINGLE,
		                new YieldingWaitStrategy());
		/*
		 * 指定等待策略
		 * BlockingWaitStrategy 是最低效的策略，但其对CPU的消耗最小并且在各种不同部署环境中能提供更加一致的性能表现；
		 * SleepingWaitStrategy 的性能表现跟 BlockingWaitStrategy 差不多，对 CPU 的消耗也类似，但其对生产者线程的影响最小，适合用于异步日志类似的场景；
		 * YieldingWaitStrategy 的性能是最好的，适合用于低延迟的系统。在要求极高性能且事件处理线数小于 CPU 逻辑核心数的场景中，推荐使用此策略；例如，CPU开启超线程的特性。
		 * WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
		 * WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
		 * WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();
		 */ 
		        
//		EventHandler<LongEvent> eventHandler = new LongEventHandler();
//		disruptor.handleEventsWith(eventHandler);
//		disruptor.handleEventsWithWorkerPool(HandlerInitial.getHandleList(4));//
		
		//1、2并行，随机执行一个
		EventHandlerGroup<LongEvent> eventHandleGroup = disruptor.handleEventsWithWorkerPool(HandlerInitial.getHandleList(2)[0],HandlerInitialTwo.getHandleList(2)[0]);
//		disruptor.handleEventsWithWorkerPool(HandlerInitial.getHandleList(1));
		//与53行并行,无先后顺序
//		EventHandlerGroup<LongEvent> eventHandleGroup = disruptor.handleEventsWithWorkerPool(HandlerInitialTwo.getHandleList(1));
		

		//与53行串行,有先后顺序
		eventHandleGroup.thenHandleEventsWithWorkerPool(HandlerInitialFinal.getHandleList(1));
		
		
		disruptor.start();
		System.out.println("start");
		//发布事件
		/*
		 * Disruptro的事件发布过程是一个两阶段提交的过程
		 * 1. 先从RingBuffer获取下一个可以写入的事件的序号
		 * 2. 获取对应的事件对象，将数据写入事件对象
		 * 3. 将事件提交到RingBuffer
		 * 事件只有在提交之后才会通知EventProcessor进行处理
		 * 
		 *  注意，最后的 ringBuffer.publish 方法必须包含在 finally 中以确保必须得到调用；
		 *  如果某个请求的 sequence 未被提交，将会堵塞后续的发布操作或者其它的 producer。
		 */
		RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
		for(int i =0;i<100;i++){
			
			long sequence = ringBuffer.next(); //请求下一个事件序号
//			System.out.println(sequence);
			try{
				LongEvent event = ringBuffer.get(sequence); //获得该序号对应的事件对象
				long data = i+1; //获取要通过事件传递的业务数据
				event.set(data);
			}finally{
				ringBuffer.publish(sequence); //发布事件
			}
		
		}
		//关闭 Disruptor
		disruptor.shutdown();//关闭 disruptor，方法会堵塞，直至所有的事件都得到处理；
		executor.shutdown();//关闭 disruptor 使用的线程池；如果需要的话，必须手动关闭， disruptor 在 shutdown 时不会自动关闭；
	}
	
}
