package Practice.Practice4.task2.manager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class ProductManager {
    private ProductInventory inventory;
    
    // 定义一个静态内部类，用于按名称升序排序
    private static class ProductNameComparator implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }

    public ProductManager() {
        this.inventory = new ProductInventory();
        initializeSampleData();
    }

    private void initializeSampleData() {
        // 添加一些示例产品
        inventory.addProduct(new Product("P001", "笔记本电脑", 5999.99, 10, LocalDate.of(2023, 1, 15)));
        inventory.addProduct(new Product("P002", "智能手机", 2999.50, 25, LocalDate.of(2023, 3, 20)));
        inventory.addProduct(new Product("P003", "平板电脑", 1999.00, 15, LocalDate.of(2023, 2, 10)));
        inventory.addProduct(new Product("P004", "无线耳机", 399.99, 50, LocalDate.of(2023, 4, 5)));
        inventory.addProduct(new Product("P005", "智能手表", 1299.00, 30, LocalDate.of(2023, 5, 12)));
        inventory.addProduct(new Product("P006", "移动电源", 99.99, 100, LocalDate.of(2023, 1, 8)));
        inventory.addProduct(new Product("P007", "蓝牙音箱", 299.00, 40, LocalDate.of(2023, 6, 18)));
        inventory.addProduct(new Product("P008", "键盘鼠标套装", 199.50, 60, LocalDate.of(2023, 3, 25)));
    }

    public static int displayMenu() {
        System.out.println("产品管理系统，请输入数字来选择操作：");
        System.out.println("1. 查询产品");
        System.out.println("2. 产品入库");
        System.out.println("3. 产品出库");
        System.out.println("4. 产品删除");
        System.out.println("5. 产品列表");
        System.out.println("0. 退出");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public void findProduct(String productId) {
        Product checkProduct = this.inventory.getProduct(productId);
        if (checkProduct != null) {
            System.out.println(
                    "找到产品：ID=" + checkProduct.getId() +
                            ", 名称=" + checkProduct.getName() +
                            ", 价格=" + checkProduct.getPrice() +
                            ", 数量=" + checkProduct.getQuantity() +
                            ", 上市日期=" + checkProduct.getLaunchDate()
            );
        } else {
            System.out.println("产品：" + productId + " 不存在");
        }
    }

    public void entryProduct(String productId) {
        Product checkProduct = this.inventory.getProduct(productId);
        if (checkProduct != null) {
            System.out.println("该" + checkProduct.getId() + "产品存在，当前数量为" + checkProduct.getQuantity());
            System.out.println("输入你想要入库的数量：");
            Scanner sc=new Scanner(System.in);
            checkProduct.setQuantity(checkProduct.getQuantity() + sc.nextInt());
            System.out.println("入库成功，当前数量为：" + checkProduct.getQuantity());
        } else {
            System.out.println("产品：" + productId + " 不存在，开始新增产品信息。请输入按顺序输入：");
            System.out.println("产品名称：");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            System.out.println("产品价格：");
            double price = sc.nextDouble();
            System.out.println("产品数量：");
            int quantity = sc.nextInt();
            System.out.println("产品上架日期（格式：YYYY-MM-DD）：");
            String dateStr = sc.next();
            LocalDate launchDate = LocalDate.parse(dateStr);
            Product newProduct = new Product(productId, name, price, quantity, launchDate);
            this.inventory.addProduct(newProduct);
            System.out.println("新增产品成功，新产品为："+
                    "ID=" + newProduct.getId() +
                    ", 名称=" + newProduct.getName() +
                    ", 价格=" + newProduct.getPrice() +
                    ", 数量=" + newProduct.getQuantity() +
                    ", 上市日期=" + newProduct.getLaunchDate()
            );
        }
    }

    public void reduceProduct(String productId) {
        Product checkProduct = this.inventory.getProduct(productId);
        if (checkProduct != null) {
            System.out.println("该" + checkProduct.getId() + "产品存在，数量为" + checkProduct.getQuantity());
            System.out.println("请输入你要出库的数量：");
            Scanner sc = new Scanner(System.in);
            int reduceQuantity = sc.nextInt();
            if (reduceQuantity <= checkProduct.getQuantity()) {
                checkProduct.setQuantity(checkProduct.getQuantity() - reduceQuantity);
                System.out.println("出库成功，当前数量为：" + checkProduct.getQuantity());
            } else {
                System.out.println("出库失败，出库数量大于现有数量");
            }
        }else{
            System.out.println("产品：" + productId + " 不存在，出库失败！");
        }
    }

    public void removeProduct(String productId) {
        Product checkProduct = this.inventory.getProduct(productId);
        if (checkProduct != null) {
            if (this.inventory.removeProduct(checkProduct)) {
                System.out.println("产品：" + productId + " 删除成功");
            } else {
                System.out.println("产品：" + productId + " 删除失败，库存数量不为0");
            }
        } else {
            System.out.println("产品：" + productId + " 不存在");
        }
    }

    public void listProducts() {
        System.out.println("产品列表：");
        List<Product> productList = this.inventory.getProductList();
        productList.sort(Product.byID());
        for (Product product : productList) {
            System.out.println(
                    "ID=" + product.getId() +
                            ", 名称=" + product.getName() +
                            ", 价格=" + product.getPrice() +
                            ", 数量=" + product.getQuantity() +
                            ", 上市日期=" + product.getLaunchDate()
            );
        }
        this.inventory.printQuantityAndAmount();
        System.out.println("你可以选择：1.按名称升序/2.按价格升序/3.按库存数量降序/0.直接返回\n你的选择：");
        Scanner sc=new Scanner(System.in);

        while(true){
            try {
                int choice = sc.nextInt();
                switch(choice) {
                    case 0:
                        return; // 直接返回
                    case 1:
                        // 按名称升序排序功能
                        System.out.println("产品列表（按名称升序）：");
                        List<Product> sortedByName = this.inventory.getProductList();
                        // 使用命名的内部类进行排序
                        sortedByName.sort(new ProductNameComparator());
                        for (Product product : sortedByName) {
                            System.out.println(
                                    "ID=" + product.getId() +
                                            ", 名称=" + product.getName() +
                                            ", 价格=" + product.getPrice() +
                                            ", 数量=" + product.getQuantity() +
                                            ", 上市日期=" + product.getLaunchDate()
                            );
                        }
                        this.inventory.printQuantityAndAmount();
                        break;
                    case 2:
                        // 按价格升序排序功能
                        System.out.println("产品列表（按价格升序）：");
                        List<Product> sortedByPrice = this.inventory.getProductList();
                        sortedByPrice.sort(new Comparator<Product>() {;
                            @Override
                            public int compare(Product p1, Product p2) {
                                return Double.compare(p1.getPrice(), p2.getPrice());
                            }
                        });
                        for(Product product:sortedByPrice){
                            System.out.println(
                                    "ID=" + product.getId() +
                                            ", 名称=" + product.getName() +
                                            ", 价格=" + product.getPrice() +
                                            ", 数量=" + product.getQuantity() +
                                            ", 上市日期=" + product.getLaunchDate()
                            );
                        }
                        this.inventory.printQuantityAndAmount();
                        break;
                    case 3:
                        // 按库存数量降序排序功能
                        System.out.println("产品列表（按库存数量降序）：");
                        List<Product> sortedByQuantity = this.inventory.getProductList();
                        // 使用Lambda表达式进行排序，按库存数量降序
                        sortedByQuantity.sort((p1, p2) -> Integer.compare(p2.getQuantity(), p1.getQuantity()));
                        for(Product product : sortedByQuantity) {
                            System.out.println(
                                    "ID=" + product.getId() +
                                            ", 名称=" + product.getName() +
                                            ", 价格=" + product.getPrice() +
                                            ", 数量=" + product.getQuantity() +
                                            ", 上市日期=" + product.getLaunchDate()
                            );
                        }
                        this.inventory.printQuantityAndAmount();
                        break;
                    default:
                        System.out.println("无效选择，请输入0-3之间的数字");
                        break;
                }
                // 如果不是选择0，则继续循环
                System.out.println("你可以选择：1.按名称升序/2.按价格升序/3.按库存数量降序/0.直接返回\n你的选择：");

            } catch(Exception e) {
                System.out.println("输入错误，请输入整数！");
                sc.nextLine(); // 清除错误的输入
                System.out.println("你可以选择：1.按名称升序/2.按价格升序/3.按库存数量降序/0.直接返回\n你的选择：");
            }
        }
    }

    public void start(){
        Scanner sc=new Scanner(System.in);
        while(true){
            int choice=ProductManager.displayMenu();
            try{
                switch(choice){
                    case 0:
                        System.out.println("退出系统，感谢使用！");
                        return;
                    case 1:
                        System.out.println("输入你想要查询的产品ID");
                        findProduct(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("输入你想要入库的产品ID");
                        entryProduct(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("输入你想要出库的产品ID");
                        reduceProduct(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("输入你想要删除的产品ID");
                        removeProduct(sc.nextLine());
                        break;
                    case 5:
                        listProducts();
                        break;
                    default:
                        System.out.println("无效选择，请输入0-5之间的数字");
                        break;
                }
            }catch (Exception e){
                System.out.println("操作失败，请检查输入格式是否正确！");
            }
        }
    }
}