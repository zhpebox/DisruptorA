package com.testMycat.demo;

public class TestMycat {
	
	public static void main(String[] args) {
		DBBean db = new DBBean();
		db.executeUpdate("insert into testtable(uname,upass,sharding_id) values('1a','cv',11)");
	}
}
