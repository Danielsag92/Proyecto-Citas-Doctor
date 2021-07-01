package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{

    //Atributos
    private String speciality;
    private ArrayList<AvailableAppointmets> availableAppointmets = new ArrayList<>();

   public Doctor(String name, String email) {
        super(name, email);
    }
    // comportamimnetos
    public String getSpeciality(){
        return speciality;
    }

    public void setSpeciality(String speciality){
        this.speciality = speciality;
    }

    public void addAvailableAppointments(String date, String time){

        availableAppointmets.add(new AvailableAppointmets(date,time));
    }
    public ArrayList<AvailableAppointmets> getAvailableAppointmets(){
        return availableAppointmets;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: "+speciality+ "\nAvailable: "+availableAppointmets.toString();
    }

    public static class AvailableAppointmets{
        private Date date;
        private String time;
        private int id_availableAppointments;
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");


        public AvailableAppointmets(String date, String time){
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate(){
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getId_availableAppointments() {
            return id_availableAppointments;
        }

        public void setId_availableAppointments(int id_availableAppointments) {
            this.id_availableAppointments = id_availableAppointments;
        }

        @Override
        public String toString() {
            return "Avaliable Appointments \nDate: " + date+ "\nTime: "+time;
        }
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz roja");
        System.out.println("Depto:  Oncologia");

    }


}
