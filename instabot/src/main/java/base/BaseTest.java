package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	protected WebDriver driver;
	
	public static int photoLikedCount=0;
	
	public BaseTest(WebDriver driver){
		this.driver = driver;
	}
	
	private static Logger logger = Logger.getLogger(BaseTest.class);
	
	@BeforeClass
	public void setUp(){
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	public List<String> readData(String columnValue){
		List<String> data = new ArrayList<String>();
		try{
			FileInputStream fileinput = new FileInputStream(new File(".\\src\\main\\resources\\data\\instaInputData.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
			XSSFSheet sheet = workbook.getSheet(this.getClass().toString());
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()){
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.iterator();
				while(cellIterator.hasNext()){
					Cell cell = cellIterator.next();
					if(cell.getStringCellValue().equalsIgnoreCase(columnValue)){
						try{
							data.add(cell.getStringCellValue());
						}
						catch(Exception e){
							System.out.println("Cell value null in excel. "+e);
						}	
					}
				}
			}
			workbook.close();
		}
		catch(Exception e){
			logger.error(e);
			System.out.println(e);
		}
		return data;
	}
	
	public void writeData(String data1, String data2, String sheetName){
		try{
			FileInputStream input = new FileInputStream(new File(".\\src\\main\\resources\\data\\InstaOutputData.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()){
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.iterator();
				while(cellIterator.hasNext()){
					Cell cell = cellIterator.next();
					if(cell.getStringCellValue() != null || cell.getStringCellValue() != ""){
						row = rowIterator.next();
						cell = row.getCell(0);
						Cell nextCell = row.getCell(1);
						if(cell==null && nextCell==null){
							cell.setCellValue(data1);
							nextCell.setCellValue(data2);
						}
					}
				}
			}
		}
		catch(Exception e){
			logger.error(e);
			System.out.println(e);
		}
		
	}
	
	public void writeFollowCount(int count){
		try{
			FileInputStream input = new FileInputStream(new File(".\\src\\main\\resources\\data\\InstaOutputData.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheet("Counter");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(0);
			cell.setCellValue(count);
		}
		catch(Exception e){
			logger.error(e);
		}
	}
	
	public void writeLikeCount(int count){
		try{
			FileInputStream input = new FileInputStream(new File(".\\src\\main\\resources\\data\\InstaOutputData.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheet("Counter");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(1);
			cell.setCellValue(count);
		}
		catch(Exception e){
			logger.error(e);
		}
	}
	
	public void writeCommentCount(int count){
		try{
			FileInputStream input = new FileInputStream(new File(".\\src\\main\\resources\\data\\InstaOutputData.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheet("Counter");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(2);
			cell.setCellValue(count);
		}
		catch(Exception e){
			logger.error(e);
		}
	}
	
	public int getFollowCount(){
		double value=0;
		try{
			FileInputStream input = new FileInputStream(new File(".\\src\\main\\resources\\data\\InstaOutputData.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheet("Counter");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(0);
			value = cell.getNumericCellValue();
		}
		catch(Exception e){
			logger.error(e);
		}
		return (int)value;
	}
	
	public int getLikeCount(){
		double value=0;
		try{
			FileInputStream input = new FileInputStream(new File(".\\src\\main\\resources\\data\\InstaOutputData.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheet("Counter");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(1);
			value = cell.getNumericCellValue();
		}
		catch(Exception e){
			logger.error(e);
		}
		return (int)value;
	}
	
	public int getCommentCount(){
		double value=0;
		try{
			FileInputStream input = new FileInputStream(new File(".\\src\\main\\resources\\data\\InstaOutputData.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheet("Counter");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(2);
			value = cell.getNumericCellValue();
		}
		catch(Exception e){
			logger.error(e);
		}
		return (int)value;
	}

}
