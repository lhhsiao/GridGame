package tiger;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class MyInternalFrame extends JInternalFrame implements FocusListener{
	Image winImage=null;
	boolean showLoseImage=false;
	public boolean isShowLoseImage() {
		return showLoseImage;
	}
	public void setShowLoseImage(boolean showLoseImage) {
		this.showLoseImage = showLoseImage;
		repaint();
	}
	Image loseImage=null;
	boolean showWinImage=false;
	public boolean isShowWinImage() {
		return showWinImage;
	}
	public void setShowWinImage(boolean showWinImage) {
		this.showWinImage = showWinImage;
		repaint();
	}
	private JComponent titleBar;
	MyImageComponent[] myICArray=null;
	public MyInternalFrame(int x,int y,int w,int h){
//		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		setResizable(true);
		setBounds(x, y, w, h);
		setVisible(true);
		setFocusable(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		ImageLoader iL=ImageLoader.getInstance();
//		URL iconPath1=GridMainWindow2.class.getResource("/tiger/1.jpeg");
		File f=new File("./resource/win.jpg");
		if(f.exists())
			winImage=iL.getImage(f.getPath());
		else
			winImage=iL.getImage(GridMainWindow2.class.getResource("/tiger/win.jpg"));
		f=new File("./resource/broken_glass.png");
		if(f.exists())
			loseImage=iL.getImage(f.getPath());
		else
			loseImage=iL.getImage(GridMainWindow2.class.getResource("/tiger/broken_glass.png"));

		URL iconPathCover=GridMainWindow2.class.getResource("/tiger/broken_glass.png");
		URL[] iconPathArray=new URL[9];
		myICArray=new MyImageComponent[9];
		for(int i=0;i<iconPathArray.length;i++){
			f=new File("./resource/"+(i+1)+".jpg");
			
			iconPathArray[i]=GridMainWindow2.class.getResource("/tiger/"+(i+1)+".jpg");
			myICArray[i]=new MyImageComponent();
			if(f.exists())
				myICArray[i].setImage(iL.getImage(f.getPath()));
			else
			myICArray[i].setImage(iL.getImage(iconPathArray[i]));
			
			panel.add(myICArray[i]);
			f=new File("./resource/cover.png");
			if(f.exists())
				myICArray[i].setFrontCoverImage(iL.getImage(f.getPath()));
			else
				myICArray[i].setFrontCoverImage(iL.getImage(iconPathCover));
		}

		titleBar=((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).getNorthPane();
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

		addFocusListener(this);
//		myIC5.setFrontCoverImage(iL.getImage(iconPathCover));
//		myIC5.setShowFrontCover(true);
	}
	public void setFrontCoverByIndex(int index,boolean show){
//		myIC5.setFrontCoverImage(iL.getImage(iconPathCover));
		myICArray[index].setShowFrontCover(show);
		repaint();
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		System.out.println("paintComponent");
//		g.drawImage(winImage, 0, 0, this.getWidth(), this.getHeight(),null);// arg5, arg6, arg7, arg8, arg9);
		super.paint(g);
		if(showLoseImage)
			g.drawImage(loseImage, 0, 0, this.getWidth(), this.getHeight(),null);
		if(showWinImage)
			g.drawImage(winImage, 0, 0, this.getWidth(), this.getHeight(),null);
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
//		titleBar=((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).getNorthPane();
//		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(titleBar);
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
//		titleBar=((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).getNorthPane();
//		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
	}
	
}
