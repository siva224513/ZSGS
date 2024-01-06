package com.zsgs.siva224513.role_hierarchy.view;

import java.util.Scanner;

import com.zsgs.siva224513.role_hierarchy.dto.RoleNode;
import com.zsgs.siva224513.role_hierarchy.dto.Users;
import com.zsgs.siva224513.role_hierarchy.viewmodel.RoleHierarchyViewModel;

public class RoleHierarchyView {
    Scanner scanner = new Scanner(System.in);
    Users user = new Users();
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

            System.out.println(
                    "1. Add Sub Role\n2. Display Roles\n3. Delete Roles\n4. Add User\n5. Display Users\n6. Display Users and Sub Users\n0. Exit");
            System.out.println("enter your choice:");
            try {

                int value = scanner.nextInt();
                scanner.nextLine();
                switch (value) {
                    case 1:
                        System.out.println("operation to be performed:" + value);
                        System.out.println("Enter sub role name: ");
                        String subRoleName = scanner.nextLine();
                        System.out.println("Enter reporting to role name:");
                        String reportingRoleName = scanner.nextLine();
                        if (subRoleName.equalsIgnoreCase("COO") || subRoleName.equalsIgnoreCase("CTO"))
                            roleHierarchyViewModel.addSubRole(root, subRoleName);
                        else
                            roleHierarchyViewModel.addSubRole(subRoleName, root, reportingRoleName);
                        break;
                    case 2:
                        System.out.println("operation to be performed:" + value);
                        roleHierarchyViewModel.displayRoles(root);
                        break;
                    case 3:
                        System.out.println("operation to be performed:" + value);
                        System.out.println("Enter the role to be deleted: ");
                        String deletedRoleName = scanner.nextLine();
                        System.out.println("Enter the role to be transferred");
                        String transferredRoleName = scanner.nextLine();
                        roleHierarchyViewModel.deleteRole(root, deletedRoleName, transferredRoleName);

                        break;
                    case 4:
                        System.out.println("operation to be performed:" + value);
                        System.out.println("Enter User Name: ");
                        String userName = scanner.nextLine();
                        System.out.println("Enter Role: ");
                        if (user.userExists(userName)) {
                            System.out.println("User already exists");
                            break;
                        }
                        user.setUserName(userName);
                        String roleName = scanner.nextLine();
                        if (roleHierarchyViewModel.findNodeByName(root, roleName) != null) {
                            roleHierarchyViewModel.addUser(user, roleName);
                        } else {
                            System.out.println("Role Not found...");
                        }
                        break;
                    case 5:
                        System.out.println("operation to be performed:" + value);
                        roleHierarchyViewModel.displayUsers(user);
                        break;
                    case 6:
                        System.out.println("operation to be performed:" + value);
                        roleHierarchyViewModel.displayUsersAndSubUsers(root, user);
                        break;
                    case 9:
                        System.out.println("operation to be performed:" + value);
                        int height=roleHierarchyViewModel.heightOfTress(root);
                        System.out.println("Height - "+ height);
                        break;
                    case 0:
                        System.out.println("Exiting..");
                        exit = true;
                        System.exit(0);
                        break;
                    default:
                        System.out.println("invaid choice enter valid choice");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter the number");
                scanner.nextLine();
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

    public void addSubRoleOnSuccess() {
        System.out.println("Role Added successfully..");
    }

    public void onDisplayError() {
        System.out.println("No Roles Available !");
    }

    public void onDeleteSuccess() {
        System.out.println("Role deleted Successfully");
    }

    public void onDeleteError() {
        System.out.println("Role not found");
    }

    public void onAddUserSuccess() {
        System.out.println("User Addes Successfully");
    }

}
