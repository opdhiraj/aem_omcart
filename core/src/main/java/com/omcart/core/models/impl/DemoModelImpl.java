package com.omcart.core.models.impl;

import com.omcart.core.models.DemoModel;
import com.omcart.core.services.DemoService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = SlingHttpServletRequest.class,adapters = DemoModel.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class DemoModelImpl implements DemoModel {

    @OSGiService
    DemoService service;


    @Override
    public String getName() {
        return service.getName();
    }

    @Override
    public String getId() {
        return service.getId();
    }
}
