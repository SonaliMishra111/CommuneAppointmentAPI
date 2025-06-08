import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private String serviceName;
    private String residentName;
    private LocalDateTime appointmentTime;

    public Appointment(int id, String serviceName, String residentName, LocalDateTime appointmentTime) {
        this.id = id;
        this.serviceName = serviceName;
        this.residentName = residentName;
        this.appointmentTime = appointmentTime;
    }

    public int getId() { return id; }
    public String getServiceName() { return serviceName; }
    public String getResidentName() { return residentName; }
    public LocalDateTime getAppointmentTime() { return appointmentTime; }

    @Override
    public String toString() {
        return "Appointment" + id + "\n"
                + "Service: " + serviceName + "\n"
                + "Resident: " + residentName + "\n"
                + "Scheduled Time: " + appointmentTime + "\n";
    }
}
