import java.util.Scanner;

public class EncryptorJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Message: ");
		String message = sc.nextLine();
		System.out.print("Enter key matrix [1][1]: ");
		int a11 = sc.nextInt();
		System.out.print("Enter key matrix [1][2]: ");
		int a12 = sc.nextInt();
		System.out.print("Enter key matrix [2][1]: ");
		int a21 = sc.nextInt();
		System.out.print("Enter key matrix [2][2]: ");
		int a22 = sc.nextInt();
		
		int key[][] = {
						{a11, a12}, 
						{a21, a22}
					  };
		
		String encryptedMessage = "";
		int letterCode[] = new int[2];
		int result;
		int i = 0;
		int intTemp;
		if(message.length() % 2 != 0)
			message = message.concat(" ");
		while(i < message.length()){
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
					result += letterCode[x]*key[row][x];
				}
				result = result % 27;
				if(result < 0)
					result = 27 - result;
				
				if(result == 0)
					intTemp = 32;
				
				else
					intTemp = result+64;
				
				encryptedMessage = encryptedMessage.concat(String.valueOf((char) intTemp));
			}
			
			i += 2;
		}
		System.out.print("Encrypted message: " + encryptedMessage);
		
		sc.close();
		
	}

}
