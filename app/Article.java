package app;

import javafx.beans.property.SimpleBooleanProperty;

public class Article {
private SimpleBooleanProperty checked;
private SimpleBooleanProperty checked2;
private String id;
private String b_date;
private String b_time;
private String b_subject;
private String b_main;
private String b_from;
private String b_to;
//private boolean check1;
	
	public Article(String id,String b_date,String b_time,String b_subject,String b_main,String b_from,String b_to) {
		this.id = id;
		this.b_date = b_date.substring(0, 10);
		this.b_time = b_time.substring(11, 16);
		this.b_subject = b_subject;
		this.b_main = b_main;
		this.b_from = b_from;
		this.b_to = b_to;
//		this.check1 = check1;
		
	}
	public String getId() {return id;}
	public String getB_date() {return b_date;}
	public String getB_time() {return b_time;}
	public String getB_subject() {return b_subject;}
	public String getB_main() {return b_main;}
	public String getB_from() {return b_from;}
	public String getB_to() {return b_to;}
//	public boolean getCheck1() {return check1;}
	
	public void setId(String id) {this.id = id;}
	public void setB_date(String b_date) {this.b_date = b_date;}
	public void setB_time(String b_time) {this.b_time = b_time;}
	public void setB_subject(String b_subject) {this.b_subject=b_subject;}
	public void setB_main(String b_main) {this.b_main=b_main;}
	public void setB_from(String b_from) {this.b_from=b_from;}
	public void setB_to(String b_from) {this.b_from=b_from;}
//	public void setCheck1(boolean check1) {this.check1=check1;}

	public SimpleBooleanProperty checkedProperty() {        return checked;    }
    public boolean isChecked() {        return checked.get();    }
    public void setChecked(boolean checked) {        this.checked.set(checked);    }	

    public SimpleBooleanProperty checked2Property() {        return checked2;    }
    public boolean isChecked2() {        return checked2.get();    }
    public void setChecked2(boolean checked) {        this.checked2.set(checked);    }
}
