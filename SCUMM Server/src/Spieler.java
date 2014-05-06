
public class Spieler {
	private int id;
	private String username;
	//private int score;

	public Spieler(){
		id=-1;
		username=null;
	}
	public Spieler(int id_,String name) {
		username=name;
	}

	public int getId(){
		return id;
	}
	public String getName(){
		return username;
	}
	public void disconnect(){
		id=-1;
		username=null;
	}
	

}
