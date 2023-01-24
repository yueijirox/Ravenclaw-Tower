package packA;
public class EmpTmp{
    protected String name;
    protected int salary;
    protected int experience;
    

    public EmpTmp(String n,int exp , int sal){
        name = n;
        experience=exp;
        salary=sal;
    }
    public EmpTmp(String n){
        name = n;
    }
    public EmpTmp(){
        name = "NONE";
        salary = 0;
        experience = 0;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setSalary(int newSalary){
        salary=newSalary;
    }
    public int getSalary(){
        return (int) salary;
    }
    public void setExperience(int exp){
        experience=exp;
    }
    public int getExperience(){
        return experience;
    }
    public String toString() {
        return "EmpTmp [name=" + name + ", salary=" + salary + ", experience=" + experience + "]";
    }
    public void sayHi(){
        System.out.println("hi from "+name);
    }
}