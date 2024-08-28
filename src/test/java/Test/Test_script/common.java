package Test.Test_script;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class common {
	private static final String filesource="C:\\Users\\bhushan.toke\\Documents\\Test_script\\src\\test\\java\\Test\\Test_script\\TestData.xlsx";
	public static String readData(int row, int column) throws IOException {
        FileInputStream fis = new FileInputStream(filesource);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("Proprietorship");
        XSSFRow r;
        r = sheet.getRow(row);
        XSSFCell cell = r.getCell(column);
        return cell.getStringCellValue();
    }

    public static void writeData(int row, int column, String value) throws IOException {
        FileInputStream fis = new FileInputStream(filesource);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("Proprietorship");
        XSSFRow r;
        r = sheet.getRow(row);
        XSSFCell cell = r.createCell(column);
        cell.setCellValue(value);
        FileOutputStream fos = new FileOutputStream(filesource);
        workbook.write(fos);
        fos.close();
   }
}