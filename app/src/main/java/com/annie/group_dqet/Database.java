package com.annie.group_dqet;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.*;



public class Database extends SQLiteOpenHelper {


    public Database(Context context) {
        super(context, Service.dbName, null,Service.dbVersion);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Service.createTable);
        db.execSQL(ServiceSP.createTableServiceProvider);
        db.execSQL(Availability.createTableEvents);
        db.execSQL(User.createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +Service.tableService);
        db.execSQL("DROP TABLE IF EXISTS " + ServiceSP.tableServiceProvider);
        db.execSQL("DROP TABLE IF EXISTS " + Availability.tableEvents);
        db.execSQL("DROP TABLE IF EXISTS " +User.tableUser);
        onCreate(db);
    }

    public void createService(Service newService){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Service.columnServiceName, newService.getServiceName());
        values.put(Service.columnServiceAmount, newService.getServiceAmount());
        values.put(Service.columnServiceInfo, newService.getServiceInfo());
        db.insert(Service.tableService, null, values);
        db.close();
    }
    public void createServiceSP(ServiceSP newService){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ServiceSP.columnServiceNameSP, newService.getServiceNameSP());
        values.put(ServiceSP.columnServiceAmountSP, newService.getServiceAmountSP());
        values.put(ServiceSP.columnServiceInfoSP, newService.getServiceInfoSP());
        db.insert(ServiceSP.tableServiceProvider, null, values);
        db.close();
    }
    public void createAvailability(Availability availability){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Availability.columnWeek, availability.getWeek());
        values.put(Availability.columnFrom, availability.getFrom());
        values.put(Availability.columnTo, availability.getTo());
        values.put(Availability.columnEventInfo, availability.getEventInfo());
        db.insert(Availability.tableEvents, null, values);
        db.close();
    }


    public Service findService(String serviceName){
        SQLiteDatabase db=this.getReadableDatabase();
        String query= "Select * FROM "
                +Service.tableService
                +" WHERE "
                +Service.columnServiceName
                +" = \""
                +serviceName
                +"\"" ;
        Cursor cursor=db.rawQuery(query, null);
        Service service = new Service();
        if(cursor.moveToFirst()){
            service.setServiceName(cursor.getString(1));
            service.setServiceAmount(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        }
        else service=null;
        db.close();
        return service;
    }
    public ServiceSP findServiceSP(String serviceName){
        SQLiteDatabase db=this.getReadableDatabase();
        String query= "Select * FROM "
                +ServiceSP.tableServiceProvider
                +" WHERE "
                +ServiceSP.columnServiceNameSP
                +" = \""
                +serviceName
                +"\"" ;
        Cursor cursor=db.rawQuery(query, null);
        ServiceSP service = new ServiceSP();
        if(cursor.moveToFirst()){
            service.setServiceNameSP(cursor.getString(1));
            service.setServiceAmountSP(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        }
        else service=null;
        db.close();
        return service;
    }
    public Availability findAvailability(String weekStr){
        SQLiteDatabase db=this.getReadableDatabase();
        String query= "Select * FROM "
                +Availability.tableEvents
                +" WHERE "
                +Availability.columnWeek
                +" = \""
                +weekStr
                +"\"";

        Cursor cursor=db.rawQuery(query, null);
        Availability availability = new Availability();
        if(cursor.moveToFirst()){
            availability.setWeek(cursor.getString(1));
            availability.setFrom(cursor.getString(2));
            availability.setTo(cursor.getString(3));
            cursor.close();
        }
        else availability=null;
        db.close();
        return availability;
    }


    public boolean deleteService(String serviceName){
        SQLiteDatabase db=this.getWritableDatabase();
        boolean result = false;
        String query= "Select * FROM "
                +Service.tableService
                +" WHERE "
                +Service.columnServiceName
                +" = \""
                +serviceName
                +"\"" ;
        Cursor cursor=db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            String id = cursor.getString(0);
            db.delete(Service.tableService, Service.columnId + " = " + id, null);
            cursor.close();
            result=true;
        }
        db.close();
        return result;

    }

    public boolean deleteServiceSP(String serviceName){
        SQLiteDatabase db=this.getWritableDatabase();
        boolean result = false;
        String query= "Select * FROM "
                +ServiceSP.tableServiceProvider
                +" WHERE "
                +ServiceSP.columnServiceNameSP
                +" = \""
                +serviceName
                +"\"" ;
        Cursor cursor=db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            String id = cursor.getString(0);
            db.delete(ServiceSP.tableServiceProvider, ServiceSP.columnIdSP + " = " + id, null);
            cursor.close();
            result=true;
        }
        db.close();
        return result;

    }



    public ArrayList<String> listTable(){

        ArrayList<String> list= new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor  cursor = db.rawQuery("select * FROM "+Service.tableService, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String serviceInfo = cursor.getString(3);
                list.add(serviceInfo);
                cursor.moveToNext();
            }
        }

        return list;

    }
    public ArrayList<String> listTableSP(){

        ArrayList<String> list= new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor  cursor = db.rawQuery("select * FROM "+ServiceSP.tableServiceProvider, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String serviceInfo = cursor.getString(3);
                list.add(serviceInfo);
                cursor.moveToNext();
            }
        }

        return list;

    }
    public ArrayList<String> listTableAvailability(){

        ArrayList<String> list= new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor  cursor = db.rawQuery("select * FROM "+Availability.tableEvents, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String serviceInfo = cursor.getString(4);
                list.add(serviceInfo);
                cursor.moveToNext();
            }
        }

        return list;

    }

    public void createUser(User usr){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(User.columnUserType, usr.getUserType());
        values.put(User.columnUserName, usr.getUserName());
        values.put(User.columnAddress, usr.getAddress());
        values.put(User.columnPassWord, usr.getPassWord());
        values.put(User.columnCompanyName, usr.getCompanyName());
        values.put(User.columnPhoneNumber, usr.getPhoneNumber());
        values.put(User.columnLicence, usr.getLicence());
        values.put(User.columnAddressMail, usr.getAddressMail());
        values.put(User.columnDescription, usr.getDescription());
        db.insert(User.tableUser, null, values);
        db.close();
    }



    public User findUser(String userName){
        SQLiteDatabase db=this.getReadableDatabase();
        String query= "Select * FROM "
                +User.tableUser
                +" WHERE "
                +User.columnUserName
                +" = \""
                +userName
                +"\"" ;
        Cursor cursor=db.rawQuery(query, null);
        User usr = new User();
        if(cursor.moveToFirst()){
            usr.setUserType(cursor.getString(1));
            usr.setUserName(cursor.getString(2));
            usr.setAddress(cursor.getString(3));
            usr.setPassWord(cursor.getString(4));
            usr.setCompanyName(cursor.getString(5));
            usr.setPhoneNumber(Integer.parseInt(cursor.getString(6)));
            usr.setLicence(cursor.getString(7));
            usr.setAddressMail(cursor.getString(8));
            usr.setDescription(cursor.getString(9));
            cursor.close();
        }
        else usr=null;
        db.close();
        return usr;
    }



    public boolean deleteUser(String userName){
        SQLiteDatabase db=this.getWritableDatabase();
        boolean result = false;
        String query= "Select * FROM "
                +User.tableUser
                +" WHERE "
                +User.columnUserName
                +" = \""
                +userName
                +"\"" ;
        Cursor cursor=db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            String id = cursor.getString(0);
            db.delete(User.tableUser, User.columnId + " = " + id, null);
            cursor.close();
            result=true;
        }
        db.close();
        return result;

    }

    public ArrayList<String> listSP(){

        ArrayList<String> list= new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor  cursor = db.rawQuery("select * FROM "+User.tableUser, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                if(cursor.getString(1).equals("serviceProvider")) list.add(cursor.getString(2));
                cursor.moveToNext();
            }
        }

        return list;

    }



}
