package isurucuma.learn.entities.keys;

import jakarta.persistence.Id;

import java.io.Serializable;

public class ProductKey implements Serializable {

    private String code;

    private String number;

    public ProductKey(String number, String code) {
        this.number = number;
        this.code = code;
    }

    public ProductKey() {}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ProductKey{" +
                "code='" + code + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
