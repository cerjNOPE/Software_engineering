package lab_2;

public class LAB_2_main {
    public static void main(String[] args) {
        String Pass = "TestJava36!~";

        System.out.println("Проверка введенного пароля на критерии безопасности. Введенный пароль:" + Pass + "\n");

        if (Check_Pass.Check(Pass)){
            System.out.println("Пароль соответствует критериям безопасности");
        } else {
            System.out.println("Пароль НЕ соответствует критериям безопасности Одна из причин указана выше");
        }
    }
}
