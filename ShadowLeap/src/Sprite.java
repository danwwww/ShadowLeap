import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import utilities.BoundingBox;

public class Sprite {
	 protected float x;
	 protected float y;
	 protected Image image;
	 protected BoundingBox bBox;
	 
	 public float getX() {
	        return x;
	    }
	 public float getY() {
	        return y;
	   }
	 
	public Sprite(){	
		} 
	 
	
	public Sprite(String imageSrc, float x, float y) throws SlickException {
		// Why would the constructor need a path to an image, and a coordinate?
		this.x=x;
		this.y=y;
		this.image=new Image(imageSrc);
		this.bBox=new BoundingBox(x,y,World.tileSize,World.tileSize);
	}
	
	public void update(Input input, int delta) {
		// How can this one method deal with different types of sprites?
	}
	
	public void render() {
		// This should be pretty simple.
		image.drawCentered(x, y);
	}
	
	public boolean contactSprite(Sprite other) {
		return this.bBox.intersects(other.bBox);
		
		/*JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				"Game Over!", "Game Over", JOptionPane.QUESTION_MESSAGE); 
		System.exit(0);*/
		// Should be called when one sprite makes contact with another. 
	}
	
	public void updateBbox() {
		this.bBox.setX(x);
		this.bBox.setY(y);
	}
	
}