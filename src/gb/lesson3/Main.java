/*
1. Опишите класс руководителя, наследник от сотрудника.
Перенесите статический метод повышения зарплаты в класс руководителя, модифицируйте метод таким образом, чтобы он мог
поднять заработную плату всем, кроме руководителей. В основной программе создайте руководителя и поместите его в общий
массив сотрудников. Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
2. (*) Написать 2 класса компараторов по возрасту и зарплате (implements Comparator)
 */

package gb.lesson3;

public class Main {
    public static void main(String[] args) {
        Employee [] employees = new Employee []{
                new Employee("Ivanov Igor", 25,40_000),
                new Manager("Petrov Evgeny", 53, 100_000),
                new Employee("Ozerova Elena", 41, 35_000),
                new Manager("Sokolova Maria ", 49, 90_000),
                new Employee("Filatov Anton", 23,45_000)
        };

        Employee.printAll(employees);

        for (Employee emp: employees) {
            Manager.riseSalary(emp, 5000);
        }

        Employee.printAll(employees);

        AgeComparator ac = new AgeComparator();
        System.out.println(ac.compare(employees[0], employees[3]));

        SalaryComparator sc = new SalaryComparator();
        System.out.println(sc.compare(employees[1], employees[2]));
    }

}
