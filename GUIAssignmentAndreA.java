/// GUI Project: Volume and Surface Area of Cube Calculator
/// Andre Arcaina
/// Due Date: 2021/11/03 @ 7:00 PM 
/// Version 3.03
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

// Extra Features:
// Two Additional JComponents
// Import Pictures
// About Panel
// Help Panel

public class GUIAssignmentAndreA implements ActionListener, ChangeListener{
	///properties for frame
	JFrame frame = new JFrame("Volume and Surface Area of A Cube"); //creating a frame
	
	///generic properties for every panel
	Timer timer = new Timer(1000/48, this); //repaints every 48 fps
	JMenuBar MenuBar = new JMenuBar(); //creating a menubar
	JMenu MainMenu = new JMenu("Switch Panels"); //creating a menu
	JMenuItem CalculationItem = new JMenuItem("Calculation Menu"); //creating a menuitem representing calculations and animation
	JMenuItem HelpItem = new JMenuItem("Help Menu"); //creating a menuitem representing help
	JMenuItem AboutItem = new JMenuItem("Acknowledgements"); //creating a menuitem representing acknowledgements
	
	///properties for animation panel / main panel
	APanel mainpanel = new APanel(); //this creates the main panel for the animation and the calculation
	JSlider InputSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 60, 30); //this creates the slider for set inputs
	//the following are creating labels that either define something, help you in something, or alter in values
	JLabel Title = new JLabel("Cube Calculator (Set values of 0 to 60 meters)"); 
	JLabel AreaValue =  new JLabel("Side Length: 30 meters");
	JLabel VolumeCalculation = new JLabel("Volume: 27000 cubic meters");
	JLabel SurfaceAreaCalculation = new JLabel("Surface Area: 5400 squared meters"); 
	JLabel MoreInfo = new JLabel("For more information, press Switch Panels and then Help Menu.");
	JLabel AnimationInfoPt1 = new JLabel("As you increase the cube's side length, you increase the volume of the cube.");
	JLabel AnimationInfoPt2 = new JLabel("Volume/Surface Area increases and decreases depending on the side length of cube.");
	
	///properties for help panel
	HelpPanel HPanel = new HelpPanel(); //this creates the help panel for instructions
	
	///properties for about panel
	AbPanel AboutPanel = new AbPanel(); //this creates the acknowledgement panel for acknowledgements
	
	///methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == timer){ //repaints every 48 fps
			mainpanel.repaint();
		}else if(evt.getSource() == HelpItem){ //Change panel to help panel
			frame.setContentPane(HPanel); //sets frame content pane to Help Panel
			frame.pack();
			HPanel.repaint();
			HPanel.add(MenuBar); 
		}else if(evt.getSource() == AboutItem){ //Change panel to about panel
			frame.setContentPane(AboutPanel); //sets frame content pane to about Panel
			frame.pack();
			AboutPanel.repaint();
			AboutPanel.add(MenuBar);
		}else if(evt.getSource() == CalculationItem){ //Change panel to calculation panel/main panel 
			frame.setContentPane(mainpanel); //sets frame content pane to main Panel
			frame.pack();
			mainpanel.repaint();
			mainpanel.add(MenuBar);
		}
	} 
	public void stateChanged(ChangeEvent evt){ //this is for the slider to change values of the cube
		if(evt.getSource() == InputSlider){
			int intValue = InputSlider.getValue();
			AreaValue.setText("Side Length: "+intValue+" meters");
			VolumeCalculation.setText("Volume: "+(int)(Math.pow(intValue, 3))+" cubic meters");
			SurfaceAreaCalculation.setText("Surface Area: "+(int)(6*Math.pow(intValue, 2))+" squared meters");
			mainpanel.intSideLength = intValue*5; //the panel uses the property in APanel and makes it equal to the value from the slider
			//multiplied it by 5 because the intValue is only in the 2 digits, meaning that if the multiplication of 5 was not there, the cube
			//will only move by values of 1 to 60, not 1*5 (5) to 60*5 (300). 
		}
	}
	///constructor
	public GUIAssignmentAndreA(){
		///start of APanel/main panel
		mainpanel.setLayout(null);
		mainpanel.setPreferredSize(new Dimension(960, 540)); //setting panel to resolution of 960 x 540
		
		MenuBar.setBounds(0, 0, 960, 30);
		MenuBar.add(MainMenu);
		MainMenu.add(HelpItem);
		MainMenu.add(AboutItem);
		MainMenu.add(CalculationItem);
		CalculationItem.addActionListener(this);
		HelpItem.addActionListener(this);
		AboutItem.addActionListener(this);
		mainpanel.add(MenuBar);
		
		InputSlider.addChangeListener(this);
		InputSlider.setBounds(50, 80, 220, 30); 
		mainpanel.add(InputSlider);
		
		Title.setBounds(40, 50, 500, 30);
		mainpanel.add(Title);
		
		AreaValue.setBounds(80, 80, 200, 100);
		mainpanel.add(AreaValue);
		
		VolumeCalculation.setBounds(80, 120, 200, 100);
		mainpanel.add(VolumeCalculation);
		
		SurfaceAreaCalculation.setBounds(80, 140, 300, 100);
		mainpanel.add(SurfaceAreaCalculation);
		
		MoreInfo.setBounds(10, 470, 500, 100);
		mainpanel.add(MoreInfo);
		
		AnimationInfoPt1.setBounds(440, 500, 500, 20);
		mainpanel.add(AnimationInfoPt1);
		
		AnimationInfoPt2.setBounds(440, 520, 500, 20);
		mainpanel.add(AnimationInfoPt2);
		
		frame.setContentPane(mainpanel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		///end of APanel
		
		///start of Help Panel 
		HPanel.setLayout(null);
		HPanel.setPreferredSize(new Dimension(960, 540)); //setting panel to resolution of 960 x 540
		/// end of Help Panel 
		
		///start of About Panel 
		AboutPanel.setLayout(null);
		AboutPanel.setPreferredSize(new Dimension(960, 540)); //setting panel to resolution of 960 x 540
		///end of Help Panel 
		
		timer.start(); 
	}
	
	///main program
	public static void main(String[] args){
		new GUIAssignmentAndreA();		
	}	
}
