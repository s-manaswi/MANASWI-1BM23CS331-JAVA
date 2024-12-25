import CIE.Student;
import CIE.Internals;
import SEE.Externals;
import java.util.Scanner;
public class Main_package {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of students whose details you want to enter");
		int n = sc.nextInt();
		Internals[] i1 = new Internals[n];
		Externals[] e1 = new Externals[n];
		for(int i=0;i<n;i++) {
			System.out.println("Student "+(i+1)+" details:");
			e1[i] = new Externals();
			i1[i] = new Internals();
			e1[i].getd();
			i1[i].getMarks();
			e1[i].getMarks();
		}
		for(int i=0;i<n;i++) {
			e1[i].display();
			e1[i].calcTotalMarks(i1[i]);
		}

	}
}
			
			
			