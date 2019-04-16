package model;

public class Cliente {
    private String email;
    private String password;
    private String CPF;
    private String name;
    private String gender;
    private String phone;
    private String birthDate;
    
    public Cliente(String email, String password, String CPF, String name,
            String gender, String phone, String birthDate) {
        this.email = email;
        this.password = password;
        this.CPF = CPF;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCPF() {
        return CPF;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
    
    public String getPhone() {
        return phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
