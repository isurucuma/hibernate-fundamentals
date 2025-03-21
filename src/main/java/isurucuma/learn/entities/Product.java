package isurucuma.learn.entities;

import isurucuma.learn.entities.keys.ProductKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(ProductKey.class)
public class Product {

    @Id
    private String code;
    @Id
    private String number;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" + "code='" + code + '\'' + ", number='" + number + '\'' + ", name='" + name + '\'' + '}';
    }
}
