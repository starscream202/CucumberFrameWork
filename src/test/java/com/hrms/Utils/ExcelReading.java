package com.hrms.Utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReading {
    static XSSFWorkbook book;
    static Sheet sheet;

    public static void setSheet(String sheetName) {
        sheet = book.getSheet(sheetName);

    }

    /**
     * Opens excel file
     * @param filepath
     * @return
     */
    public static List<Map<String, String>> openExcel(String filepath, String sheetname){

        try{
            FileInputStream fis=new FileInputStream(filepath);
            book=new XSSFWorkbook(fis);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        setSheet(sheetname);

        return null;
    }



    /**
     * Opens sheet in excel
     * @param sheetname
     */
    public static void getSheet(String sheetname){
        book.getSheet(sheetname);
    }

    /**
     * Gets number of rows in file
     * @return
     */
    public static int getRowsCount(){
        return sheet.getPhysicalNumberOfRows();
    }

    /**
     * gets number of cells in file
     * @param rowIndex
     * @return
     */
    public static int getColumnsCount(int rowIndex){
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }

    /**
     * goes through all rows and columns and stores in map then stores map into list
     * @param filepath
     * @param sheetname
     * @return
     */
    public static List<Map<String, String>> excelIntoListMap(String filepath, String sheetname){
        openExcel(filepath,sheetname);
        getSheet(sheetname);

        List<Map<String,String>> listData=new ArrayList<>();
        for(int row=1; row<getRowsCount(); row++){
            Map<String,String> map=new LinkedHashMap<>();
            for(int col=0;col<getColumnsCount(row); col++){
                map.put(getCellData(0,col),getCellData(row,col));
            }

            listData.add(map);
        }
        return listData;
    }
    public static String getCellData(int rowIndex, int colIndex){
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }


}


