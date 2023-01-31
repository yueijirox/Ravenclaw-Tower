package packA;

public class ProgrammerManager extends Programmer implements ManagerRoles {
    

    public ProgrammerManager(String n,int exp,int sal){
        super(n,exp,sal);
    }

    @Override
    public void sayHi(){
        System.out.println("Coding in [solidity, typescript]");
    }

    
    @Override
    public String coding(){
        return "HI CODING FROM PROGRAMMER MANAGER";
    }


    public int evaluate(Programmer p) {
        return p.salary*115/100;
    }

    @Override
    public String toString() {
        return "ManagerProgrammer [name="+name+", experience = "+experience+", salary = "+ salary+"]";
    }

    @Override
    public int evaluate() {
        return 0;
    }

}
