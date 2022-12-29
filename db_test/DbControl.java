package db_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbControl {
	public void selectDb(String sql) {
		Connection conn;
		Statement stat;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/sincere?user=ozaki&password=gargoyl");
			
			try {
				//クエリ
				stat = conn.createStatement();
				rs= stat.executeQuery(sql);

				while(rs.next()) {
					for(int i=1;i<=rs.getMetaData().getColumnCount();i++) {
					System.out.println(rs.getString(i));
					//System.out.println(rs.getString(3));
					//System.out.println(rs.getString(4));
					}
					
				}
				
			}finally{
				// finally method
				conn.close();
			}
					
		}catch(SQLException ex) {
			//接続できない場合
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("VendorError "+ ex.getErrorCode());
		}
	}
public void updateDb(String sql) {
	Connection conn;
	Statement stat;

	try {
		conn = DriverManager.getConnection(
			"jdbc:mysql://localhost/javaTest?user=ozaki&password=gargoyl");
		
		try {
			//クエリ
			stat = conn.createStatement();

			int result =stat.executeUpdate(sql);
			System.out.println(result + "件");
			
		}finally{
			// finally method
			conn.close();
		}
				
	}catch(SQLException ex) {
		//接続できない場合
		System.out.println("SQLException: " + ex.getMessage());
		System.out.println("SQLState: "+ ex.getSQLState());
		System.out.println("VendorError "+ ex.getErrorCode());
	}
}
}
