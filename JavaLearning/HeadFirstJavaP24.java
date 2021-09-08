package stockViewer.JavaLearning;

/**
 * Created By HaoQian on 2021/9/8
 */
public class HeadFirstJavaP24 {
    public static void main(String[] args) {
        int x = 0;
        while (x < 4) {
            System.out.print("a");
            if (x < 1) {
                System.out.print(" ");
            }
            System.out.print("n");
            if (x > 1) {
                System.out.print(" oyster");
                x = x + 2;
            }
            if (x == 1) {
                System.out.print("noys");
            }
            if (x < 1) {
                System.out.print("noise");
            }
            System.out.println();
            x = x + 1;
        }
        System.out.print("test");
    }
}
