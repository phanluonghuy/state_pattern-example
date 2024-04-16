public class ReadyState implements VendingMachineState{
    private VendingMachine machine;
    public ReadyState(VendingMachine machine) {
        this.machine = machine;
    }
    @Override
    public void insertCoin(double amount) {
        machine.updateAmount(amount);
    }

    @Override
    public void selectProduct(int productID) {
        if (machine.hasProduct(productID) && machine.hasEnoughMoney(productID)) {
            machine.setState(machine.getDispenseState());
        } else if (!machine.hasProduct(productID)) {
            machine.setState(machine.getOutOfStockState());
        } else {
            machine.setState(machine.getPaymentPendingState(productID));
        }
    }

    @Override
    public String getMessage() {
        return "Select product or insert coin";
    }
}
