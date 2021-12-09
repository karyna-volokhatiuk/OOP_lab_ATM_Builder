package atm;

import lombok.Getter;

@Getter
public class DefaultBill implements Bill{
    private int billValue;
    private Bill nextBill;

    public DefaultBill(int billValue){
        this.billValue = billValue;
    }

    @Override
    public void setNext(Bill bill) {
        this.nextBill = bill;
    }

    @Override
    public void process(int amount) {
        if (nextBill != null){
            nextBill.process(amount % billValue);
        } else if (amount % billValue != 0){
            throw new IllegalArgumentException("We don't have needed bills.");
        }

        System.out.println("Please, receive " + amount / billValue + " of " + billValue + "UAN bills");

        return;
    }
}
