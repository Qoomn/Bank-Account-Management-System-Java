public class Employee extends Account {
    //Customer cus = Customer();
    public Employee() {

    }

    public Employee(String name, String id) {
        super(name, id);
    }


    public void lockaccount(Customer customer) {
        customer.active = false;
    }

    public void unlockaccount(Customer customer) {
        customer.active = true;
    }

    public void withdrawforcustomer(Customer cus, double amount) {
        if (amount <= cus.getbalance()) {
            double i = cus.getbalance() - Math.abs(amount);
            cus.setBalance(i);
            numberoftransactions++;
            totalwithdraws = totalwithdraws + amount;
            System.out.println("Withdraw performed successfully");
        } else {
            System.out.println("Transaction has been cancelled, you have exceded your balance");
        }
    }


    public void depositforcustomer(Customer cus, double amount) {
        if (amount >= 0) {
            double i = cus.getbalance() + amount;
            cus.setBalance(i);
            numberoftransactions++;
            totaldeposits = totaldeposits + amount;
            System.out.println("Deposit performed successfully");
        } else {
            System.out.println("Transaction has been cancelled, you cannot deposit a negative value");

        }

    }

    private Customer Customer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
