package com.t2010a.t2010a_shoppingcart.entity;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

class ShoppingCartTest {
    ShoppingCartAction shoppingCartAction;
    @Test
    void add() throws IOException{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("order-details.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        for (String line; (line = reader.readLine())!= null; ){
            String[] sqlitedLine = line.split("\\|");
            if (sqlitedLine.length == 4){
                String id = sqlitedLine[0].trim();
                String name = sqlitedLine[1].trim();
                int qty = Integer.parseInt(sqlitedLine[2].trim());
                double price = Double.parseDouble(sqlitedLine[3].trim());
                Product product = new Product(id,name,price);
                shoppingCartAction.add(product,qty);
            }
        }
    }
}