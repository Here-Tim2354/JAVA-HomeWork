package Practice.Practice4.task2.manager;

import java.util.ArrayList;
import java.util.List;

public class ProductInventory {
    private List<Product> productList;

    public ProductInventory() {
        this.productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProduct(String id){
        for(Product productCheck:productList){
            if(productCheck.getId().equals(id)){
                return productCheck;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        this.productList.add(product);
    }

    public boolean removeProduct(Product product){
        if(product.getQuantity()==0){
            return this.productList.remove(product);
        }
        return false;
    }

    public int getTotalQuantity(){
        int sum=0;
        for(Product productCheck:productList){
            sum+=productCheck.getQuantity();
        }
        return sum;
    }

    public double getTotalAmount(){
        double sum=0;
        for(Product productCheck:productList){
            sum+=productCheck.getPrice()*productCheck.getQuantity();
        }
        return sum;
    }

    public void printQuantityAndAmount(){
        System.out.println("合计数量："+this.getTotalQuantity()+
                ", 合计金额："+this.getTotalAmount());
    }
}
