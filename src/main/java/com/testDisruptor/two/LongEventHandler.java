package com.testDisruptor.two;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.lmax.disruptor.EventHandler;

/*
 * 定义事件处理的具体实现
 * 通过实现接口com.Imax.disruptor.EventHandler<T>定义事件处理的具体实现 
 */
public class LongEventHandler implements EventHandler<LongEvent> {

	@Override
	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("Event: "+event+"; sequence="+sequence+";   endOfBatch="+endOfBatch);
		System.out.println(Thread.currentThread().getName()+" ---------  "+ReflectionToStringBuilder.toString(event)+" *****************************");  
	}

}
