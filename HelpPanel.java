/// GUI Project: Help Panel
/// Andre Arcaina
/// Due Date: 2021/11/03 @ 7:00 PM 
/// Version 3.05
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class HelpPanel extends JPanel{
	///HelpPanel Properties
	BufferedImage image = null;
	BufferedImage image2 = null;
	
	///methods
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 50, null);
		g.drawImage(image2, 550, 50, null);
	}
	
	///constructor
	public HelpPanel(){
		super();
		try{
			image = ImageIO.read(new File("Instructions.png")); //reading image 
			image2 = ImageIO.read(new File("GraphicalRepresentation.png")); //reading image 
		}catch(IOException e){
			System.out.println("Unable to load image."); //catching errors
		}
	}
} 
