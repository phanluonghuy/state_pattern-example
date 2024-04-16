public class OutOfStockState implements VendingMachineState{
    @Override
    public void insertCoin(double amount) {
        System.out.println("Selected product is out of stock");
    }

    @Override
    public void selectProduct(int productID) {
        System.out.println("Selected product is out of stock");
    }

    @Override
    public String getMessage() {
        return "Selected product is out of stock";
    }
}
