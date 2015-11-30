package reservation_vols;

public class DejaEnregistreException extends Exception {
	public DejaEnregistreException(){
		super();
	}
	public DejaEnregistreException(String msg){
		super(msg);
	}
}
