package Handbook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <Employee> list1 = List.of(new Employee("1", "Lia", "111", "2"),
                new Employee("2", "Mia", "222", "2"),
                new Employee("3", "Dima", "666", "3"),
                new Employee("4", "Tola", "555", "4"),
                new Employee("5", "Mia", "444", "4"),
                new Employee("6", "Lia", "333", "5"));
        List<Employee> list2 = new ArrayList<>();
        for (int i=0; i<10000; i++){
            list2.add(new Employee());
        }
        HandBook handBook = new HandBook(list2);
    }
}

