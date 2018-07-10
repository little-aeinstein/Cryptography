import java.util.Scanner;

public class Encryptor {

	public static void main(String[] args) {

			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			System.out.print("Message: ");
			String message = sc.nextLine();
			System.out.print("Key: ");
			int key = sc.nextInt();
			
			
			String encryptedMessage = "";
			int letterCode;
			int result;
			
			for(int i=0; i<message.length(); i++){
				if(message.charAt(i) != ' ')
					letterCode = (int) message.charAt(i) - 64;
					
				else
					letterCode = 0;
				
				if(key >= 0)
					result = (letterCode + key)%27;
					
				else{
					result = letterCode + (key%27);
					if(result < 0)
						result = Math.abs(result-27);
				}
				
				if(result < 10)
					encryptedMessage = encryptedMessage.concat("0");
				
				encryptedMessage = encryptedMessage.concat(Integer.toString(result));	
			}
			
			System.out.print("Encrypted message: " + encryptedMessage);
			
			sc.close();
		}
}
