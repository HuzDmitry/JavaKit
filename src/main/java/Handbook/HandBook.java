package Handbook;

import java.util.List;
import java.util.Scanner;

public class HandBook {
    private List<Employee> handBook;
    private int size;
    private Scanner scanner = new Scanner(System.in);
    private final String menu = "1 - создать сотрудника\n" +
            "2 - удалить сотрудника\n" +
            "3 - найти сотрудника по табелю\n" +
            "4 - найти сотрудника по стажу\n" +
            "5 - найти номер телефона по имени сотрудника\n" +
            "6 - вывести всех сотрудников на экран\n" +
            "0 - выйти\n";

    public HandBook(List<Employee> handBook) {
        this.handBook = handBook;
        size = handBook.size();
        start();
    }

    private void start() {
        boolean flag = true;
        String num;
        do {
            System.out.println(menu);
            num = scanner.nextLine();
            switch (num) {
                case "1" -> addEmployee();
                case "2" -> {
                    System.out.println("введите номер табеля сотрудника для удаления: ");
                    num = scanner.nextLine();
                    deleteEmployeeOfTable(num);
                }
                case "3" -> {
                    System.out.println("введите номер табеля сотрудника: ");
                    num = scanner.nextLine();
                    searchNameOfTabel(num);
                }
                case "4" -> {
                    System.out.println("введите стаж сотрудника: ");
                    num = scanner.nextLine();
                    searchNameOfStage(num);
                }
                case "5" -> {
                    System.out.println("введите имя сотрудника: ");
                    num = scanner.nextLine();
                    searchOfTelephoneIsName(num);
                }
                case "6" -> {
                    System.out.println(handBook);
                    System.out.printf("Всех сотрудников: %d\n", size);
                }
                case "0" -> flag = false;
                default -> System.out.println("нет такой команды.");
            }
        } while (flag);
    }

    private void addEmployee() {
        System.out.println("Введите данные через пробел о сотруднике:");
        System.out.println("Табельный номер, Имя, телефон, стаж работы:");
        String message = scanner.nextLine();
        String[] parsers = message.split(" ");
        if (parsers.length == 4) {
            handBook.add(new Employee(parsers[0], parsers[1], parsers[2], parsers[3]));
            size++;
            System.out.printf("добавлен сотрудник. всего: %s", size);
            System.out.println();
        } else
            System.out.println("Неверное количество данных для создания сотрудника.");
    }

    private void deleteEmployeeOfTable(String table) {
        List<Employee> newHandBook = handBook.stream().
                filter(e -> !e.getIdTable().equals(table)).
                toList();
        handBook = newHandBook;
        size--;
        System.out.println();
    }

    private void searchNameOfStage(String stage) {
        System.out.printf("Имена сотрудников со стажем: %s\n", stage);
        handBook.stream().filter(e -> e.getStage().equals(stage)).
                forEach(e -> System.out.print(e.getName() + " "));
        System.out.println();
    }

    private void searchNameOfTabel(String tabel) {
        System.out.printf("имя сотрудников по табелю: %s\n", tabel);
        handBook.stream().filter(e -> e.getIdTable().equals(tabel)).
                forEach(e -> System.out.print(e.getName() + " "));
        System.out.println();
    }

    private void searchOfTelephoneIsName(String name) {
        System.out.printf("номер телефона сотрудников с именем: %s\n", name);
        handBook.stream().filter(e -> e.getName().equals(name)).
                forEach(e -> System.out.print(e.getTelephone() + " "));
        System.out.println();
    }
}
