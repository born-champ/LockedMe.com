package locker.back;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


public class UserMenu {
	
	  Scanner sc=new Scanner(System.in);
	   public String unn=" ";
	    public UserMenu(String unn) throws IOException
	    {
	    	this.unn=unn;
	        System.out.println("1. Store Credentials");
	        System.out.println("2. Fetch Credentials");
	        System.out.println("3. Delete File");
	       
	        System.out.println("4. Back to menu");
	        
	        Scanner sc=new Scanner(System.in);
		    int selectChoice=sc.nextInt();
		    optionPicked(selectChoice);
		    
	    }
	   
	
	 
	   
	    public void optionPicked(int choice) throws IOException {
	    

	        while(choice!= 4) {

	            this.options(choice);
	           
	        }
	        if(choice==4)
	        {
	        	MainMenu hp=new MainMenu();
	        	hp.display();
	        }

}
	    public void options(int selected) throws IOException
	    {
	    	
	    	switch(selected)
	    	{
	    	case 1: // Show Files in Directory                  	
                 storeData(unn);             
                 UserMenu op=new UserMenu(unn);
                   break;
	    	case 2:
	    		fetchCreds(unn);
	    		UserMenu op1=new UserMenu(unn);
	    	case 3:
	    		gayabKarDo(unn);
	    		MainMenu hp=new MainMenu();
	    		hp.display();	    		
	    	 default:
	                System.out.println("Invalid Selection");
	                UserMenu op2=new UserMenu(unn);
	                break;

	    }
	    }
	   public void storeData(String unn) throws IOException
	   {		
			System.out.println("Welcome to your file locker,please enter the details you wish to store");
			//	File myFile=new File(unn);
				unn=unn+".txt";
              FileWriter fileWriter = new FileWriter(unn,true);
              System.out.println("Enter website whose credentials you want to add");
              String web=sc.next();
              System.out.println("Enter username for the website");
              String webuser=sc.next();
              System.out.println("Enter password");
              String webpass=sc.next();
              String a="writing";
              fileWriter.write(web+"\n");
              fileWriter.write(webuser+"\n");
              fileWriter.write(webpass+"\n"); 
              System.out.println("Your Credentials have been stored");          
              fileWriter.close(); 
	   }
	   public void fetchCreds(String unn)throws IOException
	   { int f=0;
		   System.out.println("Welcome to your file locker,please enter the website whose credentials you wish to fetch");
		   	unn=unn+".txt";
		   String fetch=sc.next();
		   try (BufferedReader br1 = new BufferedReader(new FileReader(unn))) {
			String st;
			  while ((st = br1.readLine()) != null)
			    if(st.equals(fetch))
			    {
			    	String st1=br1.readLine();
			    	String st2=br1.readLine();
			    	System.out.println("Your username for website "+fetch+" is: "+st1);
			    	System.out.println("Your password for website "+fetch+" is: "+st2);
			    	f=1;
			    }
			    if(f==0)
			    {
			    	System.out.println("Credentials Not Stored");
			    }
		}    	
	   }
		public void gayabKarDo(String unn)
		{
        	unn=unn+".txt";
			 File myFile = new File(unn);
		        if(myFile.delete()){
		            System.out.println("File deleted: " + unn);
		        }
		        else{
		            System.out.println("File not found");
		        }
		}

	}
// end of code 
