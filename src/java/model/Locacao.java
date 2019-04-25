package model;

public class Locacao {
    private String ID;
    private String CNPJ;
    private String CPF;
    private String rentDate;
    
    public Locacao(String ID, String CNPJ, String CPF, String rentDate) {
        this.ID = ID;
        this.CNPJ = CNPJ;
        this.CPF = CPF;
        this.rentDate = rentDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getCPF() {
        return CPF;
    }

    public String getRentDate() {
        return rentDate;
    }

}
