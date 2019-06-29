package edu.mum.cs544;

import javax.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;
    private String appdate;


    @OneToOne(cascade = CascadeType.ALL)
    private Patient patient;

    @OneToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

    @Embedded
    private Payment payment;


    public Appointment(){}

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment(String appdate, Patient patient, Doctor doctor, Payment payment) {
        this.appdate = appdate;
        this.patient = patient;
        this.doctor = doctor;
        this.payment = payment;
    }

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }




    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
