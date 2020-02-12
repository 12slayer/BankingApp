package org.bank;

import Utiliz.BankingApplicationUtility;
//import Utiliz.UserCrudFileUtility;
import Utiliz.UserUtiliz;
import org.model.Message;
import org.model.User;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int askAccountNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the user account");
        int accountno = scanner.nextInt();
        return accountno;
    }

    public static double askammount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the ammount");
        double ammount = scanner.nextDouble();
        return ammount;
    }


    public static void main(String[] args) {
        User user = null;


        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("welcome to banking app");
        BankingApplicationUtility bankingApplicationUtility = new BankingApplicationUtility();

        // UserUtiliz u=new UserUtiliz();

        while (true) {
            System.out.println("1 for reg");
            System.out.println("2 for deposite the ammount");
            System.out.println("3 for seeeing your account ");
            System.out.println("4 for deleting account");
            System.out.println("5 for withdraw monney");
            System.out.println("6 to transfer ammount from one to another");
            System.out.println("enter your choice");
            int choice = scanner.nextInt();

            switch (choice) {
//1589917342 ---1 -168288608  ---2

                case 1:
                    user = new User();
                    System.out.println("enter your name");
                    String n = scanner.next();
                    user.setName(n);
                    System.out.println("enter your address");
                    String a = scanner.next();
                    user.setAddress(a);
                    user.setAmmount(0);
                    user.setAcNum(random.nextInt());

                    Message message = bankingApplicationUtility.createAccount(user);

                    if (message.isSuccess()) {
                        System.out.println(message.getData().getAcNum());
                        System.out.println(message.getData().getName());
                        System.out.println(message.getData().getAddress());
                        System.out.println(message.getData().getAmmount());
                    } else {
                        System.out.println("sorry");
                    }
                    break;

                case 2:

                    bankingApplicationUtility.depositAmmount(askAccountNumber(), askammount());


                    break;

                case 3:

                     user =bankingApplicationUtility.getAccountDetails(askAccountNumber());

                    if(user==null){
                        System.out.println("wrong");
                    }else{
                        System.out.println(user.getAcNum());
                        System.out.println(user.getName());
                        System.out.println(user.getAmmount());
                        System.out.println(user.getAddress());
                    }

                    /*try {

                        File obj = new File("C:\\\\Users\\\\susha\\\\IdeaProjects\\\\BankingApplication2\\\\src\\"+user.getAcNum());
                        Scanner myReader=new Scanner(obj);
                        while ((myReader.hasNextLine())){
                            String data=myReader.nextLine();
                            System.out.println(data);

                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }*/
                    break;

                case 4:
                   /* System.out.println("enter the ammount to with draws");
                    double w=scanner.nextDouble();
                    user.setAmmount(user.getAmmount()-w);
                    Message wt=u.saveUserDetails(user);
                   u.getUserDetails(AcNum);*/

                    //deleting the file by account number

                    bankingApplicationUtility.closeAccount(askAccountNumber());



                    break;
                case 5:

                    bankingApplicationUtility.withdrawAmount(askAccountNumber(), askammount());


                   /* System.out.println("enter the ammount to with draws");
                    double w=scanner.nextDouble();
                    user.setAmmount(user.getAmmount()-w);

                    u.getUserDetails(AcNum);*/
                    break;
                case 6:
                    System.out.println("enter the account number to be withdraw");
                    int wnum=scanner.nextInt();

                    System.out.println("enter the ammount to with draw from account");
                    double wammount=scanner.nextDouble();
                    System.out.println("enter the account number to transfer");
                    int dnum=scanner.nextInt();

                    bankingApplicationUtility.transferdetailsAmount(wnum,wammount);
                    bankingApplicationUtility.tranferedTo(dnum,wammount);
                    break;
                default:
                    System.exit(0);

            }
        }
    }
}
