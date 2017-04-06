/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xl.conf;


import java.io.IOException;
import java.util.Collections;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.elasticsearch.client.Response;

import org.elasticsearch.client.RestClient;


/**
 *
 * @author anil
 */
public class NodeClientConf {

//    public static Client getClient(){
//        Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "localtestsearch").build();
//
//	TransportClient transportClient = new TransportClient(settings);
//
//	transportClient = transportClient.addTransportAddress(new InetSocketTransportAddress("localhost", 9200));
//
//	return (Client) transportClient;
//        
//    }
    
   private static RestClient restClient;
static{
        
        
        restClient = RestClient.builder(new HttpHost("localhost", 9200)).build();
              
        
     
        
    }

public static RestClient getRestClient(){
    return restClient;
}
    public static void main(String ar[]) throws IOException{
        


//HttpEntity entity = new StringEntity(
        //ReadExcel.run(null), ContentType.APPLICATION_JSON);
//Response indexResponse = getRestClient().performRequest(
      //  "PUT",
       // "/test/t2/1",
        //Collections.<String, String>emptyMap(),
        //entity);

       // System.out.println("rspone"+indexResponse.getStatusLine().getStatusCode());
        
        
    }
    
}
