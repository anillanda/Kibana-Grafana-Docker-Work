/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xl.service;

import com.xl.conf.NodeClientConf;
import com.xl.main.ReadExcelSampleSilk;

import static com.xl.conf.NodeClientConf.getRestClient;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

/**
 *
 * @author anil
 */
public class OperationService {
    
    public static void add(RestClient client) throws IOException{
        
        //HttpEntity entity = new StringEntity(
        //ReadExcel.run(null), ContentType.APPLICATION_JSON);
//Response indexResponse = getRestClient().performRequest(
        //"PUT",
        //"/test/t2/2",
       // Collections.<String, String>emptyMap(),
       // entity);

       // System.out.println("respone :::: from server ::::::::::::::"+indexResponse.getStatusLine().getStatusCode());
        
    }
    
    public static void addSampleSink(RestClient client,String fileName) throws IOException{
        
        HttpEntity entity = new StringEntity(
                ReadExcelSampleSilk.read(fileName), ContentType.APPLICATION_JSON);
Response indexResponse = getRestClient().performRequest(
        "PUT",
        "/test/sample/1",
        Collections.<String, String>emptyMap(),
        entity);

        System.out.println("respone :::: from server ::::::::::::::"+indexResponse.getStatusLine().getStatusCode());
        
    }
    
    
     
    
}
