package Controller;

import Model.ModelEmployee;

import java.util.ArrayList;

public class ControllerManager {



    private ModelEmployee newEmployee = new ModelEmployee(0,"",0,"",0);
    private ArrayList<ModelEmployee> allEmployee = new ArrayList<>();

    public ControllerManager(ModelEmployee newEmployee, ArrayList<ModelEmployee> allEmployee) {
        this.newEmployee = newEmployee;
        this.allEmployee = allEmployee;
    }


    public ModelEmployee getNewEmployee() { return newEmployee; }
    public void setNewEmployee(ModelEmployee newEmployee) { this.newEmployee = newEmployee; }
    public ArrayList<ModelEmployee> getAllEmployee() { return allEmployee; }
    //public void setAllEmployee(ArrayList<ModelEmployee> allEmployee) { this.allEmployee =
           // allEmployee; }



    public void viewEmployeeList() {
        for (int i = 0; i < getAllEmployee().size(); i++) {
            Scan.output(getAllEmployee().get(i).toString());
        }
    }
    // Method register employee
    public void registerEmployee() {

        newEmployee.setUserId(idGenerator());
        Scan.output("Creating an Employee. Please type the Employee's: ");
        Scan.output("ID: " + newEmployee.getUserId());
        Scan.output("Name:");
        newEmployee.setName(Scan.ScanLine());
        Scan.output("Birth year: ");
        newEmployee.setBirthYear(Scan.ScanInt());
        Scan.ScanLine();
        Scan.output("Address:");
        newEmployee.setAddress(Scan.ScanLine());
        Scan.output("Monthly gross salary:");
        newEmployee.setGrossSalary(Scan.ScanDouble());
        Scan.ScanLine();
        allEmployee.add(newEmployee);
        Scan.output("You have successfully added a new employee: \n" + newEmployee);

    }
    //Method for generating unique ID
    public int idGenerator() {// Hitta en ny Metod:
        int idleId = 1000;

        for (int i = 0; i < allEmployee.size(); i++) { //search through entire arraylist of userDatabase
            if (allEmployee.get(i).getUserId() == idleId) { //when idleId matches with already existing
                // user in userDatabase
                idleId++;
                i = 0; //start at i=0 with new id number
            } else {
                i++; //next index in arraylist
            }
        }
        return idleId;
    }

    //Method remove employee
    public void removeEmployee () {

        Scan.output("Removing employee account \nEnter employee ID: ");
        int idRemoval = Scan.ScanInt();
        Scan.ScanLine();

        boolean isTargetIdFound = false;

        for (int i = 0; i < allEmployee.size() && !isTargetIdFound; i++) { //search though arraylist for...
            if (allEmployee.get(i).getUserId() == idRemoval) { //...account with same userID as the one
                // given by user
                allEmployee.remove(i); // remove when found
                Scan.output("User with ID " + idRemoval + " successfully removed.");
                //... then its removed, let the user know
                isTargetIdFound = true;
            }
        }
        if (!isTargetIdFound){
            Scan.output("Employee with ID " + idRemoval + " not found");
        }
    }


    public void employeeNetSalary() {


        Scan.output("Please type your employees name:");
        String name = Scan.ScanLine();

        Scan.output("Please type hours worked in a year:");
        double hPerYear = Scan.ScanDouble(); // declare and store value from numbers, maybe decimal

        Scan.output("Please enter hourly pay rate SEK:");
        double hPayRate = Scan.ScanDouble();
        Scan.ScanLine();

        double grossPay = hPayRate * hPerYear;
        double netSalaryOver100 = (grossPay * (0.7));

        if (grossPay <= 100000) {
            Scan.output("Gross Pay is less than 100.000 SEK per year, therefore the Net Salary is: " + grossPay + " SEK");
        } else {
            Scan.output("Gross Pay is more than 100.000 SEK per year and the Net Salary is: " + (netSalaryOver100) + " SEK");
        }

    }

    public void employeeBonus() {

        Scan.output("What is the employee's age?  ");

        double age = Scan.ScanInt(); // it will come directly from getAge method.
        int bonusPac1 = 4000;
        int bonusPac2 = 6000;
        int bonusPac3 = 7500;

        if (age < 22) {
            Scan.output("The employee's bonus salary is " + bonusPac1 + " SEK.");
        } else if (age >= 22 && age <= 30) {
            Scan.output("The employee's bonus salary is " + bonusPac2 + " SEK.");
        } else {
            Scan.output("The employee's bonus salary is " + bonusPac3 + " SEK.");
        }
    }


}
