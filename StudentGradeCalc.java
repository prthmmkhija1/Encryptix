import java.util.*;
public class StudentGradeCalc {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        //Number of Subjects
        int numberOfSubjects;
        System.out.print("Enter the number of subjects:");
        numberOfSubjects=sc.nextInt();

        //Array to Store Marks
        int marks[]=new int[numberOfSubjects];
        int totalMarks=0;

        //Input Marks
        for (int i=0;i<numberOfSubjects;i++) {
            System.out.print("Enter marks for subject " + (i+1) + ":");
            marks[i]=sc.nextInt();
            totalMarks+=marks[i];
        }

        //Calculate Average Percentage
        double averagePercentage=(double) totalMarks/numberOfSubjects;

        //Determine Grade
        char grade;
        if (averagePercentage>=90) {
            grade='A';
        }
        else if (averagePercentage>=80) {
            grade='B';
        }
        else if (averagePercentage>=70) {
            grade='C';
        }
        else if (averagePercentage>=60) {
            grade='D';
        }
        else {
            grade='F';
        }

        //Display Results
        System.out.println("Total Marks:" + totalMarks);
        System.out.println("Average Percentage:" + averagePercentage);
        System.out.println("Grade:" + grade);

        sc.close();
    }
}