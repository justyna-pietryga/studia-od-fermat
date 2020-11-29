import java.util.Scanner;

public class RunProgram {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Wylosuj liczbe");
        System.out.println("2. Podaj samodzielnie liczbe do sprawdzenia");
        String how = scan.nextLine();
        int howInt = Integer.parseInt(how);
        String testedNumber = "0";

        switch (howInt) {
            case 1: {
                System.out.println("Podaj górna granice losowanej liczby (musi być wieksza niz 10^9");
                String upperLimit = scan.nextLine();
                testedNumber = String.valueOf(HandleFermat.generateOddRandomNumber(upperLimit));
                break;
            }
            case 2: {
                System.out.println("Podaj liczbe");
                testedNumber = scan.nextLine();
                break;
            }
        }

        System.out.println("Ile prob ma zostac wykonanych?");
        String howManyTries = scan.nextLine();

        FermatBigInteger fermatBigInteger = new FermatBigInteger(testedNumber, Integer.parseInt(howManyTries));

        if (fermatBigInteger.isPrimeNumber()) {
            System.out.println("Liczba " + testedNumber + " prawdopodobnie jest liczbą pierwszą");
        } else {
            System.out.println("Liczba " + testedNumber + " prawdopodobnie nie jest liczbą pierwszą");
        }
    }
}
