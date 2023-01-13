package lt.ornetas.jdbc;

public class Customer {
    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String city;
    private String country;

    public Customer(int customerNumber, String customerName) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
    }

    public Customer(int customerNumber, String customerName, String phone, String city) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.phone = phone;
        this.city = city;
    }

    public Customer(int customerNumber,
                    String customerName,
                    String contactLastName,
                    String contactFirstName,
                    String phone,
                    String addressLine1,
                    String city,
                    String country) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.country = country;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getCountry() {
        return country;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "{" +
                "Id: " + customerNumber +
                ", Name: " + customerName + '\'' +
                ", phone:'" + phone + '\'' +
                ", city: '" + city + '\'' +
                '}';
    }
}
