import java.util.*;

public class HousePricing {
    public static void main(String[] args) {
        double[] p = {150000.0, 250000.0, 180000.0, 300000.0, 200000.0, 350000.0};
        double[] s = {1200.0, 1800.0, 1500.0, 2000.0, 1600.0, 2200.0};

        double[] r = {100000, 200000, 300000, 400000, 500000, Double.MAX_VALUE};
        String[] l = {"$100,000-200,000", "$200,000-300,000", "$300,000-400,000", "$400,000-500,000", "Above $500,000"};

        Map<String, Integer> h = new HashMap<>();
        Map<String, Double> t = new HashMap<>();

        for (String label : l) {
            h.put(label, 0);
            t.put(label, 0.0);
        }

        for (int i = 0; i < p.length; i++) {
            double price = p[i];
            double sqft = s[i];

            for (int j = 0; j < r.length - 1; j++) {
                if (price >= r[j] && price < r[j + 1]) {
                    String label = l[j];
                    int count = h.get(label);
                    h.put(label, count + 1);
                    double totalSqft = t.get(label);
                    t.put(label, totalSqft + sqft);
                    break;
                }
            }
        }

        Map<String, Double> a = new HashMap<>();
        for (String label : l) {
            int count = h.get(label);
            double totalSqft = t.get(label);
            double averageSqft = count > 0 ? totalSqft / count : 0.0;
            a.put(label, averageSqft);
        }

        System.out.println("Houses sold within specific price ranges:");
        for (String label : l) {
            System.out.println(label + ": " + h.get(label));
        }

        System.out.println("\nAverage square footage for each price range:");
        for (String label : l) {
            System.out.println(label + ": " + a.get(label) + " sqft");
        }
    }
}
