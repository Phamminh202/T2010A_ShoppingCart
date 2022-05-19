package com.t2010a.t2010a_shoppingcart.entity;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

class ShoppingCartTest {
    ShoppingCartAction shoppingCartAction;
    @Test
    void add(int qty) throws IOException{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("products.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        for (String line; (line = reader.readLine())!= null; ){
            String[] sqlitedLine = line.split("\\|");
            if (sqlitedLine.length == 4){
                int id = Integer.parseInt(sqlitedLine[0].trim());
                String name = sqlitedLine[1].trim();
                double price = Double.parseDouble(sqlitedLine[2].trim());
                String thumbnail = sqlitedLine[3];
                Product product = new Product(id,name,price,thumbnail);
                shoppingCartAction.add(product,qty);
            }
        }

    }
}