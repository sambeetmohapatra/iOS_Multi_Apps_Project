package iOS.DataProvider;

import java.io.IOException;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 * Data Provider Method 
 * @author sambeetmohapatra
 * @version 1.0
 */
public class Dataprovider_testdata {
	
	
	
	public static Iterator<Object[]> commonmethod_for_testdata(String workbook,String sheetname,String scriptname) throws IOException
	{
	
		ExcelReadWrite xl= new ExcelReadWrite(workbook);
		HSSFSheet Sheet = xl.Setsheet(sheetname);
		
		int RowCount = xl.getrowcount(Sheet);
		int ColCount = xl.getcolcount(Sheet, 0);
		
		List<Object[]> arr_list= new ArrayList<Object[]>();
		
		for(int i=1;i<=RowCount;i++)
		{
			String Script_name = xl.Readvalue(Sheet, i, "Script_name");
			
			if(Script_name.equals(scriptname))
			{
				Object[] x= new Object[1];
				Map<String,String> dMap= new HashMap<String,String>();
				
				for(int j=0;j<ColCount;j++)
				{
					
					String Skey = xl.Readvalue(Sheet, 0, j);
					String Value = xl.Readvalue(Sheet, i, j);
					
					dMap.put(Skey, Value);
					
				}//end of col for loop
				
				x[0]=dMap;
				arr_list.add(x);		
				
				
			}//end of if condition
			
			
			
		}//end of row for loop
		
		
		
		return arr_list.iterator();
		
		
		
		
	}
	
		
	}

