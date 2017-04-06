package com.xl.main;

import com.xl.conf.NodeClient;
import com.xl.conf.NodeClientConf;
import com.xl.conf.Operation;
import com.xl.service.OperationService;
import java.io.IOException;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.node.Node;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        
        String fileName=null;
        if(args.length>0){
        	fileName=args[0];
        }
       
        RestClient client = NodeClientConf.getRestClient();
               
        OperationService.addSampleSink(client,fileName);
       
    }
}
