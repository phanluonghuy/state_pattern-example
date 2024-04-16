public class DispenseState implements VendingMachineState{
    private VendingMachine machine;

    public DispenseState(VendingMachine machine) {
        this.machine = machine;
    }
    @Override
    public void insertCoin(double amount) {
        System.out.println("Machine is dispensing product");
    }

    @Override
    public void selectProduct(int productID) {
        System.out.println("Machine is dispensing product");
    }

    @Override
    public String getMessage() {
        return "Dispensing product...";
    }
}
