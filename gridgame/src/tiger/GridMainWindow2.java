package tiger;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class GridMainWindow2 implements KeyListener,FocusListener{

	private JFrame frame;
	int gap=10;
	List<MyInternalFrame> myIFList=null;
	FullScreen fs=new FullScreen();
	boolean[] numberCoverShow={false,false,false,false,false,false,false,false,false,false,false,false,false};
	boolean isFullScreen=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		final GridMainWindow2 window =null;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GridMainWindow2 window= new GridMainWindow2();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public GridMainWindow2() {
		initialize();
		frame.addKeyListener(this);
		frame.addFocusListener(this);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 478, 323);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.addKeyListener(this);
		frame.getContentPane().add(desktopPane, "name_1399087871662371000");
		desktopPane.setLayout(null);
		desktopPane.setFocusable(true);
//		desktopPane.addKeyListener(this);
		
//		frame.setExtendedState(Frame.MAXIMIZED_BOTH); 
//		frame.setUndecorated(true);  
		
		myIFList=new ArrayList<MyInternalFrame>();
		int gridW=frame.getWidth()/3;
		int gridH=frame.getHeight()/2;

		for(int i=0;i<2;i++){
			for(int j=0;j<3;j++){
			MyInternalFrame temp=new MyInternalFrame(gap+gridW*j, gap+gridH*i, gridW-gap, gridH-gap);
			desktopPane.add(temp);
			
//			temp.addFocusListener(this);
			temp.addKeyListener(this);
			myIFList.add(temp);
			}
		}


	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("your pressed a key: "+arg0.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("your released a key: "+arg0.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("your typed a key: "+arg0.getKeyChar());
		String key=(""+arg0.getKeyChar()).toLowerCase();
		if(key.equalsIgnoreCase("w"))
			for(MyInternalFrame f:myIFList){
				f.setShowWinImage(!f.isShowWinImage());
			}
		else if(key.equalsIgnoreCase("l"))
			for(MyInternalFrame f:myIFList){
				f.setShowLoseImage(!f.isShowLoseImage());
			}
		else if(key.equalsIgnoreCase("f")){
			
			isFullScreen=!isFullScreen;
			System.out.println("full screen: "+isFullScreen);
			if(isFullScreen){
				JFrame newFrame=new JFrame();
				newFrame.add(frame.getContentPane());
				newFrame.setBounds(frame.getBounds());
				frame.dispose();
				
				frame=newFrame;
				
				fs.setFullScreen(null, frame);
		
			}else{
				JFrame newFrame=new JFrame();
				newFrame.add(frame.getContentPane());
				newFrame.setBounds(frame.getBounds());
				fs.CloseFullScreen();
				
				frame=newFrame;
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
			int gridW=frame.getWidth()/3;
			int gridH=frame.getHeight()/2;
			for(int i=0;i<2;i++){
				for(int j=0;j<3;j++){
					myIFList.get(i*3+j).setBounds(gap+gridW*j, gap+gridH*i, gridW-gap*2, gridH-gap*2);
				}}
		}
		try{
			int index=Integer.parseInt(key);
			numberCoverShow[index-1]=!numberCoverShow[index-1];
			for(MyInternalFrame f:myIFList){
				f.setFrontCoverByIndex(index-1, numberCoverShow[index-1]);
			}
		}catch(Exception e){
			System.out.println("not a number!");
		}
		
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("focusGained");
		
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("focusLost");
		
		
	}

}
