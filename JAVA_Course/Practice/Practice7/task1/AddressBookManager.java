package Practice.Practice7.task1;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookManager {
    private final Path addressBookPath;
    private List<InfoLine> addressBook;

    public AddressBookManager() {
        this.addressBook = new ArrayList<>();
        this.addressBookPath = Paths.get("address_book.dat");
        readAddressBook();
    }

    @SuppressWarnings("unchecked")
    public void readAddressBook() {
        File file = addressBookPath.toFile();
        if (!file.exists() || file.length() == 0) {
            this.addressBook = new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            this.addressBook = (List<InfoLine>) ois.readObject();
            System.out.println("数据已读取");
        } catch (Exception e) {
            errPrinter(e);
            System.err.println("文件已重置为空");
            this.addressBook = new ArrayList<>();
        }
    }

    public void outputAddressBookFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(addressBookPath.toFile())))) {
            oos.writeObject(this.addressBook);
            System.out.println("数据已输出到到文件" + addressBookPath.toAbsolutePath());
        } catch (Exception e) {
            errPrinter(e);
        }
    }

    private void errPrinter(Exception e) {
        System.err.println("读写文件发生错误：");
        System.err.println("错误类型：" + e.getClass());
        System.err.println("错误信息：" + e.getMessage());
    }

    public void printAddressBook() {
        /*
        打印地址簿内容
         */
        int count = 0;
        for (InfoLine info : addressBook) {
            System.out.println("记录 " + (++count) + ": " + info);
        }
    }

    public void addEntry(String name, String province, String city, String postalCode, String address) {
        /*
        向地址簿添加一条记录
         */
        InfoLine infoLine = new InfoLine(name, province, city, postalCode, address);
        addressBook.add(infoLine);
        outputAddressBookFile();
    }

    public void checkNameAndPrint(String name) {
        List<InfoLine> results = addressBook.stream()
                .filter(infoLine -> infoLine.name().equals(name))
                .toList();

        if (results.isEmpty()) {
            System.out.println("未找到姓名为：" + name + " 的记录");
        } else {
            System.out.println("满足的信息有：");
            results.forEach(System.out::println);
        }
    }

    public void deleteAddressByName(String name) {
        List<InfoLine> results = addressBook.stream()
                .filter(infoLine -> infoLine.name().equals(name))
                .toList();
        if (results.isEmpty()) {
            System.out.println("未找到姓名为：" + name + " 的记录，故无法删除。操作取消。");
            return;
        } else {
            int index = 0;
            System.out.println("查询到对应名字：" + name + " 的地址如下：");
            for (InfoLine info : results) {
                System.out.println((index++) + " " + info);
            }
            System.out.println("根据给出的需要，请选择你要删除的地址，可输入多个数以批量删除，直接换行可取消：");
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("你没有输入任何序号，操作取消。");
                    return;
                }
                String[] selections = input.trim().split("\\D+");

                List<InfoLine> toDelete = new ArrayList<>();
                for (String selection : selections) {
                    if(selection.isEmpty()) continue;
                    int choice = Integer.parseInt(selection);
                    if (choice >= 0 && choice < results.size()) {
                        toDelete.add(results.get(choice));
                    }
                }

                addressBook.removeAll(toDelete);
                System.out.println("删除成功，共删除" + toDelete.size() + "条记录。");
                outputAddressBookFile();
            }
        }
    }

    public void alterAddressByName(String name) {
        List<InfoLine> results = addressBook.stream()
                .filter(infoLine -> infoLine.name().equals(name))
                .toList();

        if (results.isEmpty()) {
            System.out.println("并没有查询到对应姓名的地址。操作取消。");
            return;
        } else {
            int index = 0;
            System.out.println("查询到对应名字：" + name + " 的地址如下：");
            for (InfoLine info : results) {
                System.out.println((index++) + " " + info);
            }
            System.out.println("根据给出的需要，请选择你要修改的地址，直接换行可取消：");
            Scanner scanner = new Scanner(System.in);
            String choiceInput=scanner.nextLine().trim();

            if(choiceInput.isEmpty()){
                System.out.println("你没有输入任何序号，操作取消。");
                return;
            }

            try{
                int choice=Integer.parseInt(choiceInput);
                if(choice<0||choice>=results.size()){
                    System.out.println("序号输入错误，操作取消");
                    return;
                }
                InfoLine target=results.get(choice);

                System.out.println("当前修改对象："+ target);
                System.out.println("输入你要修改的数据，直接回车表示不修改该项：");

                System.out.print("姓名 [" + target.name() + "]: ");
                String newName = scanner.nextLine();
                if (newName.isEmpty()) newName = target.name();

                System.out.print("省份 [" + target.province() + "]: ");
                String newProvince=scanner.nextLine();
                if(newProvince.isEmpty()) newProvince = target.province();

                System.out.print("城市 ["+target.city()+"]: ");
                String newCity=scanner.nextLine();
                if(newCity.isEmpty()) newCity = target.city();

                System.out.print("邮政编码 ["+target.postalCode()+"]: ");
                String newPostalCode=scanner.nextLine();
                if(newPostalCode.isEmpty()) newPostalCode = target.postalCode();

                System.out.print("详细地址 ["+target.address()+"]: ");
                String newAddress=scanner.nextLine();
                if(newAddress.isEmpty()) newAddress = target.address();

                InfoLine updatedInfo=new InfoLine(newName,newProvince,newCity,newPostalCode,newAddress);
                addressBook.remove(target);
                addressBook.add(updatedInfo);
                System.out.println("修改成功，当前记录为："+updatedInfo);
                outputAddressBookFile();
            }catch (Exception e){
                errPrinter(e);
            }

        }
    }

    private record InfoLine(
            String name,
            String province,
            String city,
            String postalCode,
            String address
    ) implements Serializable {
        @Override
        public String toString() {
            return String.format("姓名：%s，省份：%s，城市：%s，邮编：%s，地址：%s",
                    name, province, city, postalCode, address);
        }
    }
}

