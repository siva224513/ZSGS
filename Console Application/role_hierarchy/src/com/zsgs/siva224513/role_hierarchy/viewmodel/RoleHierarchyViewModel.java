package com.zsgs.siva224513.role_hierarchy.viewmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.zsgs.siva224513.role_hierarchy.dto.RoleNode;
import com.zsgs.siva224513.role_hierarchy.dto.Users;
import com.zsgs.siva224513.role_hierarchy.view.RoleHierarchyView;

public class RoleHierarchyViewModel {
    private RoleHierarchyView roleHierarchyView;

    public RoleHierarchyViewModel(RoleHierarchyView roleHierarchyView) {
        this.roleHierarchyView = roleHierarchyView;
    }

    public void addSubRole(RoleNode root, String subRoleName) {
        root.addToChild(newNode(subRoleName));
        this.roleHierarchyView.addSubRoleOnSuccess();
    }

    public void displayRoles(RoleNode root) {
        if (root == null) {
            this.roleHierarchyView.onDisplayError();
            return;
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

    public void addSubRole(String subRoleName, RoleNode root, String reportingRoleName) {
        RoleNode reportingRoleNode = findNodeByName(root, reportingRoleName);
        if (reportingRoleNode != null) {
            reportingRoleNode.addToChild(newNode(subRoleName));
            this.roleHierarchyView.addSubRoleOnSuccess();
        } else {
            root.addToChild(newNode(subRoleName));
            this.roleHierarchyView.addSubRoleOnSuccess();
        }

    }

    public void deleteRole(RoleNode root, String deletedRoleName, String transferredRoleName) {
        RoleNode deletedNode = findNodeByName(root, deletedRoleName);
        RoleNode transferredRoleNode = findNodeByName(root, transferredRoleName);
        if (deletedNode != null && transferredRoleNode != null) {
            transferChildRoles(deletedNode, transferredRoleNode);
            Queue<RoleNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                RoleNode current = queue.poll();
                if (current != null) {
                    for (RoleNode child : current.getRoleNodes()) {
                        if (child == deletedNode) {
                            current.getRoleNodes().remove(deletedNode);
                            this.roleHierarchyView.onDeleteSuccess();
                            return;
                        }
                        queue.offer(child);
                    }
                }
            }
            this.roleHierarchyView.onDeleteError();
        } else {
            this.roleHierarchyView.onDeleteError();
        }

    }

    private void transferChildRoles(RoleNode deletedNode, RoleNode transferredRoleNode) {
        for (RoleNode child : deletedNode.getRoleNodes()) {
            RoleNode newChild = new RoleNode();
            newChild.setData(child.getData());
            transferredRoleNode.addToChild(newChild);
            transferChildRoles(child, newChild);
        }
        deletedNode.getRoleNodes().clear();

    }

    public RoleNode findNodeByName(RoleNode root, String roleName) {
        if (root == null) {
            return null;
        }
        // if (root.getData().equalsIgnoreCase(roleName)) {
        // return root;
        // }
        // for (RoleNode child : root.getRoleNodes()) {
        // RoleNode foundNode = findNodeByName(child, roleName);
        // if (foundNode != null) {
        // return foundNode;
        // }
        // }
        Queue<RoleNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            RoleNode curr = queue.poll();
            if (curr != null && curr.getData().equalsIgnoreCase(roleName)) {
                return curr;
            }
            for (RoleNode child : curr.getRoleNodes()) {
                queue.offer(child);
            }
        }

        return null;
    }

    public void addUser(Users user, String roleName) {
        user.setUserRoleMap(user.getUserName(), roleName);
        this.roleHierarchyView.onAddUserSuccess();
    }

    public void displayUsers(Users user) {
        HashMap<String, ArrayList<String>> userRoleMap = user.getUserRoleMap();

        if (userRoleMap.isEmpty()) {
            System.out.println("No users found.");
        } else {

            for (Map.Entry<String, ArrayList<String>> entry : userRoleMap.entrySet()) {
                ArrayList<String> users = entry.getValue();
                for (String userName : users) {
                    System.out.println(userName + " - " + entry.getKey());
                }
            }
        }
    }

    public void displayUsersAndSubUsers(RoleNode root, Users user) {
        if (root == null) {
            this.roleHierarchyView.onDisplayError();
            return;
        }

        HashMap<String, ArrayList<String>> userRoleMap = user.getUserRoleMap();

    }

    public int heightOfTress(RoleNode root) {
        if (root == null) {
            this.roleHierarchyView.onDisplayError();
            return -1;
        }
        int height =0;
        Queue<RoleNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if(size==0){
                return height;
            }
            height++;
            while (size > 0) {
                RoleNode node = queue.peek();
                queue.remove();
                System.out.println(node.getData() + " ");
                for (int i = 0; i < node.getSize(); i++) {
                    queue.add(node.getRoleNodes().get(i));
                }
                size--;
            }

        }
        return height;
    }

}
