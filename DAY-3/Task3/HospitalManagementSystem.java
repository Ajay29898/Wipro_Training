// Hospital Management System  provides functionality for managing patients, doctors, and appointments. Users can add patients and doctors, 
// schedule appointments, and view appointment details.The system is structured around three main classes: Patient, Doctor, and Appointment, 
// with a management class HospitalManagementSystem that ties them together.

import java.util.ArrayList;
import java.util.Scanner;

class Patient        // Represents a patient in the hospital system.
{
    String patientId;
    String name;
    int age;
    String ailment;

    public Patient(String patientId, String name, int age, String ailment) 
    {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
    }

    @Override
    public String toString() 
    {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Ailment: " + ailment;
    }
}

class Doctor         // Represents a doctor in the hospital system.
{
    String doctorId;
    String name;
    String specialization;

    public Doctor(String doctorId, String name, String specialization) 
    {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() 
    {
        return "Doctor ID: " + doctorId + ", Name: " + name + ", Specialization: " + specialization;
    }
}

class Appointment             // Represents an appointment between a patient and a doctor on a specific date.
{
    Patient patient;
    Doctor doctor;
    String date;

    public Appointment(Patient patient, Doctor doctor, String date) 
    {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    @Override
    public String toString() 
    {
        return "Appointment Details: \n" +
               "Patient: " + patient.name + " (" + patient.patientId + ")\n" +
               "Doctor: " + doctor.name + " (" + doctor.specialization + ")\n" +
               "Date: " + date;
    }
}

public class HospitalManagementSystem     // This class serves as the backbone of the program, managing the main operations.
{
    ArrayList<Patient> patients = new ArrayList<>();                 //  A list of registered patients
    ArrayList<Doctor> doctors = new ArrayList<>();                   //   A list of registered doctors
    ArrayList<Appointment> appointments = new ArrayList<>();         //   A list of scheduled appointments
    Scanner scanner = new Scanner(System.in);

    public void addPatient()            //  Prompts the user to enter patient details and adds the patient to the patients list
    {
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Patient Ailment: ");
        String ailment = scanner.nextLine();

        patients.add(new Patient(patientId, name, age, ailment));
        System.out.println("Patient added successfully.");
    }

    public void addDoctor()             // Prompts the user to enter doctor details and adds the doctor to the doctors list.
    {
        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Doctor Specialization: ");
        String specialization = scanner.nextLine();

        doctors.add(new Doctor(doctorId, name, specialization));
        System.out.println("Doctor added successfully.");
    }

    // Prompts for a patient ID and doctor ID.Validates both IDs using the findPatient() and findDoctor() methods.
    //If valid, schedules an appointment and adds it to the appointments list

    public void scheduleAppointment()  
    {
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        Patient patient = findPatient(patientId);

        if (patient == null) 
        {
            System.out.println("Invalid Patient ID. Appointment not scheduled.");
            return;
        }

        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();
        Doctor doctor = findDoctor(doctorId);

        if (doctor == null) 
        {
            System.out.println("Invalid Doctor ID. Appointment not scheduled.");
            return;
        }

        System.out.print("Enter Appointment Date (e.g., YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Appointment appointment =new Appointment(patient, doctor, date);
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully.");
    }

    public Patient findPatient(String patientId) 
    {
        for (Patient patient : patients) {
            if (patient.patientId.equals(patientId)) 
            {
                return patient;
            }
        }
        return null;
    }

    public Doctor findDoctor(String doctorId) 
    {
        for (Doctor doctor : doctors) 
        {
            if (doctor.doctorId.equals(doctorId)) 
            {
                return doctor;
            }
        }
        return null;
    }

    public void viewAppointments() 
    {
        if (appointments.isEmpty()) 
        {
            System.out.println("No appointments scheduled.");
        } 
        else 
        {
            for (Appointment appointment : appointments) 
            {
                System.out.println(appointment);
                System.out.println("-------------");
            }
        }
    }

    public void menu() 
    {
        int choice;
        do 
        {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
            {
                case 1 -> addPatient();
                case 2 -> addDoctor();
                case 3 -> scheduleAppointment();
                case 4 -> viewAppointments();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } 
        while (choice != 5);
    }

    public static void main(String[] args) 
    {
        HospitalManagementSystem hms = new HospitalManagementSystem();
        hms.menu();
    }
}

