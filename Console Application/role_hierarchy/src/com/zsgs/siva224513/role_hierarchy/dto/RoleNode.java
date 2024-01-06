package com.zsgs.siva224513.role_hierarchy.dto;

import java.util.ArrayList;

public class RoleNode {
    private String data;
    private ArrayList<RoleNode> child = new ArrayList<>();

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void addToChild(RoleNode subRole) {
        child.add(subRole);
    }

    public ArrayList<RoleNode> getRoleNodes() {
        return child;
    }

    public int getSize() {
        return child.size();
    }
}
