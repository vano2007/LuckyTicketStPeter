package com.example.luckyticketstpeter;

public class Algorithm {

    public Algorithm() {
    }

    // метод определения счастливый билет или нет
    public boolean isHappyTicket(String input) {
        int inputInt = Integer.parseInt(input); // конвертирование данных из String в int
        int inputInt2 = inputInt;

        int s1 = 0, s2 = 0; // создание буферных переменных

        for(int i = 0; i < 3; i++) { // цикл заполнения нечетных чисел
            s1 = s1 + inputInt % 10;
            inputInt = inputInt / 100;
        }
        for(int i = 0; i < 3; i++) { // цикл заполнения четных чисел
            inputInt2 = inputInt2 / 10;
            s2 = s2 + inputInt2 % 10;
            inputInt2 = inputInt2 / 10;
        }
        // проверка равенства
        if (s1 == s2) { // если суммы равны
            return true;   // то билет счастливый
        } else { // иначе
            return false; // билет не счастливый
        }
    }
    // метод определения следующего счастливого билета
    public int nextHappyTicketV2(String input) {
        int inputInt = Integer.parseInt(input); // конвертирование данных из String в int
        int count = 0; // задание счётчика

        for (int i = inputInt; i < 1_000_000; i++) { // цикл проверки и поиски счастливого билета
            int s1 = i%10 + (i/100)%10 + (i/10000)%10; // подсчёт суммы нечетных чисел
            int j = i / 10;
            int s2 = j%10 + (j/100)%10 + (j/10000)%10; // подсчёт суммы четных чисел
            if (s1 == s2) { // проверка счастливого билета
                break; // выброс из цикла
            } else { // иначе
                count++; // увеличение счётчика на единицу
            }
        }

        return inputInt + count; // вывод счастливого билета
    }

}
