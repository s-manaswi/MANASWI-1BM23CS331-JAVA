import java.util.Scanner;
abstract class Shape 
{
	float dim1, dim2;
	Shape() {}		
	abstract void printArea();
}

class Rectangle extends Shape 
{
	Rectangle() {}
	void getd()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of rectangle:");
		dim1=sc.nextFloat();
		System.out.println("Enter breadth of rectangle:");
		dim2=sc.nextFloat();
	}

	void printArea() 
	{
        	double area = dim1 * dim2;
        	System.out.println("Area of Rectangle: " + area);
    	}
}

class Triangle extends Shape 
{
	Triangle() {}	
	void getd()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter height of triangle:");
		dim1=sc.nextFloat();
		System.out.println("Enter base of triangle:");
		dim2=sc.nextFloat();
	}
	void printArea() 
	{
        	double area = 0.5 * dim1 * dim2;
        	System.out.println("Area of Triangle: " + area);
    	}
}

class Circle extends Shape 
{
    Circle() {}
	void getd()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter radius of circle:");
		dim1=sc.nextFloat();
		dim2=0.0f;
	}
	void printArea() 
	{
        	double area = Math.PI * dim1 * dim1;
        	System.out.println("Area of Circle: " + area);
    	}
}

class Main
{
    public static void main(String[] args) 
	{
        	Rectangle rect = new Rectangle();
        	Triangle tri = new Triangle();
        	Circle circ = new Circle();
		rect.getd();
		tri.getd();
		circ.getd();
        	rect.printArea();
        	tri.printArea();
        	circ.printArea();
    	}
}