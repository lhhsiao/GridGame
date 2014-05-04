package tiger;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class MyInternalFrame extends JInternalFrame{
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
		winImage=iL.getImage(GridMainWindow2.class.getResource("/tiger/win.jpg"));
		loseImage=iL.getImage(GridMainWindow2.class.getResource("/tiger/broken_glass.png"));
		URL iconPathCover=GridMainWindow2.class.getResource("/tiger/cover.png");
		URL[] iconPathArray=new URL[9];
		myICArray=new MyImageComponent[9];
		for(int i=0;i<iconPathArray.length;i++){
			iconPathArray[i]=GridMainWindow2.class.getResource("/tiger/"+(i+1)+".jpg");
			myICArray[i]=new MyImageComponent();
			myICArray[i].setImage(iL.getImage(iconPathArray[i]));
			panel.add(myICArray[i]);
			myICArray[i].setFrontCoverImage(iL.getImage(iconPathCover));
		}

		titleBar=((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).getNorthPane();
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

		
//		myIC5.setFrontCoverImage(iL.getImage(iconPathCover));
//		myIC5.setShowFrontCover(true);
	}
	public void setFrontCoverByIndex(int index,boolean show){
//		myIC5.setFrontCoverImage(iL.getImage(iconPathCover));
		myICArray[index].setShowFrontCover(show);
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
	
}
