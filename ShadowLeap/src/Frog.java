import org.newdawn.slick.SlickException;


public class Frog extends Sprite{
	
	
	public Frog() throws SlickException {
		super("/assets/frog.png",512,720);   
		
	}
	
    public void move(float dx, float dy) {
        x += dx;
        y += dy;

		if (x < 0) {
			x = 0;
		}
		if (x > App.SCREEN_WIDTH) {
			x = App.SCREEN_WIDTH;
		}
		if (y < 0) {
			y = 0;
		}
		if (y > App.SCREEN_HEIGHT) {
			y = App.SCREEN_HEIGHT;
		}

	}

}
