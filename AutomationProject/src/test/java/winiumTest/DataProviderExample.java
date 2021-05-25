package winiumTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	
	
	
	@Test(dataProvider="dataSupplier")
	void DisplayNumbers(int x,int y,int z)
	{
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}
	
	
	@DataProvider(name="dataSupplier")
	Object [][] supplyData()
	{
		
		Object [][] Data=new Object[3][3];
		Data[0][0]=1;
		Data[0][1]=2;
		Data[0][2]=5;
		Data[1][0]=3;
		Data[1][1]=4;
		Data[1][2]=7;
		Data[2][2]=8;
		Data[2][0]=5;
		Data[2][1]=6;
		return Data;
		
	}

}
