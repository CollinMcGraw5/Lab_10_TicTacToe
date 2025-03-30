import java.util.Scanner;

public class SafeInput {
    /**
     * Prompts the user for an integer within a specified range.
     *
     * @param console Scanner object to receive input.
     * @param prompt  Message to prompt the user.
     * @param low     Lower bound of the range (inclusive).
     * @param high    Upper bound of the range (inclusive).
     * @return A valid integer within the range.
     */
    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int userInput = 0; // Initialize the variable to a default value.
        boolean isValid;
        do {
            System.out.print(prompt);
            if (console.hasNextInt()) {
                userInput = console.nextInt();
                if (userInput >= low && userInput <= high) {
                    isValid = true;
                } else {
                    System.out.println("Error: Input must be between " + low + " and " + high + ".");
                    isValid = false;
                }
            } else {
                System.out.println("Error: Invalid integer input.");
                console.next(); // Clear invalid input.
                isValid = false;
            }
        } while (!isValid);
        return userInput; // This is now guaranteed to have a valid value.
    }


    /**
     * Prompts the user for a Yes/No confirmation.
     *
     * @param console Scanner object to receive input.
     * @param prompt  Message to prompt the user.
     * @return True for Yes, False for No.
     */
    public static boolean getYNConfirm(Scanner console, String prompt) {
        String userInput;
        boolean isValid;
        do {
            System.out.print(prompt + " [Y/N]: ");
            userInput = console.next().toUpperCase();
            if (userInput.equals("Y") || userInput.equals("N")) {
                isValid = true;
            } else {
                System.out.println("Error: Input must be 'Y' or 'N'.");
                isValid = false;
            }
        } while (!isValid);
        return userInput.equals("Y");
    }
}
