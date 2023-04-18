package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();

static{

    FileInputStream file = null;
    try {
        //2- We need to open the file in java memory: FileInputStream
        file = new FileInputStream("configuration.properties");
        //3- Load the properties object using FileInputStream object
        properties.load(file);
        file.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    }
    public static String getProperty(String keyword){
        return  properties.getProperty(keyword);

}


}
