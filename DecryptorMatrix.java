import java.util.Scanner;

public class DecryptorMatrix {
	
    public static double[][] Inverse(double a[][]){
    	double determinand = a[0][0]*a[1][1] - a[0][1]*a[1][0];
    	if(determinand != 0){
    	while(determinand < 0)
    		determinand += 27;
    		
    	int x = 1;
    	while((determinand*x)%27 != 1 && x < 26)
    		x++;
    	
    	double adjugate[][] = {
    			{a[1][1], a[0][1]*-1},
    			{a[1][0] * -1, a[0][0]}
    			};
    	while(adjugate[0][0] < 0)
    		adjugate[0][0] += 27; 		
    	while(adjugate[0][1] < 0)
    		adjugate[0][1] += 27;		
    	while(adjugate[1][0] < 0)
    		adjugate[1][0] += 27;  		
    	while(adjugate[1][1] < 0)
    		adjugate[1][1] += 27;
    		
    	double i11 = (adjugate[0][0]*x) % 27;	
    	double i12 = (adjugate[0][1]*x) % 27;	
    	double i21 = (adjugate[1][0]*x) % 27; 
    	double i22 = (adjugate[1][1]*x) % 27;
    
    	double inverse[][] = {
    			{i11, i12},
    			{i21, i22}
    			};
    	
    	return inverse;
    	}
    	else
    		return a;
    	}
    
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Coded message: ");
		String message = sc.nextLine();
		System.out.print("Enter key matrix [1][1]: ");
		int a11 = sc.nextInt();
		System.out.print("Enter key matrix [1][2]: ");
		int a12 = sc.nextInt();
		System.out.print("Enter key matrix [2][1]: ");
		int a21 = sc.nextInt();
		System.out.print("Enter key matrix [2][2]: ");
		int a22 = sc.nextInt();
		
		double  key[][] = {
						{a11, a12}, 
						{a21, a22}
					  };
		
		double inverseKey[][] = Inverse(key);
		
		if(inverseKey != key){
		String decryptedMessage = "";
		int letterCode[] = new int[2];
		int result;
		int i;
		int intTemp;
		
		for(i=0; i< message.length(); i+=2){
			if(message.charAt(i) != ' ')
				letterCode[0] = (int) message.charAt(i) - 64;
				
			else
				letterCode[0] = 0;
			
			if(message.charAt(i+1) != ' ')
				letterCode[1] = (int) message.charAt(i+1) - 64;
				
			else
				letterCode[1] = 0;
				
			for(int row = 0; row < 2; row++){
				result = 0;
				
				for(int x = 0; x < 2; x++){
					result += letterCode[x]*inverseKey[row][x];
				}
				result = result % 27;
				
				if(result == 0)
					intTemp = 32;
				
				else
					intTemp = result+64;
				
				decryptedMessage = decryptedMessage.concat(String.valueOf((char) intTemp));
			}
			
		}
		System.out.print("Encrypted message: " + decryptedMessage);
		}
		
		else
			System.out.print("Matrix invalid");
		sc.close();
	}
}
