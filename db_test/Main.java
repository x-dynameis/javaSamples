package db_test;

import java.sql.ResultSet;

public class Main {
	public static void main(String[] args) {

//		
//		String sqlInsert = "insert into t_customer(c_name,c_phonetic,zip_cord,address_1,address_2)"
//				+ " values('?,?,?,?,?')";
//		String person = "大川　優羽";
//		String phonetic = "オオカワ　ユウ";
//		int zip = 00000000;
//		String address1 = "名古屋市緑区";
//		String address2 = "hogehoge";
		
		
//		
//		String sqlUp = "update t_customer set zip_cord =4580912,address_2='有松町大字桶狭間生山1-25' where id = 4";
		
		
		DbControl db = new DbControl();
		ResultSet rs;
//		String sql = "select * from t_customer";
		String sql = "select id,c_name from tbl_customer "
				+ "where "
        		+ "isnull(evacuate) "
        		+ "and "
        		+ "isnull(date_of_death) "
        		+ "and "
        		+ "customer_class < 3 "
        		+ "and "
        		+ "not isnull(c_name) "
        		+ "order by room_number";
		sql = "Select id,name from t_user where id =3";
		//選択クエリ実行
		db.selectDb(sql);
		
		try {
		 db.selectDb(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
//		db.updateDb(sqlUp);
//		db.updateDb(sqlInsert);

	}

}

