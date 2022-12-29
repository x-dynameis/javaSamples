package app;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import app.AddComboBox;
import app.CreateAlert;
import app.DBAccess;
import app.Employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DetailController {
    @FXML    private Button btnAction1;
    @FXML    private ResourceBundle resources;
    @FXML    private URL location;
    @FXML    private ComboBox<Employee> cidCombo;
    @FXML    private TextField cidResultText;
    @FXML    private TextField cidSearchText;
    @FXML    private Text customerLabel;
    @FXML    private Text dateLabel;
    @FXML    private TextField dateText;
    @FXML    private ComboBox<Employee> fromCombo;
    @FXML    private TextField fromText;
    @FXML    private TextArea mainArea;
    @FXML    private TextField subjextText;
    @FXML    private ComboBox<Employee> toCombo;
    @FXML    private TextField toText;
    @FXML    private Button btnTest;
    private  AddComboBox cidMenu;

    private  String cidSql="select id,c_name from tbl_customer "
			+ "where isnull(evacuate) and isnull(date_of_death) and customer_class < 3 and not isnull(c_name) ";
    private String cidOrder= "order by room_number";
//    private ObservableList<Employee> data;
    @FXML
    void testbutton(ActionEvent event) {
    	String sqlPulus= "and c_name_huri like '%" + cidSearchText.getText() + "%' ";
//    	System.out.println(cidSql + sqlPulus + cidOrder);
    	String sql = cidSql + sqlPulus + cidOrder;
//    	cidMenu.createEmp(sql);
//    	cidMenu.setMenu();
    	
    	
    }

    @FXML    void btnAction(ActionEvent event) {
    	DBAccess db = new DBAccess();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    	Date today = new Date();
//    	String fromVlue = fromCombo.getValue().getId();
    	String fromValue;
    	String toValue;
    	String cid;
    	try {cid = db.sqlNull(cidCombo.getValue().getId());
    	}catch(java.lang.NullPointerException e) {cid = "null";}
    	try {fromValue = db.sqlNull(fromCombo.getValue().getId());      	
    	}catch(java.lang.NullPointerException e) {fromValue = "null";	}
    	
    	try {toValue = db.sqlNull(toCombo.getValue().getId());
    	}catch(java.lang.NullPointerException e) {toValue = "null";   	}
    	
    	if (mainArea.getText()== null || mainArea.getText().length()==0 ) {
//    		System.out.println("空白です");
    		new CreateAlert("本文の入力は必須です");
    		
    	}else {

        	String sql ="insert into tbl_bulletin(cid,b_date,b_subject,b_main,b_from,b_to) values("
        			+ cid + ",'" + sdf.format(today) +"','"
        					+ "" + subjextText.getText() +"','"+mainArea.getText()+"',"
        							+ "" + fromValue + "," + toValue +")" ;
//        	System.out.println(sql);
        	db.updateDb(sql);
    		
    	}
    }

    @FXML
    void initialize() {
        assert btnAction1 != null : "fx:id=\"btnAction1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnTest != null : "fx:id=\"btnTest\" was not injected: check your FXML file 'Sample.fxml'.";
        assert cidCombo != null : "fx:id=\"cidCombo\" was not injected: check your FXML file 'Sample.fxml'.";
        assert cidResultText != null : "fx:id=\"cidResultText\" was not injected: check your FXML file 'Sample.fxml'.";
        assert cidSearchText != null : "fx:id=\"cidSearchText\" was not injected: check your FXML file 'Sample.fxml'.";
        assert customerLabel != null : "fx:id=\"customerLabel\" was not injected: check your FXML file 'Sample.fxml'.";
        assert dateLabel != null : "fx:id=\"dateLabel\" was not injected: check your FXML file 'Sample.fxml'.";
        assert dateText != null : "fx:id=\"dateText\" was not injected: check your FXML file 'Sample.fxml'.";
        assert fromCombo != null : "fx:id=\"fromCombo\" was not injected: check your FXML file 'Sample.fxml'.";
        assert fromText != null : "fx:id=\"fromText\" was not injected: check your FXML file 'Sample.fxml'.";
        assert mainArea != null : "fx:id=\"mainArea\" was not injected: check your FXML file 'Sample.fxml'.";
        assert subjextText != null : "fx:id=\"subjextText\" was not injected: check your FXML file 'Sample.fxml'.";
        assert toCombo != null : "fx:id=\"toCombo\" was not injected: check your FXML file 'Sample.fxml'.";
        assert toText != null : "fx:id=\"toText\" was not injected: check your FXML file 'Sample.fxml'.";
//        cidCombo.getItems().add("1");
//        cidCombo.getItems().add("2");
//        cidCombo.getItems().add("3");
//        cidCombo.getSelectionModel().select(0);
//        cidCombo.setEditable(true);
//        
        //setWrapText: テキストの長さがTextAreaの幅を超える場合に、テキストを別の行に折り返すかどうかをこの変数で示します。
        mainArea.setWrapText(true);

        String cidResult = cidSql + cidOrder;
        
        cidMenu = new AddComboBox(cidCombo,cidResult);
        cidCombo.getSelectionModel().selectedItemProperty().addListener((r,o,newValue) ->{
        	if(newValue.getName().length()==0) {
        		cidResultText.textProperty().set("");
        		subjextText.textProperty().set("");
        	}else {
        		cidResultText.textProperty().set(newValue.getName() + "様");
        		subjextText.textProperty().set(newValue.getName()+"様 の 件");
        	}
        });
        AddComboBox fromMenu = new AddComboBox(fromCombo,"select id,name from t_user where id=1 or id=51 or id=53 or id=3");

        fromCombo.getSelectionModel().selectedItemProperty().addListener((r,o,newValue) ->{
        	fromText.textProperty().set(newValue.getName());
        });
        AddComboBox toMenu =new AddComboBox(toCombo,"select id,name from t_user where id=1 or id=51 or id=53 or id=3");
        toCombo.getSelectionModel().selectedItemProperty().addListener((r,o,newValue) ->{
        	toText.textProperty().set(newValue.getName());
        });
        btnTest.setVisible(false);
        
        //コンボボックスを編集可能にするプロパティ
//        fromCombo.setEditable(true);
//        toCombo.setEditable(true);

    }
    public void setFromText(String text) {
    	this.fromText.setText(text);
    }
    public void setMainArea(String text) {
    	this.mainArea.setText(text);
    }
    public void setSubject(String text) {
    	this.subjextText.setText(text);
    }
    public void setToText(String text) {
    	this.toText.setText(text);
    }
    public void setDateText(String text) {
    	this.dateText.setText(text);
    }
    public void cidSetVisibleFalse() {
    	this.cidCombo.setVisible(false);
    }
    public void cidResultVisibleFalse() {
    	this.cidResultText.setVisible(false); 	
    }
    public void cidSearchVisibleFalse() {
    	this.cidSearchText.setVisible(false);
    }
    public void customerLabelUnvisible() {
    	this.customerLabel.setVisible(false);
    }
    public void FromComboUnvisible() {
    	this.fromCombo.setVisible(false);
    }
    public void ToComboUnvisible() {
    	this.toCombo.setVisible(false);
    }
    public void btnAction1Unvisible() {
    	this.btnAction1.setVisible(false);
    }
    public void dateTextUnvisible() {
    	this.dateLabel.setVisible(false);
    	this.dateText.setVisible(false);
    }
    public void setFromCombo(Employee employee) {
        
        this.fromCombo.setValue(employee);
    }
    public void searchUnvisible() {
    	this.cidSearchText.setVisible(false);
    }





}
