package com.packtpub.adfguide.ch11.view.general;

public class ErrorPageBean {
    private String errorMsg;
    public ErrorPageBean() {
        System.out.println("ErrorPageBean ");
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
