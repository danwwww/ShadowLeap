import org.newdawn.slick.SlickException;

public class Bus extends Sprite{

	public Bus(float x, float y) throws SlickException {
		super("/assets/bus.png",x,y);
	}
	
	public void move(float dx) {
        x += dx;

		if (x < 0) {
			x = App.SCREEN_WIDTH-World.tileSize;
		}
		
		if (x > App.SCREEN_WIDTH-World.tileSize) {
			x = 0;
		}
    }
	
	
}