package Calculator;


// непонял как делать
public class Calculator{
    //Сумма
    public static <V extends Number, T extends Number> void sum(V v, T t) {
        if (v instanceof Integer && t instanceof Integer)
            System.out.println((int)v+(int)t);
        else if (v instanceof Double && t instanceof Integer)
            System.out.println((double)v+(int)t);
        else if (v instanceof Integer && t instanceof Double) {
            System.out.println((int)v+(double)t);
        } else if (v instanceof Integer && t instanceof Long) {

        }
    }
    // умножение
    public static <V extends Number, T extends Number> void multiply(V v, T t){

    }
    // деление
    public static <V extends Number, T extends Number> void divide(V v, T t){

    }
    // вычитание
    public static <V extends Number, T extends Number> void subtract(V v, T t) {
    }

}
