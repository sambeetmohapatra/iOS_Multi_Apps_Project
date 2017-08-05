package iOS.DataProvider;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReadWrite {
	
	private FileInputStream fis;
	private HSSFWorkbook wb;
	
	
	public static String getExcelData(String workbook,String sheetName, int rowNum,int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException{
		Workbook wb = WorkbookFactory.create(new FileInputStream(workbook));
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(colNum).getStringCellValue();
		wb.close();
		return data;		
	}	
	
	public  int getRowCount(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowIndex = sh.getLastRowNum();
		return rowIndex;
	}
	
	public  int getColumnCount(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int noOfColumns = sh.getRow(0).getPhysicalNumberOfCells();
		return noOfColumns;
	}

	public ExcelReadWrite(String xlPath) throws IOException
	{
	 fis= new FileInputStream(xlPath);
	
	//workbook object
	 wb= new HSSFWorkbook(fis);
}
	
	public HSSFSheet Setsheet(String sheetname)
	{
		HSSFSheet Sheet = wb.getSheet(sheetname);
		return Sheet;
		
	}
	public int getrowcount(HSSFSheet Sheet)
	{
		int lastRowNum = Sheet.getLastRowNum();
		return lastRowNum;
		
	}
	public int getcolcount(HSSFSheet Sheet,int rowIndex)
	{
		int lastcolnum  = Sheet.getRow(rowIndex).getLastCellNum();
		return lastcolnum;
		
	}
	@SuppressWarnings("deprecation")
	public String Readvalue(HSSFSheet Sheet,int rowIndex, int cellnum)
	{
		HSSFCell cell = Sheet.getRow(rowIndex).getCell(cellnum);
		
		String celltext=null;
		
		if(cell==null)
		celltext="";
		
		else if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		celltext=cell.getStringCellValue();
		
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
		celltext=String.valueOf(cell.getNumericCellValue());
		
		else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
		celltext="";
		
		return celltext;
	}
	
	
	public String Readvalue(HSSFSheet Sheet,int rowIndex, String colname)
	{
		int colindex = 0;
		for(int i=0;i<getcolcount(Sheet,0);i++){
			
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(Sheet.getRow(0).getCell(i).getStringCellValue().trim().equalsIgnoreCase(colname))
				colindex=i;
		}
		
		return Readvalue(Sheet,rowIndex, colindex);
		
		
	}
	public void writecell(HSSFSheet Sheet,int rowIndex,int cellnum, String wvalue )
	{
		//writing the cell
		HSSFCell writecell = Sheet.getRow(rowIndex).getCell(cellnum);
		if(writecell==null)
		{
			writecell=Sheet.getRow(rowIndex).createCell(cellnum);
		}
		writecell.setCellValue(wvalue);
	}
	
	public void writecell(HSSFSheet Sheet,int rowIndex,String colname, String wvalue ){
		int colindex = 0;
		for(int i=0;i<getcolcount(Sheet,0);i++){
			
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(Sheet.getRow(0).getCell(i).getStringCellValue().trim().equalsIgnoreCase(colname))
				colindex=i;
		}
		writecell(Sheet,rowIndex,colindex, wvalue );
		
	}
	
	public void save_excel(String xlPath) throws IOException
	{
		fis.close();
		FileOutputStream fos= new FileOutputStream(xlPath);		
		wb.write(fos);
		fos.close();
	}
	
	
	
	
	
	
	
	
	
	

}
