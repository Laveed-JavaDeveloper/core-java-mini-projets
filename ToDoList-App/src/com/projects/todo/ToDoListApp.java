package com.projects.todo;import java.util.*;
public class ToDoListApp {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        ArrayList<String> tasks =new ArrayList<String>();
        int choice;
        do{
            System.out.println("\n========To-Do List App========");
            System.out.println("1.View Task");
            System.out.println("2.Add Task");
            System.out.println("3.Edit Task");
            System.out.println("4.Delete Task");
            System.out.println("5.Exit");
            System.out.println("===============================");
            System.out.print("Choose an option between (1-5) :: ");
            choice=scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    if(tasks.isEmpty()){
                        System.out.println("No Tasks Added Yet!");
                        System.out.println("Add Task To View");
                    }else{
                        for(int i=0;i<tasks.size();i++){
                            System.out.println((i+0)+"."+tasks.get(i));
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Task :: ");
                    String task= scan.nextLine();
                    tasks.add(task);
                    System.out.println("Task Added");
                    break;

                case 3:
                    if(tasks.isEmpty()){
                        System.out.println("No Task to edit");
                    }else{
                        for(int i=0;i< tasks.size();i++){
                            System.out.println((i+1)+"."+ tasks.get(i));
                        }
                        System.out.print("Enter task number to edit :: ");
                        int index=scan.nextInt();
                        scan.nextLine();
                        if(index>0&&index<= tasks.size()){
                            tasks.remove(index-1);
                            System.out.print("Enter the edited task :: ");
                            String editedTask=scan.nextLine();
                            System.out.println("Edited Task :: "+editedTask);
                            tasks.add(editedTask);
                        } else{
                            System.out.println("Enter valid task number To Edit");
                        }
                    }
                    break;
                case 4:
                    if(tasks.isEmpty()){
                        System.out.println("No Task to delete");
                    }else{
                        for(int i=0;i<tasks.size();i++) {
                            System.out.println((i + 1) + "." + tasks.get(i));
                        }
                        System.out.print("Enter a task number to delete :: ");
                        int index;
                        index=scan.nextInt();
                        scan.nextLine();
                        if(index>0&&index<=tasks.size()){
                            String removedTask =tasks.remove(index-1);
                            System.out.println("Task Deleted :: "+removedTask);
                        }
                        else{
                            System.out.println("InValid Task Number");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Thank You for using To-Do List App");
                    System.out.println("==========Visit Again==========");
                    break;

                default:
                    System.out.println("InValid Number Entered");
                    System.out.println("Enter a number between (1-5)");
            }
        }while(choice!=5);
        scan.close();
    }
}
