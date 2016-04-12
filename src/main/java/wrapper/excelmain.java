package wrapper;

import java.io.IOException;

import org.junit.Test;

public class excelmain extends ExcelWrapper {
	@Test
	public void excelsample() throws IOException
	{
		openwbook("./data/sample1.xlsx", "Output");
		rowcount();
		System.out.println(rowcount());
		
		CellValue(2, 2);
		System.out.println(CellValue(1,1));
		writewbook(1, 4, "new","./data/sample1.xlsx"); 
		closewbook();
	}

}
