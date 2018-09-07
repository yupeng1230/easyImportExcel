package com.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther yu
 * @createTime 2018年08月31日 11时39分
 * @discription
 */
public class ImportExcel {
    public List<ShopInfoEntity> importExcel() throws IOException {

        // 创建对Excel工作簿文件的引用
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("C:\\Users\\lee\\Desktop\\门店导入模板 - 测试.xls"));
        HSSFSheet sheet = workbook.getSheet("sheet1");
        int rows = sheet.getPhysicalNumberOfRows();
        List<ShopInfoEntity> list = new ArrayList();
        for (int i = 1; i < rows; i++) {
            HSSFRow row = sheet.getRow(i);
            if (row != null) {
                int cells = row.getPhysicalNumberOfCells();
                String value = "";
                for (int j = 1; j < cells; j++) {
                    HSSFCell cell = row.getCell(j);
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case HSSFCell.CELL_TYPE_FORMULA:
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                value += (Double) cell.getNumericCellValue() + ",";
                                break;
                            case HSSFCell.CELL_TYPE_STRING:
                                value += cell.getStringCellValue() + ",";
                                break;
                            default:
                                value += "0";
                                break;
                        }
                    }
                }
                String val[] = value.split(",");
                ShopInfoEntity shopInfoEntity = new ShopInfoEntity();
                shopInfoEntity.setShopName(val[0]);
                shopInfoEntity.setStatus((int)Double.parseDouble(val[1]));
                if(val[2].contains("E")){
                    shopInfoEntity.setPhone(new BigDecimal(val[2]).toPlainString());

                }else{
                    shopInfoEntity.setPhone(val[2]);
                }

                shopInfoEntity.setCity(val[3]);
                shopInfoEntity.setAddress(val[4]);
                shopInfoEntity.setRegion(val[5]);
                shopInfoEntity.setWerks(val[6]);
                shopInfoEntity.setShopEmployee(val[7]);
//                shopInfoEntity.setDescible(val[8]);
                shopInfoEntity.setLatitude(Double.parseDouble(val[8]));
                shopInfoEntity.setLongitude(Double.parseDouble(val[9]));
                list.add(shopInfoEntity);
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException{
        ImportExcel i = new ImportExcel();
        List<ShopInfoEntity> list = i.importExcel();
        for(ShopInfoEntity var : list) {
            System.out.println(var.toString());
        }
    }
    }

