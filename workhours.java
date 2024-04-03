import java.util.*;


public class WorkHours {
    public static void main(String[] args) {
        int[] workHoursList=new int[]{40,30,50,60,34,40,78};
        int moreThan40Count = 0, exactly40Count = 0, lessThan40Count = 0;
        int moreThan40Total = 0, exactly40Total = 0, lessThan40Total = 0;

        for (Integer totalHours : workHoursList) {
            if (totalHours > 40){
                moreThan40Count++;
                moreThan40Total += totalHours;
            } else if (totalHours == 40) {
                exactly40Count++;
                exactly40Total += totalHours;
            } else {
                lessThan40Count++;
                lessThan40Total += totalHours;
            }
        }

        // Calculate average hours worked per day for each group
        double moreThan40Average = moreThan40Count > 0 ? (double) moreThan40Total / (moreThan40Count * 5) : 0.0;
        double exactly40Average = exactly40Count > 0 ? (double) exactly40Total / (exactly40Count * 5) : 0.0;
        double lessThan40Average = lessThan40Count > 0 ? (double) lessThan40Total / (lessThan40Count * 5) : 0.0;

        // Print results
        System.out.println("Number of employees who worked more than 40 hours: " + moreThan40Count);
        System.out.println("Average hours worked per day for employees who worked more than 40 hours: " + moreThan40Average);

        System.out.println("\nNumber of employees who worked exactly 40 hours: " + exactly40Count);
        System.out.println("Average hours worked per day for employees who worked exactly 40 hours: " + exactly40Average);

        System.out.println("\nNumber of employees who worked less than 40 hours: " + lessThan40Count);
        System.out.println("Average hours worked per day for employees who worked less than 40 hours: " + lessThan40Average);
    }
}
