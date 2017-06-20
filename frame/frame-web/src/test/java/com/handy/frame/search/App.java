package com.dw;

import java.net.InetAddress;
import java.util.*;

import com.handy.frame.util.FastJsonUtil;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

/**
 * Elastic Search Demo App
 *
 * @author Matt Tyson
 */
public class App {
    protected static ObjectMapper mapper = JsonFactory.create();

    public static void main(String[] args) throws Exception {
        Client client = TransportClient
                .builder()
                .build()
                .addTransportAddress(
                        new InetSocketTransportAddress(InetAddress
                                .getByName("192.168.157.128"), 9300));

        GetResponse response = client.prepareGet("music", "lyrics", "2")
                .execute().actionGet();
        Map<String, Object> rpMap = response.getSource();

       System.out.println(FastJsonUtil.toJsonString(rpMap));
    }

}
