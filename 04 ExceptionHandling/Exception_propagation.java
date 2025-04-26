package ExceptionHandling;

public class Exception_propagation {
	public static double CalculateInterest(double amount, double rate, int years) throws IllegalArgumentException{
		if(amount<0|| rate<0) {
			throw new IllegalArgumentException("Amount or rate can,t be nagative");
		}
		return amount*rate*years/100;
	}
	
	public static void main(String[] args) {
		try {
			double interest= CalculateInterest(10000, -5, 2);
			System.out.println("Interest: "+ interest);
		}catch(IllegalArgumentException e) {
			System.out.println("Invalid Input");
		
	} 
	}
}
