package winiumTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheet {
	
	public static void main(String args[]) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Bishal\\git\\CucumberFramework\\AutomationProject\\POIExcel.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheetAt(0);
		int rowNum=sh.getLastRowNum();
		System.out.println("Last Row Number is: "+rowNum);
		int colNum=sh.getRow(0).getLastCellNum();
		System.out.println("Last Col Number is: "+colNum);
		for(int i=0;i<rowNum+1;i++)
			for(int j=0;j<colNum;j++)
				System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
		
		
		String s="How.are.you.Deo";
		String S1[]=s.split("\\.",3);
		for(String s1:S1)
			System.out.println(s1);
		
		
	}

}
