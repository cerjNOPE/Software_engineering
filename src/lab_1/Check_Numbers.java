package lab_1;
public class Check_Numbers {
    public static void Check(int a, int b){
        if (b<a){               //Если a больше чем b меняем местами для удобства
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.println("Найденные числа соответствующие условиям в диапазоне от " + a + " до " + b + ":");
        //Основной цикл проверки и вывода чисел подходящих условию и вывода результата
        do{
            if (a < 0){       //Число не может быть отрицательным (не подходит условие палиндром: к примеру число -11 не равно 11-)
                a++;
                continue;       //если число отрицательное пропускаем
            }

            String NumAsString = String.valueOf(a);                   //Проверка сколько цифр в числе
            int NumberOfDigits = NumAsString.length();

            int[] Dig = Get_Digit_from_Number(a, NumberOfDigits);     //получение массива из цифр в числе

            //проверка числа на соблюдения необходимых условий
            if (Check_Repeat_Digit(Dig,NumberOfDigits) && Check_Sum_Simple_Number(Dig,NumberOfDigits) && Check_Mirror_Number(Dig,NumberOfDigits,a)){
                System.out.println(a);
            }
            a++;
        }
        while (b>=a);
    }

    public static int[] Get_Digit_from_Number (int i, int num){
        int[] Dig = new int[num];               //Создание массива размерностью с кол-во цифр
        for (int j = 0; j < num; j++){
            Dig[j] = i % 10;
            i = i / 10;
        }
        return Dig;                             //Возвращение массива с цифрами
    }

    public static boolean Check_Repeat_Digit(int[] digit,int num){
        for (int j = 0; j < num - 1;j++){
            for (int k = j + 1; k < num; k++){
                if (digit[j] == digit[k]){
                    return true;                        //Возвращаем true при наличии повторении цифры в массиве числа
                }
            }
        }
        return false;
    }

    public static boolean Check_Sum_Simple_Number(int[] digit,int num){
        int sum = 0;
        for (int j = 0; j < num;j++){
            sum = digit[j] + sum;
        }

        if (sum <= 1){                  //Если число меньше или равно 1 оно не простое
            return false;
        } else if (sum == 2) {          //Число 2 единственное простое четное число
            return true;
        } else if (sum % 2 == 0){       //Четные числа больше 2 не являются простыми
            return false;
        }
        for (int i = 3; i < Math.sqrt(sum); i += 2){        //Проверяем делители (проверяем нечетные числа от 3 до квадратного корня из числа
            if (sum % i == 0){
                return false;                               //если найден делитель число не простое
            }
        }
        return true;                    //Оставшиеся числа простые
    }

    public static boolean Check_Mirror_Number(int[] digit,int num,int Orig_num){
        int k = 1;
        int Mir_num = 0;
        for (int i = num - 1; i>=0; i--){                   //Создание отзеркаленного числа из массива цифр данного числа
            Mir_num = (k * digit[i]) + Mir_num;
            k = k * 10;
        }
        return Mir_num == Orig_num;                         //Вывод true если отзеркаленное число равно оригинальному числу
    }
}
