package com.xl.utils;

import java.util.Properties;

import com.xl.main.PropertyFileReader;


public class EnvironmentUtils {
	
	
	private static  EnvironmentUtils instance;
	
	private Properties prop;
	
	
	
	private EnvironmentUtils(){
		PropertyFileReader reader=new PropertyFileReader();
		prop=reader.read(Constants.CONFIG_FILENAME);
		
	}
	
	public static EnvironmentUtils getInstance(){
		if(instance==null){
			instance=new EnvironmentUtils();
		}
		return instance;
	}
	
	 public int[] getExcelMetricsRowsToRead()
	 {
		 String val = prop.getProperty(Constants.EMS_METRICS_ROWNUM);
		 if (val!=null)
		 {		 
			 String arr[] = val.split(",");
			 int rownums[] = new int[arr.length];
			 for (int i = 0; i < arr.length; i++) {
				 rownums[i]=Integer.parseInt(arr[i].trim());
				
			}
			 return rownums;
			 
		 }
		 else
		 {
			 return null;
		 }
	 }
	 
	 public String getString(String propertyName){
		 
		 return prop.getProperty(propertyName);
	 }
	 
	 public Integer getInteger(String propertyName){
		  String s=prop.getProperty(propertyName);
		  Integer i=null;
		  if(s!=null) {
			  i=Integer.parseInt(s);
		  }else{
			  throw new RuntimeException("propertyName is not" + " supported to integer please make sure change");
		  }
	        
	        return  i;
	 }
	 
	 public Integer getEMSMetricsRowstart(){
		 return getInteger(Constants.EMS_METRICS_ROWSTART);
	 }
	 public String getEMSMetricsHeaderName(){
		 return getString(Constants.EMS_METRICS_HEADERNAME);
	 }
	 public Integer getEMSMetricsCellIndex(){
		 return getInteger(Constants.EMS_METRICS_CELLINDEX);
	 }
	 
	 public Integer getEMSMetricsCellStartIndex(){
		return  getInteger(Constants.EMS_METRICS_CELLSTARTINDEX);
	 }
	 public String getEMSCSVDataSeparator(){
		 
		 return getString(Constants.EMS_CSV_DATASEPERATOR);
	 }
	 public String getEMSMetricsCellDateFormat(){
		 return getString(Constants.EMS_METRICS_CELLDATEFORMAT);
	 }
	 public String getInputFileName(){
		 return getString(Constants.EMS_FILE_INPUTFILE);
	 }
	 public String getOutputFileName(){
		 return getString(Constants.EMS_FILE_OUTPUTFILE);
	 }
	 public Integer getEMSMetricsAsofCellIndex() {
	     return getInteger(Constants.EMS_METRICS_ASOFCELLINDEX);
     }   
	  


}
