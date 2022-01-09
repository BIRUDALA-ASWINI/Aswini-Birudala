import java.util.Scanner;

public class OwnSplitVersion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a line of words");
		String s1 = sc.nextLine();
		int fromIndex = 0;
		int spaceIndex = s1.indexOf(' '); 
		int commaIndex = s1.indexOf(','); 
		int semiColonIndex = s1.indexOf(';'); 
		int dotIndex = s1.indexOf('.');
		int leftBracket = s1.indexOf('(');
		int rightBracket = s1.indexOf(')');
		int toIndex = findMinAmong(commaIndex, semiColonIndex, dotIndex, spaceIndex, leftBracket, rightBracket);
		String word;
		while (toIndex != -1) {
			word = s1.substring(fromIndex, toIndex); 
			System.out.println(word); 
			toIndex = trimLeadingDelims(s1, toIndex); 
			fromIndex = toIndex + 1;
			spaceIndex = s1.indexOf(' ', fromIndex); 
			commaIndex = s1.indexOf(',', fromIndex);
			semiColonIndex = s1.indexOf(';', fromIndex);
			leftBracket = s1.indexOf('(', fromIndex);
			rightBracket = s1.indexOf(')', fromIndex);
			dotIndex = s1.indexOf('.', fromIndex); 
			toIndex = findMinAmong(commaIndex, semiColonIndex, dotIndex, spaceIndex, leftBracket, rightBracket); 
		}
		 word = s1.substring(fromIndex);
		 System.out.println(word);
	}

	static int findMinAmong(int commaIndex, int semiColonIndex, int dotIndex, int spaceIndex, int leftBracket,int rightBracket) {
		int[] numbers = { commaIndex, semiColonIndex, dotIndex, spaceIndex, leftBracket, rightBracket };
		int min = -1;
		for (int i = 0; i < numbers.length; i++) {
			if (min == -1) {
				if (numbers[i] != -1) {
					min = numbers[i];
				}
			} else if (numbers[i] != -1 && numbers[i] < min) {
				min = numbers[i];
			}
		}
		return min;
	}

	static int trimLeadingDelims(String s1, int toIndex) {
		char c1 = s1.charAt(toIndex + 1);
		while (c1 == ' ' || c1 == '.' || c1 == ';' || c1 == '(' || c1 == ')' || c1 == ',') {
			++toIndex;
			try {
				if (c1 != s1.charAt(toIndex + 1)) {
					c1 = s1.charAt(toIndex + 1);
				}
			} catch (Exception e) {

			}
		}
		return toIndex;
	}
}
