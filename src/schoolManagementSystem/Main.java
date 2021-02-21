package schoolManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Teacher lizzy = new Teacher(1, "Lizzy", 500);
        Teacher mellisa = new Teacher(2, "Mellisa", 700);
        Teacher tom = new Teacher(3, "Tom", 600);
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(lizzy);
        teacherList.add(mellisa);
        teacherList.add(tom);
        Students tamara = new Students(1, "Tamara", 4);
        Students anna = new Students(2, "Anna", 12);
        Students elen = new Students(3, "Elen", 5);
        List<Students> studentsList = new ArrayList<>();
        studentsList.add(tamara);
        studentsList.add(anna);
        studentsList.add(elen);

        School ghs = new School(teacherList, studentsList);
        tamara.payFees(5000);
        anna.payFees(6000);
        System.out.println("GHS has earned " + ghs.getTotalMoneyEarned());
        System.out.println("------Making SALARY PAY SALARY----- ");
        lizzy.receiveSalary(lizzy.getSalary());
        System.out.println("ghs has spent for salary to: " + lizzy.getName() + " and now has: $ " + ghs.getTotalMoneyEarned());

        mellisa.receiveSalary(mellisa.getSalary());
        System.out.println("ghs has spent for salary to: " + mellisa.getName() + " and now has: $ " + ghs.getTotalMoneyEarned());
        System.out.println(tamara);

        System.out.println(mellisa);
    }
}
