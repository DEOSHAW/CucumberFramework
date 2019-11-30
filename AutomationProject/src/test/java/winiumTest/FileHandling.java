package winiumTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import org.testng.annotations.Test;

public class FileHandling {
	
	
	@Test
	public void File_Handling() throws Exception
	{
		String S;
		/*
		 * File file1=new File("D:/File_Handling.txt");
		 * file1.createNewFile();
		Scanner ob=new Scanner(file1);
		while(ob.hasNext())
		{
			String data=ob.next();
			
			
			System.out.println(data);
		}*/
		
		
		//This is to open file for writing in append mode
		BufferedWriter writer=new BufferedWriter(new FileWriter("D:/FileHandling.txt",true));
		writer.newLine();
		writer.write("where are you going");
		
		writer.close();
		
		File file=new File("D:/FileHandling.txt");
		
		//This is to open file for writing in overwrite mode
		//BufferedWriter writer1=new BufferedWriter(new FileWriter(file));
		
		BufferedReader reader=new BufferedReader(new FileReader(file));
		while((S=reader.readLine()) != null)
		{
			System.out.println(S);
		}
		reader.close();
		
		
	}

}
