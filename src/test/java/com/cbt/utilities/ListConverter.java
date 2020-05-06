package com.cbt.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListConverter {
    public static List<String> convertElements(List<WebElement> list ){
        List<String> listStrings = new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            listStrings.add(list.get(i).getText());
        }
        return listStrings;
    }
}
