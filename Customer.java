public class Customer extends Account{
    private double balance = 0;
    Boolean active = true;

    public Customer(String name, String id){
        super(name,id);
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getbalance(){
        return this.balance;
    }


    public void withdraw(double amount){
        if(active){
            if(amount<=this.balance){
                this.balance = this.balance - Math.abs(amount);
                numberoftransactions++;
                totalwithdraws = totalwithdraws + amount;
                System.out.println("Withdraw performed successfully");
            }
            else{
                System.out.println("Transaction has been cancelled, you have exceded your balance");
            }
        }
        else{
            System.out.println("Error, Account is not active");
        }
    }


    public void deposit(double amount){
        if(active){
            if(amount>=0){
                this.balance = this.balance + amount;
                numberoftransactions++;
                totaldeposits = totaldeposits + amount;
                System.out.println("Deposit performed successfully");
            }
            else{
                System.out.println("Transaction has been cancelled, you cannot deposit a negative value");

            }
        }
        else{
            System.out.println("Error, Account is not active");
        }
    }
}
