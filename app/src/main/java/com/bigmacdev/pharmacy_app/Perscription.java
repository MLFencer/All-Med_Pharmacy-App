package com.bigmacdev.pharmacy_app;


import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Perscription {
    private String patientName, drugId, perscriberName, scriptWrittenDate, scriptNumber, quantity;
    private int timeDue;
    private MyTime time;

    Perscription(String patientName,String drugId,String perscriberName,String scriptWrittenDate,String scriptNumber,String quantity, int timeDue){
        this.drugId=drugId;
        this.patientName=patientName;
        this.perscriberName=perscriberName;
        this.quantity=quantity;
        this.scriptWrittenDate=scriptWrittenDate;
        this.scriptNumber=scriptNumber;
        this.timeDue=timeDue;
        time = new MyTime();
        time.addMinutes(timeDue);
    }



    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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
