package com.annie.group_dqet;

public class ServiceSP {


    public static  String tableServiceProvider = "serviceProvider";
    public static String columnIdSP = "idServiceProvider";
    public static String columnServiceNameSP = "serviceNameSP";
    public static String columnServiceAmountSP = "serviceAmountSP";
    public static String columnServiceInfoSP = "serviceInfoSP";


    public static final String createTableServiceProvider ="CREATE TABLE " +tableServiceProvider+"("
            +columnIdSP+" INTEGER PRIMARY KEY, "
            +columnServiceNameSP+" TEXT, "
            +columnServiceAmountSP+" INTEGER, "
            +columnServiceInfoSP+" TEXT )";


    private String serviceNameSP;
    private int serviceAmountSP;


    public ServiceSP(String serviceNameSP, int serviceAmountSP){
        this.serviceNameSP=serviceNameSP;
        this.serviceAmountSP=serviceAmountSP;
    }



    public ServiceSP(){


    }


    public String getServiceNameSP(){
        return serviceNameSP;
    }



    public int getServiceAmountSP(){
        return serviceAmountSP;
    }

    public void setServiceNameSP(String serviceNameSP){
        this.serviceNameSP=serviceNameSP;
    }


    public void setServiceAmountSP(int serviceAmountSP){
        this.serviceAmountSP=serviceAmountSP;
    }


    public String getServiceInfoSP(){
        return serviceNameSP+", "+serviceAmountSP+"$";
    }


}

