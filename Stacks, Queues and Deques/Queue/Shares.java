// => Helper class to create Share Object
public class Shares {
    public int amount;
    public int valueEach;
    public boolean buy;

    public Shares(int amount, int valueEach, boolean buy) {
        this.amount = amount;
        this.valueEach = valueEach;
        this.buy = buy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Amount: ");
        sb.append(amount);
        sb.append("   Value: ");
        sb.append(valueEach);
        sb.append("   Mode: ");
        if (buy) {
        sb.append("Buy");
        } else {
            sb.append("Sell");
        }

        return sb.toString();
    }
}
