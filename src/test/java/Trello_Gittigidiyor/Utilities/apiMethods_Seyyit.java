package Trello_Gittigidiyor.Utilities;

import java.util.HashMap;
import java.util.Map;


public class apiMethods_Seyyit {

    //I create this method for using of DataTable, Body inputws as dynamic.
    public static Map<String,Object> boardMap(String name,String defaultList,String backgroundColor){
        Map<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("name",name);
        bodyMap.put("defaultLists",defaultList);
        bodyMap.put("prefs_background",backgroundColor);



        return bodyMap;
    }
    public static Map<String,Object> authorizationMap(){
        Map<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("token",ConfigurationReader.get("token"));
        bodyMap.put("key",ConfigurationReader.get("key"));


        return bodyMap;
    }

    public static Map<String,Object> listMap(String name,String idList){
        Map<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("idBoard",idList);
        bodyMap.put("name",name);




        return bodyMap;
    }

    public static Map<String,Object> cardsMap(String name,String idList){
        Map<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("idList",idList);
        bodyMap.put("name",name);




        return bodyMap;
    }

}
