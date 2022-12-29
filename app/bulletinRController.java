package app;

import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import app.Article;
import app.DBAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class bulletinRController {
	private ObservableList<Article> data;
    private String masterName;
    private String masterId;
    @FXML    private ResourceBundle resources;
    @FXML    private URL location;
    @FXML    private TableView<Article> table;
    @FXML    private TableColumn<Article, CheckBox> check1Col;
    @FXML    private TableColumn<Article, CheckBox> check2Col;
    @FXML    private TableColumn<Article, Button> buttonCol;

    @FXML    private TableColumn<Article, String> idCol;
    @FXML    private TableColumn<Article, String> dateCol;    
    @FXML    private TableColumn<Article, String> timeCol;
    @FXML    private TableColumn<Article, String> subCol;    
    @FXML    private TableColumn<Article, String> contCol;
    @FXML    private TableColumn<Article, String> writerCol; 
    @FXML    private TableColumn<Article, String> readerCol;

    @FXML    private TextField fromField;
    @FXML    private TextField toField;
    @FXML    private TextField userName;
    @FXML    private ComboBox<Employee> userNo;

    @FXML    void btnNewForm(ActionEvent event) {

    }
    @FXML    void btnSearch(ActionEvent event) {
tableShow();
    }

    @FXML    void initialize() {
		data = FXCollections.observableArrayList();
		table.itemsProperty().setValue(data);
		table.setItems(data);
	 idCol.setCellValueFactory(new PropertyValueFactory<Article,String>("id"));
	 dateCol.setCellValueFactory(new PropertyValueFactory<Article,String>("b_date"));
	 timeCol.setCellValueFactory(new PropertyValueFactory<Article,String>("b_time"));
	 timeCol.setCellValueFactory(new PropertyValueFactory<Article,String>("b_time"));
	 subCol.setCellValueFactory(new PropertyValueFactory<Article,String>("b_subject"));
	 contCol.setCellValueFactory(new PropertyValueFactory<Article,String>("b_main"));
	 writerCol.setCellValueFactory(new PropertyValueFactory<Article,String>("b_from"));
	 readerCol.setCellValueFactory(new PropertyValueFactory<Article,String>("b_to"));
//	 check1Col.setCellValueFactory(new PropertyValueFactory<Article,CheckBox>("checked"));
//	 check2Col.setCellValueFactory(new PropertyValueFactory<Article,CheckBox>("checked2"));
	 
	 setDateText();
	 tableShow();
    }
    public void tableShow() {
 		ResultSet rs;
 		DBAccess db = new DBAccess();
 		String fromDate = fromField.getText();
 		String toDate = toField.getText();
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		try {
 			Date date = sdf.parse(toDate);
 			Calendar c = Calendar.getInstance();
 			c.setTime(date);
 			c.add(c.DAY_OF_MONTH, +1);
 			Date oneDay = c.getTime();
 			toDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(oneDay);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		
 		String SQL ="SELECT bt.id, bt.b_date, bt.b_subject, bt.b_main,"
 				+ " bt.b_from, u1.name AS fromName, bt.b_to, u2.name as toName "
 				+ "FROM tbl_bulletin as bt "
 				+ "LEFT JOIN t_user as u1 ON bt.b_from = u1.id "
 				+ "left join t_user as u2 on bt.b_to = u2.id "
 				+ "where bt.b_date Between '" + fromDate + "' and '" + toDate +"'" ;

// 		System.out.println(SQL);
 		
 		try {

 			rs = db.executeQuery(SQL);

 			while(rs.next()) {
 				data.add(new Article(rs.getString(1),rs.getString(2),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(8)));
 			}
 		}catch(Exception ex) {
 			ex.printStackTrace();
 		}finally {
 			db.DisCon();
 		}
     	
     }
     //日付検索用のテキストボックスに日付をセットする
     public void setDateText() {
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		Calendar c = Calendar.getInstance();
// 		Calendar c2 = Calendar.getInstance();
 		c.setTime(new Date());
 		c.add(c.DAY_OF_MONTH, -7);
// 		c2.setTime(new Date());
// 		c2.add(c2.DAY_OF_MONTH, +1);
 		Date sevenDay=c.getTime();
// 		Date today=c2.getTime();
 		Date today=new Date();
 		
 		fromField.setText(sdf.format(sevenDay));
 		toField.setText(sdf.format(today));
     }
     public String getMasterId() {
     	return masterId;
     }

}
