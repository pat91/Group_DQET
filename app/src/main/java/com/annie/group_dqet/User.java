package com.annie.group_dqet;

public class User{

    public static String tableUser = "user";
    public static String columnId = "id";
    public static String columnUserType = "userType";
    public static String columnUserName = "userName";
    public static String columnAddress = "adress";
    public static String columnPassWord = "userPassWord";
    public static String columnCompanyName= "companyName";
    public static String columnPhoneNumber= "phoneNumber";
    public static String columnLicence= "licence";
    public static String columnAddressMail = "adressMail";
    public static String columnDescription = "description";


    public static final String createTable ="CREATE TABLE " +tableUser+"("
            +columnId+" INTEGER PRIMARY KEY, "
            +columnUserType+" TEXT, "
            +columnUserName+" TEXT, "
            +columnAddress+" TEXT, "
            +columnPassWord+" TEXT, "
            +columnCompanyName+" TEXT, "
            +columnPhoneNumber+" INTEGER, "
            +columnLicence+" TEXT, "
            +columnAddressMail+" TEXT, "
            +columnDescription+" TEXT)";


    private String userType;
    private String userName;
    private String address;
    private String passWord;
    private String companyName;
    private int phoneNumber;
    private String licence;
    private String addressMail;
    private String description;


    public User(String userType, String userName, String address, String passWord, String companyName, int phoneNumber, String licence, String addressMail, String description){

        this.userType = userType;
        this.userName = userName;
        this.address = address;
        this.passWord = passWord;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.licence = licence;
        this.addressMail = addressMail;
        this.description = description;

    }


    public User(){

    }


    public String getUserType(){
        return userType;
    }

    public String getUserName(){
        return userName;
    }

    public String getAddress(){
        return address;
    }

    public String getPassWord(){
        return passWord;
    }

    public String getCompanyName(){
        return companyName;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }


    public String getLicence(){
        return licence;
    }


    public String getAddressMail(){
        return addressMail;
    }


    public String getDescription(){
        return description;
    }


    //-----------------------------------------------



    public void setUserType(String userType){
        this.userType=userType;
    }


    public void setUserName(String userName){
        this.userName=userName;
    }


    public void setAddress(String address){
        this.address = address;
    }


    public void setPassWord(String passWord){
        this.passWord=passWord;
    }


    public void setCompanyName(String companyName){
        this.companyName=companyName;
    }


    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber=phoneNumber;
    }


    public void setLicence(String licence){
        this.licence=licence;
    }


    public void setAddressMail(String addressMail){
        this.addressMail=addressMail;
    }


    public void setDescription(String description){
        this.description=description;
    }



}
