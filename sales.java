import java.util.*;


public class Sales {
    public static void main(String[] args) {
        List<Double> sales = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of products: ");
        int n= sc.nextInt();
        System.out.println("Enter prices of products one by one: ");
        for(int i=0;i<n;i++)
        {
            sales.add(sc.nextDouble());
        }
        Map<String, Integer> productCountByRange = new HashMap<>();
        Map<String, Double> revenueByRange = new HashMap<>();

        double[] ranges = {0, 50, 100, 200, Double.MAX_VALUE};
        String[] rangeLabels = {"$0-50", "$50-100", "$100-200", "Above $200"};

        for (String label : rangeLabels) {
            productCountByRange.put(label, 0);
            revenueByRange.put(label, 0.0);
        }

        for (double price : sales) {;
            for (int i = 0; i < ranges.length - 1; i++) {
                if (price >= ranges[i] && price < ranges[i + 1]) {
                    String rangeLabel = rangeLabels[i];
                    int count = productCountByRange.get(rangeLabel);
                    productCountByRange.put(rangeLabel, count + 1);
                    double revenue = revenueByRange.get(rangeLabel);
                    revenueByRange.put(rangeLabel, revenue + price);
                    break;
                }
            }
        }

        System.out.println("Number of products sold within specific price ranges:");
        for (String label : rangeLabels) {
            System.out.println(label + ": " + productCountByRange.get(label));
        }

        System.out.println("\nTotal revenue generated within each price range:");
        for (String label : rangeLabels) {
            System.out.println(label + ": $" + revenueByRange.get(label));
        }
    }
}
