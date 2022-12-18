package EmailApp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String Email;
    private String companySuffix = ".anycompany.com";
    private int mailBoxCapacity = 500;
    private String alternateEmail;
    private int defaultPasswordLength = 10;

    //receive first & last name from user
    public Email(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Hello " + firstName + " " + lastName + "!");
        this.department = setDepartment();
        this.password = setPassword(defaultPasswordLength);
        Email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department.toLowerCase() + companySuffix;

    }

    //Ask for department
    private String setDepartment(){
        System.out.print("Please enter department:\n(1) for Sales.\n(2) for Development.\n(3) for Accounting.\n" +
                "(0) for none.\nEnter here:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1){return "Sales";}
        else if (depChoice == 2){return "Development";}
        else if (depChoice == 3){return "Accounting";}
        else{return "";}
    }
    //Generate a random password
    private String setPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWSYZ0123456789!@#$%";
        char [] password = new char[length];
        for (int i = 0; i<length;i++){
            int rand = (int)(Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailBoxCapacity(){return mailBoxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String toString(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nDEPARTMENT: " + department +
                "\nCOMPANY EMAIL: " + Email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity +
                "\nPASSWORD: " + password;


    }
}
