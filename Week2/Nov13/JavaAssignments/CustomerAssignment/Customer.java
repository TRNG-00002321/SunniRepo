import java.text.ListFormat.Style;

public class Customer {
    String name;
    String phoneNumber = "";
    int customerID;
    static int customerCount = 0;
    final String location = "Plano, TX";

    public Customer(String name) {
        this.name = name;
        this.customerID = customerCount++;
    }

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.customerID = customerCount++;
    }

    public void printCustomerInfo() {
        System.out.println(name);
        System.out.println(customerID);
        System.out.println(location);
        System.out.print(phoneNumber.isEmpty() ? phoneNumber : "");

    }

    public void printCustomerInfo(boolean verbose) {
        if (verbose) {
            System.out.println("Name: " + name);
            System.out.println("ID: " + customerID);
            System.out.println("Location: " + location);
            System.out.print(phoneNumber.isEmpty() ? "Phone: " + phoneNumber : "");
        } else
            this.printCustomerInfo();
    }

}
