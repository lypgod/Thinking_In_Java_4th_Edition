package com.lypgod.test.tij4.practices.Ch17_Containers.Practice2;

import com.lypgod.test.tij4.practices.Ch17_Containers.Countries;

import java.util.HashMap;
import java.util.Map;

public class Practice2 {
    public static void main(String[] args) {
        Map<String, String> countryMap = new HashMap<>();
        for (int i = 0; i < Countries.DATA.length; i++) {
            if (Countries.DATA[i][0].startsWith("A")) {
                countryMap.put(Countries.DATA[i][0], Countries.DATA[i][1]);
            }
        }

        System.out.println(countryMap);
        System.out.println(countryMap.keySet());
    }
}
