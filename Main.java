import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static ArrayList<Manager> managerList = new ArrayList<>();
    static ArrayList<Customer> customerList = new ArrayList<>();
    static ArrayList<Employee> employeeList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("***Bank Software***");
        boolean exit = false;
        int actionChoice = 0;
        while (!exit) {
            showActionChoices();
            actionChoice = input.nextInt();
            switch (actionChoice) {
                case 1:
                    createAccount();
                    break;

                case 2:
                    accountLogin();
                    break;

                case 3:
                    exit = true;
                    System.out.print("Program Ended");
                    break;
            }

        }
    }

    static void showActionChoices() {
        System.out.print("""
                Enter the number of the action you want to make:\s
                 1- Create an account
                 2- Use an existing account
                 3- Exit

                 Chosen Number:\s""");
    }

    static void createAccount() {
        int accountChoice = 0;
        while (accountChoice != 4) {
            System.out.print("what kind of account do you want to create? (choose a number): ");
            showAccountsChoices();
            accountChoice = input.nextInt();
            switch (accountChoice) {
                case 1:
                    createManagerAccount();
                    break;

                case 2:
                    createEmployeeAccount();
                    break;

                case 3:
                    createCustomerAccount();
                    break;

                case 4:
            }
        }


    }

    //Make sure there is an account to sign in to
    static boolean managercreated = false;

    static void createManagerAccount() {
        System.out.println("Enter the Account Name:");
        String accountName = input.next();

        // Check if the manager account exists
        boolean accountExists = false;
        
        //Manager selectedManager = null;
        for (Manager manager : managerList) {
            if (manager.getName().equals(accountName)) {
                accountExists = true;
                managercreated = true;
                break;
            }
        }

        if (accountExists) {
            System.out.println("Manager already exists with the given account name: " + accountName);
        } else {
            System.out.println("Enter the Account ID:");
            String accountId = input.next();

            // Create a new manager
            Manager newManager = new Manager(accountName, accountId);
            managerList.add(newManager);
            System.out.println("Manager account created successfully!");
        }
    }

    //Make sure there is an account to sign in to
    static boolean employeecreated = false;

    static void createEmployeeAccount() {
        System.out.println("Enter the Account Name:");
        String accountName = input.next();

        // Check if the employee account exists
        boolean accountExists = false;
        
        //Manager selectedManager = null;
        for (Employee employee : employeeList) {
            if (employee.getName().equals(accountName)) {
                accountExists = true;
                employeecreated = true;
                break;
            }
        }

        if (accountExists) {
            System.out.println("Employee already exists with the given account name: " + accountName);
        } else {
            System.out.println("Enter the Account ID:");
            String accountId = input.next();

            // Create a new employee
            Employee newEmployee = new Employee(accountName, accountId);
            employeeList.add(newEmployee);
            System.out.println("Employee account created successfully!");
        }
    }

    //Make sure there is an account to sign in to
    static int customercreated = 0;

    static void createCustomerAccount() {
        System.out.println("Enter the Account Name:");
        String accountName = input.next();

        // Check if the customer account exists
        boolean accountExists = false;
        
        //Manager selectedManager = null;
        for (Customer customer : customerList) {
            if (customer.getName().equals(accountName)) {
                accountExists = true;
                customercreated = 1;
                break;
            }
        }

        if (accountExists) {
            System.out.println("Customer already exists with the given account name: " + accountName);
        } else {
            System.out.println("Enter the Account ID:");
            String accountId = input.next();

            // Create a new customer
            Customer newCustomer = new Customer(accountName, accountId);
            customerList.add(newCustomer);
            System.out.println("Customer account created successfully!");
        }
    }

    static void accountLogin() {
        int accountChoice = 0;
        while (accountChoice != 4) {
            System.out.print("In which account do you want to sign in (Choose a number): ");
            showAccountsChoices();
            accountChoice = input.nextInt();
            switch (accountChoice) {
                case 1:                  
                     managerLogin();
                    break;

                case 2:
                     employeeLogin();                    
                    break;

                case 3:
                     customerLogin();                 
                    break;

            }
        }

    }

    static void showAccountsChoices() {
        System.out.print("""
                \n1- Manager
                2- Employee
                3- Customer
                4- Back

                Chosen number: """);
    }

    static void managerLogin() { 
        System.out.println("Managers Accounts(Choose the number of account): ");
        showManagers();
        System.out.print("\nChosen Number: ");
        int managerChoice = input.nextInt();

        int managerSize = managerList.size();
        Manager chosenManager = managerList.get(managerChoice - 1);
        if (managerChoice >= 0 && managerChoice <= managerSize) {
            managerActions(chosenManager);
        }
    }

    static void showManagers() {
        int i = 1;
        for (Manager manager : managerList) {
            System.out.println(i + "- Manager Name: " + manager.getName());
            System.out.println("   Manager ID: " + manager.getId());
            System.out.println();
            i++;
        }
    }

    static void managerActions(Manager chosenManager) {
        int actionChoice = 0;
        while (actionChoice != 4) {
            System.out.println("Which action do you want to make (Choose a number): ");
            showManagerActions();
            actionChoice = input.nextInt();
            switch (actionChoice) {

                case 1:
                    chosenManager.Report();
                    break;

                case 2:
                    chosenManager.listofembloyees(employeeList);
                    //showEmployees();
                    break;

                case 3:
                    chosenManager.listofCustomers(customerList);
                    //showCustomers();
                    break;
            }
        }
    }

    static void showManagerActions() {
        System.out.print("""
                1- Print a report
                2- View list of employees
                3- View list of customers
                4- Back

                Chosen Number: """);
    }

    static void employeeLogin() {
        System.out.println("Employees Accounts(Choose the number of account): ");
        showEmployees();

        System.out.println();
        System.out.print("Chosen Number: ");
        int employeeChoice = input.nextInt();

        int employeeSize = employeeList.size();
        if (employeeChoice >= 0 && employeeChoice <= employeeSize) {

            Employee chosenEmployee = employeeList.get(employeeChoice - 1);
            System.out.println("Choose the number of the account you want to preform actions on: ");
            showCustomers();
            System.out.println();
            System.out.print("Chosen Number: ");
            int customerChoice = input.nextInt();
            Customer chosenCustomer = customerList.get(customerChoice - 1);

            int customerSize = customerList.size();
            if (customerChoice >= 0 && customerChoice <= customerSize) {
                employeeActions(chosenEmployee, chosenCustomer);
            }
        }
    }

    static void showEmployees() {
        int i = 1;
        for (Employee employee : employeeList) {
            System.out.println(i + "- Employee Name: " + employee.getName());
            System.out.println("   Employee ID: " + employee.getId());
            System.out.println();
            i++;
        }
    }

    static void employeeActions(Employee chosenEmployee, Customer chosenCustomer) {
        int actionChoice = 0;
        int amount;
        while (actionChoice != 5) {

            System.out.println("Which action do you want to make (Choose a number): ");
            showEmployeeActions();
            actionChoice = input.nextInt();
            switch (actionChoice) {

                case 1:
                    chosenEmployee.lockaccount(chosenCustomer);
                    System.out.print("new customer status: " + chosenCustomer.active + " \n");
                    break;

                case 2:
                    // unlock
                    chosenEmployee.unlockaccount(chosenCustomer);
                    System.out.print("new customer status: " + chosenCustomer.active + " \n");
                    break;
                case 3:
                    // Make a deposit
                    System.out.print("Enter the amount you want to deposit: ");
                    amount = input.nextInt();
                    chosenEmployee.depositforcustomer(chosenCustomer, amount);
                    break;
                case 4:
                    // Make a withdraw
                    System.out.print("Enter the amount you want to withdraw: ");
                    amount = input.nextInt();
                    chosenEmployee.withdrawforcustomer(chosenCustomer, amount);
                    break;

            }
        }
    }


    static void showEmployeeActions() {

        System.out.println("1- Lock customer account");
        System.out.println("2- unLock customer account");
        System.out.println("3- Make a deposit for customer");
        System.out.println("4- Make a withdraw for customer");
        System.out.println("5- Back");
        System.out.println();
        System.out.print("Chosen Number: ");
    }


    static void customerLogin() {
        System.out.println("Customers Accounts(Choose the number of account): ");
        showCustomers();


        System.out.println();
        System.out.print("Chosen Number: ");
        int customerChoice = input.nextInt();
        Customer chosenCustomer = customerList.get(customerChoice - 1);
        customerActions(chosenCustomer);


    }

    static void showCustomers() {
        int i = 1;
        for (Customer customer : customerList) {
            System.out.println(i + "- Customer Name: " + customer.getName());
            System.out.println("   Customer ID: " + customer.getId());
            System.out.println(" Customer status: " + customer.active);
            System.out.println();
            i++;
        }
    }

    static void customerActions(Customer chosenCustomer) {
        int actionChoice = 0;
        int amount;
        while (actionChoice != 4) {
            System.out.println("Which action do you want to make (Choose a number): ");
            showCustomerActions();
            actionChoice = input.nextInt();
            switch (actionChoice) {

                case 1:
                    System.out.print(chosenCustomer.getbalance());
                    System.out.println("$");
                    System.out.println();
                    break;


                case 2:
                    System.out.print("Enter the amount you want to deposit: ");
                    amount = input.nextInt();
                    chosenCustomer.deposit(amount);
                    break;

                case 3:
                    System.out.print("Enter the amount you want to withdraw: ");
                    amount = input.nextInt();
                    chosenCustomer.withdraw(amount);
                    break;

                default:
                    System.out.println("Error: Please choose a number from the list");
                    System.out.println();
                    break;

            }
        }
    }

    static void showCustomerActions() {

        System.out.println("1- View balance");
        System.out.println("2- Make a deposit");
        System.out.println("3- Make a withdraw");
        System.out.println("4- Back");
        System.out.println();
        System.out.print("Chosen Number: ");
    }


}

