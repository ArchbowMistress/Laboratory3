import java.io.FileWriter;
import javax.swing.JOptionPane;


public class SalesDoc {
	public static void main(String[]args) {
		//Code By: Elman, Jhonna Mae M.
		JOptionPane jop = new JOptionPane();
		
		//Company Name
		String companyName = "Mann Co. - We Sell Products and Get in Fights.";
		//Year
		int year = 1850;
		//File Name
		String filename = "Sales.txt";
		//Months as a String Array
		String[] months = {"January", "February", "March", "April", "May", "June",
		          "July", "August", "September", "October", "November", "December"};
		//Header
		String header = String.format("%-9s %-19s %-19s %s\n", "Month", "Gross Income", "Total Expenses", "Net Income");
		
		double totalMonth = 0.0;
		double totalExpenses = 0.0;
		double totalNetIncome = 0.0;
		double netIncome = 0.0;
		
		
		StringBuilder monthOutput = new StringBuilder();
		monthOutput.insert(0, header);
		
		String eachMonth = "";
		String totalOutput = "";
		
		for (int i =0; i < months.length; i++) {
			String month = months[i];
			Double gross = Double.parseDouble(jop.showInputDialog(null, "Enter Gross Income", month, jop.OK_CANCEL_OPTION));
			Double expense = Double.parseDouble(jop.showInputDialog(null, "Enter Total Expenses", month, jop.OK_CANCEL_OPTION));
				
   	 		totalMonth += gross;
			
			totalExpenses += expense;
			
			netIncome = gross-expense;
			
			totalNetIncome += netIncome;
			
			eachMonth = String.format("%-9s $%,15.2f    $%,15.2f      $%,15.2f\n", month, gross, expense, netIncome);
			monthOutput.append(eachMonth); 
	     	
		}
		
		totalOutput = String.format("%-9s $%,15.2f    $%,15.2f      $%,15.2f\n", "TOTAL", totalMonth, totalExpenses, totalNetIncome);
		monthOutput.append(totalOutput);
		
		 String output = ("*********" + companyName + "***********" + 
     			 "\nYear : " + year + 
     			 "\n**********************************************************" + 
     			 "\n" + monthOutput.toString() + 
     			 "\n**********************************************************" +
     			 "\nCode By: Elman, Jhonna Mae M.");
     	JOptionPane.showMessageDialog(null, output, "Final Table", JOptionPane.PLAIN_MESSAGE);
		
    	try {
			FileWriter file = new FileWriter(filename);
			file.write(output);
			file.close();
			
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error\t: "+ e.getMessage());
			}
	}		
}
