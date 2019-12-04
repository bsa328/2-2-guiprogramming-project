package Handler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePn extends JPanel {
	BufferedImage img = null;

	public ImagePn(int x, int y, int h, int w) {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		this.setBounds(x,y,h,w);
		this.setBackground(Color.white);
		try {
			File file = new File("TUlogo.png");
			img = ImageIO.read(file);
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.requestFocus();
		this.setFocusable(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(img, 20, 20, 180, 160, null);
	}
}
