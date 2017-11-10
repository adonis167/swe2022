package Lesson8;

public class Owner {
    private final int ownerValue;
    private final Base ownerBase;

    Owner(int ownerValue, Base ownerBase) {
        this.ownerValue = ownerValue;
        this.ownerBase = ownerBase;
    }

    @Override
    protected Owner clone() throws CloneNotSupportedException {
        Owner result = new Owner(this.ownerValue, this.ownerBase);
        result = new Owner(this.ownerValue, this.ownerBase.clone());
        return result;
    }

    public Base getBase() {
        return ownerBase;
    }
}
