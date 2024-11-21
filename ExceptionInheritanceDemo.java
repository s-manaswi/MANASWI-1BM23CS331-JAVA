class WrongAgeException extends Exception {
    public WrongAgeException(String message) {
        super(message);
    }
}

class Father {
    protected int age;

    public Father(int age) throws WrongAgeException {
        if (age < 0) {
            throw new WrongAgeException("Father's age cannot be negative.");
        }
        this.age = age;
    }
}

class Son extends Father {
    private int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAgeException {
        super(fatherAge);
        if (sonAge < 0) {
            throw new WrongAgeException("Son's age cannot be negative.");
        }
        if (sonAge >= fatherAge) {
            throw new WrongAgeException("Son's age cannot be greater than or equal to Father's age.");
        }
        this.sonAge = sonAge;
    }

    @Override
    public String toString() {
        return "Father's Age: " + age + ", Son's Age: " + sonAge;
    }
}

public class ExceptionInheritanceDemo {
    public static void main(String[] args) {
        try {
            Father father = new Father(45);
            System.out.println("Father created with age: " + father.age);

            Son son = new Son(45, 20);
            System.out.println(son);
        } catch (WrongAgeException e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }

        try {
            Son invalidSon = new Son(40, 40);
        } catch (WrongAgeException e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }

        try {
            Father invalidFather = new Father(-5);
        } catch (WrongAgeException e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }
    }
}