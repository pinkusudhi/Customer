package com.example.Customer.Customer.Constant;

public class Constant {

    public static final String post="/save";

    public static final String get ="/Customer/{customerId}";

    public static final String getAll= "/getAllcustomer";

    public static final String updateCustomer="/updatecustomer/{id}";

    public static final String deleteCustomer="/deletecustomer/{id}";

    public static final String CreateCustomerAddress="/createCustomerAddress";

    public static final String GetcustomerAddressbyId="/customerAddressEntity/{id}";

    public static final String UpdatecustomerAddressbyId = "updateCustomerAddress/{id}";

    public static final String deleteCustomerAddress = "deleteCustomerAddress/{id}";

    public static final String getCustomerByfullname = "getCustomerByfullname/{fullName}";

    public static final String getCustomerAddressByPostalcode = "getCustomerAddressByPostalcode/{postalCode}";

    public static final String createCustomerIdentification = "/createCustomerIdentification";

    public static final String getAllCustomerIdentification ="getAllCustomerIdentification";

    public static final String deleteCustomerIdentificationByid="deleteCustomerIdentificationByid/{id}";

    public static final String getCustomerIdentificationById = "getCustomerIdentificationById/{id}";

    public static final String updateCustomerIdentificationById ="updateCustomerIdentificationById/{id}";
}
