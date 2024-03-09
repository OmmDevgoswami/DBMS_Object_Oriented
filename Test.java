package reg_no_2241004223;
/* Name : Omm Devgoswami
 * Registration No. 2241004223
 * Section: 2241006
 */

import java.util.Scanner;
import java.time.LocalDate;

interface Date 	//interface Date is used as an instance variable in the class.
{
	String hireDate();
}
interface Address	//interface Address is used as an instance variable in the class.
{
	String address();
}

class Employee implements Date,Address 	//Multiple Interface used in the Parent class.
{
	String name;
	int empId;
	double salary;
	String jobPosition;
	String contactNumber;
	String Date, Address;
	Employee()
		{}
	Employee(String name, int empId, double salary, String jobPosition, String contactNumber, String Date, String Address)
		{
		 this.name = name;
		 this.empId = empId;
		 this.salary = salary;
		 this.jobPosition = jobPosition;
		 this.contactNumber = contactNumber;
		 this.Date = Date; this.Address = Address;
		}
	public String hireDate()
		{return Date;}
	public String address()
		{return Address;}
	Scanner obj = new Scanner(System.in);
	void Enter_Emp_Details() 	//getter used to obtain value from the objects
		{
		 System.out.println();
		 System.out.print("Enter the Name of the Employee: "); name = obj.nextLine();
		 System.out.print("Enter the Employee ID: "); empId = obj.nextInt(); obj.nextLine();
		 System.out.print("Enter the Position of the Employee: "); jobPosition = obj.nextLine();
		 System.out.print("Salary of the Employee: "); salary = obj.nextDouble(); obj.nextLine();
		 System.out.print("Enter the Date of Joining [yyyy-MM-dd]: "); Date = obj.nextLine();
		 System.out.print("Contact Number of the Employee: "); contactNumber = obj.nextLine();
		 System.out.print("Address: "); Address = obj.nextLine();
		}
	void Details()		//used to display the value obtained from the objects
		{
		 System.out.println(name+"\t\t"+empId+"\t\t"+jobPosition+"\t\t"+Date+"\t\t"+salary+"\t"+contactNumber+"\t\t"+Address);
		}
}

public class Test 
{
	
	public static void Details_of_Employee(Employee []ar)
		{
		 BasicOutLine();
		 for(int i =0; i <ar.length; i++)
			{ar[i].Details();}
		}
	
	private static void BasicOutLine() 	//Header outline
	{
		System.out.println("Name_of_Emp\t\tEmp_ID\t\tPosition\tDate_of_Joining\t\tSalary\t\tContact_No.\t\tAddress");
		 System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
	}

	public static void arrangeEmployeeBySalary(Employee []ar) //Used to Arrange the Employee in descending order as per their Salary
		{
		 Employee temp = new Employee();
		 for(int i =0; i < ar.length; i++)
			for(int j = i; j <ar.length; j++)
	 	 	{if(ar[i].salary < ar[j].salary)
	 	 		{
	 	 		 temp = ar[i];
	 	 		 ar[i] = ar[j];
	 	 		 ar[j] = temp;
	 	 		}
	 	 	}
		 System.out.println();
		 System.out.println("Updated List");
		 Details_of_Employee(ar);
		}
	
	public static void getEmployeesByJobPosition(Employee []ar, String s) //Used to find the Employees as per their Job Position.
		{
		 System.out.println();
		 System.out.println("The Required List : 'Position of Employee' : '"+s+"'");
		 BasicOutLine();
		 for(int i = 0; i < ar.length; i++)
		 	{if(s.equalsIgnoreCase(ar[i].jobPosition))
		 		{ar[i].Details();}
		 	}
		}
	
	public static void getEmployeesByHireDate(Employee []ar, String d1, String d2) //Used to find the Employees that joined the Company in between a given period of time.
		{
		 LocalDate date1 = LocalDate.parse(d1);
		 LocalDate date2 = LocalDate.parse(d2);
		 System.out.println();
		 System.out.println("The Required List : 'Hire_Date' ");
		 BasicOutLine();
		 for(int i = 0; i < ar.length; i++)
		 	{
			 LocalDate date = LocalDate.parse(ar[i].Date);
			 if(date.isAfter(date1) && date.isBefore(date2))
			 	{ar[i].Details();}
			 }
		}
	
	public static int foreignEmployeeCount(Employee []ar) //Used to find the number of foreign contacts.
		{
		System.out.println();
		int count = 0;
		for(int  i = 0; i < ar.length; i++)
			 {String str = ar[i].contactNumber.substring(0, 3);
			  if(!(str.equals("+91")))
			 	 {count ++;}
			 }
		return count;
		}
	
	public static void getEmployeeBySalary(Employee []ar, double s1, double s2) //Used to find the Employee with in a particular salary range.
		{
		System.out.println();
		System.out.println("The Required List : 'Salary_of_Employee' between '"+s1+"' and '"+s2+"'");
		BasicOutLine();
		for(int i = 0; i < ar.length; i++)
			{if (ar[i].salary > s1 && ar[i].salary <s2)
			 	{ar[i].Details();}
			}
		}

	public static void main(String[] args) 			//Main method.
	{
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter the Number of Employees required: "); int n = obj.nextInt();
		Employee [] ar = new Employee[n];
		for(int i =0; i <ar.length; i++)
			{
			 ar[i] = new Employee();
			 ar[i].Enter_Emp_Details();
			}
		System.out.println();
		Details_of_Employee(ar);

		arrangeEmployeeBySalary(ar); getEmployeesByJobPosition(ar ,"Manager");
		getEmployeesByHireDate(ar, "2022-04-01" , "2023-03-31");
		System.out.println("The Number of Foreign Employee is:"+foreignEmployeeCount(ar));
		getEmployeeBySalary(ar,150000,300000);
		
		obj.close();
	}

}
