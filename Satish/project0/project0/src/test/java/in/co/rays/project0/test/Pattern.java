package in.co.rays.project0.test;

public class Pattern {
public static void main(String[] args) {
	for (int i = 1; i <=5; i++) {
		
		for (int s = 5; s>=i; s--) {
			
			System.out.print(" ");
			
		}
		for (int j = 1; j <=i; j++) {
			System.out.print(" *");
			
		}
		System.out.println();
	}
}
}
