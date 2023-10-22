package Handbook;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private final static int  NUMBER_TABEL = 10000;
    private final static int  NUMBER_TELEPHON = 1000000;
    private final static int  NUMBER_STAG = 10;
    private final static String[] NAMES ={"Mia","Lia","Dima","Tola","Kola","Macha","Micha","Sacha",
            "Gena","Lena","Ira","Olya","Yla","Kiril","Blad","Denis","Sergey","Andrey","Alla",
            "Wika","Luda"};

    private String idTable;
    private String telephone;
    private String name;
    private String stage;

    public Employee(){
        Random random = new Random();
        idTable = String.valueOf(random.nextInt(NUMBER_TABEL));
        telephone = String.valueOf(random.nextInt(NUMBER_TELEPHON));
        stage = String.valueOf(random.nextInt(NUMBER_STAG));
        name = NAMES[(random.nextInt(NAMES.length))];
    }

    public Employee(String idTable,String name, String telephone, String stage) {
        this.idTable = idTable;
        this.telephone = telephone;
        this.name = name;
        this.stage = stage;
    }

    public String getIdTable() {
        return idTable;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getName() {
        return name;
    }

    public String getStage() {
        return stage;
    }

    @Override
    public String toString() {
        return "("+idTable + "," + name + "," + telephone + "," + stage +")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(idTable, employee.idTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTable);
    }
}
