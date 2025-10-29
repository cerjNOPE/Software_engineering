package lab_4;
//Реализуется простой кредитный счет
//creditMoneyLimit это лимит для кредитного счета. Баланс всегда должен быть больше кредитного лимита.
//В месяц если баланс меньше кредитного лимита начисляются проценты по этой разнице
public class Credit_Account extends Basic_Account{

    private double creditInterest;
    private double creditMoneyLimit;

    //баланс изначальный = кредитному лимиту
    public Credit_Account(String owner, double creditMoneyLimit, int accountID, String AccountType, double creditInterest) {
        super(owner, creditMoneyLimit, accountID, AccountType);
        this.creditInterest = creditInterest;
        this.creditMoneyLimit = creditMoneyLimit;
    }

    public void setCreditInterest(double creditInterest){
        this.creditInterest = creditInterest;
    }

    public void setCreditMoneyLimit(double creditMoneyLimit){
        this.creditMoneyLimit = creditMoneyLimit;
    }

    public double getCreditInterest(){
        return this.creditInterest;
    }

    public double getCreditMoneyLimit(){
        return this.creditMoneyLimit;
    }

    //начисление процентов по задолженности
    //возвращает false если нет задолженности, true если есть задолженности и зачислились проценты
    public boolean interestCapitalizationMouth(){
        if (this.getBalance() >= this.creditMoneyLimit){return false;}

        this.setBalance(this.getBalance() - ((this.creditMoneyLimit - this.getBalance()) * this.creditInterest / 12) );
        this.setBalance(Math.round(this.getBalance()*100.0) / 100.0);               //Для исправления ошибки с неточными подсчетами над числами с точкой с запятой
        return true;
    }

    //пополнение наличных такое же как и у наследуемого класса Basic_Account

    //Снятие наличных такое же как и у наследуемого класса Basic_Account т.к мы превышаем кредитный лимит только в том случае если баланс меньше 0
    //а если баланс меньше 0 тогда наследуемая функция снятия выдаст false в остальных случаях она сработает стандартно, что нам подходит

}
