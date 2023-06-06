import java.util.Scanner;

public class Runner {
     /*
      Vehicle Insurance Payment Calculator

      Vehicle types:  car, truck, bus, motorcycle
                      (bus: 18-30 seats or 31 and above seats)
      Period(term): December 2022, June 2022

      1st term: June 2022                      2nd term: December 2022
         cars: 2000                            cars: 2500
         truck: 3000                           truck: 3500
         bus: type1: 4000 type2: 5000          bus: type1: 4500 type2: 5500
         motorcycle: 1500                      motorcycle: 1750

       In case of incorrect entry, the calculation failed warning should be given
       to the user and the menu should be shown again.

       To be able to show the user the application repeatedly,
       we should present an option to restart the application.
*/

    public static void main(String[] args) {
        startCalculation();
    }

    public static void startCalculation() {
        boolean isFailed;
        Scanner input = new Scanner(System.in);
        do {
            isFailed = false;
            System.out.println("--- Vehicle Insurance Calculator ---");
            System.out.println("Please choose the term for payment: ");

            System.out.println("1. Term: June 2023");
            System.out.println("2. Term December 2023");

            int term = input.nextInt();

            if (term == 1 || term == 2) {
                Vehicle objVehicle = new Vehicle();
                System.out.println("Enter the type of the vehicle for payment calculation");

                System.out.println("Car, Truck, Bus, Motorcycle");
                objVehicle.type = input.next().toUpperCase();

                objVehicle.payment = objVehicle.countPayment(term);

                int select;
                String termName = term==1 ? "June 2023" : "December 2023";

                if (objVehicle.payment>0){

                    System.out.println("Calculation is done successfully");
                    System.out.println("The type of vehicle: "+ objVehicle.type);
                    System.out.println("Payment term: "+ termName );
                    System.out.println("Payment: "+ objVehicle.payment);
                    System.out.println("Press 1 to restart, Press 0 to exit");
                    select=input.nextInt();
                    if (select==1){
                        isFailed=true;
                    }else {
                        isFailed=false;
                    }

                }else {

                    System.out.println("Calculation failed, please try again");
                    System.out.println("Press 1 to restart, Press 0 to exit");
                    select= input.nextInt();
                    if (select==1){
                        isFailed=true;
                    }else {
                        isFailed=false;
                    }

                }

            } else {
                System.out.println("Calculation cannot be done! Incorrect input!");
                isFailed = true;
            }

        } while (isFailed);

    }
}
