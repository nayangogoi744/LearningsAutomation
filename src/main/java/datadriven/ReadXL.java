package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXL {

	public static void main(String[] args) throws IOException {
		
			File src = new File("C:\\Old-data\\Projects\\testdata\\loginInfo.xlsx");
			FileInputStream stream = new FileInputStream(src);
			XSSFWorkbook wm = new XSSFWorkbook(stream);
			XSSFSheet sheet1 = wm.getSheetAt(0);
			String value1 = sheet1.getRow(0).getCell(0).getStringCellValue();
			System.out.println("Data is : "+value1);
			
			String value2 = sheet1.getRow(0).getCell(1).getStringCellValue();
			System.out.println("Data is : "+value2);
			/*wm.write(fileOut);
			fileOut.flush();
			fileOut.close();*/
			stream.close();
			
			
	}

}
