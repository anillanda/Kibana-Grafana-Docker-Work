/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xl.main;

import com.google.gson.Gson;
import com.xl.beans.SampleSinkBean;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author anil
 */
public class ReadExcelSampleSilk {
    
    public static String read(String filename) {
          Gson gson = new Gson();
           Map<String, List<SampleSinkBean>> values = new HashMap<String, List<SampleSinkBean>>();
            List<SampleSinkBean> byRow = new ArrayList<SampleSinkBean>();
        try {
        	
            FileInputStream file=null;
            if(filename==null){
            file = new FileInputStream(new File("H:\\anil\\sample-sink.xlsx"));
            }
            else{
            	file = new FileInputStream(new File(filename));
            }

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
           
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
               
               
                if (row.getRowNum()>0&&row.getRowNum()<20) {
                    SampleSinkBean sb=new SampleSinkBean();
                    //System.out.println("row value" + sheet.getRow(3).getCell(3));
                    while (cellIterator.hasNext()) {//
                        Cell cell = cellIterator.next();
                      
                            String cellString = " ";
                            switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                cellString = cell.getNumericCellValue() + "";
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                               cellString = cell.getStringCellValue()+ "";

                            	break;
                                case Cell.CELL_TYPE_ERROR:
                            	cellString = cell.getErrorCellValue()+ "";
                            	break;
                                default:
                                    cellString = cell.getStringCellValue() + "";

                            }
                            
                            switch (cell.getColumnIndex()) {
                                case 0:
                                    sb.setFrYear(cellString);
                                    break;
                                case 1:
                                   sb.setVpmod(cellString);
                                case 2:
                                    sb.setProjectName(cellString);
                                case 3:
                                    sb.setProjectWorktype(cellString);
                                case 4:
                                    sb.setBusinessObjective(cellString);
                                

                            }
                        
                          
                    }
                 byRow.add(sb);
                 
                }
               // System.out.println("");
          
            }
          values.put("sink", byRow);
            System.out.println("output *********" + gson.toJson(values));

            file.close();
         
        } catch (Exception e) {
            e.printStackTrace();
        }
           return gson.toJson(values);
    }
    
    
    public static void main(String ar[]){
        
        System.out.println("output data"+ReadExcelSampleSilk.read(null));
    }
}
