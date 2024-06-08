package demo;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	
	FileInputStream fis;
	Workbook wb;
	
	public Object[][] getmultipledata(String sheetname) {
		try
		{
			fis = new FileInputStream("./src/test/resources/ExcelDPCrediantial.xlsx");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			wb = WorkbookFactory.create(fis);
		}
		catch(EncryptedDocumentException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Sheet sheet = wb.getSheet(sheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[] [] data = new Object[rowCount-1] [cellCount];
		
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1] [j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
}
	
	//After read the data we can remove this main method
	
	
	//public static void main(String[] args)
	//{
		//ReadExcel read = new ReadExcel();
		//Object[][] data = read.getmultipledata("Sheet1"); //sheetname
		//for(int i =0;i<data.length;i++)
		//{
			//for(int j=0;j<2;j++)
			//{
				//System.out.println(data[i][j]);
		//	}
		//}
	//}
	

