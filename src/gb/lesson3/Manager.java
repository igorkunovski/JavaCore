package gb.lesson3;

public class Manager extends Employee{
    public Manager(String name, int age, int salary) {
        super(name, age, salary);
    }

    public static void riseSalary(Employee emp, int amount){
        if (!(emp instanceof Manager)){
            emp.setSalary(emp.getSalary() + amount);
        }
    }
}
