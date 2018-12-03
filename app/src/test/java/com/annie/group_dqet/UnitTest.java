package com.annie.group_dqet;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class UnitTest {

    @Test
    public void checkServiceName() { 
     Service service = new Service("cleaning", 123);
     assertEquals("Check the name of the service", "cleaning", service.getServiceName());
    }

    @Test
    public void checkServiceAmount() {
     Service service = new Service("cleaning", 123);
     assertEquals("Check the amount of the service", "123",  Integer.toString(service.getServiceAmount()));
    }

    @Test
    public void checkUsername() {
     User user = new User("owner","pat","123 main str","psswrd","clean&co",4517,"yes","p@g.ca","cleaning");
     assertEquals("Check username","pat",user.getUserName());
    }

    @Test
    public void checkUserType() {
     User user = new User("owner","pat","123 main str","psswrd","clean&co",4517,"yes","p@g.ca","cleaning");
     assertEquals("Check user type","owner",user.getUserType());
    }

    @Test
    public void checkUserAddress() {
     User user = new User("owner","pat","123 main str","psswrd","clean&co",4517,"yes","p@g.ca","cleaning");
     assertEquals("Check user address","123 main str",user.getAddress());
    }


    @Test
    public void checkUserPassword() {
     User user = new User("owner","pat","123 main str","psswrd","clean&co",4517,"yes","p@g.ca","cleaning");
     assertEquals("Check user password","psswrd",user.getPassWord());
    }


    @Test
    public void checkUserLicence() {
     User user = new User("owner","pat","123 main str","psswrd","clean&co",4517,"yes","p@g.ca","cleaning");
     assertEquals("Check company licence","yes",user.getLicence());
    }


    @Test
    public void checkUserDescription() {
     User user = new User("owner","pat","123 main str","psswrd","clean&co",4517,"yes","p@g.ca","cleaning");
     assertEquals("Check company description","cleaning",user.getDescription());
    }

   
    @Test
    public void checkUserPhoneNumber() {
     User user = new User("owner","pat","123 main str","psswrd","clean&co",4517,"yes","p@g.ca","cleaning");
     assertEquals("Check phone number","4517",Integer.toString(user.getPhoneNumber())); 
    }


    @Test
    public void checkCompanyName() {
     User user = new User("owner","pat","123 main str","psswrd","clean&co",4517,"yes","p@g.ca","cleaning");
     assertEquals("Check company name","clean&co",user.getCompanyName());
    }




}
