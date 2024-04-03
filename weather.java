import java.util.*;

class WeatherData {
    private double temperature;
    private double humidity;

    public WeatherData(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }
}

public class Weather {
    public static void main(String[] args) {
        List<WeatherData> data = new ArrayList<>();
        data.add(new WeatherData(15.0, 60.0));
        data.add(new WeatherData(5.0, 70.0));
        data.add(new WeatherData(25.0, 50.0));
        data.add(new WeatherData(10.0, 80.0));
        data.add(new WeatherData(0.0, 75.0));
        data.add(new WeatherData(-5.0, 85.0));

        double[] temperatureRanges = {-Double.MAX_VALUE, 0, 10, 20, 30, Double.MAX_VALUE};
        String[] rangeLabels = {"<0°C", "0-10°C", "10-20°C", "20-30°C", ">30°C"};

        Map<String, Integer> tempRange = new HashMap<>();
        Map<String, Double> humidityRange = new HashMap<>();

        for (String label : rangeLabels) {
            tempRange.put(label, 0);
            humidityRange.put(label, 0.0);
        }

        for (WeatherData weatherData : data) {
            double temperature = weatherData.getTemperature();
            double humidity = weatherData.getHumidity();

            for (int i = 0; i < temperatureRanges.length - 1; i++) {
                if (temperature >= temperatureRanges[i] && temperature < temperatureRanges[i + 1]) {
                    String rangeLabel = rangeLabels[i];
                    int days = tempRange.get(rangeLabel);
                    tempRange.put(rangeLabel, days + 1);

                    double avgHumidity = humidityRange.get(rangeLabel);
                    int count = tempRange.get(rangeLabel);
                    humidityRange.put(rangeLabel, (avgHumidity * (count - 1) + humidity) / count);
                    break;
                }
            }
        }

        System.out.println("Number of days with temperatures within certain ranges:");
        for (String label : rangeLabels) {
            System.out.println(label + ": " + tempRange.get(label));
        }

        System.out.println("\nAverage humidity for each temperature range:");
        for (String label : rangeLabels) {
            System.out.println(label + ": " + humidityRange.get(label) + "%");
        }
    }
}
