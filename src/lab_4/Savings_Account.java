package lab_4;
//реализован простой накопительный счет со сложной процентной ставкой
//на каждый конец месяца баланс увеличивается на его состояние на конец месяца + установленный годовой процент деленный на 12 от этой суммы
public class Savings_Account extends Basic_Account{

    private double interestRate;

    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    public double getInterestRate(){
        return this.interestRate;
    }

    public Savings_Account(String owner, double balance, int accountID, String AccountType, double interestRate) {
        super(owner, balance, accountID, AccountType);
        this.interestRate=interestRate;
    }

    //Начисление процентов на конец месяца (Процентная ставка указана в год поэтому делиться на количество месяцев в году)
    public void interestCapitalizationMouth(){
        this.setBalance(this.getBalance() + this.getBalance() * (interestRate / 12));
        this.setBalance(Math.round(this.getBalance()*100.0) / 100.0);               //Для исправления ошибки с неточными подсчетами над числами с точкой с запятой
    }

}
