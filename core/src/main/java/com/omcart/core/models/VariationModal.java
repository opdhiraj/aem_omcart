package com.omcart.core.models;

public class VariationModal {

    public String variationName;
    public String variationColor;
    public Double variationPrice;

    public String getVariationName() {
        return variationName;
    }

    public String getVariationColor() {
        return variationColor;
    }

    public Double getVariationPrice() {
        return variationPrice;
    }

    public void setVariationName(String variationName) {
        this.variationName = variationName;
    }

    public void setVariationColor(String variationColor) {
        this.variationColor = variationColor;
    }

    public void setVariationPrice(Double variationPrice) {
        this.variationPrice = variationPrice;
    }
}
