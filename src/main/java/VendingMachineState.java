public interface VendingMachineState {
    void insertCoin(double amount);
    void selectProduct(int productID);
    String getMessage();
}
