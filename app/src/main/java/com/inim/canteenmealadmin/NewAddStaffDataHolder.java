package com.inim.canteenmealadmin;

public class NewAddStaffDataHolder {

    String fN,address,user,lN,email,post;
    int salary;
    double phone;

    NewAddStaffDataHolder(){}

    NewAddStaffDataHolder(String fN,String address,String user,String lN,String email,String post,double phone, int salary){
        this.fN=fN;
        this.address=address;
        this.user=user;
        this.lN=lN;
        this.email=email;
        this.post=post;
        this.phone=phone;
        this.salary=salary;
    }

    public void setFn(String fN) {
        this.fN = fN;
    }

    public String getFn() {
        return fN;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setlN(String lN) {
        this.lN = lN;
    }

    public String getlN() {
        return lN;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public double getPhone() {
        return phone;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}
