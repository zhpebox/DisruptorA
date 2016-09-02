package com.testJava.Lamda;

import java.util.Arrays;
import java.util.List;


/**
 * @author Administrator
 *
 * 参考 http://blog.csdn.net/renfufei/article/details/24600507
 */
public class testLamda {
	
	public static void main(String[] args) {
		/*String[] atp = {"Rafael Nadal", "Novak Djokovic",
			       "Stanislas Wawrinka",
			       "David Ferrer","Roger Federer",
			       "Andy Murray","Tomas Berdych",
			       "Juan Martin Del Potro"};
		List<String> list = Arrays.asList(atp);
		
//		for(String e : list){
//			System.out.println(e);
//		}
		
		//使用lambda表达式以及函数操作（function operation）
		list.forEach((e)->System.out.println(e));
		
		//在Java 8 中使用双冒号操作符（double colon operator）
		list.forEach(System.out::println);*/
		
		// 1.1使用匿名内部类
//		new Thread(new Runnable(){
//			public void run(){
//				System.out.println("Hello world!");
//			}
//		}).start();
		
		// 1.2使用lambda expression
//		new Thread(()->System.out.println("Hello world!")).start();;
		
		// 2.1使用匿名内部类
		Runnable race1 = new Runnable() {
		    @Override
		    public void run() {
		        System.out.println("Hello world !");
		    }
		};
		
		// 2.2使用 lambda expression
		Runnable race2 = () -> System.out.println("Hello world !");
		 
		// 直接调用 run 方法(没开新线程哦!)
		race1.run();
		race2.run();
	}
	
}
