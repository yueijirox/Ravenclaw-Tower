package pack7a;

import java.util.ArrayList;
import java.util.Map;



public class Shop {
    private String name;
    private Catalog catalog = new Catalog();
    private ArrayList<Basket> ordersToday = new ArrayList<>();

    public Shop(String n) {
        name = n;
        catalog.add(new Drink("mix veggies", "refreshing"), 22);
        catalog.add(new Drink("lactasoy", "less hungry"), 15);
        catalog.add(new Noodles("mama", "classic"), 9);
        catalog.add(new Noodles("korean", "i can afford"), 33);
        // duplicate won't update
        catalog.add(new Noodles("mama", "duplicate"), 11);
        System.out.println("DADADA");
        showCatalog();
    }

    private void showCatalog() {
        System.out.println("Welcome to "+name);
        catalog.showCatalog();
    }

    public Basket newCustomerArrives() {
        return new Basket();
    }

    public LineItem generateLineItem(String pName, int q) { // add to UML
        int price = catalog.getPrice(pName);
        Product product = catalog.getProduct(pName);
        return new LineItem(product, q, price);
    }

    public LineItem generateBuyNowItem(String pName) {
        int price = catalog.getPrice(pName);
        Product product = catalog.getProduct(pName);
        return new LineItem(product, 1, price);
    }

    public void getPayment(Basket b) {
        System.out.println("I am cashier");
        b.printInvoice();
        
    }

    public void dailySalesReport() {
        System.out.println("");
        System.out.println("*************DAILY SALES REPORT*************");
        System.out.println("");
        for(Basket B:ordersToday){
            B.printInvoice();
        }
        System.out.println("Grand total is "+Basket.Grandtotal);
    }

}
