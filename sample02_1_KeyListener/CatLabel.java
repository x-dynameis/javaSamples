package sample02_1_KeyListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
public class CatLabel {
	private static final long serialVersionUID=1L;
	//field
	Image catImage;
	//Const
	CatLabel(){
		//image Settings
		catImage = new ImageIcon(getClass().getClassLoader().getResource("./images/man.png")).getImage();
//		this.setBounds(100,100,catImage.getWidth(null),catImage.getHeight(null));
		
	}
//	public void paint(Graphics g) {

//		super.paint();
//		//use catImage
//		Graphics2D g2D = (Graphics2D) g;
//		g2D.drawImage(catImage, 0, 0, catImage.getWidth(null), catImage.getHeight(null), null);
//		
//	}
//	

}
