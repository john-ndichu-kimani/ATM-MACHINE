package atmScreen;//This is the super class in which all types of transactions inherit from some attributes and methods



public class Transaction{
    protected AtmScreen atmScreen;
    protected AtmBankDatabase atmBankDatabase;

    public Transaction(AtmScreen atmScreen, AtmBankDatabase atmBankDatabase) {
        this.atmScreen = atmScreen;
        this.atmBankDatabase = atmBankDatabase;
    }

    public Transaction() {
    }
    public void execute(){

    }

    public static void main(String[] args) {
        new SignUp();
    }
}

