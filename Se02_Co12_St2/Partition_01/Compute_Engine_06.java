package Partition_01;
import java.io.*;
import com.opencsv.*;
public class Compute_Engine_06
{
	public static String Engine_06(String Message_In) throws InterruptedException //change
	{
		Thread.sleep(5);
		boolean Final_Seed=false;
		int Node_Id=0;
		int Seed_Status=0;
		int Current_Seed=0;
		int User_In=0;
		String Message_Out="";
		String Raw_User_In;
		String Raw_Node_Id="";
		String Raw_Seed_Status="";
		String Raw_Current_Seed="";
		for(int a=0;a<=2;a++)
		{
			Raw_Node_Id+=Message_In.charAt(a);
		}
		Node_Id=Integer.valueOf(Raw_Node_Id)-900;
		for(int b=3;b<=5;b++)
		{
			Raw_Seed_Status+=Message_In.charAt(b);
		}
		Seed_Status=Integer.valueOf(Raw_Seed_Status)-900;
		for(int d=6;d<=14;d++)
		{
			Raw_Current_Seed+=Message_In.charAt(d);
		}
		Current_Seed=Integer.valueOf(Raw_Current_Seed)-900000000;
		if(Node_Id!=6) //Change
		{
			Message_Out=(String.valueOf(Node_Id+900))+(String.valueOf(944))+(String.valueOf(Current_Seed+900000000));
			return Message_Out;
		}
		//Check if Current seed is positive integer
		if(Integer.signum(Current_Seed)!=1&&Integer.signum(Current_Seed)!=0)
		{
			//Current Seed error, request same seed again
			Message_Out=(String.valueOf(Node_Id+900))+(String.valueOf(922))+(String.valueOf(Current_Seed+900000000));
			return Message_Out;
		}
		if(Seed_Status==00||Seed_Status==11)
		{
			//Compute here
			String File_Path=".\\Se1_Co15_Config_Output_Test\\"+String.valueOf(Current_Seed)+"_06.csv"; //Change
			File file = new File(File_Path);
			try
			{
				FileWriter OutputFile = new FileWriter(file); //Create FileWriter object with file as parameter
				CSVWriter writer = new CSVWriter(OutputFile,',',CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END); //Create CSVWriter object with filewriter object as parameter, comma as seperator, no quotes on data, and default escape characters and line ends
				String[] header = {"Intermediary Value","nanoTime"}; //Define Headers
				writer.writeNext(header); //Add Header to CSV
				long This_Term=Current_Seed; //Create and initialise This_Term variable for tracking current seed number
				String[] Seed_Data_Temp = {String.valueOf(Current_Seed),String.valueOf(System.nanoTime())}; //Create Seed_Data_Temp array and add current seed value and nanoTime to array
				writer.writeNext(Seed_Data_Temp); //Write Seed_Data_Temp array to CSV
				String[] Intermediary_Data_Temp={"",""}; //Create Intermediary_Data_Temp array and leave empty so it can be used for all intermediary values later
				while(This_Term!=1)
				{
					if(This_Term%2!=0) //If This_Term is odd:
					{
						This_Term=(3*This_Term)+1; //Multiply This_Term by 3 and add 1
						Intermediary_Data_Temp[0]=String.valueOf(This_Term); //Add This_Term to Intermediary_Data_Temp array at position 0
						Intermediary_Data_Temp[1]=String.valueOf(System.nanoTime()); //Add nanoTime to Intermediary_Data_Temp at position 1
						writer.writeNext(Intermediary_Data_Temp); //Write Intermediary_Data_Temp to CSV
					}
					else //Else (If This_Term is even)
					{
						This_Term=This_Term/2; //Divide This_Term by 2
						Intermediary_Data_Temp[0]=String.valueOf(This_Term); //Add This_Term to Intermediary_Data_Temp array at position 0
						Intermediary_Data_Temp[1]=String.valueOf(System.nanoTime()); //Add nanoTime to Intermediary_Data_Temp at position 1
						writer.writeNext(Intermediary_Data_Temp); //Write Intermediary_Data_Temp to CSV
					}
				}
				writer.close();
				//Re-construct message here
				Message_Out=(String.valueOf(Node_Id+900))+(String.valueOf(Seed_Status+900))+(String.valueOf(Current_Seed+900000000));
				return Message_Out;
			}
			catch(IOException e)
			{
				e.printStackTrace();
				//Re-construct message here
				Message_Out=(String.valueOf(Node_Id+900))+(String.valueOf(Seed_Status+900))+(String.valueOf(Current_Seed+900000000));
				return Message_Out;
			}
		}
		if(Seed_Status==22)
		{
			//return 922, node will send old message
			Message_Out="922";
			return Message_Out;
		}
		if(Seed_Status==99)
		{
			Message_Out="999";
			return Message_Out;
		}
		else
		{
			System.err.println("Unknown error occured");
			Message_Out="988";
			return Message_Out;
		}
	}
}