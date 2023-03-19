package pack7a;

import java.util.ArrayList;

public class Basket {
    private ArrayList<LineItem> items = new ArrayList<>();
    static int Grandtotal;
    public void showItemsInBasket() {
        
        System.out.println("This basket contain");
        for(LineItem a : items){
            System.out.println(a);
        }
    }

    public void putInBasket(LineItem item) {
        Grandtotal+=item.calculateAmount();
        items.add(item);
    }

    public void printInvoice() {
        System.out.println("invoice header");
        int sum = 0;
        for (LineItem line : items) {
            System.out
                    .println(line.getProduct().getpName() + " x " + line.getQuantity() + " " + line.calculateAmount());
            sum += line.calculateAmount();
            
        }
        System.out.println("Total is " + sum + "******");
        System.out.println("=========================================");
        

    }

    public void buyNow(LineItem item) {
        putInBasket(item);
        printInvoice();
        
    }
}
