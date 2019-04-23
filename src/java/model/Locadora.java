package model;

public class Locadora {

    private String email;
    private String password;
    private String CNPJ;
    private String name;
    private String city;

    public Locadora(String email, String password, String CNPJ, String name,
            String city) {
        this.email = email;
        this.password = password;
        this.CNPJ = CNPJ;
        this.name = name;
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
