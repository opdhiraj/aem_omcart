package com.omcart.core.services.impl;

import com.omcart.core.services.PracticeService;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Component(service = PracticeService.class)

    
public class PracticeServiceImpl implements PracticeService {
    
    @Reference
    ResourceResolverFactory resolverFactory;
    private  final Logger logger= LoggerFactory.getLogger(PracticeServiceImpl.class);

    
    @Override
    public ResourceResolver getResourceResolver() {
        ResourceResolver resolver=null;
        Map<String, Object> param = getServiceParams();
        try {
            resolver=resolverFactory.getServiceResourceResolver(param);
        } catch (LoginException e) {
           
            e.printStackTrace();
        }
        return resolver;
    }


    private static Map<String, Object> getServiceParams() {
        Map<String, Object>param= new HashMap<>();
        param.put(ResourceResolverFactory.SUBSERVICE,"omcartserviceuser");
        return param;
    }
   
    
}
