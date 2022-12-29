package sample02_1_KeyListener;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	//定数
	Color backgroundColor = Color.green;
	//コンポーネント
	CatLabel catLabel;
	//リスナー
//	MyKeyListener myKeyListener;
	
	
	
	MainPanel(){
		this.setLayout(null);//レイアウト設定
		this.setBackground(backgroundColor);//背景の色
		//その他の追加設定をここに追加
	}

	private class MyKeyListener implements KeyListener{
		//貼り付け先保持
		MainPanel panel;
		//コンストラクタ
		MyKeyListener(MainPanel p){
			super();
			panel = p;
			p.addKeyListener(this);
		}
	
//	@Override
	public void keyTyped(KeyEvent e) {
		//do nothing
	}
//	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
//		switch(e.getKeyCode()) {
//		case KeyEvent.VK_UP:
//			if(catLabel.getY()>0) {
//				catLabel.setLocation(catLabel.getX(),catLabel.getY()-5);
//			}
//			break;
//		case KeyEvent.VK_DOWN:
//			if(catLabel.getY() + catLabel.catImage.getHeight(null)<panel.getHeight()) {
//				catLabel.setLocation(catLabel.getX(),catLabel.getY()+5);
//			}
//			break;
//		case KeyEvent.VK_LEFT:
//			if(catLabel.getX() > 0) {
//				catLabel.setLocation(catLabel.getX()-5,catLabel.getY());
//			}
//			break;
//		case KeyEvent.VK_RIGHT:
//			if(catLabel.getX()+ catLabel.catImage.getWidth(null)<pane.getWidth()) {
//				catLabel.setlocation(catLabel.getX()+5,catLabel.getY());
//			}
//			break;
//		case KeyEvent.VK_ENTER:
//			if(backgroundColor == Color.green) {
//				backgroundColor= Color.blue;
//				panel.setBackground(backgroundColor);
//			}else if(backgroundColor== Color.blue) {
//				backgroundColor = Color.green;
//				panel.setBackground(backgroundColor);
//			}
//			break;
//		}
	}
	}
}
