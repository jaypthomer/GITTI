package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	
	Image background;
	Font men�SchriftStart, men�SchriftOptionen, men�SchriftCredits;
	Font schriftSchwarz, schriftRot;
	
	MouseOverArea startKnopf, optionenKnopf, creditsKnopf;
	Sound knopfGedrueckt;
	
	int height, width;
	int xtitle1, ytitle1, xtitle2, ytitle2, xtitle3, ytitle3;

	public Menu(int state, int pWidth, int pHeight){
		super();
		height = pHeight;
		width = pWidth;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{ //throws=nicht um Exception k�mmern
		
		Image unscaledBackground = new Image("res/Pics/background.jpg");
		background = unscaledBackground.getScaledCopy(0.6f);
		
		schriftSchwarz = new AngelCodeFont("res/Fonts/TakeCoverSchwarz.fnt", new Image("res/Fonts/TakeCoverSchwarz.png"));
		schriftRot = new AngelCodeFont("res/Fonts/TakeCover.fnt", new Image("res/Fonts/TakeCover.png"));
		men�SchriftStart = schriftSchwarz;
		men�SchriftOptionen = schriftSchwarz;
		men�SchriftCredits = schriftSchwarz;
		
		this.titelPosition();
		
		// Achtung Image = null!!!
		startKnopf = new MouseOverArea(gc, null, xtitle1, ytitle1, men�SchriftStart.getWidth("START"), men�SchriftStart.getHeight("START"));
		optionenKnopf = new MouseOverArea(gc, null, xtitle2, ytitle2, men�SchriftStart.getWidth("OPTIONEN"), men�SchriftStart.getHeight("OPTIONEN"));
		creditsKnopf = new MouseOverArea(gc, null, xtitle3, ytitle3, men�SchriftStart.getWidth("CREDITS"), men�SchriftStart.getHeight("CREDITS"));
		
		knopfGedrueckt = new Sound("res/Sounds/button-29.ogg");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		
		g.setFont(men�SchriftStart); //render in mouseoverarea m�glich!!!
		g.drawString("START", xtitle1, ytitle1);
		g.setFont(men�SchriftOptionen);
		g.drawString("OPTIONEN", xtitle2, ytitle2);
		g.setFont(men�SchriftCredits);
		g.drawString("CREDITS", xtitle3, ytitle3);
		
	        
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{ 
		
			if((startKnopf.isMouseOver())){							
				men�SchriftStart = schriftRot;		
				if(Mouse.isButtonDown(0)){ 
					knopfGedrueckt.play();
					sbg.enterState(1);
						}
					} else {
						men�SchriftStart = schriftSchwarz;	
						}
			if(optionenKnopf.isMouseOver()){
				men�SchriftOptionen = schriftRot;
				if(Mouse.isButtonDown(0)){
					knopfGedrueckt.play();
					sbg.enterState(2);
						}
					} else {
						men�SchriftOptionen = schriftSchwarz;
							}										
			if(creditsKnopf.isMouseOver()){
				men�SchriftCredits = schriftRot;
				if(Mouse.isButtonDown(0)){ 
					knopfGedrueckt.play();
					sbg.enterState(3); 
						}		
					} else {
						men�SchriftCredits = schriftSchwarz;
						}
			
		}
	
	
	public int getID(){
		return 0;
	}


//Hilfsdienste

private void titelPosition() throws ArithmeticException {  //errechnet f�r Bildschirmgr��e x,y die Position der Fonts
	xtitle1 = (width/2-men�SchriftStart.getWidth("START")/2);
	xtitle2 = (width/2-men�SchriftStart.getWidth("OPTIONEN")/2);
	xtitle3 = (width/2-men�SchriftStart.getWidth("CREDITS")/2);
	
	ytitle1 = ((height/4)-((men�SchriftStart.getHeight("START"))/2));
	ytitle2 = ((height/2)-((men�SchriftStart.getHeight("OPTIONEN"))/2));
	ytitle3 = ((3*height/4)-((men�SchriftStart.getHeight("CREDITS"))/2));
}

}







