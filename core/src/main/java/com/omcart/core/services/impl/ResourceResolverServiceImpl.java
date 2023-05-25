package com.omcart.core.services.impl;

import com.omcart.core.services.ResourceResolverService;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.omcart.core.constant.AppConstants.SUB_SERVICE;

@Component(
        service = ResourceResolverService.class,
        property = {
                Constants.SERVICE_ID + "= omcart Resource Resolver Service",
                Constants.SERVICE_DESCRIPTION + "= This service is responsible for returning an instance of ResourceResolver"
        })

public class ResourceResolverServiceImpl implements ResourceResolverService {

       private static final String TAG = ResourceResolverServiceImpl.class.getSimpleName();
       // private static final String SYSTEM_USER = "omcart_service";
        private static final Logger LOGGER = LoggerFactory.getLogger(ResourceResolverServiceImpl.class);

        @Reference
        ResourceResolverFactory resourceResolverFactory;

        private ResourceResolver resourceResolver;

        @Activate
        protected void activate() {
                try {
                        // Service User map
                        Map<String, Object> serviceUserMap = new HashMap<>();
                        // Putting sub-service name in the map
                        serviceUserMap.put(ResourceResolverFactory.SUBSERVICE, SUB_SERVICE);
                        // Get the instance of Service Resource Resolver
                        resourceResolver = resourceResolverFactory.getServiceResourceResolver(serviceUserMap);
                        LOGGER.debug("resourceResolver 46 {}",resourceResolver.getUserID());

                } catch (LoginException e) {
                        LOGGER.error("{}: Exception occurred while getting resource resolver: {}",  e.getMessage());
                }
        }

        @Override
        public ResourceResolver getResourceResolver() {
                return resourceResolver;
        }
}
