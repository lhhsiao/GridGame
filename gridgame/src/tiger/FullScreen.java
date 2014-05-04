package tiger;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FullScreen{
	GraphicsDevice vc;
	
	//Initialize the vc with the Screen Device
	public FullScreen(){
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc=ge.getDefaultScreenDevice();
	}
	//Set the Frame to Full Screen
		public void setFullScreen(DisplayMode dm, JFrame win){
		
		//Remove the Title Bar, Maximization , Minimization Button...
		win.setUndecorated(true); 
		
		// Can not be resized
		win.setResizable(false);
		
		//Make the win(JFrame) Full Screen
		vc.setFullScreenWindow(win);		
		
		 //check low-level display changes are supported for this graphics device.
		if(dm!=null && vc.isDisplayChangeSupported()){
				try{
						vc.setDisplayMode(dm);
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
		}
		}
		//To Exit From Full Screen
		public void CloseFullScreen(){
			Window w=vc.getFullScreenWindow();
			if(w!=null){
			w.dispose();
			}
			vc.setFullScreenWindow(null);
		}	
	}