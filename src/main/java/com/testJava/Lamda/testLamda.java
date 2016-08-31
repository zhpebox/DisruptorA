package com.testJava.Lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;


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
//		Runnable race2 = () -> System.out.println("Hello world !");
		 
		// 直接调用 run 方法(没开新线程哦!)
//		race1.run();
//		race2.run();
		
//		testInnerClass test1 = new testInnerClass(){
//
//			@Override
//			public void sayWhat() {
//				System.out.println(" has said that ……");
//			}
//		};
		
//		test1.sayWhat();
		
		String names = "tom";
		testInnerClass test2 = (String name) -> System.out.println("Hello world !"+name);
		test2.sayWaht("Z");
		
		String[] atp = {"Rafael Nadal", "Novak Djokovic",
			       "Stanislas Wawrinka",
			       "David Ferrer","Roger Federer",
			       "Andy Murray","Tomas Berdych",
			       "Juan Martin Del Potro"};
		
		List list = Arrays.asList(atp);
		list.forEach((e)->System.out.println(e));
		
//		Arrays.sort(atp,new Comparator<String>(){
//			@Override
//			public int compare(String o1, String o2) {
//				return (o1.compareTo(o2));
//			}
//		});
		
//		Comparator<String> sortByName = (String s1,String s2) -> (s1.compareTo(s2));
//		Arrays.sort(atp,sortByName);
		
		Arrays.sort(atp,(String s1,String s2)->(s1.compareTo(s2)));
		
		System.out.println("***************");
		list.forEach((e)->System.out.println(e));
		
		List<Person> javaProgrammers = new ArrayList<Person>() {
			  {
			    add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
			    add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
			    add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
			    add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
			    add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
			    add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
			    add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
			    add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
			    add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
			    add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
			  }
			};
			
			List<Person> phpProgrammers = new ArrayList<Person>() {
				  {
				    add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
				    add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
				    add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
				    add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
				    add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
				    add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
				    add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
				    add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
				    add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
				    add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
				  }
			};
			phpProgrammers.stream().filter((p)->(p.getSalary()>1400)).
			forEach((p) -> System.out.println(p.getFirstName()));
			
			Predicate<Person> getFilter = (p) -> (p.getAge()>24);
			
			phpProgrammers.stream().filter(getFilter).forEach(
					(p) -> System.out.println(p.getFirstName()));
			
			
			//计算 count, min, max, sum, and average for numbers
			List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
			IntSummaryStatistics stats = numbers
			          .stream()
			          .mapToInt((x) -> x)
			          .summaryStatistics();

			System.out.println("List中最大的数字 : " + stats.getMax());
			System.out.println("List中最小的数字 : " + stats.getMin());
			System.out.println("所有数字的总和   : " + stats.getSum());
			System.out.println("所有数字的平均值 : " + stats.getAverage()); 
	}
	
}
