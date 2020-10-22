package com.thinking.in.spring.ioc.overview.domain;


import com.thinking.in.spring.ioc.overview.annotation.Supper;

@Supper
public class SupperUser extends  User {


    private  String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SupperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
