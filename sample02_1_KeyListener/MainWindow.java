package sample02_1_KeyListener;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
	public static final long serialVersionUID = 1L;
	//フィールド
	ScreenMode screenMode = ScreenMode.MAIN;
	//定数
	final int WIDTH=800;
	final int HEIGHT =600;
	//レイアウト（紙芝居のような設定用）
	CardLayout layout = new CardLayout();
	//コンポーネント
//	TitlePanel titlePanel;
	MainPanel mainPanel;
	
	MainWindow(){
		this.setTitle("タイトル");
//		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("agg.png"));
//		this.setIconImage(icon.getImage());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.green);
		
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.pack();
		this.setLocationRelativeTo(null);
		
		
	}
	//コンストラクタが呼ばれたあとメインメゾッドから手動で呼び出す
	public void praparePanels() {
		mainPanel = new MainPanel();
		this.add(mainPanel,"メイン画面");
//		gamePanel = new MainPanel();
//		this.add(gamePanel,"ゲーム画面");
		this.pack();
	}
	//preparePanels()が呼ばれたあとメイン目ゾッドからさらに手動で呼び出す
	public void prepareComponents() {
//		mainPanel.prepareComponents();
//		gamePanel.prepareComponents();
	}
	//SCREEN modeを切り替える
	//メインメゾッドから最後に手動で呼び出す
	public void setFrontScreenAndFocus(ScreenMode s) {
		screenMode = s;
		//表示される画面の設定
		switch(screenMode) {
		case MAIN:	
			layout.show(this.getContentPane(),"タイトル画面");
			mainPanel.requestFocus();
			break;
//		case GAME:
//			layout.show(this.getContentPane(),"ゲーム画面");
//			gamePanel.requestFocus();
				
		}
	}
	
}
