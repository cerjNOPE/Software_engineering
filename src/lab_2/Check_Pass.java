package lab_2;

public class Check_Pass {                   // проверка всех условий и вывод true если все условия прошли
    public static boolean Check(String Pass){
        char[] arr = Pass.toCharArray();                                    //Создание массива из знаков пароля
        return Check_Leght(Pass) && Check_Capital_Letter(arr) && Check_Lowercase_Letter(arr) && Check_Digital(arr) && Check_Symbol(arr) && Check_White_space(arr) && Check_Repeat(Pass, arr) && Check_Categories(Pass, arr);
    }

    public static boolean Check_Leght(String Pass){
        if ( (8 > Pass.length()) || (Pass.length() > 20) ){
            System.out.println("Длина пароля должна быть от 8 до 20 символов");
            return false;
        }
        return true;
    }

    public static boolean Check_Capital_Letter(char[] Pass){
        for (char i:Pass){
            if (Character.isUpperCase(i)){
                return true;
            }
        }
        System.out.println("Пароль должен содержать минимум одну ЗАГЛАВНУЮ букву");
        return false;
    }

    public static boolean Check_Lowercase_Letter(char[] Pass){
        for (char i:Pass){
            if (Character.isLowerCase(i)){
                return true;
            }
        }
        System.out.println("Пароль должен содержать минимум одну СТРОЧНУЮ букву");
        return false;
    }

    public static boolean Check_Digital(char[] Pass){
        for (char i:Pass){
            if (Character.isDigit(i)){
                return true;
            }
        }
        System.out.println("Пароль должен содержать минимум одну ЦИФРУ");
        return false;
    }

    public static boolean Check_Symbol(char[] Pass){
        for (char i:Pass){
            if (!Character.isLetterOrDigit(i) && !Character.isWhitespace(i)){
                return true;
            }
        }
        System.out.println("Пароль должен содержать минимум один СПЕЦИАЛЬНЫЙ СИМВОЛ");
        return false;
    }

    public static boolean Check_White_space(char[] Pass){
        for (char i:Pass){
            if (Character.isWhitespace(i)){
                System.out.println("Пароль НЕ должен содержать ПРОБЕЛЫ");
                return false;
            }
        }
        return true;
    }

    public static boolean Check_Repeat(String Pass_str,char[] Pass ){
        for (int i = 0; i < Pass_str.length() - 2; i++){
            if (Pass[i] == Pass[i+1] && Pass[i] == Pass[i+2]){
                System.out.println("Пароль НЕ должен содержать более двух одинаковых символов подряд");
                return false;
            }
        }
        return true;
    }

    public static boolean Check_Categories(String Pass_str,char[] Pass){
        for (int i = 0; i < Pass_str.length() - 3; i++){
            if (
                    (!Character.isLetterOrDigit(Pass[i]) && !Character.isLetterOrDigit(Pass[i+1]) && !Character.isLetterOrDigit(Pass[i+2]) && !Character.isLetterOrDigit(Pass[i+3]))
                            || (Character.isDigit(Pass[i]) && Character.isDigit(Pass[i+1]) && Character.isDigit(Pass[i+2]) && Character.isDigit(Pass[i+3]))
                            || (Character.isUpperCase(Pass[i]) && Character.isUpperCase(Pass[i+1]) && Character.isUpperCase(Pass[i+2]) && Character.isUpperCase(Pass[i+3]))
                            || (Character.isLowerCase(Pass[i]) && Character.isLowerCase(Pass[i+1]) && Character.isLowerCase(Pass[i+2]) && Character.isLowerCase(Pass[i+3]))
            ){
                System.out.println("Пароль НЕ должен содержать более трех символов одной категории подряд");
                return false;
            }
        }
        return true;
    }

}