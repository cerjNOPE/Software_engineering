package lab_4;

public class LAB_4_main {
    public static void main(String[] args) {
        //создание счетов всех типов (процент ставок указывается ГОДОВОЙ)
        Basic_Account basicAccount = new Basic_Account("Сергей",10000,1,"Basic");
        Savings_Account savingsAccount = new Savings_Account("Иван",10000,2,"Savings",0.05);
        Deposit_Account depositAccount = new Deposit_Account("Артем", 10000, 3, "Deposit",0.15,12);
        Deposit_Account depositAccount1 = new Deposit_Account("Ваня", 10000, 4, "Deposit", 0.15, 12);
        Credit_Account creditAccount = new Credit_Account("Маша", 20000,5, "Credit",0.20);

        //тест базового счета
        System.out.println("\nТесты базового счета");
        System.out.println("Изначальный баланс базового счета: " + basicAccount.getBalance());
        basicAccount.withdrawal(100.15);
        System.out.println("Баланс базового счета: " + basicAccount.getBalance());
        basicAccount.replenishment(5156.70);
        System.out.println("Баланс базового счета: " + basicAccount.getBalance());


        //тест накопительного счета
        System.out.println("\nТесты накопительного счета");
        System.out.println("Изначальный баланс накопительного счета: " + savingsAccount.getBalance());
        savingsAccount.interestCapitalizationMouth();
        System.out.println("Баланс накопительного счета через месяц: " + savingsAccount.getBalance());
        savingsAccount.replenishment(100000);
        System.out.println("Баланс накопительного счета после пополнения на 100000: " + savingsAccount.getBalance());
        savingsAccount.interestCapitalizationMouth();
        System.out.println("Баланс накопительного счета спустя еще месяц: " + savingsAccount.getBalance());


        //тест депозитного счета
        System.out.println("\nТесты депозитного счета");
        System.out.println("Изначальный баланс депозитного счета: " + depositAccount.getBalance() + " Изначально накопленная сумма с процентов: " + depositAccount.getAccumulatedMoney());
        depositAccount.interestCapitalizationMouth();
        System.out.println("Баланс депозитного счета через месяц: " + depositAccount.getBalance() + " Накопленная сумма с процентов: " + depositAccount.getAccumulatedMoney());
        depositAccount.interestCapitalization(11);
        System.out.println("Баланс депозитного счета спустя весь срок накопления 12 месяцев: " + depositAccount.getBalance() + " Накопленная сумма с процентов: " + depositAccount.getAccumulatedMoney());
        System.out.println("Второй депозитный счет");
        System.out.println("Изначальный баланс депозитного счета: " + depositAccount1.getBalance() + " Изначально накопленная сумма с процентов: " + depositAccount1.getAccumulatedMoney());
        depositAccount1.interestCapitalization(3);
        System.out.println("Баланс депозитного счета через 3 месяца: " + depositAccount1.getBalance() + " Накопленная сумма с процентов: " + depositAccount1.getAccumulatedMoney());
        depositAccount1.withdrawal(1000);
        System.out.println("Баланс депозитного счета после снятия 1000: " + depositAccount1.getBalance() + " Накопленная сумма с процентов: " + depositAccount1.getAccumulatedMoney());

        //тест кредитного счета
        System.out.println("\nТесты кредитного счета (кредитный лимит: " + creditAccount.getCreditMoneyLimit() + ")");
        System.out.println("Изначальный баланс кредитного счета: " + creditAccount.getBalance());
        creditAccount.interestCapitalizationMouth();
        System.out.println("Баланс кредитного счета спустя месяц: " + creditAccount.getBalance());
        creditAccount.withdrawal(20000);
        System.out.println("Баланс кредитного счета после снятия денег в долг: " + creditAccount.getBalance());
        creditAccount.interestCapitalizationMouth();
        System.out.println("Баланс кредитного счета спустя месяц: " + creditAccount.getBalance());
        creditAccount.replenishment(30000);
        System.out.println("Баланс кредитного счета после пополнения: " + creditAccount.getBalance());
        creditAccount.interestCapitalizationMouth();
        System.out.println("Баланс кредитного счета спустя месяц: " + creditAccount.getBalance());

    }
}
