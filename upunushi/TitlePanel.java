package upunushi;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel titleLabel;
	
	TitlePanel(){
		
		this.setLayout(null);//レイアウト設定
		this.setBackground(Color.red);//背景の色
		//その他の追加設定をここに追加
	
	}
	public void prepareComponents() {
		//以降コンポーネントに関する命令
		titleLabel = new JLabel();
		titleLabel.setText("タイトル画面");
		titleLabel.setBounds(100,0,100,30);
		this.add(titleLabel);
	}
	

}
