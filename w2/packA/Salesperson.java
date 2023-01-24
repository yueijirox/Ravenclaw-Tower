package packA;

public class Salesperson extends Programmer {
    private int target;

    public Salesperson(String n,int Sal,int exp, int assignedTarget){
        super(n,exp,Sal);
        target = assignedTarget;
    }
    public Salesperson(String n,int exp){
        super(n,exp,0);
        target=0;
    }
    public void setTarget(int target){
        this.target=target;
    
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
    
}
