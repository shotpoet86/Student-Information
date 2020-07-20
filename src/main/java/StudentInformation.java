/*Programmer: Austin Parker Date: July 20, 2020
 * Assignment: CIST2371 Final Project
 * Purpose: Allows input from user about student information.
 * Allows user to display information after inputting.*/

import java.util.Scanner;

public class StudentInformation {

    //declarations
    private final Scanner scan = new Scanner(System.in);
    private final String[] name = new String[20];
    private final String[] subjects = new String[3];
    private final int[] grades = new int[3];

    public static void main(String[] args) {
        new StudentInformation().run();
    }

    private void run() {
        int choice;

//do while loop to allow user to choose information after completing
        //  previous info
        do {
            showMenu();
            choice = scan.nextInt();
            scan.nextLine();

            //switch statement is more streamlined than using several if statements for menu
            switch (choice) {
                case 1:
                    enterName();
                    break;
                case 2:
                    enterCourses();
                    break;
                case 3:
                    displayGrades();
                    break;
                case 4:
                    displayAverageGrade();
            }

            //choosing 5 exits program
        } while (choice != 5);
    }

    //display menu
    private void showMenu() {
        System.out.println("1. Enter Student Name");
        System.out.println("2. Enter course name and grade");
        System.out.println("3. Display all grades");
        System.out.println("4. Calculate average grade");
        System.out.println("5. Exit ");
    }

    //display for entering student name
    private void enterName() {
        System.out.println("Enter Student Name");
        System.out.println();
        String studentName = scan.nextLine();
        System.out.println("Student Name = " + studentName);
    }

    //course info display
    private void enterCourses() {
        System.out.println("Enter 3 subjects and their corresponding grades.\n" + "You will enter subject first, press enter , then be prompted for grade.");
        System.out.println();

        for (int i = 0; i < subjects.length; i++) {
            System.out.println("Subject:");
            subjects[i] = scan.nextLine();

            System.out.println("Grade:");
            grades[i] = scan.nextInt();
            scan.nextLine();

            if (i == (subjects.length - 1)) {
                System.out.println("Thank you!");
                System.out.println();
            }
        }
    }

    //grade display
    private void displayGrades() {
        System.out.println("Subjects" + "\tGrades");
        System.out.println("---------------------");

        for (int p = 0; p < subjects.length; p++) {
            System.out.println(subjects[p] + "\t" + "\t" + grades[p]);
        }
    }

    //average grade display
    private void displayAverageGrade() {


        System.out.println("Total of grades: " + getSum(grades));
        System.out.println("Count of grades: " + grades.length);
        System.out.println("Average of grades: " + getAverage(grades));
        System.out.println();
    }

    //calculates average grade if chosen in menu by user
    private double getAverage(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return ((double) sum) / array.length;
    }

    private double getSum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

}

