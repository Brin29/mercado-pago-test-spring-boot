package prueba.products.Dto;

import java.math.BigDecimal;

public class PreferenceDTO {

    private String title;
    private String description;
    private String pictureUrl;
    private String categoryId;
    private int quantity;
    private String currencyId;
    private BigDecimal unitPrice;

    public PreferenceDTO(String description, String pictureUrl, String categoryId, int quantity, String currencyId, BigDecimal unitPrice) {
        this.description = description;
        this.pictureUrl = pictureUrl;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.currencyId = currencyId;
        this.unitPrice = unitPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
