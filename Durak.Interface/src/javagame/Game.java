package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {
	
	public static final String gamename= "Durak - Sei kein Arsch!";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int opt = 2;
	public static final int credits = 3;
	
	public static final int x = 900;
	public static final int y = 600;
	
	public Game(String gamename) {
		super(gamename);
		this.addState(new Menu(menu, x, y));
		this.addState(new Play(play));
		this.addState(new Optionen(opt));
		this.addState(new Credits(credits));
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new Game(gamename)); //Bildschirm erstellen
			appgc.setDisplayMode(x, y, false); //Größe,Fullscreen ja/nein
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(opt).init(gc, this);
		this.getState(credits).init(gc, this);
		this.enterState(menu);
	}

}
