package SEE;
import CIE.Student;
import CIE.Internal;
import java.util.Scanner;
public class External extends Student {
	int marksSee[] = new int[5];
	public void getMarks() {
		for(int i=0;i<5;i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter SEE marks in subject "+(i+1));
			marksSee[i]=sc.nextInt();
		}
	}
	public void calcTotalMarks(Internal i1) {
		for(int i=0;i<5;i++) {
			System.out.println("Subject "+(i+1)+": "+(i1.returnCieMarks(i)+(marksSee[i]/2)));	
		}
		System.out.println();

	}
}