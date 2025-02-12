import java.util.ArrayList;

public class Manager extends Account {


    public Manager() {


    }

    public Manager(String name, String id) {
        super(name, id);

    }


    public void Report() {

        System.out.println("the total number of deposits is: " + totaldeposits + "$");
        System.out.println("the total number of withdraws is: " + totalwithdraws + "$");
        System.out.println("the total number of transactions is: " + numberoftransactions);

    }


    public void listofembloyees(Iterable<Employee> emp) {
        int i = 1;
        for (Employee employee : emp) {
            
            System.out.println(i + "- Embloyee Name: " + employee.getName());
            System.out.println("   Embloyee ID: " + employee.getId());
            System.out.println();
            i++;
       }
    }


    public void listofCustomers(ArrayList<Customer> customers) {
        int i = 1;
        for (Customer customer : customers) {
            
            System.out.println(i + "- Customers Name: " + customer.getName());
            System.out.println("   Customers ID: " + customer.getId());
            System.out.println();
            i++;
        }
    }
}
