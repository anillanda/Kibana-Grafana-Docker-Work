/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xl.conf;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import static org.elasticsearch.index.query.QueryBuilders.fieldQuery;
import org.elasticsearch.node.Node;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;
import org.elasticsearch.search.SearchHit;

/**
 *
 * @author anil
 */
public class Operation {

    public static void add(Client client) {

       // IndexResponse response = client.prepareIndex("test", "data1", "1")
               // .setSource(ReadExcel.run(null)).execute().actionGet();

       // System.out.println("" + response.getId());
        //node.close();

    }

    public static String get(Client client) {

        Gson gson = new Gson();
        
        GetResponse getResponse = client.prepareGet("test", "data1", "1").execute().actionGet();

        Map<String, Object> source = getResponse.getSource();

        System.out.println("------------------------------");

        System.out.println("Index: " + getResponse.getIndex());

        System.out.println("Type: " + getResponse.getType());

        System.out.println("Id: " + getResponse.getId());

        System.out.println("Version: " + getResponse.getVersion());

        System.out.println(source);

        System.out.println("------------------------------");

       

        return gson.toJson(source);
    }
    
    public static void searchDocument(Client client, String index, String type,

                                      String field, String value){

        SearchResponse response = client.prepareSearch(index)

                                        .setTypes(type)

                                        .setSearchType(SearchType.QUERY_AND_FETCH)

                                        .setQuery(fieldQuery(field, value))

                                        .setFrom(0).setSize(60).setExplain(true)

                                        .execute()

                                        .actionGet();

        SearchHit[] results = response.getHits().getHits();

        System.out.println("Current results: " + results.length);

        for (SearchHit hit : results) {

            System.out.println("------------------------------");

            Map<String,Object> result = hit.getSource();   

            System.out.println(result);

        }

    }

}
