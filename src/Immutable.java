/*
 * class - final
 * variables - private, final
 * deep copy in constructor
 * no setters
 * getters - don't return actual references, return temporary objects
 */
public class Immutable {
    public static void main(String[] args) {
        Address address = new Address("Patna", "Bihar");
        UserDetails userDetails = new UserDetails("Bhaskar Sharan", address);
        System.out.println(userDetails);
        // try to mutate the object
        Address tmp = userDetails.getAddress();
        tmp.setCity("Bihta");
        System.out.println(userDetails);
    }
}
// Immutable class
// 1. final class
final class UserDetails{
    // 2. private final variables
    private final String name;
    private final Address address;
    UserDetails(String name, Address address){
        this.name = name;
        // deepCopy in constructor
        Address deepCopy = new Address(address.getCity(), address.getState());
        this.address = deepCopy;
    }
    // 3. No setters
    public String getName() {
        return name;
    }
    // 4. Getters return temporary objects for complex classes instead of returning actual reference
    public Address getAddress() {
        //return address;
        return new Address(address.getCity(), address.getState());
    }
    @Override
    public String toString() {
        return "UserDetails [name=" + name + ", address=" + address + "]";
    }
}
class Address{
    private String city;
    private String state;
    Address(){}
    Address(String city, String state){
        this.city = city;
        this.state = state;
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
    @Override
    public String toString() {
        return "Address [city=" + city + ", state=" + state + "]";
    }
}
// output
// UserDetails [name=Bhaskar Sharan, address=Address [city=Patna, state=Bihar]]
// UserDetails[name=Bhaskar Sharan, address=Address [city=Patna, state=Bihar]]