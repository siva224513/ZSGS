package com.siva224513;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Home {

  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
      IllegalAccessException, InvocationTargetException {

    String path = "src/com/siva224513";
    
    String packageName = "com.siva224513";
    Scanner scan = new Scanner(System.in);
    Stack<String> pathStack = new Stack<>();
    boolean exit = false;

    while (!exit) {
      String list[] = getFolders(path);
      printFile(list);

      System.out.println("Enter your choice (0 to exit, -1 to go back): ");
      int choice = scan.nextInt();

      if (choice == 0) {
        exit = true;
        System.out.println("Exiting....");
      } else if (choice == -1) {
        if (!pathStack.isEmpty()) {
          path = pathStack.pop();
          packageName = packageName.substring(0, packageName.lastIndexOf('.'));
        } else {
          System.out.println("You are at the root.");
        }
      } else if (choice > 0 && choice <= list.length) {
        String selectedName = list[choice - 1];
        packageName = packageName + "." + selectedName;
        String selectedPath = path + "/" + selectedName;

        if (isDirectory(selectedPath)) {
          pathStack.push(path);
          path = selectedPath;
        } else {
          executeJavaClass(packageName);
        }
      } else {
        System.out.println("Invalid Choice!!!");
      }
    }
  }

  public static String[] getFolders(String p) {
    File path = new File(p);
    
    String list[] = path.list();
    return list;
  }

  public static void printFile(String[] list) {
    System.out.println("-----Menu Options-----:");

    for (int i = 0; i < list.length; i++) {

      System.out.println((i + 1) + ". " + list[i]);
    }
  }

  public static boolean isDirectory(String path) {
    File file = new File(path);
    return file.isDirectory();
  }

  public static void executeJavaClass(String path)
      throws ClassNotFoundException, NoSuchMethodException, SecurityException,
      IllegalAccessException, InvocationTargetException {
    Class<?> cls = Class.forName(path.substring(0, path.length() - 5));
    Method method = cls.getDeclaredMethod("main", String[].class);
    String[] str = new String[1];
    str[0] = "null";
    method.invoke(null, (Object) str);
    System.out.println(" ");
  }
}
