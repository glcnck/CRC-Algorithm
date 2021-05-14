import java.util.Scanner;

public class CRC {
	public static void main(String args [])
	{
		Scanner scanner = new Scanner(System.in);
		//Enter the message
		System.out.print("Enter the message:");
		String input = scanner.nextLine();
		
		//Enter the generator
		System.out.print("Enter the polynomial generator:");
		String generator = scanner.nextLine();
		
		//created int message variable as the size of input 
		int message[] = new int[input.length()+generator.length()-1]; 
		//created int divisor as the size of the generator
		int remainder[] = new int[generator.length()];
		
		//the input bits copied to the message as int
		for(int i=0; i<input.length(); i++) {
			message[i] = Integer.parseInt(input.charAt(i)+"");
		}
		
		//the generator bits copied to the divisor as int
		for(int i=0; i<generator.length(); i++) {
			remainder[i] = Integer.parseInt(generator.charAt(i)+"");
		}
		
		//the input and divisor xor 
		for(int i=0; i<input.length(); i++)
		{
			if(message[i]==1) {
				for(int j=0; j<remainder.length; j++)
					message[i+j]^=remainder[j];
			}
		}
		
		System.out.print("The CRC code is:");
		for(int i=0; i<input.length(); i++)
			message[i]=Integer.parseInt(input.charAt(i)+"");
		for(int i= 0; i<message.length; i++)
			System.out.print(message[i]);
		System.out.println();
		
		//the message with remainder
		System.out.print("Enter the message you want to send:");
		input = scanner.nextLine();
		message = new int[input.length()+generator.length()-1];
		remainder = new int[generator.length()];
		
		for(int i=0; i<input.length(); i++)
			message[i] = Integer.parseInt(input.charAt(i)+"");
		
		for(int i=0; i<generator.length(); i++)
			remainder[i] = Integer.parseInt(generator.charAt(i)+"");
		
		
		//the message and generator xor 
		for(int i=0; i<input.length(); i++)
		{
			if(message[i]==1) {
				for(int j=0; j<remainder.length; j++)
					message[i+j]^=remainder[j];
			}
		}
		
		boolean alter = true;
		for(int i=0; i<message.length; i++) {
			if(message[i]==1) {
				alter= false;
				break;
			}
		}
		
		if(alter==true)
			System.out.println("The message sent successfully. There is no error.");
		else 
			System.out.print("The message has changed. There is an error in the message.");
	}

}
