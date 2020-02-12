package Utiliz;

import org.model.Message;


import org.model.User;


public class BankingApplicationUtility {
    private UserCrudUtility userCrudUtility;

    public BankingApplicationUtility() {
        //object is created for the usercrudutility so we can use method that has been defined in UserCrudUtility interface
        // userCrudUtility = new UserCrudFileUtility();
        userCrudUtility = new UserCrudDButility();
    }

    public Message createAccount(User user) {
        return userCrudUtility.saveUserDetails(user);

    }

    public void withdrawAmount(int accNum, double withd) {

        User withdraw = userCrudUtility.getUserDetails(accNum);
        if (withdraw == null) {
            System.out.println("user not found");
        } else {
            System.out.println("enter deposite ammount");


            double remaining = withdraw.getAmmount() - withd;
            withdraw.setAmmount(remaining);
            userCrudUtility.saveUserDetails(withdraw);

            Message meWith = userCrudUtility.saveUserDetails(withdraw);
            System.out.println(withdraw.getId());
            if (meWith.isSuccess()) {
                System.out.println("your account these ammount left " + withdraw.getAmmount());
            } else {
                System.out.println("error" + meWith.getErrorMessage());
            }
        }

    }

    public void depositAmmount(int accNo, double depositam) {
        User fetchUser = userCrudUtility.getUserDetails(accNo);
        if (fetchUser == null) {
            System.out.println("user not found");
        } else {

            fetchUser.setAmmount(fetchUser.getAmmount() + depositam);

            Message medeposite = userCrudUtility.saveUserDetails(fetchUser);

            if (medeposite.isSuccess()) {
                System.out.println("ok");
            } else {
                System.out.println("error" + medeposite.getErrorMessage());
            }
            System.out.println(fetchUser.getAmmount());
        }
    }

    public void closeAccount(int accNum) {
        User user = getAccountDetails(accNum);

        System.out.println(user.getAddress());
        if (user == null) {
            System.out.println("this account number doesnt exist in our system");
        } else {
            userCrudUtility.deleteUser(user);
        }
    }



    public User getAccountDetails(int accNum) {

        return userCrudUtility.getUserDetails(accNum);
    }
    public void transferdetailsAmount(int Num,double ammount) {
        User transfer = userCrudUtility.getUserDetails(Num);
        //User to = userCrudUtility.getUserDetails(aNum);
        if (transfer == null) {
            System.out.println("user not found");

        } else {
            if (ammount < 0 && ammount > transfer.getAmmount()) {
                System.out.println("the balance is insufficent cant transfer");
            } else {
                transfer.setAmmount(transfer.getAmmount() - ammount);
                Message deposite = userCrudUtility.saveUserDetails(transfer);
                if (deposite.isSuccess()) {
                    System.out.println("your balance has been reduce and deposited to another account");
                } else {
                    System.out.println("error" + deposite.getErrorMessage());
                }


            }
        }
    }

    public void tranferedTo(int aNum,double ammount){
        User to = userCrudUtility.getUserDetails(aNum);
        if (to == null) {
            System.out.println("user not found");

        } else {
            to.setAmmount(to.getAmmount() + ammount);
            Message medeposite = userCrudUtility.saveUserDetails(to);
            if (medeposite.isSuccess()) {
                System.out.println("ok");
            } else {
                System.out.println("error" + medeposite.getErrorMessage());
            }
            System.out.println(to.getAmmount());
        }
    }

    }

