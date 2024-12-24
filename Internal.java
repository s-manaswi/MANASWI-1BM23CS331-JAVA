package CIE;
import java.util.Scanner;
public class Internal {
	public int marksCie[] = new int[5];
	public void getMarks() {
		for(int i=0;i<5;i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter CIE marks in subject "+(i+1));
			marksCie[i]=sc.nextInt();
		}
	}
	public int returnCieMarks(int i) {
		return marksCie[i];
	}
}
