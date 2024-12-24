import java.util.Scanner;
public class quadratic_equation {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.println("enter coefficient a:");
        double a = sc.nextDouble();
        System.out.println("enter coefficient b:");
        double b = sc.nextDouble();
        System.out.println("enter coefficient c:");
        double c = sc.nextDouble();
        double discriminant= b* b- 4*a*c;
        if (discriminant > 0){
            double root1 = (-b + Math.sqrt(discriminant)) / (2*a);
            double root2 = (-b - Math.sqrt (discriminant))/( 2*a);
            System.out.println ("root 1= "+root1);
            System.out.println ("root 2= "+root2);
        }
        else if (discriminant==0){
            double root = -b/(2*a);
            System.out.println("roots are real and equal");
            System.out.println("root="+root);
        }
        else{
            System.out.println("there are no real solutions");
        }
        sc.close();
    }
}