package reservation_vols;

public class VolCompletException extends Exception {
	public VolCompletException(){
		super();
	}
	public VolCompletException(String msg){
		super(msg);
	}
}
