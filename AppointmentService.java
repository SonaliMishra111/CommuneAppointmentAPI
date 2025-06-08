import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class AppointmentService {
    private static Timer timer = new Timer();
    private static List<Appointment> appointments = new ArrayList<>();
    private static int idCounter = 1;

    public static Appointment addAppointment(String serviceName, String residentName, LocalDateTime appointmentTime) {
        Appointment appointment = new Appointment(idCounter++, serviceName, residentName, appointmentTime);
        appointments.add(appointment);
        return appointment;
    }

    public static List<Appointment> getAllAppointments() {
        return appointments;
    }

    public static Appointment getAppointmentById(int id) {
        return appointments.stream().filter(app -> app.getId() == id).findFirst().orElse(null);
    }

    public static void startNotificationService() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();

                for (Appointment app : appointments) {
                    if (app.getAppointmentTime().isBefore(now.plusMinutes(5)) && app.getAppointmentTime().isAfter(now)) {
                        System.out.println("\n Reminder: Your appointment is in less than 5 minutes!\n" + app);
                    }
                }
            }
        };

        timer.schedule(task, 10000, 10000); // Check every 10 seconds
    }
}
