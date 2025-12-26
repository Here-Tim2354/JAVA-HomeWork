package Practice.Practice7.task1;

import java.util.Scanner;

public class Main {
    public static void uiStart(AddressBookManager manager){
        while(true){
            System.out.println("---地址簿管理系统功能选项---");
            System.out.println("1.地址列表");
            System.out.println("2.查找地址");
            System.out.println("3.增加地址");
            System.out.println("4.删除地址");
            System.out.println("5.修改地址");
            System.out.println("6.文件地址");
            System.out.println("0.退出系统");
            System.out.println("-------------------------");

            Scanner sc = new Scanner(System.in);
            System.out.print("请输入功能选项对应的数字：");

            try{
                int choice=Integer.parseInt(sc.nextLine().trim());
                if(choice<0||choice>6){
                    System.out.print("输入选项错误，请重新输入：");
                    continue;
                }else{
                    System.out.println();
                    switch(choice){
                        case 1 -> manager.printAddressBook();
                        case 2 -> {
                            System.out.print("请输入要查找的姓名：");
                            String name=sc.nextLine().trim();
                            manager.checkNameAndPrint(name);
                        }
                        case 3 -> manager.addEntry();
                        case 4 -> {
                            System.out.print("请输入要删除的姓名：");
                            String name=sc.nextLine().trim();
                            manager.deleteAddressByName(name);
                        }
                        case 5 -> {
                            System.out.print("请先输入姓名，根据姓名查找对应地址：");
                            String name=sc.nextLine().trim();
                            manager.alterAddressByName(name);
                        }
                        case 6 -> manager.printAbsolutePath();
                        case 0 -> {
                            System.out.println("已退出地址簿管理系统。");
                            return;
                        }
                    }
                }
            }catch(NumberFormatException e){
                System.out.print("输入不合法，请重新输入：");
            }
        }

    }

    public static void main(String[] args){
        AddressBookManager manager = new AddressBookManager();
        uiStart(manager);
    }
}
