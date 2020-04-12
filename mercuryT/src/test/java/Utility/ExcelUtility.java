package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Data_Project.MercuryCredential;

public class ExcelUtility {
	Workbook newbook=null;
	Row row=null;
	FileInputStream inputStream=null;
	File file =   null;
	MercuryCredential mercuryDobj=null;


	public List<MercuryCredential> getMercuryDetails() throws IOException
	{
		file= new File("C:\\Users\\naresh.sunkari\\eclipse\\mercuryT\\mercury.xlsx");
		inputStream = new FileInputStream(file);
		newbook =  new XSSFWorkbook(inputStream);

		List<MercuryCredential> mercuryList=new LinkedList<MercuryCredential>();

		Sheet sheet1=newbook.getSheet("Sheet1");
		int rowCount = sheet1.getLastRowNum();

		row=sheet1.getRow(0);
		int colCount=row.getLastCellNum();
		System.out.println(rowCount);
		System.out.println(colCount);	
		for(int i=1;i<=rowCount;i++)
		{
			row=sheet1.getRow(i);
			mercuryDobj=new MercuryCredential();
			String firstname=row.getCell(0).getStringCellValue();
			String lastname=row.getCell(1).getStringCellValue();
			String phone=row.getCell(2).getStringCellValue();
			String emaill=row.getCell(3).getStringCellValue();
			String address=row.getCell(4).getStringCellValue();
			String city=row.getCell(5).getStringCellValue();
			String state=row.getCell(6).getStringCellValue();
			String postalcode=row.getCell(7).getStringCellValue();
			String username=row.getCell(9).getStringCellValue();
			String password=row.getCell(10).getStringCellValue();
			String conpassw=row.getCell(11).getStringCellValue();

			mercuryDobj.setFirstName(firstname);
			mercuryDobj.setLastName(lastname);
			mercuryDobj.setPhone(phone);
			mercuryDobj.setEmail(emaill);
			mercuryDobj.setAddress(address);
			mercuryDobj.setCity(city);
			mercuryDobj.setState_province(state);
			mercuryDobj.setPostalCode(postalcode);
			mercuryDobj.setuName(username);
			mercuryDobj.setPassWord(password);
			mercuryDobj.setConfirmpassWord(conpassw);
			mercuryList.add(mercuryDobj);
		}
		return mercuryList;
	}

}



