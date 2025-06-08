import java.time.LocalDateTime;
import java.util.Scanner;

public class CommuneAppointmentAPI {
    public static void main(String[] args) {
        System.out.println("Welcome to Commune Appointment System!");

        // Start notification service
        AppointmentService.startNotificationService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n 1 Book Appointment \n 2 View All Appointments \n 3 Get Appointment Details \n 4 Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print(" Enter service name (e.g., Residency Permit, Passport Renewal): ");
                String serviceName = scanner.nextLine();
                System.out.print(" Enter resident name: ");
                String residentName = scanner.nextLine();
                System.out.print(" Enter appointment date & time (yyyy-MM-dd HH:mm): ");
                String appointmentTimeInput = scanner.nextLine();
                LocalDateTime appointmentTime = LocalDateTime.parse(appointmentTimeInput.replace(" ", "T")); // Parse input

                Appointment appointment = AppointmentService.addAppointment(serviceName, residentName, appointmentTime);
                System.out.println("\n Appointment Successfully Booked! \n" + appointment);

            } else if (choice == 2) {
                System.out.println("\n All Appointments:");
                for (Appointment app : AppointmentService.getAllAppointments()) {
                    System.out.println(app);
                }

            } else if (choice == 3) {
                System.out.print("Enter Appointment ID:");
                int id = scanner.nextInt();
                Appointment app = AppointmentService.getAppointmentById(id);
                System.out.println(app != null ? app : "Appointment not found!");

            } else if (choice == 4) {
                System.out.println("\n Exiting Commune Appointment System");
                break;
            }
        }
        scanner.close();
    }
}
