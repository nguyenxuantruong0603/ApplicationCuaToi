package com.example.applicationcuatoi.datamodel.user;

public class User {
    private String email;
    private String password;
    private int age;
    private String address;
    private int phoneNumber;
    private String sex;

    //Class DataModel User thiết kế theo Builder Pattern

    public User(final UserBuilder userBuilder) {
        this.email = email;
        this.password = password;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getSex() {
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


}
