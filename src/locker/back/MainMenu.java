package locker.back;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

public class MainMenu {
	  private String productName = "Welcome to LockedMe!";
	  private String developerName = "Developer: Ashutosh Dubey";
	  int choice;
	  String u_N;
	  String u_n;
	public  String  unn;
	    Scanner sc=new Scanner(System.in);
	   
	    
	    public MainMenu()
	    {   
	        File myFile=new File("userpass.txt"); 		
		}
	    
	    public void introduction() throws IOException
	    {
	    	System.out.println(productName);
	        System.out.println(developerName);
	    	display();
	    }
	    public void display() throws IOException {
	    	System.out.println("Main Menu");
	        System.out.println("1. Show Current Files");
	        System.out.println("2. Register");
	        System.out.println("3. Login");
	        System.out.println("4. Exit");
	        Scanner sc=new Scanner(System.in);
		    int choice=sc.nextInt();
		    optionPicked(choice);
		    
	    }
	   
	    public void optionPicked(int choice) throws IOException {
	    

	        while(choice!= 4) {
	        	
	            this.options(choice);
	           
	        }
	        if(choice==4)
	        {
	        	System.exit(7);
	        }
	    }
	    public void options(int selected) throws IOException
	    {
	    	
	    	switch(selected)
	    	{
	    	case 1: // Show Files in Directory
                  	viewData();
                    display();
                    break;
	    	case 2:
	    		registration();
	    		display();
	    		break;
	    	case 3:
	    		login();
	    		display();
	    		
	    	break;
	    		
	    		
	    	 default:
	                System.out.println("Invalid Option");
	                display();
	                break;

	    }
	    
	    
}
	    public void viewData()
	    {

			File folder= new File("C:\\Users\\pcm\\Desktop\\Programs\\Simplilearn_codes_project_1_to_submit");

	    	 
	        String[] file1 = folder.list();
	        List<String> files=  Arrays.asList(file1);
	        Collections.sort(files);
//	        if( files.size() ==0)
//	        {
//	        	System.out.println("No file in dir...");
//	        }
	        for (String file : files)
	        {
	            System.out.println(file);
	        }
	    }
	    public void registration() throws IOException
	    {
	    	System.out.println("Enter your username");
	    	  u_N = sc.next();
	    	 String un=u_N;
	    	 u_N = u_N+".txt";
	    	
	    	  try (BufferedReader r1 = new BufferedReader(new FileReader("userpass.txt"))) {
	  			String st;
	  			  while ((st = r1.readLine()) != null)
	  			    if(st.equals(un))
	  			    {
	  			    	System.out.println("Username already taken,try another username");
	  			    	display();
	  			    
	  			    }
	  			  
	  		}
	    	 
	  
	    		File myFile=new File(u_N);

	         System.out.println("You are adding a user named: " + un);
	        	
	 			try {	
	 		      if (myFile.createNewFile()) {
	 		    	  System.out.println("File created: " + u_N);
	 		    	
	 		    	  
	 		      } else {
	 		        System.out.println("This User Already Exits, no need to add another");
	 		        display();
	 		      }
	 		}catch (IOException e){
	 			System.out.println(e);
	 		}
	 			System.out.println("Enter your password");
		    	 String passWord = sc.next();	
		    	 
		    	   
		            try {
		                FileWriter fileWriter = new FileWriter("userpass.txt",true);
		                fileWriter.write(un+"\n");
		               
		                fileWriter.write(passWord+"\n");
		                System.out.println("Registration Successful");
		             fileWriter.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }

	    }
	    public void login() throws IOException
	    {
	    	System.out.println("Enter your username");
	     	u_n=sc.next();
	   unn=u_n;
	    u_n =u_n+".txt";
		

		File myFile = new File("C:\\Users\\pcm\\Desktop\\Programs\\Simplilearn_codes_project_1_to_submit");

		
		String[] flist = myFile.list();
		int flag = 0;
		if (flist == null) {
			System.out.println("Database is empty");
		}
		
		else {

			// Linear search in the array
			for (int i = 0; i < flist.length; i++) {
				String filename = flist[i];
				if (filename.equals(u_n)) {
					System.out.println("Enter password");
					 String	password=sc.next();
					  BufferedReader br = new BufferedReader(new FileReader("userpass.txt"));
					  
					  String st;
					  while ((st = br.readLine()) != null)
					    if(st.equals(unn))
					    {
					    	st=br.readLine();
					    	if(st.equals(password))
					    	{
					    		System.out.println("Login Successful");
					    	UserMenu op1=new UserMenu(unn);
					    		
					    	}
					    	else
					    		System.out.println("Invalid Credentials");
					    	
					    }
					flag = 1;

				   
				}
			}
		}

		if (flag == 0) {
			System.out.println("User not found,try again");
			}
	    }
  
   }