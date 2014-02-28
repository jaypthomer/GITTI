package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	
	Image background;
	Font menüSchriftStart, menüSchriftOptionen, menüSchriftCredits;
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
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{ //throws=nicht um Exception kümmern
		
		Image unscaledBackground = new Image("res/Pics/background.jpg");
		background = unscaledBackground.getScaledCopy(0.6f);
		
		schriftSchwarz = new AngelCodeFont("res/Fonts/TakeCoverSchwarz.fnt", new Image("res/Fonts/TakeCoverSchwarz.png"));
		schriftRot = new AngelCodeFont("res/Fonts/TakeCover.fnt", new Image("res/Fonts/TakeCover.png"));
		menüSchriftStart = schriftSchwarz;
		menüSchriftOptionen = schriftSchwarz;
		menüSchriftCredits = schriftSchwarz;
		
		this.titelPosition();
		
		// Achtung Image = null!!!
		startKnopf = new MouseOverArea(gc, null, xtitle1, ytitle1, menüSchriftStart.getWidth("START"), menüSchriftStart.getHeight("START"));
		optionenKnopf = new MouseOverArea(gc, null, xtitle2, ytitle2, menüSchriftStart.getWidth("OPTIONEN"), menüSchriftStart.getHeight("OPTIONEN"));
		creditsKnopf = new MouseOverArea(gc, null, xtitle3, ytitle3, menüSchriftStart.getWidth("CREDITS"), menüSchriftStart.getHeight("CREDITS"));
		
		knopfGedrueckt = new Sound("res/Sounds/button-29.ogg");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		
		g.setFont(menüSchriftStart); //render in mouseoverarea möglich!!!
		g.drawString("START", xtitle1, ytitle1);
		g.setFont(menüSchriftOptionen);
		g.drawString("OPTIONEN", xtitle2, ytitle2);
		g.setFont(menüSchriftCredits);
		g.drawString("CREDITS", xtitle3, ytitle3);
		
	        
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{ 
		
			if((startKnopf.isMouseOver())){							
				menüSchriftStart = schriftRot;		
				if(Mouse.isButtonDown(0)){ 
					knopfGedrueckt.play();
					sbg.enterState(1);
						}
					} else {
						menüSchriftStart = schriftSchwarz;	
						}
			if(optionenKnopf.isMouseOver()){
				menüSchriftOptionen = schriftRot;
				if(Mouse.isButtonDown(0)){
					knopfGedrueckt.play();
					sbg.enterState(2);
						}
					} else {
						menüSchriftOptionen = schriftSchwarz;
							}										
			if(creditsKnopf.isMouseOver()){
				menüSchriftCredits = schriftRot;
				if(Mouse.isButtonDown(0)){ 
					knopfGedrueckt.play();
					sbg.enterState(3); 
						}		
					} else {
						menüSchriftCredits = schriftSchwarz;
						}
			
		}
	
	
	public int getID(){
		return 0;
	}


//Hilfsdienste

private void titelPosition() throws ArithmeticException {  //errechnet für Bildschirmgröße x,y die Position der Fonts
	xtitle1 = (width/2-menüSchriftStart.getWidth("START")/2);
	xtitle2 = (width/2-menüSchriftStart.getWidth("OPTIONEN")/2);
	xtitle3 = (width/2-menüSchriftStart.getWidth("CREDITS")/2);
	
	ytitle1 = ((height/4)-((menüSchriftStart.getHeight("START"))/2));
	ytitle2 = ((height/2)-((menüSchriftStart.getHeight("OPTIONEN"))/2));
	ytitle3 = ((3*height/4)-((menüSchriftStart.getHeight("CREDITS"))/2));
}

}







