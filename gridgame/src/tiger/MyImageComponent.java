package tiger;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

public class MyImageComponent extends Component {
	Image image=null;
	Image frontCoverImage=null;
	boolean showFrontCover=false;
	public boolean isShowFrontCover() {
		return showFrontCover;
	}
	public void setShowFrontCover(boolean showFrontCover) {
		this.showFrontCover = showFrontCover;
		repaint();
	}
	public Image getFrontCoverImage() {
		return frontCoverImage;
	}
	public void setFrontCoverImage(Image frontCoverImage) {
		this.frontCoverImage = frontCoverImage;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		
		if(image!=null)
			arg0.drawImage(image,0,0,this.getWidth(),this.getHeight(),null);
		if(frontCoverImage!=null && showFrontCover)
			arg0.drawImage(frontCoverImage,0,0,this.getWidth(),this.getHeight(),null);
		
	}

}
