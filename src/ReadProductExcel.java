import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

public class ReadProductExcel {
    /*
    readExcel是什么方法？成员方法
     */
    public Product[] readExcel(InputStream in) {
        Product products[] = null;
        try {
            XSSFWorkbook xw = new XSSFWorkbook(in);
            XSSFSheet xs = xw.getSheetAt(0);
            products = new Product[xs.getLastRowNum()];
            for (int j = 1; j <= xs.getLastRowNum(); j++) {
                XSSFRow row = xs.getRow(j);
                Product product = new Product();
                for (int k = 0; k <= row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);
                    if (cell == null)
                        continue;
                    if (k == 0) {
                        product.setId(this.getValue(cell));
                    } else if (k == 1) {
                        product.setName(this.getValue(cell));
                    } else if (k == 2) {
                       product.setPrice(Float.valueOf(this.getValue(cell)));
                    } else if (k == 3) {
                        product.setDecs(this.getValue(cell));
                    }
                    products[j-1]=product;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
    public Product getProductById(String id,InputStream inproduct) {
        try {
            XSSFWorkbook xw = new XSSFWorkbook(inproduct);
            XSSFSheet xs = xw.getSheetAt(0);
            for (int j = 1; j <= xs.getLastRowNum(); j++) {
                XSSFRow row = xs.getRow(j);
                Product product = new Product();
                for (int k = 0; k <= row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);
                    if (cell == null)
                        continue;
                    if (k == 0) {
                        product.setId(this.getValue(cell));
                    } else if (k == 1) {
                        product.setName(this.getValue(cell));
                    } else if (k == 2) {
                        product.setPrice(Float.valueOf(this.getValue(cell)));
                    } else if (k == 3) {
                        product.setDecs(this.getValue(cell));
                    }
                }
                if (id.equals(product.getId())){
                    return product;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getValue(XSSFCell cell) {
        String value;
        CellType type = cell.getCellType();

        switch (type) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BLANK:
                value = "";
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue() + "";
                break;
            case NUMERIC:
                value = cell.getNumericCellValue() + "";
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case ERROR:
                value = "非法字符";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }
}
