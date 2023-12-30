package com.zsgs.siva224513.role_hierarchy.view;

import java.util.Scanner;

import com.zsgs.siva224513.role_hierarchy.dto.RoleNode;
import com.zsgs.siva224513.role_hierarchy.viewmodel.RoleHierarchyViewModel;

public class RoleHierarchyView {
    Scanner scanner = new Scanner(System.in);
    private RoleHierarchyViewModel roleHierarchyViewModel;

    public RoleHierarchyView() {
        roleHierarchyViewModel = new RoleHierarchyViewModel(this);
    }

    public void startWithroot() {
        System.out.println("Enter root role name in Captial letters:");
        String rootRoleName = scanner.next();
        RoleNode root = roleHierarchyViewModel.newNode(rootRoleName);
        System.out.println(root.getData());
        start(root);
    }

    public void start(RoleNode root) {
        boolean exit = false;
        while (!exit) {
            System.out.println("enter your choice:");
            System.out.println("1. Add Sub Role\n2. Display Roles\n3.Delete Roles\n0.Exit");
            try {

                int value = scanner.nextInt();
                scanner.nextLine();
                switch (value) {
                    case 1:
                        System.out.println("operation to be performed:" + value);
                        System.out.println("Enter sub role name: ");
                        String subRoleName = scanner.nextLine();
                        if (subRoleName.equalsIgnoreCase("COO") || subRoleName.equalsIgnoreCase("CTO"))
                            roleHierarchyViewModel.addSubRole(root, subRoleName);
                        else
                           roleHierarchyViewModel.addSubRole(subRoleName,root);
                        break;
                    case 2:
                        System.out.println("operation to be performed:" + value);
                        roleHierarchyViewModel.displayRoles(root);
                        break;
                    case 0:
                        System.out.println("Exiting..");
                        exit = true;
                        // System.exit(0);
                        break;
                    default:
                        System.out.println("invaid choice enter valid choice");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter the number");
                scanner.next();
            }
        }
        // printSubrole();

    }

    // private void printSubrole() {
    // ArrayList<RoleNode> list = RoleNode.getRoleNodes();
    // for(RoleNode r:list){
    // System.out.println(r.getData());
    // }

    // }

    public void addSubRoleOnSuccess(RoleNode root) {
        System.out.println("Enter reporting to role name :" + root.getData());
    }

}
