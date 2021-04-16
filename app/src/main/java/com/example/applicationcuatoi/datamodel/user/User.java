package com.example.applicationcuatoi.datamodel.user;

import android.util.Patterns;

public class User {
    private String email;
    private String password;
    private int age;
    private String address;
    private int phoneNumber;
    private String sex;

    //Class DataModel User Design according Builder Pattern
    public User(final UserBuilder userBuilder) {
        this.email = userBuilder.email;
        this.password = userBuilder.password;
        this.age = userBuilder.age;
        this.address = userBuilder.address;
        this.phoneNumber = userBuilder.phoneNumber;
        this.sex = userBuilder.sex;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public String getEmail() {
        if (email == null) {
            return "";
        }
        return email;
    }

    public String getPassword() {
        if (password == null) {
            return "";
        }
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        if (address == null) {
            return "";
        }
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getSex() {
        if (sex == null) {
            return "";
        }
        return sex;
    }

    public static class UserBuilder {
        private String email;
        private String password;
        private int age;
        private String address;
        private int phoneNumber;
        private String sex;

        public UserBuilder setEmail(final String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setpassword(final String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setAge(final int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setAdress(final String address) {
            this.address = address;
            return this;
        }

        public UserBuilder setPhoneNumber(final int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder setSex(final String sex) {
            this.sex = sex;
            return this;
        }

        public User createUser() {
            return new User(this);
        }
    }

//    public boolean isEmailValid() {
//        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
//    }
//
//    public boolean isPasswordValid() {
//        return getPassword().length() > 6;
//    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", sex='" + sex + '\'' +
                '}';
    }
}
