package winiumTest;

import org.testng.annotations.Test;

public class Demo {
	
	
	 static int cube(int x)
	 {
		 int volume=x*x*x;
		 return volume;
	 }

	    public static void main(String args[])
	    {  
	    	System.out.println("This is Demo Class");
	    	int volume1=Demo.cube(5);
	    	System.out.println("Volume is"+volume1);
	    	Demo ob=new Demo();
	    	ob.display();
	    	ob.show();
	    	Demo1 ob1=new Demo1();
	    	ob1.Manifest();
	    	
	    	
	    	
	        
	     }
	    void show()
	    {
	    	display();
	    	System.out.println("This is Show Method");
	    }
	    void display()
	    {
	    	int volume2=cube(7);
	    	System.out.println("This is Display Method"+volume2);
	    }
	    

}

class Demo1
{
	void Manifest()
	{
		int volume3=Demo.cube(8);
		System.out.println("This is Manifest Method"+volume3);
	}
}


