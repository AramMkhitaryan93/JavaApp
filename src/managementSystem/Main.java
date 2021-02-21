package managementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("Enter 1- for Module 1\nEnter 2- for Module2:");
            choice = obj.nextInt();
            if (choice == 1) {
                Module1 obj1 = new Module1();
                System.out.println("Enter students name:");
                obj1.name = obj.nextLine();
                System.out.println("Enter students father's name:");
                obj1.fName=obj.nextLine();
                System.out.println("Enter university id:");
                obj1.uni_id=obj.nextLine();
                System.out.println("Enter user id:");
                obj1.uid=obj.nextLine();
                System.out.println("In which semester do you study:");
                obj1.getData(obj1.name,obj1.fName,obj1.uid,obj1.uni_id,obj1.sem);
                obj1.setData();
            }
            else if (choice==2){
                Module2 obj2=new  Module2();
                obj2.chemistry();
                obj2.physics();
                obj2.biology();

            }
        }
    }
}
