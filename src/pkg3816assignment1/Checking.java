package pkg3816assignment1;

public class Checking extends Account {

    public Checking() {
        super(100);
    }

    @Override

    public double getInterest() {
        
        datediff = seconddate - firstdate;
        rate = .03 / 365;
        double ratetime = Math.pow(1 + rate, datediff);
        balance = balance * ratetime;
        firstdate = seconddate;

        return balance;
    }
}
