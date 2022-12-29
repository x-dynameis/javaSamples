package upunushi;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel gameLabel;
	
	GamePanel(){
		this.setLayout(null);//レイアウト設定
		this.setBackground(Color.green);//背景の色
		//その他の追加設定をここに追加
	}
	public void prepareComponents() {
		gameLabel = new JLabel();
		gameLabel.setText("ゲーム画面");
		gameLabel.setBounds(100,200,100,30);
		this.add(gameLabel);
	}

}
