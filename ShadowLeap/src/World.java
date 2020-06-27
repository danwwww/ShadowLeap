import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class World {
	private Image water;
	private Image grass;
	private Frog player;
	private ArrayList<Bus> buses432 = new ArrayList<Bus>();
	private ArrayList<Bus> buses480 = new ArrayList<Bus>();
	private ArrayList<Bus> buses528 = new ArrayList<Bus>();
	private ArrayList<Bus> buses576 = new ArrayList<Bus>();
	private ArrayList<Bus> buses624 = new ArrayList<Bus>();
	public static int tileSize=48;
	private int busY=0;	
	
	
	public World() throws SlickException {
		// Perform initialisation logic
		//import the grass and water image
		water = new Image("assets/water.png");
		grass = new Image("assets/grass.png");
		//create the frog
		player = new Frog();
		
		//create all the buses
		
		busY=432;
		for (int offset=48;offset<App.SCREEN_WIDTH;offset+=6.5*tileSize) {
			buses432.add(new Bus(offset, busY));
			}
		
		busY=482;
		for (int offset=0;offset<App.SCREEN_WIDTH;offset+=5*tileSize) {
			buses480.add(new Bus(offset, busY));
			}
		busY=528;
		for (int offset=64;offset<App.SCREEN_WIDTH;offset+=12*tileSize) {
			buses528.add(new Bus(offset, busY));
			}
		
		busY=576;
		for (int offset=128;offset<App.SCREEN_WIDTH;offset+=5*tileSize) {
			buses576.add(new Bus(offset, busY));
			}
		
		busY=624;
		for (int offset=250;offset<App.SCREEN_WIDTH;offset+=6.5*tileSize) {
			buses624.add(new Bus(offset, busY));
			
			}

	}
	
	public void update(Input input, int delta) {
		// Update the player in the game
		int Px = 0, Py = 0,Bx=0;
		
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			System.exit(0);
		}
		
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			Px -= 48;
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			Px += 48;
		}
		if (input.isKeyPressed(Input.KEY_UP)) {
			Py -= 48;
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			Py += 48;
		}
		player.move(Px, Py);
		if(player.getY()<=336) {
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"You win!", "You win", JOptionPane.QUESTION_MESSAGE); 
					System.exit(0);	}

		
		
		
		
		
		//update the buses in the game
		for(int i =0;i<buses432.size();i++) {
			Bx=-3;
			buses432.get(i).updateBbox();
			buses432.get(i).move(Bx);
			if(buses432.get(i).contactSprite(player)==true) {
				JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				"Game Over!", "Game Over", JOptionPane.QUESTION_MESSAGE); 
				System.exit(0);		
			}

			
		}
		
		for(int i =0;i<buses480.size();i++) {
			Bx=3;
			buses480.get(i).updateBbox();
			buses480.get(i).move(Bx);
			if(buses480.get(i).contactSprite(player)==true) {
				JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				"Game Over!", "Game Over", JOptionPane.QUESTION_MESSAGE); 
				System.exit(0);		
			}
		
		}
		
		for(int i =0;i<buses528.size();i++) {
			Bx=-3;
			buses528.get(i).updateBbox();
			buses528.get(i).move(Bx);
			if(buses528.get(i).contactSprite(player)==true) {
				JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				"Game Over!", "Game Over", JOptionPane.QUESTION_MESSAGE); 
				System.exit(0);		
			}

			
		}
		
		for(int i =0;i<buses576.size();i++) {
			Bx=3;
			buses576.get(i).updateBbox();
			buses576.get(i).move(Bx);
			if(buses576.get(i).contactSprite(player)==true) {
				JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				"Game Over!", "Game Over", JOptionPane.QUESTION_MESSAGE); 
				System.exit(0);		
			}

			
		}
		
		for(int i =0;i<buses624.size();i++) {
			Bx=-3;
			buses624.get(i).updateBbox();
			buses624.get(i).move(Bx);
			if(buses624.get(i).contactSprite(player)==true) {
				JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				"Game Over!", "Game Over", JOptionPane.QUESTION_MESSAGE); 
				System.exit(0);		
			}

		}
		
		
		
		
	}
	
	public void render(Graphics g) {
		//drawing all the water
		for(int i =0;i<App.SCREEN_WIDTH;i+=tileSize) {
			for(int j =48;j<=336;j+=tileSize) {
				water.drawCentered(i,j);
			}
		}
		//drawing all the grass
		for(int i =0;i<App.SCREEN_WIDTH;i+=tileSize ) {
			grass.drawCentered(i,384);
			grass.drawCentered(i,672);
			
		}
		
		
		
		//drawing all the buses
		for(int i =0;i<buses432.size();i++) {
			buses432.get(i).render();	
			
		}
		
		for(int i =0;i<buses480.size();i++) {
			buses480.get(i).render();	
			
		}
		
		for(int i =0;i<buses528.size();i++) {
			buses528.get(i).render();	
			
		}
		
		for(int i =0;i<buses576.size();i++) {
			buses576.get(i).render();	
			
		}
		
		for(int i =0;i<buses624.size();i++) {
			buses624.get(i).render();	
			
		}
		
		//draw the frog
		player.updateBbox();
		player.render();



	}
}
