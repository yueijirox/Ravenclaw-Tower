public class Client implements CanPay{
    private String name;
    private MemberTypeWithDiscount membertype;
    


    public Client(String name){
        this.name = name;
        membertype=MemberTypeWithDiscount.NONE;    
    }


    private void promoteMemberType(){
        switch(membertype){
            case NONE:
                membertype=MemberTypeWithDiscount.SILVER;
                break;
            case SILVER:
                membertype=MemberTypeWithDiscount.GOLD;
                break;
            case GOLD:
                membertype=MemberTypeWithDiscount.PREMIUM;
                break;
            case PREMIUM:
                membertype=MemberTypeWithDiscount.PREMIUM;
                break;
        }
    }
    
    private void demoteMemberType(){
        switch(membertype){
            case NONE:
                membertype=MemberTypeWithDiscount.NONE;
                break;
            case SILVER:
                membertype=MemberTypeWithDiscount.SILVER;
                break;
            case GOLD:
                membertype=MemberTypeWithDiscount.SILVER;
                break;
            case PREMIUM:
                membertype=MemberTypeWithDiscount.GOLD;
                break;
        }
    }

    public void showMembershipStatus(){

        System.out.println("You are now "+membertype+" "+(int)membertype.getProductDiscount()+"% discount on product "+(int) membertype.getServiceDiscount()+"% on Service.");

    }

    @Override
    public void spend(int direction) {
        if(direction>0)
            promoteMemberType();
        else
            demoteMemberType();
        showMembershipStatus();
        
    }
}
