import java.util.Scanner;

public class Student_Report_card {

    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        System.out.print("Enter no.of students: ");
        int n = inp.nextInt();

        System.out.print("Enter no.of subjects: ");
        int subjects = inp.nextInt();

        System.out.print("Enter maximum marks per subject: ");
        int maxMarksPerSubject = inp.nextInt();
        inp.nextLine();

        String[] names = new String[n];
        int[] totals = new int[n];
        double[] average = new double[n];
        char[] grade = new char[n];
        String[] status = new String[n];
        String[] remarks = new String[n];
        int[] ranks = new int[n];

        // Input Student Details
        for (int i = 0; i < n; i++) {

            int total = 0;

            System.out.print("\nEnter student " + (i + 1) + " name: ");
            names[i] = inp.nextLine();

            for (int j = 1; j <= subjects; j++) {

                System.out.print("Enter marks of subject " + j + ": ");
                int marks = inp.nextInt();

                total += marks;
            }

            inp.nextLine();

            totals[i] = total;

            average[i] =
                    ((double) total / (subjects * maxMarksPerSubject)) * 100;

            // Grade & Remarks
            if (average[i] >= 90) {
                grade[i] = 'A';
                remarks[i] = "Excellent Performance - Passed in Distinction";
            }
            else if (average[i] >= 80) {
                grade[i] = 'B';
                remarks[i] = "Very Good Performance";
            }
            else if (average[i] >= 70) {
                grade[i] = 'C';
                remarks[i] = "Good Performance";
            }
            else if (average[i] >= 50) {
                grade[i] = 'D';
                remarks[i] = "Needs Improvement";
            }
            else if (average[i] >= 36) {
                grade[i] = 'E';
                remarks[i] = "Work Harder For Better Results";
            }
            else {
                grade[i] = 'F';
                remarks[i] = "Better Luck Next Time";
            }

            // Pass / Fail
            if (average[i] >= 36) {
                status[i] = "Pass";
            }
            else {
                status[i] = "Fail";
            }
        }

        // Rank Calculation
        if (n > 1) {

            for (int i = 0; i < n; i++) {

                int rank = 1;

                for (int j = 0; j < n; j++) {

                    if (average[j] > average[i]) {
                        rank++;
                    }
                }

                ranks[i] = rank;
            }

        } else {
            ranks[0] = 0;
        }
        System.out.println("\n========== STUDENT REPORT CARD ==========");

        for (int currentRank = 1; currentRank <= n; currentRank++) {

            for (int i = 0; i < n; i++) {

                if ((n == 1) || (ranks[i] == currentRank)) {

                    System.out.println("Student Name : " + names[i]);

                    if (n > 1) {
                        System.out.println("Rank         : " + ranks[i]);
                    } else {
                        System.out.println("Rank         : N/A");
                    }

                    System.out.println("Total Marks  : " + totals[i]);
                    System.out.printf("Average      : %.2f%%\n", average[i]);
                    System.out.println("Grade        : " + grade[i]);
                    System.out.println("Status       : " + status[i]);
                    System.out.println("Remark       : " + remarks[i] +"\n");
                }
            }
        }

        inp.close();
    }
}