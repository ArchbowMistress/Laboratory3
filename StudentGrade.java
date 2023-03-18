import java.io.FileWriter;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class StudentGrade {
	public static void main(String[]args) {
		
		JOptionPane input = new JOptionPane();
			
			//Student's Name
			String name = input.showInputDialog(null, "Enter your full name: ", "Student Name", input.INFORMATION_MESSAGE);
			//Program
			String program = input.showInputDialog(null, "Enter your program: ", "Program", input.INFORMATION_MESSAGE);
			//Course
			String course = input.showInputDialog(null, "Enter your course: ", "Course", input.INFORMATION_MESSAGE);
			
			//User Instructions, Separate Window 
			String userDialog =("\nPlease input the grade for the following examinations");
			input.showMessageDialog(null, userDialog);
			
			//First Grade
			String first = input.showInputDialog(null, "First Exam", "Grade", input.INFORMATION_MESSAGE);
			//Second Grade
			String second = input.showInputDialog(null, "Second Exam", "Grade", input.INFORMATION_MESSAGE);
			//Third Grade
			String third = input.showInputDialog(null, "Third Exam", "Grade", input.INFORMATION_MESSAGE);
			//Fourth Grade
			String fourth = input.showInputDialog(null, "Fourth Exam", "Grade", input.INFORMATION_MESSAGE);
			
			//Parse them separately
			Float firstGrade = Float.parseFloat(first);
			Float secondGrade = Float.parseFloat(second);
			Float thirdGrade = Float.parseFloat(third);
			Float fourthGrade = Float.parseFloat(fourth);
			
			//Average of Grades
			float average = ((firstGrade + secondGrade + thirdGrade + fourthGrade)/4);
			
			//Remarks
			String remarks;
			if (average >= 75) {
				remarks = new String("Passed");
			} else {
				remarks = new String("Failed");
			}
			//GUI Display
			String display = ("Student's Name: " + name + "\nProgram: " + program + "\nCourse: " + course)
					+ ("\n" + "\n1st  2nd  3rd  4th") + ("\n" + firstGrade + "  " + secondGrade + "  " + thirdGrade + "  " + fourthGrade)
					+ ("\n" + "\nAverage: " + average + "\nRemarks: " + remarks);
			
			input.showMessageDialog(null, display, "Student Information", input.PLAIN_MESSAGE);
			//File Writing
			String fileWrite = "-----Student Information-----\n" + "Name\t\t\tProgram\tCourse\t\tFirst\tSecond\tThird\tFourth\tAverage\t\tRemarks\n"
			+ name + "\t" + program + "\t" + course + "\t" + firstGrade + "\t" + secondGrade + "\t" + thirdGrade + "\t" + fourthGrade + "\t" + average + "\t"
			+ remarks;
			System.out.println(fileWrite);
			//File
			try {
			FileWriter student = new FileWriter("Student.txt");
			student.write(fileWrite);
			student.close();
			
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error\t: "+ e.getMessage());
			}
		}	
	}
