package boundary;

import control.ReservationManager;
import control.TableManager;
import entity.Reservation;
import entity.Table;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by root on 14-11-8.
 */
public class ReservationBoundary {

    private ReservationManager reservationManager;

    public ReservationBoundary(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createReservation();

                    break;
                case 2:
                    removeReservation();
                    break;
                case 3:
                    checkReservation();
                    break;
                default:
                    break;
            }
        } while (choice != 4);
    }

    private void createReservation() {
        Scanner sc = new Scanner(System.in);
        Calendar calTime = Calendar.getInstance();
        int pax;
        String cstName;
        String dateStr, timeStr;
        String[] date, time;

        System.out.print("Please enter the date(DD/MM/YYYY):");
        dateStr = sc.next();
        date = dateStr.split("/");
        System.out.print("Please enter the time(HH:MM)");
        timeStr = sc.next();
        time = timeStr.split(":");
        calTime.set(new Integer(date[2]), new Integer(date[1]) - 1,
                new Integer(date[0]), new Integer(time[0]),
                new Integer(time[1]));
        System.out.print("Please enter the pax:");
        pax = sc.nextInt();
        System.out.print("Please enter the customer name:");
        cstName = sc.next();

        reservationManager.clearReservation();
        Reservation reservation = new Reservation(calTime, pax, cstName);
        boolean isAssigned = reservationManager.assignTable(reservation);
        if (isAssigned) {
            System.out.println("entity.Reservation has been successfully created!");
            reservationManager.getReservations().add(reservation);
        } else {
            System.out.println("entity.Reservation is not created. No table is available!");
        }
    }

    private void removeReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the customer name:");
        String cstName = sc.next();
        boolean isRemoved = reservationManager.removeReservation(cstName);
        if (isRemoved) {
            System.out.println("entity.Reservation is successfully removed!");
        } else {
            System.out.println("entity.Reservation is not removed. Please check!");
        }
    }

    private void checkReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the customer name:");
        String name = sc.next();
        int index = reservationManager.searchByName(name);
        if (index != -1) {
            System.out.println(reservationManager.getReservations().get(index).toString());
        } else {
            System.out.println("No reservation for this customer!");
        }
    }

    private void printMenu() {
        System.out.println("1: Create new reservation");
        System.out.println("2: Remove old reservaiton");
        System.out.println("3: Check a reservation");
        System.out.println("4: Go back");
        System.out.print("Choose any options above:");
    }
}
