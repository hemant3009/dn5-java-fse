


class Product {
    int id;
    String name;

    Product(int id, String name){
        this.id = id;
        this.name = name;
    }
}

public class ECommercePlatformSearch {
    // Linear Search
    public static Product linearSearch(Product[] products, int targetId){
        for(Product product : products){
            if(product.id == targetId){
                return product;
            }
        }
        return null;
    }   

    // Binary Search
    public static Product binarySearch(Product[] products, int targetId){
        int low = 0;
        int high = products.length -1;

        while(low <= high){
            int mid = (low+high)/2;

            if(products[mid].id == targetId){
                return products[mid];
            }else if(products[mid].id < targetId){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop"),
            new Product(102, "Mobile"),
            new Product(103, "Headphones"),
            new Product(104, "Keyboard"),
            new Product(105, "Mouse")
        };

        int targetId = 104;

        System.err.println("-----Linear Search------");
        Product linearResult = linearSearch(products, targetId);

        if(linearResult != null){
            System.out.println("Product Found:");
            System.out.println("ID : " + linearResult.id);
            System.out.println("Name : " + linearResult.name);
        }else{
            System.err.println("Product Not Found");
        }

        System.err.println();

        System.out.println("----- Binary Search -----");
        Product binaryResult = binarySearch(products, targetId);

        if (binaryResult != null) {
            System.out.println("Product Found:");
            System.out.println("ID : " + binaryResult.id);
            System.out.println("Name : " + binaryResult.name);
        } else {
            System.out.println("Product Not Found");
        }

        System.out.println();

        System.out.println("Time Complexity Comparison");
        System.out.println("Linear Search : Best O(1), Average O(n), Worst O(n)");
        System.out.println("Binary Search : Best O(1), Average O(log n), Worst O(log n)");
    }
}
