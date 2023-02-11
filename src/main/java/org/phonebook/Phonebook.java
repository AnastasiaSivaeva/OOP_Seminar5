package org.phonebook;

public class Phonebook {
    String Name;
    String Phone;
    String City;

    public Phonebook(String name, String phone, String city){
        this.Name = name;
        this.Phone = phone;
        this.City = city;
    }

    public String getName() {
        return Name;
    }
    public String getPhone() {
        return Phone;
    }
    public String getCity() {
        return City;
    }


}
