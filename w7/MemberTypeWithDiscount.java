enum MemberTypeWithDiscount {
    NONE(0,0), SILVER(0.5,0.5),
    GOLD(1.0,2.0), PREMIUM(3.0,4.5);
    private double productDiscountRate;
    private double serviceDiscountRate;

     MemberTypeWithDiscount(double productDiscountRate , double serviceDiscountRate){
        this.productDiscountRate=productDiscountRate;
        this.serviceDiscountRate=serviceDiscountRate;
    }

    public double getProductDiscount(){
        double superman=productDiscountRate*10;
        return superman;
    }
    
    public double getServiceDiscount(){
        double spiderman=serviceDiscountRate*10;
        return spiderman;
    }
}
