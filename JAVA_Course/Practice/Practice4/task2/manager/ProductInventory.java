package Practice.Practice4.task2.manager;

import java.util.ArrayList;
import java.util.List;

public class ProductInventory {
    private List<Product> productList;

    public ProductInventory() {
        this.productList = new ArrayList<>();
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

    public double getTotalAmount(){
        double sum=0;
        for(Product productCheck:productList){
            sum+=productCheck.getPrice()*productCheck.getQuantity();
        }
        return sum;
    }
}
