package reflection2;

public abstract class Gear {
    protected String type;
    protected int count;

    abstract void nextGear();

    abstract void prevGear();

    abstract void goBack();

    abstract void setParking();

    abstract void setNeutral();

    public String getType() {
        return type;
    }

    public Gear() {
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Gear{" +
                "type='" + type + '\'' +
                ", count=" + count +
                '}';
    }
}
