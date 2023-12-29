package com.zsgs.siva224513.utswallet.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.zsgs.siva224513.utswallet.dto.userDetails;

public class Repository {
    private Map<Integer,ArrayList<userDetails>> map =new HashMap<>();
    void getFile() {
        String str = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    "G:/ZSGS/Console Application/UTS_Wallet/src/com/zsgs/siva224513/utswallet/repository/destination.csv"));
            while ((str = reader.readLine()) != null) {
                String s[] = str.split(",");
                System.out.println(s[0] + " " + s[1]);
            }

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
