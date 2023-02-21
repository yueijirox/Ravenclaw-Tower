public class Customer implements CanPay {
    private String name;
    private MemberType memberType;
    
    public Customer(String name){
        this.name = name;
        memberType=MemberType.NONE;    
    }
    private void promoteMemberType(){
        switch(memberType){
            case NONE:
                memberType=MemberType.SILVER;
                break;
            case SILVER:
                memberType=MemberType.GOLD;
                break;
            case GOLD:
                memberType=MemberType.PREMIUM;
                break;
            case PREMIUM:
                memberType=MemberType.PREMIUM;
                break;
        }
        
    }

    private void demoteMemberType(){
        switch(memberType){
            case NONE:
                memberType=MemberType.NONE;
                break;
            case SILVER:
                memberType=MemberType.SILVER;
                break;
            case GOLD:
                memberType=MemberType.SILVER;
                break;
            case PREMIUM:
                memberType=MemberType.GOLD;
                break;
        }
    }

    public void showMembershipStatus(){

        System.out.println("You are now "+memberType);
    }

    @Override
    public void spend(int direction) {
        if(direction > 0){
            promoteMemberType();
        }
        else{
            demoteMemberType();
        }
        showMembershipStatus();
    }
}
