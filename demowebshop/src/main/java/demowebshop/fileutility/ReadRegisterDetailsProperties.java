package demowebshop.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadRegisterDetailsProperties {
	FileInputStream path;
	public String fetchProperties(String key) 
	{
		try
		{
			path = new FileInputStream("./src/test/resources/RegisterDetails.properties");
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Properties pObj = new Properties();
		try
		{
			pObj.load(path);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		String data = pObj.getProperty(key);
		return data;
	}
	public static void main(String[] args) 
	{
		ReadRegisterDetailsProperties reg = new ReadRegisterDetailsProperties();
		String firstname = reg.fetchProperties("firstname");
		System.out.println(firstname);
		
	}

}
