package common;

	import java.io.File;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.LinkedHashMap;
	import java.util.List;
	import java.util.Map;
	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class ExcelReader {
		public static int totalRow;

	    public List<Map<String, String>> getData(String excelFilePath, String sheetName)
	            throws InvalidFormatException, IOException {

	        // Use try-with-resources to ensure workbook is closed after use
	        try (Workbook workbook = WorkbookFactory.create(new File(excelFilePath))) {
	            Sheet sheet = workbook.getSheet(sheetName);
	            return readSheet(sheet);
	        }
	    }
	    private List<Map<String, String>> readSheet(Sheet sheet) {
	        Row row;
	        Cell cell;
	        totalRow = sheet.getLastRowNum();

	        List<Map<String, String>> excelRows = new ArrayList<>();

	        // Ensure that the sheet has at least one row
	        if (totalRow > 0) {
	            // First row contains column headers
	            Row headerRow = sheet.getRow(0);

	            // Loop through each row (skipping header row)
	            for (int currentRow = 1; currentRow <= totalRow; currentRow++) {

	                row = sheet.getRow(currentRow);
	                int totalColumn = row.getLastCellNum();
	                LinkedHashMap<String, String> columnMapData = new LinkedHashMap<>();

	                // Loop through columns in each row
	                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
	                    cell = row.getCell(currentColumn);
	                    String columnHeaderName = headerRow.getCell(currentColumn).getStringCellValue();

	                    // Handle potential null values in cells
	                    String cellValue = (cell != null) ? cell.getStringCellValue() : "";
	                    columnMapData.put(columnHeaderName, cellValue);
	                }

	                excelRows.add(columnMapData);
	            }
	        }
	        return excelRows;
	    }

	    public int countRow() {
	        return totalRow;
	    }



}
