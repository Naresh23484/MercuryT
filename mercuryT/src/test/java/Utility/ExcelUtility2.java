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

public class ExcelUtility2 {
	Workbook newbook=null;
	Row row=null;
	FileInputStream inputStream=null;
	File file =   null;
	MercuryCredential mercuryDobj1=null;


	public List<MercuryCredential> getMercuryDetails() throws IOException
	{
		file= new File("C:\\Users\\naresh.sunkari\\eclipse\\mercuryT\\mercury.xlsx");
		inputStream = new FileInputStream(file);
		newbook =  new XSSFWorkbook(inputStream);

		List<MercuryCredential> mercuryList1=new LinkedList<MercuryCredential>();

		Sheet sheet1=newbook.getSheet("Sheet2");
		int rowCount = sheet1.getLastRowNum();

		row=sheet1.getRow(0);
		int colCount=row.getLastCellNum();
		System.out.println(rowCount);
		System.out.println(colCount);	
		for(int i=1;i<=rowCount;i++)
		{
			row=sheet1.getRow(i);
			mercuryDobj1=new MercuryCredential();
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

			mercuryDobj1.setFirstName(firstname);
			mercuryDobj1.setLastName(lastname);
			mercuryDobj1.setPhone(phone);
			mercuryDobj1.setEmail(emaill);
			mercuryDobj1.setAddress(address);
			mercuryDobj1.setCity(city);
			mercuryDobj1.setState_province(state);
			mercuryDobj1.setPostalCode(postalcode);
			mercuryDobj1.setuName(username);
			mercuryDobj1.setPassWord(password);
			mercuryDobj1.setConfirmpassWord(conpassw);
			mercuryList1.add(mercuryDobj1);
		}
		return mercuryList1;
	}

}



