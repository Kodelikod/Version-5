package Model;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

    public class ModelEmployee {

        //attributes
        private int userId;
        private String name;
        private int birthYear;
        private String address;
        private double grossSalary;

        public ModelEmployee (int userId, String name, int birthYear, String address, double grossSalary) {
            this.userId = userId;
            this.name = name;
            this.birthYear = birthYear;
            this.address = address;
            this.grossSalary = grossSalary;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBirthYear() {
            return birthYear;
        }

        public void setBirthYear(int birthYear) {
            this.birthYear = birthYear;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) { this.address = address;
        }

        public double getGrossSalary() {
            return grossSalary;
        }

        public void setGrossSalary(double grossSalary) {
            this.grossSalary = grossSalary;
        }


        public int getAge(int birthYear){ //https://youtu.be/6cp4P4XZ9hE
            Date currentDate = new Date(); // created new object currentDate from imported class Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");       //imported
            // SimpleDateFormat package for getting current year
            int currentYear = Integer.parseInt(dateFormat.format(currentDate));       //previous line gives current year in variable type string, used Integer.parseInt to turn string into int

            int age = currentYear - birthYear;

            return age;
        }

        @Override
        public String toString() {
            return "Employee name: " + name +
                    "\nUser ID: " + userId +
                    "\nBirth year: " + birthYear + " (age: " + getAge(birthYear) +
                    ")\nAddress: " + address +
                    "\nMonthly gross salary: " + grossSalary + " SEK";
        }
    }
