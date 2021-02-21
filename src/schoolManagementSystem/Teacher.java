package schoolManagementSystem;

/**
 * Created by Aram on 20/02/2021.
 * This class is responsible for keeping the track
 * of teacher's name,id,salary.
 */
public class Teacher {
    private int id;
    private String name;
    private int salary;
    private int salaryEarned;

    /**
     * Creates a new Teacher object.
     *
     * @param id     id of the Teacher.
     * @param name   name of the Teacher.
     * @param salary salary of the Teacher.
     */
    public Teacher(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.salaryEarned=0;

    }

    /**
     *
     * @return the id of the teacher.
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return the name of the teacher.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the salary of the teacher.
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Set of salary.
     * @param salary
     */
    public void setSalary(int salary){
        this.salary=salary;
    }

    /**
     * Adds to the salary.
     * Removes from the total money earned by the school.
     * @param salary
     */
    public void receiveSalary(int salary){salaryEarned+=salary;School.updateTotalMoneyEarned(salary);}

    @Override
    public String toString() {
        return "Name of the Teacher : "+name+
                " Total salary earned so far $ "+salaryEarned;
    }
}
