package UI;
import Model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " +UIMenu.doctorLogged.getName());
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My scheduled appointments ");
            System.out.println("0. Logout");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        }while (response != 0);


    }

    private static void showAddAvailableAppointmentsMenu(){
        int response = 0;
        do {
            System.out.println();
            System.out.println("::Add Available Appointments");
            System.out.println("::Select a Month");
            for (int i = 0; i < 3;i++){
                int j = i + 1;
                System.out.println(j+ ". " +UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            if (response > 0 && response < 4){
                //options 1,2,3
                int monthSelecd = response;
                System.out.println(monthSelecd+ " . " + UIMenu.MONTHS[monthSelecd-1]);

                System.out.println("inser the date available: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("Your date is: " +date+ "\n1. Correct \n2. Change date");
                int responseDate = Integer.valueOf(sc.nextLine());

                if (responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Inser the Time available for date: "+date+ "[16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: " +time+ "\n1. Correct \n2. Change time");
                    responseTime = Integer.valueOf(sc.nextLine());


                }while (responseTime == 2);

                UIMenu.doctorLogged.addAvailableAppointments(date, time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);


            }else if (response == 0){
                showDoctorMenu();
            }

        }while (response != 0);
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if(doctor.getAvailableAppointmets().size() > 0
                && !doctorsAvailableAppointments.contains(doctor)){

                doctorsAvailableAppointments.add(doctor);
        }
    }
}
