package com.bigmacdev.pharmacy_app;


import java.io.Serializable;

public class Perscription implements Serializable{
    private static final long serialVersionUID = 454690L;
    private String patientLastName, patientFirstName, drugId, perscriberName, scriptWrittenDate, scriptNumber, quantity;
    private int timeDue, timeLeft;
    private MyTime time;

    Perscription(String patientLastName, String patientFirstName, String drugId,String perscriberName,String scriptWrittenDate,String scriptNumber,String quantity, int timeDue){
        this.drugId=drugId;
        this.patientLastName=patientLastName;
        this.patientFirstName=patientFirstName;
        this.perscriberName=perscriberName;
        this.quantity=quantity;
        this.scriptWrittenDate=scriptWrittenDate;
        this.scriptNumber=scriptNumber;
        this.timeDue=timeDue;
        time = new MyTime();
        time.addMinutes(timeDue);
        updateTimeDue();
    }

    public void updateTimeDue(){
        MyTime current = new MyTime();
        timeLeft = time.getMinutes()-current.getMinutes();
    }

    public int getTimeLeft(){
        return timeLeft;
    }


    public String getPatientLastName() {
        return patientLastName;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public void setPatientLastName(String patientName) {
        this.patientLastName = patientName;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getPerscriberName() {
        return perscriberName;
    }

    public void setPerscriberName(String perscriberName) {
        this.perscriberName = perscriberName;
    }

    public String getScriptWrittenDate() {
        return scriptWrittenDate;
    }

    public void setScriptWrittenDate(String scriptWrittenDate) {
        this.scriptWrittenDate = scriptWrittenDate;
    }

    public String getScriptNumber() {
        return scriptNumber;
    }

    public void setScriptNumber(String scriptNumber) {
        this.scriptNumber = scriptNumber;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getTimeDue() {
        return timeDue;
    }

    public void setTimeDue(int timeDue) {
        this.timeDue = timeDue;
    }
}
