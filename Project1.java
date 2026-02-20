package Tell;

import java.util.ArrayList;
import java.util.Scanner;

class Atm {
    String name;
    long AccountNo;
    int passcode;
    int balance;

    public Atm(String name, long AccountNo, int passcode) {
        this.name = name;
        this.AccountNo = AccountNo;
        this.passcode = passcode;
        this.balance = 1000;//default
    }

    public void depositMethod(int deposit) {
        balance += deposit;
    }
    public void withdrawMethod(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
        }
    }
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
    public void display(){
        System.out.println("Account Holder: "+name+" Account Number-"+AccountNo+" passcode:"+passcode);
    }
}
public class Project1 {
    public static void main(String[] args) {

        ArrayList<Atm> m=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true) {
            int total=0;
            System.out.println("\n--- Atm Management System ---");
            System.out.println("1. Create bank Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. display all");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Create bank Account");
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter AccountNo: ");
                    long AccountNo = sc.nextLong();
                    boolean exists = false;
                    for (Atm acc : m) {
                        if (acc.AccountNo == AccountNo) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Enter correct ACCOUNT NUMBER");
                    }else {
                        System.out.print("Enter passcode: ");
                        int passcode = sc.nextInt();
                        m.add(new Atm(name, AccountNo, passcode));
                        System.out.println("ADDED SUCCESSFULLY.....");
                    }
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    long dep= sc.nextLong();
                    for(Atm acc:m){
                        if(dep==acc.AccountNo){
                            System.out.print("Enter Deposit Money: ");
                            int deposit=sc.nextInt();
                            acc.depositMethod(deposit);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    long withAcc = sc.nextLong();
                    System.out.print("Enter passcode: ");
                    int pass=sc.nextInt();

                    for (Atm acc : m) {
                        if (acc.AccountNo == withAcc&&acc.passcode==pass) {
                            System.out.print("Enter Withdraw Amount: ");
                            int withdraw = sc.nextInt();
                            acc.withdrawMethod(withdraw);
                        }
                    }
                    break;
                case 4:
                System.out.print("Enter Account Number: ");
                long checkAcc = sc.nextLong();
                for (Atm acc : m) {
                    if (acc.AccountNo == checkAcc) {
                        acc.checkBalance();
                    }
                }
                break;
                case 5:
                    for(Atm acc:m){
                        acc.display();
                    }
                    break;

                case 6:
                    System.out.println("Thank You Deepika!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Option!");
                    System.out.println("hai");

            }
            }
        }
    }

