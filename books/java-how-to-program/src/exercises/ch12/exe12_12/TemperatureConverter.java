package ch12.exe12_12;

/**
 * TemperatureConverter
 */
public class TemperatureConverter {

    public static double fahrenheitToCelsius(double temp)
    {
        return 5.0 / 9.0 * (temp - 32);
    }
    
    public static double celsiusToFahrenheit(double temp)
    {
        return (temp * 9.0 / 5.0) + 32;
    }

    public static double celsiusToKelvin(double temp) {
        return temp + 273.15;
    }

    public static double fahrenheitToKelvin(double temp) {
        return fahrenheitToCelsius(temp) + 273.15;
    }

    public static double kelvinToCelius(double temp) {
        return temp - 273.15;
    }

    public static double kelvinToFahrenheit(double temp) {
        return celsiusToFahrenheit(kelvinToCelius(temp));
    }
}