package prueba.products.Entity;


import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    private @Id @GeneratedValue Long id;


    private String productName;

    private Long productPrice;

    @Lob // Indicar que es un campo de gran tamaño
    private String image;

    public Product(){

    }

    public Product(String productName, Long productPrice, String image) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.image = image;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // Comparar y comprobar que los objetos de la clase son identicos
    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.productName, this.productPrice, this.image);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return Objects.equals(this.id, product.id) &&
                Objects.equals(this.productName, product.productName) &&
                Objects.equals(this.productPrice, product.productPrice) &&
                Objects.equals(this.image, product.image);
    }
}
