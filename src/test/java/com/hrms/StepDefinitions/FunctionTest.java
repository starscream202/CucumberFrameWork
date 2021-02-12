package com.hrms.StepDefinitions;

import com.hrms.Utils.ConfigReader;
import com.hrms.Utils.Constants;
import com.hrms.Utils.db_Utils;

import java.util.List;
import java.util.Map;

public class FunctionTest {
    public static void main(String[] args) {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        String query;
        List<Map<String,String>> list=db_Utils.getDBDataIntoList("select * from ohrm_nationality;");
        System.out.println(list);
        System.out.println(list.size());

    }
}
