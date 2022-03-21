package Partition_02;
import java.io.*;
import java.net.*;
public class Collatz_Server
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket Control_Socket=null; //Declare ControlSocket and set to null, allows the control node to
		boolean listening=true; //Declares boolean listening as true, sets Server to default always listen on ports
		String Control_Name="Control"; //Declares ControlName variable and sets equal to Control, this names the server
		int Control_Num=4545; //Declares ControlNum variable, this sets the socket number that the server will listen on
		int[][] Seed_Table=Seed_Table_Generator.Seed_Table_Engine();
		Collatz_Server_State Shared_State_Object = new Collatz_Server_State(Seed_Table);
		try
		{
			Control_Socket = new ServerSocket(Control_Num);
		}
		catch(IOException e)
		{
			System.err.println("Could not start Control_Node on port: "+Control_Num); 
			System.exit(1);
		}
		System.out.println(Control_Name+" started");
		while(listening)
		{
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_01", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_02", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_03", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_04", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_05", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_06", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_07", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_08", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_09", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_10", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_11", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_12", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_13", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_14", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_15", Shared_State_Object).start();
			System.out.println("New control thread started");
		}
		Control_Socket.close();
	}
}