public class PaymentPendingState implements VendingMachineState{
    private int productId;

    public PaymentPendingState(int productId) {
        this.productId = productId;
    }
    @Override
    public void insertCoin(double amount) {
        VendingMachine machine = VendingMachine.getInstance();
        machine.updateAmount(amount);
        if (machine.hasEnoughMoney(productId)) {
            machine.setState(machine.getDispenseState());
        }
    }

    @Override
    public void selectProduct(int productID) {
        System.out.println("Please insert more coins");
    }

    @Override
    public String getMessage() {
        return "Insufficient amount. Please insert more coins";
    }
}
