/// GUI Project: Animation Panel
/// Andre Arcaina
/// Due Date: 2021/11/03 @ 7:00 PM 
/// Version 3.04
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class APanel extends JPanel{
	///APanel properties
	int intSideLength = 150;
	BufferedImage image = null;
	
	///method 
	//overrides the method in JPanel
	//to draw APanel differently
	//Jpanel by default draws a gray background
	//APanel will draw whatever We want it to draw
	public void paintComponent(Graphics g){
		//background
		g.setColor(new Color(238, 238, 238)); 
		g.fillRect(0, 0, 960, 540);
		g.setColor(Color.BLACK);
		g.fillRect(399, 0, 10, 540);
		g.fillRect(421, 0, 10, 540);
		g.setColor(new Color(211, 211, 211));
		g.fillRect(400, 0, 30, 540);
		
		//Drawing the cube line by line
		g.setColor(Color.BLACK);
		//bottom line
		g.drawLine(450, 500, 450+intSideLength, 500);
		//left line
		g.drawLine(450, 500, 450, 500-intSideLength);
		//top line
		g.drawLine(450, 500-intSideLength, 450+intSideLength, 500-intSideLength);
		//right line
		g.drawLine(450+intSideLength, 500, 450+intSideLength, 500-intSideLength);
		
		//top left diagonal line	 
		g.drawLine(450, 500-intSideLength, (int)(450+(intSideLength/2)), (int)(500-intSideLength-(intSideLength/2)));
		//middle diagonal line
		g.drawLine(450+intSideLength, 500-intSideLength, (int)(450+intSideLength+(intSideLength/2)), (int)(500-intSideLength-(intSideLength/2)));
		//bottom right diagonal line
		g.drawLine(450+intSideLength, 500, (int)(450+intSideLength+(intSideLength/2)), (int)(500-(intSideLength/2)));
		
		//top line at the back
		g.drawLine((int)(450+(intSideLength/2)), (int)(500-intSideLength-(intSideLength/2)), (int)(450+intSideLength+(intSideLength/2)), (int)(500-intSideLength-(intSideLength/2)));
		//right line at the back
		g.drawLine((int)(450+intSideLength+(intSideLength/2)), (int)(500-(intSideLength/2)), (int)(450+intSideLength+(intSideLength/2)), (int)(500-intSideLength-(intSideLength/2)));
	
		//drawing image onto screen of the equation and another cube indicating where the sidelengths are
		g.drawImage(image, 50, 250, null);
	}
	/// constructor
	public APanel(){
		super();
		try{
			image = ImageIO.read(new File("Equations.png")); //reading image 
		}catch(IOException e){
			System.out.println("Unable to load image."); //catching errors
		}
	}
} 
