package com.omcart.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AssetServletModel {

    private  static  final Logger LOGGER= LoggerFactory.getLogger(AssetServletModel.class);


    @PostConstruct
    protected void init(){
        LOGGER.debug("AssetServletModel------->");
    }

}
