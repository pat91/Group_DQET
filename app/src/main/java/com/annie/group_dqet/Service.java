package com.annie.group_dqet;


public class Service {

    public static final int dbVersion = 3;
    public static final String dbName = "app4";
    public static String tableService = "service";


    public static String columnId = "id";


    public static String columnServiceName = "serviceName";

    public static String columnServiceAmount = "serviceAmount";


    public static String columnServiceInfo = "serviceInfo";



    public static final String createTable ="CREATE TABLE " +tableService+"("
            +columnId+" INTEGER PRIMARY KEY, "
            +columnServiceName+" TEXT, "
            +columnServiceAmount+" INTEGER, "
            +columnServiceInfo+" TEXT )";




    private String serviceName;
    private int serviceAmount;


    public Service(String serviceName, int serviceAmount){
        this.serviceName=serviceName;
        this.serviceAmount=serviceAmount;
    }



    public Service(){


    }


    public String getServiceName(){
        return serviceName;
    }



    public int getServiceAmount(){
        return serviceAmount;
    }

    public void setServiceName(String serviceName){
        this.serviceName=serviceName;
    }


    public void setServiceAmount(int serviceAmount){
        this.serviceAmount=serviceAmount;
    }


    public String getServiceInfo(){
        return serviceName+", "+serviceAmount+"$";
    }


}
