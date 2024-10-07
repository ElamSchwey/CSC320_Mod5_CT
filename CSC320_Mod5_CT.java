import java.util.Scanner;

public class CSC320_Mod5_CT {

    public static void main(String[] args) {
        // months & their average temperatures
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        double[] avgTemp = {20, 30, 40, 60, 70, 80, 85, 75, 65, 55, 45, 35};

        Scanner inputScanner = new Scanner(System.in);
        boolean continueInput = true;

        // loop until yearly stats
        while (continueInput) {
            System.out.print("\nEnter the number of a month (Jan = 1, Feb = 2, etc.) or 'year' for yearly stats: ");
            String userInput = inputScanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("year")) {
                displayYearlyStats(monthNames, avgTemp);
                continueInput = false;
            } else {
                try {
                    int monthNumber = Integer.parseInt(userInput);

                    if (monthNumber >= 1 && monthNumber <= 12) {
                        System.out.println("Month: " + monthNames[monthNumber - 1] + " | Average Temp: " + avgTemp[monthNumber - 1] + "°F");
                    } else {
                        System.out.println("Invalid month number. Please enter a number between 1 and 12.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid month number or 'year'.");
                }
            }
        }

        inputScanner.close();
    }

    // display yearly stats
    private static void displayYearlyStats(String[] months, double[] temps) {
        double totalTemp = 0;
        double maxTemp = temps[0];
        double minTemp = temps[0];
        String hottestMonth = months[0];
        String coldestMonth = months[0];

        System.out.println("\n--- Yearly stats summary  ---");

        for (int i = 0; i < months.length; i++) {
            System.out.println(months[i] + ": " + temps[i] + "°F");
            totalTemp += temps[i];

            // warmest month
            if (temps[i] > maxTemp) {
                maxTemp = temps[i];
                hottestMonth = months[i];
            }

            // coolest month
            if (temps[i] < minTemp) {
                minTemp = temps[i];
                coldestMonth = months[i];
            }
        }

        double avgYearlyTemp = totalTemp / months.length;
        System.out.printf("\nAverage Yearly Temp: %.2f°F", avgYearlyTemp);
        System.out.println("\nHottest Month: " + hottestMonth + " with " + maxTemp + "°F");
        System.out.println("Coldest Month: " + coldestMonth + " with " + minTemp + "°F");
    }
}

