package FractionalUnitTest;

//Mustafa NAZLIER 15050111035 - HW6
//final code that I have sent as homework-6
public class Fractional {
	public final long numerator;
	public final long denominator;
	public static final String NotANumber = "Not a Number";
	public static final String PositiveInfinity = "+Infinity";
	public static final String NegativeInfinity = "-Infinity";
	public String fract; // I will use this extra variable for showing fraction value as string
	
	Fractional(long numerator, long denominator) {	
		this.numerator = numerator;
		this.denominator = denominator;
		fract = numerator + "/" + denominator;
	}
	
	Fractional simplify() {
		if (isNaN()) 
		 {
			return null;
		 }
		
		if (isInfinity()) {
			
			return null;
		}
	
		long gcd= gcd();
	
		return new Fractional(this.numerator / gcd,this.denominator /gcd);
		
		
		
	}
	
 
	boolean isNaN() {
		if (this.numerator == 0 && this.denominator == 0 ) {
			return true;
		}

		return false;
	}

	boolean isInfinity() {
		if (this.numerator != 0  && this.denominator == 0) {
			return true;
		}

		return false;
	}
	
	int sign(long numerator, long denominator) {
		if (numerator == 0 && denominator == 0) {
			return 0;
		}

		if (numerator != 0 && denominator == 0) {
			if (numerator > 0) {
				return 1;
			}
			return -1;
		}

		long x = numerator * denominator;
		if (x < 0) {
			return -1;
		}

		else if (x > 0) {
			return 1;
		}

		return 0;
	}
	
	int sign() {
		if (isInfinity()) {
			if (this.numerator > 0) {
				return 1;
			} else {
				return -1;
			}
		}

		if (isNaN()) {  //if number is not a number when checking with sign, it returns zero so
			            //we can deal with this without throwing an exception
			return 0;
		}

		long x =this.numerator*this.denominator;
		 if (x == 0) {
			return 0;
		}
		 else if (x < 0) {
			return -1;
		}  else {
			return 1;
		}
	}

	@Override
	public boolean equals(Object fraction) {
		Fractional checker = (Fractional) fraction;
 
		if((this.numerator / this.denominator) == (checker.numerator / checker.denominator))
		return true;
		
		else return false;
	}

	@Override
	public String toString() {
		if (isNaN()) {
			return NotANumber;
		}

		if (isInfinity()) {
			if (sign() == +1) {
				return PositiveInfinity;
			} 
			else if (sign() == -1){
				return NegativeInfinity;
			}
		}

		return this.fract;
	}
	
	// The function that finds greatest common divisor of the numerator and denominator
	public long gcd(){
		
		if (isNaN()) {
			return 0;
		}

		if (isInfinity()) {
			return 0;
		}
		
		long a=this.numerator;
		long b=this.denominator;
		
	    if(a<0)
	        a=-1*a;            //Euclidean algorithm for finding greatest common divisor
	    if(b<0)                //The first two if checks if numerator and denominator are 
	        b=-1*b;            //negative, if they are, it makes them all positive
	    long t;                //to give the same GDC to negative and positive given numbers
	    while(b!=0){
	        t=b;
	        b = a%b;
	        a = t;          
	    }
	    return a;
	}
	
	
	
	
	
	
	
	
	
	
	

}

