package lesson1.object;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int compute() throws SQLException{
        Scanner scanner = new Scanner(System.in);

            int denominator = scanner.nextInt();
            int numerator = scanner.nextInt();
            if(denominator == 0) {
                throw new SQLException("Denominator cannot be zero");
            } else {
                return numerator / denominator;
            }

    }
    public static void main(String[] args) {
        try{
            System.out.println( compute());
        } catch (SQLException e) {}
        System.out.println("End of program");
    }


}
