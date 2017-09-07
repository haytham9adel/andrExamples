package com.example.andr.andr_example.model;

/**
 * Created by dev-haytham on 9/7/2017.
 */


public class UserModel {

    Long id ;
    String name ;
    String address ;

    public UserModel(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
