public class Main {
    public static void main(String[] args) {
        VendingMachine machine = VendingMachine.getInstance();

        System.out.println("____________ Test ReadyState messages and insufficient funds");
        System.out.println(machine.getMessage()); // ReadyState message
        machine.insertCoin(0.5);
        System.out.println(machine.getCurrentAmount());
        System.out.println(machine.getMessage()); // ReadyState message (not enough money)

        System.out.println("____________ Test selecting out-of-stock product");
        machine.selectProduct(3); // Assuming product 3 is not available
        System.out.println(machine.getMessage());// OutOfStockState message
        machine.setState(new ReadyState(machine)); // reset after waiting ... seconds

        System.out.println("____________ Test successful purchase");
        machine.insertCoin(1.0);
        System.out.println(machine.getMessage()); // ReadyState message (enough money)
        machine.selectProduct(1);
        System.out.println(machine.getMessage()); // DispenseState message (product dispensed)
        machine.setState(new ReadyState(machine)); // reset after waiting ... seconds

        System.out.println("____________ Test PaymentPendingState and successful purchase after adding more money");
        machine.setCurrentAmount(0); // Start with no money
        machine.selectProduct(2);
        System.out.println(machine.getMessage()); // PaymentPendingState message
        machine.insertCoin(1.0);
        System.out.println(machine.getMessage()); // DispenseState message (product dispensed)
        machine.setState(new ReadyState(machine)); // reset after waiting ... seconds

        System.out.println("____________ Test insufficient funds even after adding money");
        machine.selectProduct(1); // Requires $1.50
        System.out.println(machine.getMessage()); // PaymentPendingState message
        machine.insertCoin(0.5);
        System.out.println(machine.getMessage()); // PaymentPendingState message (still not enough)
    }
}
