package applications;
//このやり方はたぶんダメなので、サンプルのみで、実際には使わない
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Select {
	private ResultSet rs;
	private Connection conn;
	
	Select(String sql) throws Exception{
		//String driver = "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://192.168.11.17:3306/sincere?serverTimezone=UTC";
		
		//Class.forName(driver);
		this.conn=DriverManager.getConnection(url,"ozaki","gargoyl");
		try {
			
			System.out.println("Hello mysql!!");
			PreparedStatement stmc = conn.prepareStatement(sql);
			this.rs = stmc.executeQuery();

		}finally {
			//conn.close();
			
		}
	}

	
	public static void main(String[] args)throws Exception {
		System.out.println("Hello javawoc!!");
		String sql="select * from tbl_customer";
		Select mi = new Select(sql);
		while(mi.rs.next()) {
			System.out.println(mi.rs.getString(1)+ ":" + mi.rs.getString(4));
		}
		mi.rs.close();
		mi.conn.close();
		
	}
	
}
