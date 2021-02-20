package SchoolManagementSystem;

import java.util.List;

/**
 * Many teacher,many students.
 * Implements teacher and students
 * using an ArrayList
 * Created by Aram on 20/02/2021.
 */
public class School {
    private List<Teacher> teachers;
    private List<Students> students;
    private int totalMoneyEarned;
    private int totalMoneySpent;

    /**
     * new school object is created.
     *
     * @param teachers list of teachers in the school.
     * @param students list of students in the school.
     */
    public School(List<Teacher> teachers, List<Students> students) {
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }

    /**
     * @return the list of teacher in the school.
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Adds a teacher to the school.
     *
     * @param teacher the teacher to be added.
     */
    public void addTeachers(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     * @return the list of students in the school.
     */
    public List<Students> getStudents() {
        return students;
    }

    /**
     * Adds a students to the school.
     *
     * @param student the student to be added.
     */
    public void addStudents(Students student) {
        students.add(student);
    }

    /**
     * @return the total money earned by the school
     */
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    /**
     * Adds the total money earned by  the school.
     *
     * @param moneyEarned money that is supposed to be added.
     */
    public void updateTotalMoneyEarned(int moneyEarned) {
        totalMoneyEarned += moneyEarned;
    }

    /**
     * @return the total money spent by the school
     */
    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    /**
     * update the money spent by the school which
     * is the salary given by the school to its teachers.
     * @param moneySpent the money spent by school.
     */
    public void updateTotalMoneySpent(int moneySpent) {
        totalMoneySpent -= moneySpent;
    }
}
