package com.testDisruptor.two;

/*http://www.cnblogs.com/haiq/p/4112689.html
 *定义事件，事件（Event）就是通过Disruptor进行交换的数据类型
 */
public class LongEvent {
	
	private long value;
	
	public void set(long value){
		this.value = value;
	}
	
}
