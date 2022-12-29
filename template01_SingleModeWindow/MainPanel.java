package template01_SingleModeWindow;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel mainLabel;
	
	MainPanel(){
		this.setLayout(null);//レイアウト設定
		this.setBackground(Color.green);//背景の色
		//その他の追加設定をここに追加
	}
	public void prepareComponents() {
		mainLabel = new JLabel();
		mainLabel.setText("メイン画面");
		mainLabel.setBounds(100,200,100,30);
		this.add(mainLabel);
	}

}
