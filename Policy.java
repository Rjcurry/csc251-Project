import java.util.Scanner;

public class Policy {
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    // Constructor
    public Policy(int policyNumber, String providerName, String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Getters and Setters

    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    public double calculateFee() {
        double fee = 600.0;
        if (age > 50) {
            fee += 75.0;
        }
        if (smokingStatus.equals("smoker")) {
            fee += 100.0;
        }
        double bmi = calculateBMI();
        if (bmi > 35) {
            fee += (bmi - 35) * 20;
        }
        return fee;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Policy Number: ");
        int policyNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Provider Name: ");
        String providerName = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Smoking Status (smoker/non-smoker): ");
        String smokingStatus = scanner.nextLine();
        System.out.print("Enter Height (in inches): ");
        double height = scanner.nextDouble();
        System.out.print("Enter Weight (in pounds): ");
        double weight = scanner.nextDouble();

        Policy policy1 = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);

        System.out.println("BMI: " + policy1.calculateBMI());
        System.out.println("Insurance Fee: $" + policy1.calculateFee());

        scanner.close();
    }
}