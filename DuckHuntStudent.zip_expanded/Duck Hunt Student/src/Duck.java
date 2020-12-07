import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Duck implements MouseListener{
	private int x = 300,y = 300;
	private int vx, vy;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public Duck() {
		img = getImage("Mothman.png"); //load the image for Tree
		init(x, y); 				//initialize the location of the image
		vy=(int)(Math.random()*(-2+4+1)-4);
		vx = (int)(Math.random()*(6-4+1)+4);
		if((Math.random())<.5) {
			vx*=-1;
		}
	}
	
	public void paint(Graphics g) {
		
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		/*get the bird tomove randomly up from the bottom of the screen
		 * it should start at the bottom
		 * makeit bounce off of the top and side borders
		 */
	
		
		if(x<0) {
			vx*=-1;
			x=0;
		}
			if(x>750) {
				vx*=-1;
				x=750;
			
		}
		if(y<-250) {
			y=400;
			x=(int)(Math.random()*(601)+0);
			vx = (int)(Math.random()*(6-2)+3);
			if((Math.random())<.5) {
				vx*=-1;
			}
			
		}
		if(y>400) {
			y=400;
			vy*=-1;
		}
		y+=vy;
		x+=vx;

		tx.setToTranslation(x, y);
		g2.drawImage(img, tx, null);   
		}
	
	public boolean collided(int mX, int mY) {
	//print out mouse information
	System.out.println(mX+ ":" +mY);
	
	//represent the duck as a rectangle object!
	Rectangle a = new Rectangle(x+30,y+50,100,100);
	
	Rectangle b = new Rectangle(x-50,y,300,350);
	//check if mouse x, y is in the rectangle
	if(a.contains(mX, mY)) {
		Music thud = new Music("monkey.wav", false);
		System.out.println("ouch");
		thud.play();

		y=400;
			x=(int)(Math.random()*(601)+0);
			vx = (int)(Math.random()*(6-2)+3);
			if((Math.random())<.5) {
				vx*=-1;}
	}
	if(b.contains(mX, mY)&& !a.contains(mX, mY)) {
		Music haha = new Music("haha.wav", false);
		//if someone was sort of close
		//use haha sound
		System.out.println("haha");
		haha.play();
	}
		return false;
	
	}
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Duck.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	
		
		System.out.println("ouch");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
