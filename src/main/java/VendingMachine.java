import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private static VendingMachine instance;
    private VendingMachineState state;
    private double currentAmount;
    private Map<Integer, Double> productPrices;
    private Map<Integer, Integer> productStock;
    private VendingMachine() {
        this.state = new ReadyState(this);
        this.currentAmount = 0.0;

        this.productPrices = new HashMap<>();
        productPrices.put(1, 1.50);
        productPrices.put(2, 1.00);

        this.productStock = new HashMap<>();
        productStock.put(1, 5);
        productStock.put(2, 2);

    }
    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }
    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public VendingMachineState getReadyState() {
        return new ReadyState(this);
    }

    public VendingMachineState getDispenseState() {
        return new DispenseState(this);
    }

    public VendingMachineState getOutOfStockState() {
        return new OutOfStockState();
    }

    public VendingMachineState getPaymentPendingState(int productId) {
        return new PaymentPendingState(productId);
    }

    public void insertCoin(double amount) {
        state.insertCoin(amount);
    }

    public void selectProduct(int productId) {
        state.selectProduct(productId);
    }

    public String getMessage() {
        return state.getMessage();
    }

    public void updateAmount(double amount) {
        currentAmount += amount;
    }

    public boolean hasProduct(int productId) {
        return productStock.containsKey(productId) && productStock.get(productId) > 0;
    }

    public boolean hasEnoughMoney(int productId) {
        return currentAmount >= productPrices.get(productId);
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }
}
