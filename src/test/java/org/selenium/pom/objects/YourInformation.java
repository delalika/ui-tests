package org.selenium.pom.objects;

public class YourInformation {
    private String firstName;
    private String lastName;
    private String zipPostalCode;

    public YourInformation(){}
    public YourInformation(String firstName, String lastName, String zipPostalCode){
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipPostalCode = zipPostalCode;
    }

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getZipPostalCode() { return this.zipPostalCode; }
}
