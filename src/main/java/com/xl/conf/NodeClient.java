/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xl.conf;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 *
 * @author anil
 */
public class NodeClient {
    
    static{
          Node node = nodeBuilder().clusterName("localhost").node();

           client = node.client();
    }
    public static Client client;
    public static Client getClient(){
         
            return client;
        
    }
    
    public static void close(){
        client.close();
    }
}
