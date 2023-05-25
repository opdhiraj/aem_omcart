package com.omcart.core.models.impl;

import com.omcart.core.models.BasicDetails;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.inject.Inject;


@Model(adaptables = SlingHttpServletRequest.class,adapters = BasicDetails.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class BasicDetailsImpl implements BasicDetails {


    @Inject
    @Optional
   private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
