package com.annie.group_dqet;

public class Availability {

    public static  String tableEvents = "event";
    public static String columnIdEvent = "idEvent";
    public static String columnWeek = "week";
    public static String columnFrom = "fromAvailability";
    public static String columnTo = "toAvailability";
    public static String columnEventInfo = "eventInfo";


    public static final String createTableEvents ="CREATE TABLE " + tableEvents+"("
            +columnIdEvent+" INTEGER PRIMARY KEY, "
            +columnWeek+" TEXT, "
            +columnFrom+" TEXT, "
            +columnTo+" TEXT, "
            +columnEventInfo+" TEXT "+ ")";


    private String week;
    private String from;
    private String to;


    public Availability(String week, String from, String to){
        this.week =week;
        this.from = from;
        this.to = to;
    }



    public Availability(){


    }


    public String getWeek(){
        return week;
    }



    public String getFrom(){
        return from;
    }

    public String getTo(){
        return to;
    }

    public void setWeek(String week){
        this.week = week;
    }


    public void setFrom(String from){
        this.from = from;
    }


    public String setTo(String to){
        return this.to = to;
    }

    public String getEventInfo(){
        return week + ":" + "\n" + "From: " + from + "\n" +"to: " +to;
    }


}
