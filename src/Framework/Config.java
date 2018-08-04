package Framework;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

public final class Config {
    private Config(){
    }

    private static Properties properties;
    public static void load() throws IOException{
        properties = new Properties();
        InputStream is = new FileInputStream(new File("config.properties"));
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        is,
                        StandardCharsets.UTF_8));
        try {
            properties.load(reader);
        }
        finally {
            is.close();
            reader.close();
        }
    }

    public static String get(String option){
        String value = properties.getProperty(option);
        if (value == null){
            return "";
        }
        return value;
    }

    public static void print(){
        for (Map.Entry<Object,Object> entry : properties.entrySet() ){
            System.out.println(String.format("%s=%s", entry.getKey(), entry.getValue()));
        }
    }



}
