package demowebshop.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadAddressProperties {
		FileInputStream path;
		public String fetchProperties(String key)
		{
			try
			{
				path = new FileInputStream("./src/test/resources/Address.properties");
			} 
			
			catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Properties pObj = new Properties();
			try 
			{
				pObj.load(path);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    String data = pObj.getProperty(key);
			return data;
		}
		public static void main(String[] args) 
		{
			ReadAddressProperties add=new ReadAddressProperties();
			String firstname = add.fetchProperties("firstname");
			System.out.println(firstname);
			
		}
}
		
	
