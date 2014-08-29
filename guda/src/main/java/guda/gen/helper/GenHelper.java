package guda.gen.helper;

import guda.tool.common.StringTool;

/**
 * Created by foodoon on 2014/7/29.
 */
public class GenHelper {

    public static String getDomainName(String tableName,String appName){
        if(tableName == null || appName == null){
            return null;
        }
        tableName = tableName.toLowerCase();
        appName = appName.toLowerCase();
        if(tableName.startsWith(appName+"_")){
            tableName = tableName.substring(appName.length()+1);
        }
        return StringTool.uppercaseFirstLetter(StringTool.underLineStringToCamel(tableName))+"DO";
    }

    public static String getDomainNameWithoutDO(String tableName,String appName){
        if(tableName == null || appName == null){
            return null;
        }
        tableName = tableName.toLowerCase();
        appName = appName.toLowerCase();
        if(tableName.startsWith(appName+"_")){
            tableName = tableName.substring(appName.length()+1);
        }
        return StringTool.uppercaseFirstLetter(StringTool.underLineStringToCamel(tableName));
    }

}
