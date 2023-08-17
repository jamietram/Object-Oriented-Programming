import java.util.Scanner;
import java.util.*;
/**
 * EECS 40
 * Assignment 5 Dictionary
 * @author Tram Le
 * @version 11/29/2022
 */

public class SimpleBankAccount{
    private static String userName;
    private static double userBalance;
    private static HashMap<String, Double> accountStandard = new HashMap();
    private static HashMap<String, Double> accountVIP = new HashMap();
    private static bankAccount standard = new standardAccount();
    private static bankAccount VIP = new VIPAccount();

    /**
     * This method print the Menu
     */
    public static void printMenu() {
        System.out.println("*** Menu ***");
        System.out.println("1. Create Account");
        System.out.println("2. Display");
        System.out.println("3. Withdraw");
        System.out.println("4. Deposit");
        System.out.println("5. Display All");
        System.out.println("6. Remove Account");
        System.out.println("7. Calculate Interest");
        System.out.println("8. Exit");
        System.out.print("\nEnter your choice: ");
    }
    /**
     * This method print create account
     */
    public static void createAccount(){
        System.out.print("Enter name: ");
        Scanner scannerName = new Scanner(System.in);
        userName = scannerName.next();
        System.out.print("Starting balance: ");
        Scanner scannerBalance = new Scanner(System.in);
        userBalance = scannerBalance.nextDouble();
    }
    /**
     * This method print display account
     */
    public static void displayAccount(){
        Scanner keyboard = new Scanner(System.in);
        String name = "";
        System.out.print("\nEnter Your name: ");
        name = keyboard.next();
        for(Map.Entry<String,Double> entry: accountVIP.entrySet()){
            if (VIP.getAccount().containsKey(name)){
                System.out.println("**Account Details**");
                System.out.println("Name: " + entry.getKey());
                System.out.println("Account Type: " + VIP.setAccountType());
                System.out.println("Balance: " + entry.getValue() + "\n");
            }
        }
        for(Map.Entry<String,Double> entry: accountStandard.entrySet()){
            if (standard.getAccount().containsKey(name)){
                System.out.println("**Account Details**");
                System.out.println("Name: " + entry.getKey());
                System.out.println("Account Type: " + standard.setAccountType());
                System.out.println("Balance: " + entry.getValue() + "\n");
            }
        }

    }
    /**
     * This method withdraw balance
     */
    public static void withdraw(){
        System.out.println("**Transaction - Withdraw**");
        System.out.print("Enter Your name: ");
        String name = "";
        Scanner userN = new Scanner(System.in);
        name = userN.next();
        for(Map.Entry<String,Double> entry: accountVIP.entrySet()){
            if (VIP.getAccount().containsKey(name)){
                Double balanceVIP = entry.getValue();
                System.out.print("Enter amount to withdraw: ");
                Scanner amountWithdrawals = new Scanner(System.in);
                Double amount = amountWithdrawals.nextDouble();
                if (amount <= balanceVIP){
                    balanceVIP = balanceVIP - amount;
                    System.out.println("Name: " + entry.getKey());
                    System.out.println("Balance: " + balanceVIP + "\n");
                    accountVIP.replace(entry.getKey(), balanceVIP);
                }
                else{
                    System.out.println("Not enough balance\n");
                }
            }

        }
        for(Map.Entry<String,Double> entry: accountStandard.entrySet()){
            if (standard.getAccount().containsKey(name)){
                Double balanceStandard = entry.getValue();
                System.out.print("Enter amount to withdraw: ");
                Scanner amountWithdrawals = new Scanner(System.in);
                Double amount = amountWithdrawals.nextDouble();
                if (amount <= balanceStandard){
                    balanceStandard = balanceStandard - amount;
                    System.out.println("Name: " + entry.getKey());
                    System.out.println("Balance: " + balanceStandard + "\n");
                    accountStandard.replace(entry.getKey(), balanceStandard);
                }
                else{
                    System.out.println("Not enough balance\n");
                }
            }

        }
    }
    /**
     * This method deposit balance
     */
    public static void deposit(){
        System.out.println("**Transaction - Deposit**");
        System.out.print("Enter Your name: ");
        String name = "";
        Scanner userN = new Scanner(System.in);
        name = userN.next();
        for(Map.Entry<String,Double> entry: accountStandard.entrySet()){
            if (standard.getAccount().containsKey(name)){
                Double balanceStandard = entry.getValue();
                System.out.print("Enter amount to deposit: ");
                Scanner amountDeposit = new Scanner(System.in);
                Double amount = amountDeposit.nextDouble();
                balanceStandard  = balanceStandard  + amount;
                System.out.println("Name: " + entry.getKey());
                System.out.println("Balance: " + balanceStandard  + "\n");
                accountStandard.replace(entry.getKey(), balanceStandard);
            }

        }
        for(Map.Entry<String,Double> entry: accountVIP.entrySet()){
            if (VIP.getAccount().containsKey(name)){
                Double balanceVIP = entry.getValue();
                System.out.print("Enter amount to deposit: ");
                Scanner amountDeposit = new Scanner(System.in);
                Double amount = amountDeposit.nextDouble();
                balanceVIP  = balanceVIP  + amount;
                System.out.println("Name: " + entry.getKey());
                System.out.println("Balance: " + balanceVIP + "\n");
                accountVIP.replace(entry.getKey(), balanceVIP);
            }

        }

    }
    /**
     * This method display all accounts
     */
    public static void displayAll(){
        if(!accountStandard.isEmpty()) {
            System.out.println("Standard Account Details");
            System.out.println("**Account Details**");
            accountStandard.entrySet().forEach(entry -> {
                System.out.println("Name: " + entry.getKey() + "\n" + "AccountType: " + standard.setAccountType() + "\n" + "Balance: " + entry.getValue() + "\n");
            });
        }
        if(!accountVIP.isEmpty()) {
            System.out.println("VIP Account Details");
            System.out.println("**Account Details**");
            accountVIP.entrySet().forEach(entry -> {
                System.out.println("Name: " + entry.getKey() + "\n" + "AccountType: " + VIP.setAccountType() + "\n" + "Balance: " + entry.getValue() + "\n");
            });
        }
    }
    /**
     * This method remove account
     */
    public static void removeAccount(){
        System.out.println("**Transaction - remove Account**");
        System.out.print("Enter Your name: ");
        String name = "";
        Scanner userN = new Scanner(System.in);
        name = userN.next();
        for(Map.Entry<String,Double> entry: accountStandard.entrySet()) {
            if (standard.getAccount().containsKey(name)) {
                accountStandard.remove(entry.getKey(), entry.getValue());
                System.out.println("Account has been removed!!\n");
            }
        }
        for(Map.Entry<String,Double> entry: accountVIP.entrySet()) {
            if (VIP.getAccount().containsKey(name)) {
                accountVIP.remove(entry.getKey(), entry.getValue());
                System.out.println("Account has been removed!!\n");
            }
        }
    }
    /**
     * This method calculate interest
     */
    public static void calculateInterest(){
        System.out.println("**Transaction - calculate interests**");
        System.out.print("Enter Your name: ");
        String name = "";
        Scanner userN = new Scanner(System.in);
        name = userN.nextLine();
        for(Map.Entry<String,Double> entry: accountStandard.entrySet()) {
            if (standard.getAccount().containsKey(name)) {
                Double balanceStandard = entry.getValue();
                System.out.print("Enter amount the number of months: ");
                Scanner monthsInput = new Scanner(System.in);
                int months = monthsInput.nextInt();
                balanceStandard = balanceStandard * months * 0.005;
                accountStandard.replace(entry.getKey(), balanceStandard);
                System.out.println("The expected interest is: " + balanceStandard + "\n");
            }
        }
        for(Map.Entry<String,Double> entry: accountVIP.entrySet()) {
            if (VIP.getAccount().containsKey(name)) {
                Double balanceVIP = entry.getValue();
                System.out.print("Enter amount the number of months: ");
                Scanner monthsInput = new Scanner(System.in);
                int months = monthsInput.nextInt();
                balanceVIP = balanceVIP * months * 0.01;
                accountVIP.replace(entry.getKey(), balanceVIP);
                System.out.println("The expected interest is: " + balanceVIP + "\n");
            }
        }
    }
    /**
     * This main method used to run the program
     */
    public static void main(String args[]) {
        VIP.setAccount(accountVIP);
        standard.setAccount(accountStandard);
        int choice;
        do{
            printMenu();
            Scanner scannerObject = new Scanner(System.in);
            choice = scannerObject.nextInt();
            switch(choice){
                case 1:
                    System.out.println("\n**Create New Account**");
                    System.out.println("1. Create Standard Account");
                    System.out.println("2. Create VIP Account");
                    System.out.print("Enter your choice: ");
                    Scanner scannerObject1 = new Scanner(System.in);
                    int createChoice = scannerObject1.nextInt();
                    if(createChoice == 1){
                        createAccount();
                        accountStandard.put(userName,userBalance);
                        System.out.println("Account Created!!\n");
                        VIP.setAccountType();
                    }
                    else if(createChoice == 2){
                        createAccount();
                        accountVIP.put(userName,userBalance);
                        System.out.println("Account Created!!\n");
                        standard.setAccountType();
                    }
                    else {
                        System.out.println("\nWrong choice!!\n");
                    }
                    break;
                case 2:
                    displayAccount();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    deposit();
                    break;
                case 5:
                    displayAll();
                    break;
                case 6:
                    removeAccount();
                    break;
                case 7:
                    calculateInterest();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("\nWrong choice!!\n");
            }
        }
        while(choice != 8);
    }
}
/**
 * This is the interface bank account
 */
interface bankAccount{
    String setAccountType();
    public HashMap<String, Double> getAccount();
    public void setAccount(HashMap<String, Double> account);

}
/**
 * This is constructor for standard account
 */
class standardAccount implements bankAccount{
    private HashMap<String, Double> accountStandard;

    public void setAccount(HashMap<String, Double> account) {
        this.accountStandard = account;
    }
    public String setAccountType(){
        return "Standard";
    }
    public HashMap<String, Double> getAccount() { return accountStandard;}
}
/**
 * This is constructor for VIP account
 */
class VIPAccount implements bankAccount{
    private HashMap<String, Double> accountVIP;

    public void setAccount(HashMap<String, Double> account) {
        this.accountVIP = account;
    }
    public String setAccountType() {
        return "VIP";
    }
    public HashMap<String, Double> getAccount() { return accountVIP;}
}

