import java.util.Scanner;

public class Palindrome {

		public static void main(String[] args) {
			Scanner sc = new  Scanner(System.in);
			System.out.println("Enter a String to check whether it is Palindrome or not");
			String str = sc.nextLine();
			String reversedString = "";
			for(int i = str.length()-1 ; i >= 0; i--) {
				reversedString += str.charAt(i);
			}
			
			if(str.equals(reversedString)) {
				System.out.println(str + " is a palindrome");
			}
			else {
				System.out.println(str + " is not a palindrome");
			}
		}
	}


