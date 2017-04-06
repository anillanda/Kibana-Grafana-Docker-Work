/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xl.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author anil
 */
public class PropertyFileReader {
 private final Properties configProp = new Properties();
    
    public  Properties read(String file){
         InputStream in = this.getClass().getClassLoader().getResourceAsStream(file);
      System.out.println("Read all properties from file");
      try {
        
          configProp.load(in);
         
      } catch (IOException e) {
          e.printStackTrace();
      }
       return configProp;
        
    }
    
}
