package Calculator;
//1. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
// sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа
// (но необязательно разного между собой), над которыми должна быть произведена операция.
//2.  Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
// если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных,
// но должны иметь одинаковую длину и содержать элементы одного типа.
//3. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
// Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из
// составляющих пары, а также переопределение метода toString(), возвращающее строковое
// представление пары.

public class Main {
    public static void main(String[] args) {
        Integer integer = 5;
        Double doub =3.4;
        Float flo = 4.5f;
        Long lon = 2345L;
        Byte by = 12;
        Character ch = 'd';
        Calculator.sum(integer, flo);
    }

    /**
     * Метод сравнивающий два массива любого типа. Решение 2
     * @param t
     * @param a
     * @return
     * @param <T>
     */
    public static <T> boolean compareArrays(T[]t, T[]a){
        if (t.length==a.length) {
            for (int i = 0; i < t.length; i++) {
                if (!t[i].equals(a[i]))
                    return false;
            }
            return true;
        }
        else
            return false;
    }
}
