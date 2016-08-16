
package pkg3816assignment1;
  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class ATM implements Serializable 
{
    
    Account[] acctArray = new Account[3];
    
  
  
  public static void main(String[] args) throws IOException  
  {
    ATM arrows = new ATM(); 
    Scanner sc = new Scanner(System.in);
    
    
    System.out.println("Welcome to Universal Banking");
    System.out.println("Are you an UnderGraduate or Grad?");
    System.out.println("Please enter U for UnderGrad, G for Graduate, or O for Other");
        arrows.UGorGrad();
    System.out.println("Is this your first time using Universal's ATM?");
    System.out.println("Please enter Yes or No");
    System.out.println("");
    
    String input = sc.nextLine();
    
        if(input.equalsIgnoreCase("yes"))
        {
            System.out.println("");
            System.out.println("Please enjoy $100 for banking with us");
            
            System.out.println("Three seperate Accounts were created for you");
            //arrows.loadAccts();
            arrows.populateAccts();
            //arrows.loadAccts();
            
            
        }
        else if(input.equalsIgnoreCase("no"))
        {
            System.out.println("");
       
            //arrows.populateAccts();
            //arrows.saveAccount();
            
            {
                arrows.loadAccts();
            }
        }
        else if (!"yes".equals(input) || !"no".equals(input))
        {
            System.out.println("Please try again");
            System.out.println("Enter Yes or No");
           // arrows.populateAccts();
            System.exit(1);
        }
        arrows.beginMenu();  
     
  }
//Erick: I was unable to create an array and convert the numbers to chars and have the user pick a char
// So i took the easy way out and use equalsIgnoreCase
 public void UGorGrad() throws IOException
 {  Scanner sc = new Scanner(System.in);
    String confirm = sc.nextLine();
  
    if(confirm.equalsIgnoreCase("U"))
    {
       System.out.println("Hello Undergraduate");
       System.out.println();
    }
    else if(confirm.equalsIgnoreCase("G"))
    {
        System.out.println("Hello Graduate");
        System.out.println();
    }
    else if(confirm.equalsIgnoreCase("O"))
    {
        System.out.println("Hello Customer");
        System.out.println();
    }
    else if(!"U".equals(confirm) || !"G".equals(confirm) || !"O".equals(confirm))
    {
        System.out.println("Please try again");
        System.out.println("Enter U, G, or O");
        System.exit(1);
    }
    
 }
  
 public void beginMenu() throws IOException
         
    {
     Scanner sc = new Scanner(System.in);
     int input;
     do
      {
         System.out.println();
         System.out.println("Here is a list of Accounts you can access [1],[2],[3] Press 4 to exit ");         
         System.out.println();
         System.out.println("Which Account would you like to access");
         input = sc.nextInt();
         //input = input + 1;
         
         if(input == 1)
         {
            System.out.println("You have chosen Account 1");
            System.out.println("Which action would you like to perform?");
             acctArray[0].menu();
             saveAccount();
           
         }
         else if(input == 2)
         {
            System.out.println("You have chosen Account 2");
            System.out.println("Which action would you like to perform?");
            acctArray[1].menu();
            saveAccount();
         }
         else if(input == 3)
         {
            System.out.println("You have chosen Account 3");
            System.out.println("Which action would you like to perform?");
            
            acctArray[2].menu();
            saveAccount();
         }
         else if(input != 1 && input !=2 && input!=3 && input!= 4)
         {
                System.out.println("Invalid Input");
                
         }
         else if(input ==4)
         {
             System.out.println("Have a nice day");
         }
        
      }while(input != 4);
     //saveAccount();
     
 }

public void loadAccts()
{
    //read    
         //Test testobj = null;
    
        try
        {
            FileInputStream fis = new FileInputStream("Banking.out");
            //testobj = (Test)ois.readObject();
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                //testobj = (Test)ois.readObject();
                loadAccts((Account[])ois.readObject());
            }
        }
        catch (IOException | ClassNotFoundException ioe)
        {
            loadAccts(new Account[3]); 
        }
//        System.out.println(testobj.str);
//        System.out.println(testobj.ivalue);
//    System.out.println("Sorry no accounts to load");
//    
//    System.exit(1);
    
}
  
 public void populateAccts() throws IOException
    {
        for(int i=0; i<acctArray.length; i++)
        {
            //acctArray = new Account[3];  
            acctArray[i] = new Account(100);
            
           // this.beginMenu();
        }
   }
 
public void loadAccts(Account[] accounts) 
 {
        this.acctArray = accounts;     
 }

public void saveAccount()//write
        
{
    try
        {
            FileOutputStream fos = new FileOutputStream("Banking.out");
            //FileOutputStream fos = new FileOutputStream("file");
        //Test x = new Test("testing", 37);
//            Test y = new Test();
//            y.str = "testing";
//            y.ivalue = 37;
        try ( //String content = "This is the text content";
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            //Test x = new Test("testing", 37);
//            Test y = new Test();
//            y.str = "testing";
//            y.ivalue = 37;
oos.writeObject(acctArray);
oos.flush();
        }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
}  
  
}