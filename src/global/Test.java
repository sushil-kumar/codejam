package global;

public final class Test {

	public static void main(String[] args) {
		int min = 999999999, max = 1000000000;
		int choice = 9;
		int guessed = 0, notGuessed = 0;
		for (int k = min;k<=max;++k) {
			int a = min, b = max+1;
			choice = k;
			int i=0;
			//int guess = new Random().nextInt(b - a) + a;
			for (;i<30;++i) {
				//System.out.print("Range = " + a + " - " + b + " ==> ");
				//int guess = new Random().nextInt(b - a + 1) + a;				 
				//System.out.println(guess);
				int guess = (b+a) / 2;
				if (guess == choice) {
					guessed++;
					System.out.println(choice + " guessed after " + (i+1) + " tries");
					break;
				} else if (guess > choice) {
					// Big case
					b = guess;
				} else {
					// Small case
					a = guess;
				}
			}
			if (i == 30) {
				notGuessed++;
				System.out.println(choice + " not guessed");
			}
		}
		System.out.println("Total Guessed = " + guessed);
		System.out.println("Total not Guessed = " + notGuessed);
	}

}
