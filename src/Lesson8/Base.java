package Lesson8;

class Base {
    int baseValue;

    public Base(int baseValue) {
        this.baseValue = baseValue;
    }

    @Override
    protected Base clone() throws CloneNotSupportedException {
        return new Base(this.baseValue);
    }

    @Override
    public String toString() {
        return "base: " + this.hashCode() + ":value =" + this.baseValue;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Base)) return false;
        if(obj.hashCode() == this.hashCode()) return true;
        return this.baseValue == ((Base)obj).baseValue;
    }
}
