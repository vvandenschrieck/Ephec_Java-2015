package unittest;

public class MyMath {
	
	/**
	 * Cette methode calcule la factorielle de n
	 * @param n : un entier
	 * @return Si n >= 0 : renvoie n!
	 * @exception une NonPositiveException est lancee
	 * si n est negatif.  
	 */
	public static int fact(int n) throws NonPositiveException{
		if(n==1 || n==0)
			return 0;
		else if(n>1)
			return n*fact(n-1);
		else 
			throw new NonPositiveException("Parametre de la methode negatif : "+n);
	}

}
