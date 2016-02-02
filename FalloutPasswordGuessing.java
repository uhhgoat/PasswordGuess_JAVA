import java.util.Scanner ;
public class FalloutPasswordGuessing {
	static String[] words = {"hello", "bacon", "words", "letters", "indubitably", "jokes", "people", "harsh", "mock", "friend", 
			"program", "hacker", "computer", "phone", "case", "array", "fallout"} ;
	static String password = words[(int)(Math.random()*words.length)] ;
	static Scanner input = new Scanner(System.in) ;
	static int numGuesses = 5 ;
	static int numChars = 0 ;
	static char letter ;
	static String output = "" ;
	static String entry ;
	public static void main(String[] args) {
		while(numGuesses > 0) {
			printArrayContent(words) ;
			System.out.println("Choose the correct password. " + numGuesses + " tries remaining.") ;
			numChars = 0 ;
			output = "" ;
			entry = waitForInput() ;
			numGuesses-- ;
			if(entry.equals(password)) {
				for(int j = 0 ; j < password.length() ; j++) {
					output += " *" ;
				}
				System.out.println(output) ;
				System.out.println("Correct, you have have access.") ;
				return ;
			}
			for(int i = 0 ; i < entry.length() ; i++) {
				letter = entry.charAt(i) ;
				if(entry.indexOf(letter, i) == entry.lastIndexOf(letter)) {
					for(int a = 0 ; a < password.length() ; a++) {
						if(letter == password.charAt(a)) {
							numChars++ ;
						}
					}
				}
			}
			for(int b = 0 ; b < numChars ; b++) {
				output += " *" ;
			}
			System.out.println(output) ;
			System.out.println("Incorrect.") ;
		}
		System.out.println("No more tries, you are locked out.") ;
	}
	public static String waitForInput(){
		entry = input.nextLine() ;
		return entry ;
	}
	public static void printArrayContent(String[] array) {
		String arrayContent = "[" ;
		for(int i = 0 ; i < array.length ; i++) {
			arrayContent = arrayContent + array[i] ;
			if(i < array.length-1)
				arrayContent = arrayContent + ", " ;
		}
		arrayContent = arrayContent + "]" ;
		System.out.println(arrayContent) ;
	}
}