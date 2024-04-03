import java.util.*;


public class Medical_Test {
    public static void main(String[] args) {
        Map<String,Double> testResults = new HashMap<>();
        testResults.put("Patient 1", 80.0);
        testResults.put("Patient 2", 120.0);
        testResults.put("Patient 3", 90.0);
        testResults.put("Patient 4", 140.0);
        testResults.put("Patient 5", 100.0);
        testResults.put("Patient 6", 160.0);

        double normalRange = 100.0;
        double borderlineRange = 120.0;
        String normalLabel = "Normal";
        String borderlineLabel = "Borderline";
        String highLabel = "High";

        int normalCount = 0, borderlineCount = 0, highCount = 0;
        double normalTotal = 0.0, borderlineTotal = 0.0, highTotal = 0.0;

        for (String patient : testResults.keySet()) {
            double value = testResults.get(patient);
            if (value <= normalRange) {
                normalCount++;
                normalTotal += value;
            } else if (value <= borderlineRange) {
                borderlineCount++;
                borderlineTotal += value;
            } else {
                highCount++;
                highTotal += value;
            }
        }

        double normalAverage = normalCount > 0 ? normalTotal / normalCount : 0.0;
        double borderlineAverage = borderlineCount > 0 ? borderlineTotal / borderlineCount : 0.0;
        double highAverage = highCount > 0 ? highTotal / highCount : 0.0;

        System.out.println("Number of patients with results falling within specific ranges:");
        System.out.println(normalLabel + ": " + normalCount);
        System.out.println(borderlineLabel + ": " + borderlineCount);
        System.out.println(highLabel + ": " + highCount);

        System.out.println("\nAverage value for each range:");
        System.out.println(normalLabel + ": " + normalAverage);
        System.out.println(borderlineLabel + ": " + borderlineAverage);
        System.out.println(highLabel + ": " + highAverage);
    }
}
