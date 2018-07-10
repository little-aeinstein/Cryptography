import java.util.Scanner;

public class Decryptor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Coded message: ");
		String encryptedMessage = sc.nextLine();
		System.out.print("Key: ");
		int key = sc.nextInt();
		String decryptedMessage = "";
		for(int i=0; i<encryptedMessage.length(); i+=2){
			int code = Integer.parseInt(encryptedMessage.substring(i, i+2));
			int result;
			int temp;
			
			if(code < 28){
				temp = 27 - (key%27);
				result = (code+temp)%27;
			}
			
			else{
				temp = code - 27;
				result = Math.abs(key%27)-temp;
			}
			
			if(result == 0)
				decryptedMessage = decryptedMessage.concat(" ");

			else{
					int intTemp = result+64;
					decryptedMessage = decryptedMessage.concat(String.valueOf((char) intTemp));
				}
		}
		
		System.out.println("Decrypted Message: " + decryptedMessage);
		
		sc.close();
	}
}
