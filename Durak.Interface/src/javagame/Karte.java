package javagame;

import org.newdawn.slick.*;

public class Karte {
	
	private int wert;
	private int iFarbe;
	private String Farbe;
	
	public Image bild;
	
	public Karte(int pWert, int intFarbe){
		wert=pWert; iFarbe=intFarbe;
		switch (intFarbe){ 
		case 0: Farbe="k"; break; 
		case 1: Farbe="p"; break; 
		case 2: Farbe="h"; break;
		case 3: Farbe="c"; break;
			}
		
		try {
		bild = new Image(("res/Pics/Karten/"+intFarbe+","+wert+".gif"));
			} catch (SlickException e){};
			
		} 
	
	public void setzeWert(int pWert){
		wert =pWert;
		} 
	
	public void setzeFarbe(String pFarbe){ 
		Farbe = pFarbe; 
		}
	
	public void setzeFarbe(int pFarbe){
		iFarbe = pFarbe;
		}
	
	public int gibWert(){
		return wert;
		}
	
	public String gibFarbeAlsString(){
		return Farbe;
		} 
	
	public int gibFarbeAlsZahl(){
		return iFarbe;
		} 
	
	public Image gibBild(){
		return bild;
	}
	
}