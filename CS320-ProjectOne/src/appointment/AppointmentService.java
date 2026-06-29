package appointment;

import java.util.HashMap;
import java.util.Map;
public class AppointmentService{
    //Hash map to store data
    private Map<String, Appointment> appointmentMap;

    //Constructor
    public AppointmentService() { this.appointmentMap = new HashMap<>(); }

    //Getter
    public Appointment getAppointment(String appointmentId){ return appointmentMap.get(appointmentId); }

    //Add an appointment to the Map
    public void addAppointment(Appointment appointment){
    	
        //Check if appointment is empty
    	
        if (appointment == null){
            throw  new IllegalArgumentException("The appointment cannot be null.");
        }
        
        //Check if Appointment Exists
        
        else if(appointmentMap.containsKey(appointment.getAppointmentId())){
            throw  new IllegalArgumentException("There is an appointment that exists with this ID.");
        }

        //Add the appointment into the appointmentMap
        
        appointmentMap.put(appointment.getAppointmentId(), appointment);
    }

    //Delete the Appointment by appointmentID
    public void removeAppointment(String appointmentId){
        //If the appointment ID does not exist in the Map
    	
        if(!appointmentMap.containsKey(appointmentId)){
            throw new IllegalArgumentException("Appointment ID not found, cannot delete.");
        }
        appointmentMap.remove(appointmentId);
    }

}