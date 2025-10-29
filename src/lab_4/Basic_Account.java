package lab_4;

public class Basic_Account {
    private String owner;
    private double balance;
    private int accountID;
    private String accountType;

    public Basic_Account(String owner,double balance, int accountID, String AccountType){
        this.owner=owner;
        this.balance=balance;
        this.accountID=accountID;
        this.accountType=AccountType;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setAccountID(int accountID){
        this.accountID = accountID;
    }

    public void setAccountType(String accountType){
        this.accountType=accountType;
    }

    public String getOwner(){
        return this.owner;
    }

    public double getBalance(){
        return this.balance;
    }

    public int getAccountID(){
        return this.accountID;
    }

    public String getAccountType(){
        return this.accountType;
    }

    //Снятие наличных (возвращает true если успешно и false если денег недостаточно)
    public boolean withdrawal(double amountForWithdrawal){
        if (this.balance < amountForWithdrawal || amountForWithdrawal <= 0){
            return false;
        }
        this.balance=this.balance-amountForWithdrawal;
        this.balance=Math.round(this.balance*100.0) / 100.0;            //Для исправления ошибки с неточными подсчетами над числами с точкой с запятой
        return true;
    }

    //Пополнение наличных
    public void replenishment(double amountForReplenishment){
        if (amountForReplenishment > 0) {
            this.balance = this.balance + amountForReplenishment;
            this.balance = Math.round(this.balance * 100.0) / 100.0;            //Для исправления ошибки с неточными подсчетами над числами с точкой с запятой
        }
    }

}
