package atmScreen;//This class acts as the model class it has properties of a user account and also the getters and setters

public class UserAccount{
    private int accountNum;

    private double balance;

    public UserAccount(int accountNum,double balance){
        this.accountNum=accountNum;
        this.balance=balance;
    }

}