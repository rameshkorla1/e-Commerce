package testDataTypes;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class UserSignUp {

private String customerfirstName;
private String customerlastName;
private String password;
private String firstName;
private String lastName;
private String company;
private String address;
private String city;
private String state;
private String postcode;
private String country;
private String phone;
private String alias;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getCustomerfirstName() {
return customerfirstName;
}

public void setCustomerfirstName(String customerfirstName) {
this.customerfirstName = customerfirstName;
}

public String getCustomerlastName() {
return customerlastName;
}

public void setCustomerlastName(String customerlastName) {
this.customerlastName = customerlastName;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

public String getCompany() {
return company;
}

public void setCompany(String company) {
this.company = company;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getState() {
return state;
}

public void setState(String state) {
this.state = state;
}

public String getPostcode() {
return postcode;
}

public void setPostcode(String postcode) {
this.postcode = postcode;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public String getPhone() {
return phone;
}

public void setPhone(String phone) {
this.phone = phone;
}

public String getAlias() {
return alias;
}

public void setAlias(String alias) {
this.alias = alias;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
