package BrandWatch.Utilities;

import java.util.HashMap;
import java.util.Map;


public class apiBrandwatchMethods {

    //I create this method for using of DataTable, Body inputws as dynamic.
    public static Map<String,Object> bodyMap(String name,String email,String gender,String status){
        Map<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("name",name);
        bodyMap.put("email",email);
        bodyMap.put("gender",gender);
        bodyMap.put("status",status);

        return bodyMap;
    }
    public static Map<String,Object> bodyMap(String name,String email,String status){
        Map<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("name",name);
        bodyMap.put("email",email);
        bodyMap.put("status",status);

        return bodyMap;
    }

}
