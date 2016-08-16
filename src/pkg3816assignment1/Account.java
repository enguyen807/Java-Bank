package pkg3816assignment1;

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

public class Account implements Serializable 
        {
   protected double balance;
   private double withdraw;
   private double deposit;
   protected int firstdate;
   protected int seconddate;
   protected Calendar cal1 = new GregorianCalendar();
   protected Calendar cal2 = new GregorianCalendar(); 
   protected boolean dateflag = false;
   protected double rate;
   int datediff = 0;
  
   
 Account(double i)
   {
     this.balance += i;

   }


  
public double getInterest()
    {
    return rate;
    }
 public double getBalance()
    {
     return balance;
    }
 
 public double getWithdraw()
    {
     return withdraw;
    }
 public double getDeposit()
    {
     return deposit;
    }

public void setBalance(double newBalance)
    {
    balance = newBalance;
    }
public void setWithdraw(double newWithdraw)
    {
    withdraw = newWithdraw;
    }
   public void menu() throws IOException
    {
       
        Scanner sc = new Scanner(System.in);
        int input = 0;
        

        System.out.println("You have a Current Balance of"+ " "+  this.balance);
        do
        {   
           
            System.out.println("1)Deposit");
            System.out.println("2)Withdraw");
            System.out.println("3)Check Balance");
            System.out.println("4)Return to Account Menu");
               try
               {
                input = sc.nextInt();
               }
               catch(Exception e)
               {
                   System.out.println("Try again");
               }

           if (input == 1)
            {
              this.getDeposit();
              
              System.out.println("Your current balance is:" + this.depositCalculation());
              
            }
            else if (input == 2)
            {
              this.getWithdraw();
              System.out.println("Your current balance is:" + this.withdrawCalculation());
            }
            else if (input == 3)
            {
              this.getdate2();
              this.getInterest();
              System.out.println("Your current balance is:" +this.balance);
              System.out.println("Your current balance with interest is:" +this.interestCalculation());
            }
        }while (input != 4);
        
    }

   public double withdrawCalculation()
   {
       Scanner sc = new Scanner(System.in);
       System.out.println("How much would you like to withdraw?");
       //Scanner sc = new Scanner(System.in);
       withdraw = sc.nextInt();
       if (withdraw > balance)
       {
           System.out.println("Not enough money to withdraw");
       }
       else
       {
           this.balance = balance - withdraw;
       }
       return balance;         
   }
   public double depositCalculation() throws IOException
   {
       Scanner sc = new Scanner(System.in);
       this.getdate1();
       System.out.println("How much would you like to deposit?");
      // Scanner sc = new Scanner(System.in);
       deposit = sc.nextInt();
       balance = balance + deposit;
       return balance;
   }
       private void getdate2() throws IOException
    {
        System.out.print("Enter second date (mm/dd/yyyy): ");
        Scanner sc = new Scanner(System.in);
        String inputText = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat ("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse(inputText, pos);

        cal2.setTime(date);

        seconddate = cal2.get(Calendar.DAY_OF_YEAR);

        if (firstdate > seconddate)
        {
            System.out.println("you must enter a future date.");
            getdate2();
        }
    }
   private void getdate1() throws IOException
    {
        System.out.print("Enter first date (mm/dd/yyyy): ");
        Scanner sc = new Scanner(System.in);
        String inputText = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat ("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse(inputText, pos);

        cal1.setTime(date);

        firstdate = cal1.get(Calendar.DAY_OF_YEAR);
        dateflag = true;
    }
   


//   public double interestCalculation()
//    {
//       
//        int datediff = seconddate - firstdate;
//        rate = 0.05/365;
//        double ratetime = Math.pow(1+rate, datediff);
//        balance = Math.round((balance * ratetime)*100.0)/100.0;
//        firstdate = seconddate;
//        
//        return balance;
//    }
 
    public double interestCalculation()
    {
        return balance;
    }
}   