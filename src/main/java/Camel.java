/**
 *
 */
interface Rideable {
    String getGait();
}
public class Camel implements Rideable {
    int x = 2;
    public static void main(String[] args) {
        new Camel().go(8);
    }
    void go(int speed) {
        System.out.println((++speed * x++)
                + this.getGait());
    }
    String getGait() {
        return " mph, lope";
    }
}