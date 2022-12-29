package applications;
import java.sql.*;
public class Sqltest {
	public void main(String[] args)throws Exception {
		
		Sqltest m=new Sqltest();
		
		String sql="select * from tbl_customer";
		m.SelectSql(sql);
		
		
	}
	
	public void SelectSql(String sql) throws Exception  {
		
		String driver = "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://192.168.11.17:3306/sincere?serverTimezone=UTC";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,"ozaki","gargoyl");
		try {
			
			System.out.println("Hello mysql!!");
			PreparedStatement stmc = conn.prepareStatement(sql);
			ResultSet rs = stmc.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+ ":" + rs.getString(4));
				
			}
		}finally {
			conn.close();
			
		}
		
	}
	
}
