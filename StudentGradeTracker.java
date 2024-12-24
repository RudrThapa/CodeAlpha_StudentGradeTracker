import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker{
    public static void main(String[] args){
        // Creating an ArrayList to store the grades.
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Tracker!");

        while(true){
            // Menu options:
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a grade");
            System.out.println("2. View statistics like: Average, Highest and Lowest Grade.");
            System.out.println("3. Exit.");
            System.out.print("\nEnter your choice: ");

            int choice;

            // Ensure the choice is valid input
            if(sc.hasNextInt()) choice = sc.nextInt();

            else{
                System.out.println("\nInvalid input. Please enter a valid choice.");
                sc.next();
                continue;
            }

            switch (choice) {
                case 1:
                    //Takes user input for grade
                    System.out.print("Enter the grade (0-100): ");
                    if (sc.hasNextInt()) {
                        int grade = sc.nextInt();
                        if (grade >= 0 && grade <= 100) {
                            grades.add(grade);
                            System.out.println("\nGrade added successfully.");
                        } else {
                            //Handle invalid grade input
                            System.out.println("\nInvalid grade. Please enter a value between 0 and 100.");
                        }
                    } else {
                        //Handle non-integer input
                        System.out.println("\nInvalid input. Please enter an integer value between 0 and 100.");
                        sc.next();
                    }
                    break;
                case 2:
                    //Show statistics only if there are grades in the list
                    if (grades.isEmpty()) {
                        System.out.println("\nNo grades available. Please add grades first.");
                    } else {
                        double average = findAverage(grades);  //Find the average grade
                        int highest = findHighest(grades);    //Find the highest grade
                        int lowest = findLowest(grades);      //Find the lowest grade

                        //Display the statistics to the user
                        System.out.println("\nGrade Statistics:");
                        System.out.println("Average Grade: " + average);
                        System.out.println("Highest Grade: " + highest);
                        System.out.println("Lowest Grade: " + lowest);
                    }
                    break;
                case 3:
                    //Exit the program
                    System.out.println("\nExiting the program. Goodbye!");
                    sc.close();
                    return;
                default:
                    //Handle invalid menu choices
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    //Average grade Method:
    private static double findAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    //Highest Grade Method:
    private static int findHighest(ArrayList<Integer> grades) {
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    //Lowest Grade Method:
    private static int findLowest(ArrayList<Integer> grades) {
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
