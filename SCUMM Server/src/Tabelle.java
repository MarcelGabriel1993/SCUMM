
public class Tabelle {
	private Spieler liste[];
	private int MAX_SPIELER=6;
	private int count; 
	
	public Tabelle(){
		
		liste=new Spieler[MAX_SPIELER];
		for(int i=0;i<MAX_SPIELER;i++){
			liste[i].disconnect();
		}
	}
	
	public void sortSpieler(){
		Spieler[] tmp=new Spieler[MAX_SPIELER];
		int a=0;
		for(int i=0;i<MAX_SPIELER;i++){		//in tmp[] alle gefüllten Spieler speichern
			if(liste[i].getName()!=null){
				tmp[a]=liste[i];
				a++;
			}
		}
		for(int i=0;i<MAX_SPIELER;i++){		//leere Plätze füllen
			if(i<a){
				liste[i]=tmp[i];
			}
			else{
				liste[i].disconnect();
			}
		}
	}
	
	public void countSpieler(){
		count=0;
		for(int i=0;i<MAX_SPIELER;i++){
			if(liste[i].getId()!=-1){
				count++;
			}
		}
	}
	
	public void addSpieler(Spieler s){
		countSpieler();
		if(count<MAX_SPIELER){
			sortSpieler();
			for (int i=0;i<MAX_SPIELER;i++){
				if(liste[i].getId()!=-1){
					liste[i]=s;
					break;
				}
			}
		}
		else{
			//send zu viele Spieler
		}
		
	}
	
	
}
