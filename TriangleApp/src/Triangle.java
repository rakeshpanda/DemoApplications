import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
	private Double sideA;
	private Double sideB;
	private Double sideC;
	
	

    
    private Triangle(){}
    
    private Triangle(double a , double b , double c){
    	sideA = a;
    	sideB = b;
    	sideC = c;
    }
    
    public static Triangle getInstance(double a , double b , double c){
    	if(a > 0 && b > 0 && c > 0){
    		if(a + b >= c || (a + c >= b) || (b+c >= a)){
    			Triangle instance = new Triangle(a, b, c);
    			return instance;
    		}
    		
    	}
    	System.err.println("Invalid dimensions !");
        return null;
    }
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean exitFlow = false;
		Triangle myTriangle = null;
		while(!exitFlow){
        System.out.print("Enter dimensions of triangle ");
        System.out.println( "dimension a ? " );
        String s1 = br.readLine();
        System.out.println( "dimension b ? " );
        String s2 = br.readLine();
        System.out.println( "dimension c ? " );
        String s3 = br.readLine();
        try{
        	 myTriangle =  Triangle.getInstance( new Double(s1),  new Double(s2),  new Double(s3));
        	 if(myTriangle != null){
        		 System.out.println( myTriangle.getTriangleType());	 
        	 }
        	
        	
       }catch(NumberFormatException nfe){
            System.err.println("Invalid dimensions!");
        }
        
        System.out.print("Press Y to continue N to Exit");
        String s4 = br.readLine();
        if("N".equalsIgnoreCase(s4)){
        	exitFlow = true;
        	System.out.print("Thank You");
        }
		}

	}
	
	public String getTriangleType(){
		if(sideA.compareTo(sideB) == 0  || (sideA.compareTo(sideC) == 0)) {
			if(sideB.compareTo(sideC) == 0){
				return "Equilateral";
			} else return "Isosceles";
			
		} else if(sideB.compareTo(sideC) == 0) {
			return "Isosceless";
		} else return "Scalene";
		
	}
	
	

}
