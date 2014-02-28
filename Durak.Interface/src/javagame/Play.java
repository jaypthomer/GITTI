package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	
	public Image ball;
	public Image tisch;
	
	int ballX = 100;
	int ballY = 100;
	
	public Play(int state){
		super();
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{ //throws=nicht um Exception kümmern
		Image unscaledTisch = new Image("res/Pics/tisch.jpg");
		tisch = unscaledTisch.getScaledCopy(1.2f);
		ball = new Image("res/Pics/Basketball.png");
		
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(tisch, 0, 0);
		g.drawImage(ball, ballX, ballY);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{ 
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_UP)){
			ballY -= 1;
		}if(input.isKeyDown(Input.KEY_DOWN)){
			ballY += 1;
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			ballX -= 1;
		}
		if(input.isKeyDown(Input.KEY_RIGHT)){
			ballX += 1;
		}
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			sbg.enterState(0);
		}
	}
	
	public int getID(){
		return 1;
	}
}
