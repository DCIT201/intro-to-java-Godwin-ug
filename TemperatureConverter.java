import java.util.Scanner;

/**
 * TemperatureConverter - A comprehensive temperature conversion utility
 * supporting Celsius, Fahrenheit, and Kelvin conversions.
 *
 * @godwin-odoom
 * @version 1.1
 */
public class TemperatureConverter {
    // Constant for absolute zero references
    private static final double CELSIUS_ABSOLUTE_ZERO = -273.15;
    private static final double FAHRENHEIT_ABSOLUTE_ZERO = -459.67;
    private static final double KELVIN_ABSOLUTE_ZERO = 0.0;

    /**
     * Converts Celsius to Fahrenheit
     * @param celsius Temperature in Celsius
     * @return Temperature in Fahrenheit
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0/5.0) + 32;
    }

    /**
     * Converts Fahrenheit to Celsius
     * @param fahrenheit Temperature in Fahrenheit
     * @return Temperature in Celsius
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0/9.0;
    }

    /**
     * Converts Celsius to Kelvin
     * @param celsius Temperature in Celsius
     * @return Temperature in Kelvin
     */
    public static double celsiusToKelvin(double celsius) {
        return celsius - CELSIUS_ABSOLUTE_ZERO;
    }

    /**
     * Converts Kelvin to Celsius
     * @param kelvin Temperature in Kelvin
     * @return Temperature in Celsius
     */
    public static double kelvinToCelsius(double kelvin) {
        return kelvin + CELSIUS_ABSOLUTE_ZERO;
    }

    /**
     * Validates temperature based on the conversion type
     * @param temperature Input temperature
     * @param conversionType Type of conversion
     * @return true if temperature is valid, false otherwise
     */
    private static boolean isValidTemperature(double temperature, int conversionType) {
        switch (conversionType) {
            case 1: // Celsius to Fahrenheit
                return temperature >= CELSIUS_ABSOLUTE_ZERO;
            case 2: // Fahrenheit to Celsius
                return temperature >= FAHRENHEIT_ABSOLUTE_ZERO;
            case 3: // Celsius to Kelvin
                return temperature >= CELSIUS_ABSOLUTE_ZERO;
            case 4: // Kelvin to Celsius
                return temperature >= KELVIN_ABSOLUTE_ZERO;
            default:
                return false;
        }
    }

    /**
     * Main method to run the temperature conversion utility
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            // Display conversion menu
            System.out.println("\n--- Temperature Converter ---");
            System.out.println("Select Conversion Type:");
            System.out.println("1. Celsius (℃) to Fahrenheit (℉)");
            System.out.println("2. Fahrenheit (℉) to Celsius (℃)");
            System.out.println("3. Celsius (℃) to Kelvin (K)");
            System.out.println("4. Kelvin (K) to Celsius (℃)");

            // Get valid conversion choice
            int conversionType = getValidChoice(scanner, 4);

            // Get valid temperature input
            double temperature = getValidTemperature(scanner, conversionType);

            // Perform conversion
            double result = performConversion(temperature, conversionType);

            // Display result
            displayConversionResult(temperature, result, conversionType);

            // Ask to continue
            playAgain = askToContinue(scanner);
        }

        System.out.println("Thank you for using Temperature Converter. Goodbye!");
        scanner.close();
    }

    /**
     * Gets a valid menu choice from the user
     * @param scanner Input scanner
     * @param maxChoice Maximum valid choice number
     * @return Validated choice
     */
    private static int getValidChoice(Scanner scanner, int maxChoice) {
        int choice;
        while (true) {
            System.out.print("\nEnter your choice (1-" + maxChoice + "): ");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= maxChoice) {
                    return choice;
                }
            } else {
                scanner.next(); // Clear invalid input
            }
            
            System.out.println("Invalid choice. Please try again.");
        }
    }

    /**
     * Gets a valid temperature input from the user
     * @param scanner Input scanner
     * @param conversionType Type of conversion
     * @return Validated temperature
     */
    private static double getValidTemperature(Scanner scanner, int conversionType) {
        double temperature;
        while (true) {
            System.out.print("Enter the temperature: ");
            
            if (scanner.hasNextDouble()) {
                temperature = scanner.nextDouble();
                
                if (isValidTemperature(temperature, conversionType)) {
                    return temperature;
                }
                
                System.out.println("Temperature is below absolute zero for this conversion.");
            } else {
                scanner.next(); // Clear invalid input
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    /**
     * Performs temperature conversion based on selected type
     * @param temperature Input temperature
     * @param conversionType Type of conversion
     * @return Converted temperature
     */
    private static double performConversion(double temperature, int conversionType) {
        switch (conversionType) {
            case 1: return celsiusToFahrenheit(temperature);
            case 2: return fahrenheitToCelsius(temperature);
            case 3: return celsiusToKelvin(temperature);
            case 4: return kelvinToCelsius(temperature);
            default: return 0.0;
        }
    }

    /**
     * Displays conv
