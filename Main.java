import java.util.Scanner;

interface Examination_System
{
	abstract double calculateEligibility();
	abstract double calculateGPA();
	
}


class Eligibility implements Examination_System
{
	String Subject[];
	int lecHours[]=new int[7];
	double attPercentage[]=new double[7];
	int TotalLecHours[];
	
	double Attendence[]=new double[7];
	int ICA1[]=new int[7];
	int ICA2[]=new int[7];
	int ICA3[]=new int[7];	
	
	String ICAEligibile="no";
	
	Scanner scan1=new Scanner(System.in);
	
	
	Eligibility(String Subject[],int TotalLecHours[])
	{
		this.Subject=Subject;
		this.TotalLecHours=TotalLecHours;
	}
	
	public double calculateEligibility()
	{
		System.out.println("         Calculate Eligibility");
		
		System.out.println("=======================================");
		System.out.println();
		
		for(int i=0; i<7; i++)
		{
			System.out.print("Enter the attending lecturing hours in "+Subject[i]+" total of "+TotalLecHours[i]+" : ");
			lecHours[i]=scan1.nextInt();
			
			attPercentage[i]=(lecHours[i]*100)/TotalLecHours[i];
			
			
			System.out.print("Enter your "+Subject[i]+" ICA-1 marks : ");
			ICA1[i]=scan1.nextInt();
			
			System.out.print("Enter your "+Subject[i]+" ICA-2 marks : ");
			ICA2[i]=scan1.nextInt();
			
			System.out.print("Enter your "+Subject[i]+" ICA-3 marks : ");
			ICA3[i]=scan1.nextInt();
			
			if(ICA1[i]>=40 && ICA2[i]>=40 )
			{
				ICAEligibile="yes";
			}
			if(ICA2[i]>=40 && ICA3[i]>=40 )
			{
				ICAEligibile="yes";
			}
			if(ICA1[i]>=40 && ICA3[i]>=40 )
			{
				ICAEligibile="yes";
			}
			
			if(attPercentage[i]>=80 && ICAEligibile.equals("yes"))
			{
				System.out.println("You are ELIGIBLE for Semister exam in "+Subject[i]);
			}
			else
			{
				System.out.println("You are NOT eligible for Semister exam in "+Subject[i]);
			}
			
			System.out.println("\n");
		}
		
		return 0;
	}
	 public double calculateGPA()
	 {return 0;}
}


class GPA implements Examination_System
{
	String Subject[];
	String Grade[]={"A+","A","A-","B+","B","B-","C+","c","c-","F"};
	double GradePoints[]={4.0,4.0,3.7,3.3,3.0,2.7,2.3,2.0,1.7,1.0,0.0};
	
	int SubCredits[]={3,4,3,3,2,1,1};
	String SubGrade[]=new String[7];
	double points_credits[]=new double[7];
	double total_points_credits=0;
	
	Scanner scan2=new Scanner(System.in);
	
	GPA(String Subject[])
	{
		this.Subject=Subject;
	}
	
	
	
	public double calculateGPA()
	{   
		System.out.println("         Calculate GPA & Class");
		
		System.out.println("=======================================");
		System.out.println();
		System.out.println("Enter your grades for following subject (A+ / A / A- )");
		
	
		for(int i=0; i<7; i++)
		{
			System.out.print("Enter the "+Subject[i]+" Grade : ");
			SubGrade[i]=scan2.nextLine();
			
			for(int j=0; j<10; j++)
			{
				if(SubGrade[i].equals(Grade[j]))
				{
					points_credits[i]=GradePoints[j]*SubCredits[i];
					total_points_credits=total_points_credits+points_credits[i];
				}
				
			}
		}
		
		double gpa=total_points_credits/17;
		
		if(gpa<=4.0 && gpa>=3.5)
		{
			System.out.println("\nYou are the FIRST class.\n");
		}
		else if(gpa<=3.49 && gpa>=3.0)
		{
			System.out.println("\nYou are the SECOND class(Upper).\n");
		}
		else if(gpa<=2.99 && gpa>=2.5)
		{
			System.out.println("\nYou are the SECOND class.\n");
		}
		else if(gpa<=2.49 && gpa>=2.0)
		{
			System.out.println("\nYou are the THIRD class.\n");
		}
		else
		{
			System.out.println("\nYou are FAIL !.\n");
		}
		return 0;
	}
	
	public double calculateEligibility()
	{
		return 0;
	}
}


class Main
{
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		
		String Subject[]={"Discrete Structure","Object oriented programming","Operating system","Electronics & digital circuits design","Computational engineering drawing","IT law","Social harmony"};
		int TotalLecHours[]={30,40,35,25,20,15,15};
		
		System.out.println("\n_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_Welcome to University of VAVUNIYA Student Examination System_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
		System.out.println("********************************************************************************************************************************\n");
		System.out.println("    Following Options are available.. ");
		System.out.println("       1-Eligiblity Checking for the final examination");
		System.out.println("       2-Calculate GPA & Class \n");
		System.out.print("Choose the option(1 OR/ 2) : ");
		int option=scan.nextInt();
		System.out.println("\n");
		
		switch (option)
		{
			case 1:
				Eligibility ob1=new Eligibility(Subject,TotalLecHours);
				ob1.calculateEligibility();
				break;
			
			case 2:
				GPA ob2=new GPA(Subject);
				ob2.calculateGPA();
				break;
				
			default:
				System.out.println("ERROR!...Your choise is invalid");
			
		}
		
		
	}
}