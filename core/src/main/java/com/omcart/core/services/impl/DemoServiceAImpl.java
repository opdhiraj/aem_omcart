package com.omcart.core.services.impl;

import com.omcart.core.services.DemoService;
import org.osgi.service.component.annotations.Component;

@Component(service =DemoService.class,immediate = true,name = "serviceA")
public class DemoServiceAImpl implements DemoService {


    @Override
    public String getName() {
        return "dhiraj";
    }

    @Override
    public String getId() {
        return "3748y3487y";
    }
}
