package com.zsgs.siva224513.role_hierarchy.viewmodel;

import java.util.LinkedList;
import java.util.Queue;

import com.zsgs.siva224513.role_hierarchy.dto.RoleNode;
import com.zsgs.siva224513.role_hierarchy.view.RoleHierarchyView;

public class RoleHierarchyViewModel {
    private RoleHierarchyView roleHierarchyView;

    public RoleHierarchyViewModel(RoleHierarchyView roleHierarchyView) {
        this.roleHierarchyView = roleHierarchyView;
    }

    public void addSubRole(RoleNode root, String subRoleName) {
        root.addToChild(newNode(subRoleName));
        this.roleHierarchyView.addSubRoleOnSuccess(root);
    }

    public void displayRoles(RoleNode root) {
        if (root == null) {
            System.out.println("No roles");
        }
        Queue<RoleNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            RoleNode node = queue.peek();
            queue.remove();
            System.out.println(node.getData() + " ");
            for (int i = 0; i < node.getSize(); i++) {
                queue.add(node.getRoleNodes().get(i));
            }
            size--;
        }
    }

    public RoleNode newNode(String data) {
        RoleNode roleNode = new RoleNode();
        roleNode.setData(data);
        return roleNode;
    }

    public void addSubRole(String subRoleName,RoleNode root) {
       if(subRoleName.equalsIgnoreCase("Director of Technology")){
           if(root.getRoleNodes().get(1).getData().equalsIgnoreCase("CTO")){
               ((root.getRoleNodes().get(1))).addToChild(newNode(subRoleName));
               this.roleHierarchyView.addSubRoleOnSuccess(root.getRoleNodes().get(1));
           }
           else{
               root.addToChild(newNode(subRoleName));
               this.roleHierarchyView.addSubRoleOnSuccess(root);
           }
       }
       else{
            if(root.getRoleNodes().get(0).getData().equalsIgnoreCase("COO")){
               ((root.getRoleNodes().get(0))).addToChild(newNode(subRoleName));
               this.roleHierarchyView.addSubRoleOnSuccess(root.getRoleNodes().get(0));
           }
           else{
               root.addToChild(newNode(subRoleName));
               this.roleHierarchyView.addSubRoleOnSuccess(root);
           }
       }
    }

}
