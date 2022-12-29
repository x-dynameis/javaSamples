package applications;
import java.sql.*;
//CORDEPREP のサンプルコードを参考に作成
//テーブルのカラムを取得するmethod
public class ColumnsTest {
	public static void main(String[] args)throws SQLException {
		ColumnsTest m = new ColumnsTest();
		m.disc();
		

	}
	public void disc()throws SQLException {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.11.17:3306/sincere?serverTimezone=UTC";
		Connection conn = DriverManager.getConnection(url,"ozaki","gargoyl");
		try {
			DatabaseMetaData dmd= conn.getMetaData();
			ResultSet rs = dmd.getColumns(null,null,"tbl_customer",null);
			
			while(rs.next()) {
				System.out.println(
				rs.getString("TABLE_NAME") + "," +
				rs.getString("COLUMN_NAME") + "," +
				rs.getString("TYPE_NAME")
				);
			}
		}finally{
			conn.close();
		}
	}

}
