import java.io.Serializable;


public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private Integer type;
	
	public Message(Integer t,String m) {
		type=t;
		message=m;
	}
	
	public String getMessage(){
		return message;
	}
	
	public Integer getType(){
		return type;
	}
}
