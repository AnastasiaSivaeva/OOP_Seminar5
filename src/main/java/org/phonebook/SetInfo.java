package org.phonebook;

public class SetInfo extends Phonebook {
    public SetInfo(String name, String phone, String city) {
        super(name, phone, city);
    }

    public void setName(String name) {
        Name = name;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public void setCity(String city) {
        City = city;
    }
}
