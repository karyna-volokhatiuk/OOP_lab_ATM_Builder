package atm;

public interface Bill {
    void setNext(Bill bill);
    void process(int amount);
    Bill getNextBill();
}
