import java.util.ArrayList;
import java.util.List;

public class ResidentCustomer extends Customer {
    private ArrayList<OneReading> readings = new ArrayList<>();

    public ResidentCustomer(String id, String name) {
        super(id, name);
    }

    public List<OneReading> getReadings() {
        return readings;
    }

    public void addReading(OneReading reading) {
        getReadings().add(reading);
    }

    public double charge() {
        int oldIndex = getOldReading().getIndex();
        int newIndex = getNewReading().getIndex();
        int usage = newIndex - oldIndex;

        int u1 = Math.min(usage, 100);
        int u2 = usage <= 150 ? (usage - u1) : 50;
        int u3 = usage <= 200 ? (usage - u1 - u2) : 50;
        int u4 = usage <= 300 ? (usage - u1 - u2 - u3) : 100;
        int u5 = usage - u1 - u2 - u3 - u4;

        double result = u1*550 + u2*900 + u3*1210 + u4*1340 + u5*1400;

        result += result * TAX_RATE;

        return result;
    }

    public String statement() {
        Reading oldReading = getOldReading();
        Reading newReading = getNewReading();
        int usage = newReading.getIndex() - oldReading.getIndex();

        return "Ma Khach: " + getId() + "\nTen: " + getName() + "\nChi so cu: " + oldReading.getIndex() +
                "\nChi so moi: " + newReading.getIndex() + "\nDien nang tieu thu: " + usage + "\nThanh tien (10% VAT): " + charge() + " VND\n\n\n\n";
    }
}
