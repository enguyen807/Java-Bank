package pkg3816assignment1;

public class Savings extends Account {

    public Savings() {
        super(100);
    }

    @Override

    public double getInterest() {

        datediff = seconddate - firstdate;
        rate = .07 / 365;
        double ratetime = Math.pow(1 + rate, datediff);
        balance = balance * ratetime;
        firstdate = seconddate;

        return balance;
    }
}
