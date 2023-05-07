package br.edu.utfpr.td.tsi.projeto_delegacia.utils;

import org.apache.commons.lang3.StringUtils;

public class FilterUtils {

    private static String cleanString(String str) {
        str = str.toLowerCase().replaceAll("[^\\p{ASCII}]", "").trim();
        str = StringUtils.stripAccents(str);

        return str;
    }
    
    public static boolean compare(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        
        String cleanStr1 = cleanString(str1);        
        String cleanStr2 = cleanString(str2);
        
        return cleanStr1.equals(cleanStr2);
    }
}
