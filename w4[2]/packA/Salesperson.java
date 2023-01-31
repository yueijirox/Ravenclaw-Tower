package packA;

public class Salesperson extends Employee implements SalesRole {
    private int target;

    public Salesperson(String n,int exp,int Sal, int assignedTarget){
        target = assignedTarget;
    }
    public Salesperson(String n,int exp){
        target=0;
    }
    public void setTarget(int target){
        this.target=target;
    
    }
    public int getTarget(){
        return target;
    }

    public void setSalary(){
        salary=salary*110/100;
    }

    public void setSalary(int incresedAmount){
        salary=salary+incresedAmount;
    }   
    public String makeQuotation(){
        
        return "Dear value customer, "+ (int) (Math.random()*10000) +" is my best offer."   ;
    }
    public String toString() {
        return "Salesperson [target=" + target +" "+ super.toString()+" ]";
    }
    @Override
    public void sayHi() {
        
        System.out.println("Hi from Salesperson");
        
    }
    
}
