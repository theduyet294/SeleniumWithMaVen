 package common;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Utils {
	public static String[][] getTableObject(String xlFilePath, String sheetName) {
		String[][] tabArray = null;
		int ci, cj;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			tabArray = new String[sheet.getRows() - 1][sheet.getColumns()-1];
			ci = 0;

			for (int i = 1; i < sheet.getRows(); i++, ci++) {
				cj = 0;
				for (int j = 0; j < sheet.getColumns(); j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (tabArray);

}
	//get data form  Excel then convert to hasmap
	public static List<HashMap<String,String>> getTestDataFromExcel(String xlFilePath, String sheetName) {
		List<HashMap<String,String>> listData = new ArrayList<HashMap<String,String>>();
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int startRow = 1, startCol = 0;
			int endRow = sheet.getRows();
			int endCol = sheet.getColumns();
			
			for(int i = startRow ; i < endRow; i++)
			{
				HashMap<String,String> valSet = new HashMap<String,String>();
					for(int j = 1; j < endCol; j++)
					{
						valSet.put(sheet.getCell(startRow,j ).getContents(), sheet.getCell(i, j).getContents());
					}
					listData.add(valSet);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (listData);
	}

	public static List<Map> getTestDataFromCSV(String csvFilePath){
		 List<Map> listData = new ArrayList<>();
		try {
			Reader in = new FileReader(csvFilePath);
	         Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);

	         for (CSVRecord record : records) {
	             listData.add(record.toMap());
		}
		}catch (Exception e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
	
         
		return listData;
	}
	
	
	}


