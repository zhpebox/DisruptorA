package com.testMycat.demo;
import java.sql.*;
public class DBBean {
	private String driverStr = "com.mysql.jdbc.Driver";
	private String connStr = "jdbc:mysql://localhost:8066/TESTDB?useUnicode=true&characterEncoding=utf-8";
	private String dbusername = "root";
	private String dbpassword = "123";
	private Connection conn = null;
	private Statement stmt = null;
	
	public DBBean(){
		try{
			Class.forName(driverStr);
			conn = DriverManager.getConnection(connStr,dbusername,dbpassword);
			stmt = conn.createStatement();
			System.out.println("连接OK");
		}catch(Exception e){System.out.println("连接失败");}
	}
	
	public int executeUpdate(String s){
		int result = 0;
		try{
			result = stmt.executeUpdate(s);
			System.out.println("OK");
		}catch(Exception e){System.out.println("失败");}
		return result;
	}
	
	public ResultSet executeQuery(String s){
		ResultSet rs = null;
		try{
			rs = stmt.executeQuery(s);
		}catch(Exception e){System.out.println("ִ�в�ѯ����");}
		return rs;
	}
	
	public void close(){
		try{
			stmt.close();
			conn.close();
		}catch(Exception e){}
	}
}
