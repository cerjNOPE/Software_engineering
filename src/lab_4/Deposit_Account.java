package lab_4;
//реализован простой депозитный счет
//всю прибыль от процентов за какой-то период сохраняется в переменной accumulatedMoney
//реализована возможность подсчета сразу за несколько месяцев т.к. Процент реализован простой.
//при завершении срока действия счета т.е. когда termMouth будет равен 0
//К средствам на счете добавляются накопленные проценты и ставка приравнивается к нулю
public class Deposit_Account extends Savings_Account{

    private int termMouth;
    private double accumulatedMoney;

    public Deposit_Account(String owner, double balance, int accountID, String AccountType, double interestRate, int termMouth) {
        super(owner, balance, accountID, AccountType, interestRate);
        this.termMouth = termMouth;
        this.accumulatedMoney = 0;
    }

    public void setAccumulatedMoney(int accumulatedMoney){
        this.accumulatedMoney = accumulatedMoney;
    }

    public void setTermMouth(int termMouth){
        this.termMouth = termMouth;
    }

    public int getTermMouth(){
        return this.termMouth;
    }

    public double getAccumulatedMoney(){
        return this.accumulatedMoney;
    }

    //процент на депозитном счете простой (в конце выплачивается вся сумма процента, при снятии все накопленные проценты сгорают)
    //Начисление процентов за указанный срок (0 означает что закрывает весь период)
    //и также если переданное число месяцев больше чем оставшийся срок - закрывается весь период который остался
    public void interestCapitalization(int mouthClose){
        if (this.getInterestRate() == 0){return;}                     //Если процент равен нулю то ничего не насчитываем

        if (mouthClose == 0 || mouthClose > termMouth){mouthClose = termMouth;}

        this.accumulatedMoney = this.accumulatedMoney + this.getBalance() * ((this.getInterestRate() / 12) * mouthClose);
        this.accumulatedMoney=Math.round(this.accumulatedMoney*100.0) / 100.0;              //Для исправления ошибки с неточными подсчетами над числами с точкой с запятой
        this.termMouth = this.termMouth - mouthClose;

        if (this.termMouth == 0){                                                           //закрываем счет если срок закончился (начисляем проценты на баланс и процентную ставку делаем 0)
            this.setInterestRate(0);
            this.setBalance(this.getBalance()+this.accumulatedMoney);
            this.setBalance(Math.round(this.getBalance()*100.0) / 100.0);                   //Для исправления ошибки с неточными подсчетами над числами с точкой с запятой
            this.accumulatedMoney = 0;
        }
    }

    //реализация функции начисления процента за месяц
    public void interestCapitalizationMouth(){
        this.interestCapitalization(1);
    }

    //возвращает false если денежных средств недостаточно
    //если средств достаточно - устанавливает процент на счете 0 и удаляет все накопленные проценты
    //Если счет уже закрыт тогда просто снимает деньги
    public boolean withdrawal(double amountForWithdrawal){
        if (!super.withdrawal(amountForWithdrawal)){return false;}

        if(this.termMouth != 0) {           //Нет смысла закрывать счет если он уже закрыт
            this.accumulatedMoney = 0;
            this.termMouth = 0;
        }
        return true;
    }

    //Пополнить депозитный счет невозможно (заглушка, чтобы не срабатывал метод наследуемого класса)
    public void replenishment(double accumulatedMoney){
    }
}