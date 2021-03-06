package ru.matevosyan;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created isNumber for get true or false.
 * Created on 09.02.2017.
 * @since 1.0
 * @author Matevosyan Vardan
 * @version 1.0
 */

public class EvenAndOddNumber {
    private boolean checkEvenAndOddNumber  = false;

    /**
     * isNumber created for checking eve numbers in the stream.
     * @param in input stream
     * @return checkEvenAndOddNumber which is boolean and can return true is number is even.
     * @throws IOException exception.
     */

        public boolean isNumber(InputStream in) throws IOException {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {
                int number = bufferedReader.read();
            while (number != -1) {
                try {
                    if ((number % 2) == 0) {
                        this.checkEvenAndOddNumber = true;
                        break;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Number is no available");
                }
                number = bufferedReader.read();
            }
        } catch (IOException ioe) {
                System.out.println("Input/Output problem");
            }
            return this.checkEvenAndOddNumber;
    }

}
