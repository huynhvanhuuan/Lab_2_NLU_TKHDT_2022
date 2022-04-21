import java.util.Date;

public class ThreeReading extends Reading {
    private int lowIndex;
    private int highIndex;

    public ThreeReading(Date date, int index, int lowIndex, int highIndex) {
        super(date, index);
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
    }

    public int getLowIndex() {
        return lowIndex;
    }

    public int getHighIndex() {
        return highIndex;
    }
}
