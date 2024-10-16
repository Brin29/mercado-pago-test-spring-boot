package prueba.products.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.util.Arrays;
import java.util.Objects;

@Entity
public class Product {

    private @Id @GeneratedValue Long id;


    private String productName;

    private Long productPrice;

    @Lob // Indicar que es un campo de gran tamaño
    private byte[] image;

    public Product(){

    }

    public Product(String productName, Long productPrice, byte[] image) {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    // Comparar y comprobar que los objetos de la clase son identicos
    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.productName, this.productPrice, Arrays.hashCode(this.image));
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return Objects.equals(this.id, product.id) &&
                Objects.equals(this.productName, product.productName) &&
                Objects.equals(this.productPrice, product.productPrice) &&
                Arrays.equals(this.image, product.image);
    }
}
