package appointment;

import java.util.Date;

public class Appointment {
    private String appointmentId;
    private String appointmentDescription;
    private Date appointmentDate;

    public Appointment(String appointmentId, Date appointmentDate, String appointmentDescription){
        //Validate Appointment ID
        if(appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid Contact Id");
        }
        if(appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid Appointment Date");
        }
        if(appointmentDescription == null || appointmentDescription.length() > 50){
            throw new IllegalArgumentException("Invalid Appointment Description Name");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentDescription = appointmentDescription;
    }
    //*******************************//
    //***         Getters         ***//
    //*******************************//
    public String getAppointmentId(){
        return appointmentId;
    }

    public Date getAppointmentDate(){
        return appointmentDate;
    }

    public String getAppointmentDescription(){
        return appointmentDescription;
    }


//*******************************//
//***         Setters         ***//
//*******************************//
    
    public void setAppointmentDate(Date appointmentDate){
    	if(appointmentDate == null || appointmentDate.before(new Date())){
            throw new IllegalArgumentException("Invalid Appointment Description Name");
        }
        this.appointmentDate = appointmentDate;
    }
    
    public void setAppointmentDescription(String appointmentDescription) {
        if(appointmentDescription == null || appointmentDescription.length() > 50){
            throw new IllegalArgumentException("Invalid Appointment Description Name");
        }
        this.appointmentDescription = appointmentDescription;
    }


}
