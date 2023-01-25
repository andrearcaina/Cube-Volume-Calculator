/// GUI Project: About/Acknowledgement Panel
/// Andre Arcaina
/// Due Date: 2021/11/03 @ 7:00 PM 
/// Version 3.06
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class AbPanel extends JPanel{
	///AbPanel Properties
	BufferedImage image = null;
	BufferedImage image2 = null;
	
	///methods
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, null);
		g.drawImage(image2, 520, 100, null);
	}
	
	///constructor
	public AbPanel(){
		super();
		try{
			image = ImageIO.read(new File("Acknowledgements.png")); //reading image 
			image2 = ImageIO.read(new File("Logo.png")); //reading image 
		}catch(IOException e){
			System.out.println("Unable to load image."); //catching errors
		}
	}
} 
