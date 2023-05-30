package com.we.utilities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtilities {
	private static Scanner scanner = new Scanner(System.in);
	

	public static int getInputAsInteger(String varName, String prompt) {
	    int input = 0;
	    boolean validInput = false;
	    
	    do {
	        try {
	            System.out.println(prompt);
	            input = scanner.nextInt();
	            scanner.nextLine();
	            validInput = true;
	        } catch (InputMismatchException e) {
	            System.out.println(varName +  " must be an integer.");
	            scanner.nextLine(); // consume invalid input
	        }catch (Exception e) {
	            System.out.println("Oops! Something went wrong. ");
	            return -1;
	        }

	    } while (!validInput);

	    return input;
	}
	
	public static double getInputAsDouble(String varName, String prompt) {
	    boolean validInput = false;
	    double input = 0;

	    do {
	        try {
	            System.out.println(prompt);
	            input = scanner.nextDouble();
	            scanner.nextLine();
	            validInput = true;
	        } catch (InputMismatchException e) {
	            System.out.println(varName + " must be a valid double ");
	            scanner.nextLine();
	        } catch (Exception e) {
				System.out.println("Oooop! Something went wrong !");
			}
	    } while (!validInput);

	    return input;
	}

	public static long getInputAsLong(String varName, String prompt) {
	    boolean validInput = false;
	    long input = 0;
	    
	    do {
	        try {
	            System.out.println(prompt);
	            input = scanner.nextLong();
	            scanner.nextLine();
	            validInput = true;
	        } catch (InputMismatchException e) {
	            System.out.println(varName + " must be a valid integer");
	            scanner.nextLine();
	        } 
	    } while (!validInput);

	    return input;
	}
	
	public static String getInputAsString(String varName, String prompt) {
	    boolean validInput = false;
	    String input = "";

	    do {
	        try {
	            System.out.println(prompt);
	            input = scanner.nextLine();
	            validInput = true;
	        } 
	        catch (Exception e) {
	            System.out.println("Ooops! Something went wrong. ");
	            System.out.println(e.getMessage());
	        }
	    } while (!validInput);

	    return input;
	}
	
	 public static BigDecimal getInputAsBigDecimal(String varName, String prompt) {
	        BigDecimal input = BigDecimal.ZERO;
	        boolean validInput = false;

	        do {
	            try {
	                System.out.println(prompt);
	                String inputString = scanner.nextLine();
	                input = new BigDecimal(inputString);
	                validInput = true;
	            } catch (NumberFormatException e) {
	                System.out.println(varName + " must be a valid number.");
	            } catch (Exception e) {
	                System.out.println("Oops! Something went wrong. ");
	                return BigDecimal.ZERO;
	            }

	        } while (!validInput);

	        return input;
	    }
	
	
	
	
	
	public static LocalDate getInputAsDate(String varName, String prompt) {
        boolean validInput = false;
        LocalDate date = null;

        do {
            try {
                System.out.println(prompt);
                String input = scanner.nextLine();

                // Parse the input string into a LocalDate object
                date = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                validInput = true;
            } catch (DateTimeParseException e) {
                System.out.println(varName + " must be a valid date in the format dd/MM/yyyy. try again");
            } catch (Exception e) {
                System.out.println("Oops! Something went wrong. try again ");
            }
        } while (!validInput);

        return date;
    }	
	
	

}
