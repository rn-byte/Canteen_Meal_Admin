package com.inim.canteenmealadmin;

public class DataHolder {
    String  name, address,post,email;
    int salary,number;
    DataHolder(){ }

    DataHolder(String name,String address,String  email, int number,String post, int salary){

        this.address = address;
        this.email = email;
        this.name = name;
        this.number = number;
        this.post = post;
        this.salary = salary;
    }

    public String getAddress(){ return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public String getPost() { return post; }
    public void setPost(String post) { this.post = post; }

    public int getSalary() {     return salary; }
    public void setSalary(int salary) {     this.salary = salary; }
}


