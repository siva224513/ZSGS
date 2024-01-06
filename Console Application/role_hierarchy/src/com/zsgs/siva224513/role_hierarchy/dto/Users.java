package com.zsgs.siva224513.role_hierarchy.dto;

import java.util.ArrayList;
import java.util.HashMap;


public class Users {
   private String userName;
   private  HashMap<String,ArrayList<String>> userRoleMap = new HashMap<>();
   public String getUserName() {
      return userName;
   }
   public void setUserName(String userName) {
      this.userName = userName;
   }
   public HashMap<String, ArrayList<String>> getUserRoleMap() {
      return userRoleMap;
   }

   public void setUserRoleMap(String userName,String role) {
     ArrayList<String> users = userRoleMap.get(role);
     if(users==null){
         users = new ArrayList<>();
         userRoleMap.put(role,users);
     }
     users.add(userName);
   }
   public boolean userExists(String userName){
       return userRoleMap.containsKey(userName);
   }
   
}
