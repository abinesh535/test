package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_testing {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		String host="192.168.5.132";
		String port= "3306";

		
		Connection obj=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/KantimeMedications", "admin", "admin@123");
		Statement obj1=obj.createStatement();
		ResultSet obj2=obj1.executeQuery("SELECT * FROM KantimeMedications.ClientMHRMedications where client_mhr_id=3;");

		while(obj2.next())  
		{
		
		System.out.println(obj2.getString("medication485_id"));
		
		}}
		
	}

//using this db connection, can get data from db and pass to respective site and can test
