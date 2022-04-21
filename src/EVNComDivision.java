import java.util.HashMap;
import java.util.Map;

public class EVNComDivision {
    private String name;

    private Map<String, Customer> customers = new HashMap<>();

    public EVNComDivision(String name) {
        this.name = name;
    }

    public void register(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Customer getCustomer(String id) {
        return customers.get(id);
    }

    public String invoice(String id) {
        StringBuffer result = new StringBuffer("Cong ty " + name + "\n");
        result.append("HOA DON TIEN DIEN CUA KHACH HANG\n\n");
        result.append(getCustomer(id).statement());
        return result.toString();
    }

    public String allInvoice() {
        StringBuffer result = new StringBuffer("Cong ty " + name + "\n");
        result.append("BAO CAO VE VIEC THU TIEN DIEN CUA KHACH HANG\n\n");
        for (Customer customer : customers.values()) {
            result.append(customer.statement());
        }
        return result.toString();
    }
}
