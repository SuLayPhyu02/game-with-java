package model;

import java.sql.*;
import java.util.*;

public class DBHandler {
	private static Connection con;
	private static String userName="root";
	private static String password="Sulay6619#";
	private static int port=3306;
	private static String dbName="uni1";
	private static String host="localhost";
	
	public static boolean openConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://"+host+":"+port+"/"+dbName;
			con=DriverManager.getConnection(url,userName,password);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public static boolean closeConnection()
	{
		try {
			con.close();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public static ArrayList<Person> getAllPerson()
	{
		ArrayList<Person> persons=new ArrayList<>();
		try {
			openConnection();
			String q="select * from person";
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Person p=new Person(rs.getInt("pid"),rs.getString("name"),rs.getInt("age"));
				persons.add(p);
			}
			closeConnection();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return persons;
	}
	public static boolean insertPerson(String name,int age)
	{
		try {
			openConnection();
			String sql="insert into person(name,age) values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			int line=ps.executeUpdate();
			closeConnection();
			return line>0;
		}catch(Exception e)
		{
			return false;
		}
	}
	public static boolean updatePerson(int pid,String name,int age)
	{
		try {
			openConnection();
			String sql="update person set name=?,age=? where pid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setInt(3, pid);
			int line=ps.executeUpdate();
			closeConnection();
			return line>0;
		}catch(Exception e)
		{
			return false;
		}
	}
	public static boolean deletePerson(int pid)
	{
		try {
			openConnection();
			String sql="delete from person where pid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			int line=ps.executeUpdate();
			closeConnection();
			return line>0;
		}catch(Exception e)
		{
			return false;
		}
	}
	public static boolean insertStaff(String n,String p)
	{
		p=Checker.digestMsg(p);
		try {
			openConnection();
			String sql="Insert into staff(name,password) values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, n);
			ps.setString(2,p);
			int line=ps.executeUpdate();
			closeConnection();
			return line>0;
		}catch(Exception e)
		{
			return false;
		}
	}
	public static int login(String n,String p)
	{
		int id=-1;
		try {
			openConnection();
			p=Checker.digestMsg(p);
			String sql="select sid from staff where name=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, n);
			ps.setString(2, p);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				id=rs.getInt(1);
			}
			
		}catch(Exception e) {
			
		}
		closeConnection();
		return id;
	}
	public static void main(String args[])
	{
//		insertStaff("Mg Mg","mgmg123");
//		insertStaff("Aye Aye", "ayeaye123");
		System.out.println(login("Aye Aye","ayeaye123"));
	}
}
