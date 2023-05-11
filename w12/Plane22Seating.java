public class Plane22Seating extends PlaneSeating {
    public Plane22Seating(String args){
        super();
        String [] tokens = args.split(",");
        int numRow = tokens.length;
        int numCol = tokens[0].length();
        seating = new char[numRow][numCol];
        for(int i=0;i<tokens.length;i++){
            seating[i]=tokens[i].toCharArray();
            //System.out.println("Arrays" + Array)
        }
    }
    public void showSeating() { //Plane22Seating
        // System.out.println(flight);
        // seating.showSeating();
        
       }
       

    private boolean isFull(){
        return false;
    }
    @Override
    public boolean reserveSeat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reserveSeat'");
    }
    
}
