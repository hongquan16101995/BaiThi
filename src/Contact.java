public class Contact {
    private String phonenumber;
    private String group;
    private String name;
    private String render;
    private String address;
    private String dateofbirth;
    private String email;

    public Contact(String phonenumber, String group, String name, String render, String address, String dateofbirth, String email) {
        this.phonenumber = phonenumber;
        this.group = group;
        this.name = name;
        this.render = render;
        this.address = address;
        this.dateofbirth = dateofbirth;
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRender() {
        return render;
    }

    public void setRender(String render) {
        this.render = render;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phonenumber = " + phonenumber +
                ", group = '" + group + '\'' +
                ", name = '" + name + '\'' +
                ", render = '" + render + '\'' +
                ", address = '" + address + '\'' +
                '}';
    }
}
