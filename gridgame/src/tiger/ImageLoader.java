package tiger;

import java.awt.Component;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
public class ImageLoader extends Component{
	static ImageLoader self=null;
	static ImageLoader getInstance(){
		self=self==null?new ImageLoader():self;
		return self;
	}
	public Image getImage(URL url){
		
		{
			/* Get the toolkit from this Component */
			Toolkit t = java.awt.Toolkit.getDefaultToolkit();
//			Toolkit t = getToolkit();
			/* Begin a retrieval of a remote image */
			Image   i = t.getImage(url);
			/* Create a new MediaTracker linked to this Component */
			MediaTracker m = new MediaTracker( this );
			/* Add the loading image to the MediaTracker,
			   with an ID of 1 */
			m.addImage( i, 1 );
			/* Explicitly wait for the image to load */
			try
			{
				m.waitForAll();
			}
			/* Catch the exception */
			catch( InterruptedException e )
			{
				System.out.println("Loading of the image was interrupted" );
			}

			/* Check the status */
//			if( m.ststatus() & MedaiTracker.LOADING )
//				System.out.println("Still Loading - oops, we should never be here!");
//			if( m.status() & MediaTracker.ABORTED )
//				System.out.println("Loading of image aborted");
//			if( m.status() & MediaTracker.ERRORED )
//				System.out.println("Image was errored");
//			if( m.status() & MediaTracker.COMPLETE )
//				System.out.println("Image load complete!");
			return i;
		}
	}
public Image getImage(String path){
		
		{
			/* Get the toolkit from this Component */
			Toolkit t = java.awt.Toolkit.getDefaultToolkit();
//			Toolkit t = getToolkit();
			/* Begin a retrieval of a remote image */
			Image   i = t.getImage(path);
			/* Create a new MediaTracker linked to this Component */
			MediaTracker m = new MediaTracker( this );
			/* Add the loading image to the MediaTracker,
			   with an ID of 1 */
			m.addImage( i, 1 );
			/* Explicitly wait for the image to load */
			try
			{
				m.waitForAll();
			}
			/* Catch the exception */
			catch( InterruptedException e )
			{
				System.out.println("Loading of the image was interrupted" );
			}

			/* Check the status */
//			if( m.ststatus() & MedaiTracker.LOADING )
//				System.out.println("Still Loading - oops, we should never be here!");
//			if( m.status() & MediaTracker.ABORTED )
//				System.out.println("Loading of image aborted");
//			if( m.status() & MediaTracker.ERRORED )
//				System.out.println("Image was errored");
//			if( m.status() & MediaTracker.COMPLETE )
//				System.out.println("Image load complete!");
			return i;
		}
	}
}
