package schoolManagementSystem;

/**
 * Created by Aram on 20/02/2021.
 * This class is responsible for keeping the
 * track of students fees,name,grade & fees paid.
 */
public class Students {
    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    /**
     * To create a new student by initializing.
     * Fees for every students is 30000$.
     * Fees paid initially is 0.
     *
     * @param id    id for the students: unique.
     * @param name  name of the student.
     * @param grade grade of the students.
     */

    public Students(int id, String name, int grade) {
        this.feesPaid = 0;
        this.feesTotal = 30000;
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //Not going to alter student's name ,student's id.

    /**
     * Used to update the student's grade.
     *
     * @param grade new grade of the student.
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * Keep adding the fees to feedPaid Field.
     * Add the fees to the paid
     * The school is going receive the funds
     *
     * @param fees new fees of the student
     */
    public void payFees(int fees) {
        feesPaid = feesPaid - fees;
        School.updateTotalMoneyEarned(feesPaid);
    }

    /**
     * @return id of the students.
     */
    public int getId() {
        return id;
    }

    /**
     * @return name of the students.
     */
    public String getName() {
        return name;
    }

    /**
     * @return grade of the students.
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @return feesPaid of the students.
     */
    public int getFeesPaid() {
        return feesPaid;
    }

    /**
     * @return feesTotal of the students.
     */
    public int getFeesTotal() {
        return feesTotal;
    }

    /**
     * @return the returning fees.
     */
    public int getRemainingFees() {
        return feesTotal - feesPaid;
    }

    @Override
    public String toString() {
        return "Students name : " + name + " Total fees paid so far $" + feesPaid;
    }
}
