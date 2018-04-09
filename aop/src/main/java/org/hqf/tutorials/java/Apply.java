package org.hqf.tutorials.java;

import java.util.Date;

public class Apply {
    private int empId;
    private int orderId;
    private String phone;
    private Date appointmentTime;

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "empId=" + empId +
                ", orderId=" + orderId +
                ", phone='" + phone + '\'' +
                ", appointmentTime=" + appointmentTime +
                '}';
    }
}
