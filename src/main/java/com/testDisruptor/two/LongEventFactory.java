package com.testDisruptor.two;

import com.lmax.disruptor.EventFactory;

/*
 * 定义事件工厂，事件工厂（Event Factory）定义了如何实例化第一步中定义的事件（Event），需要实现接口
 * com.Imax.disruptor.EventFacotry<T>.
 * Disruptor通过EventFactoryz在RingBuffer中预创建了Event的实例
 * 
 * 一个Event实例实际上被用作一个“数据槽”，发布者发布前，先从RingBuffer获得一个Event的实例，然后往
 * Event实例中填充数据，之后再发布到RingBuffer中，
 * 之后Consumer获得该Event实例并从中读取数据
 */
public class LongEventFactory implements EventFactory<LongEvent> {

	@Override
	public LongEvent newInstance() {
		System.out.println("创建事件");
		return new LongEvent();
	}

}
