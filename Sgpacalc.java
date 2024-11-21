import java.util.Scanner;

class Sgpacalc {
    String usn;
    String name;
    int numSubjects;
    int[] credits;
    int[] marks;
    
    Sgpacalc(int x) {
        numSubjects = x;
        credits = new int[numSubjects];
        marks = new int[numSubjects];
    }
    
    void acceptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter USN: ");
        usn = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        
        System.out.println("Enter credits for each subject:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Credits for subject " + (i+1) + ": ");
            credits[i] = sc.nextInt();
        }
        
        System.out.println("Enter marks for each subject:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Marks for subject " + (i+1) + ": ");
            marks[i] = sc.nextInt();
        }
    }
    
    void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        
        System.out.println("\nSubject-wise Credits and Marks:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Subject " + (i+1) + ": Credits = " + credits[i] + ", Marks = " + marks[i]);
        }
        
        System.out.println("SGPA: " + calculateSGPA());
    }
    
    double calculateSGPA() {
        int totalCredits = 0;
        int totalGradePoints = 0;
        
        for (int i = 0; i < numSubjects; i++) {
            totalCredits += credits[i];
            int gradePoint = calculateGradePoint(marks[i]);
            totalGradePoints += gradePoint * credits[i];
        }
        
        return (double) totalGradePoints / totalCredits;
    }
    
    int calculateGradePoint(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else if (marks >= 40) return 5;
        else return 0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();
        
        Sgpacalc s = new Sgpacalc(numSubjects);
        s.acceptDetails();
        s.displayDetails();
    }
}