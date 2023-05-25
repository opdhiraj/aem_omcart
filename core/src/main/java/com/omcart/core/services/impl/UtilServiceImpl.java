package com.omcart.core.services.impl;

import com.omcart.core.services.ResourceResolverService;
import com.omcart.core.services.UtilService;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.settings.SlingSettingsService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = UtilService.class,
        immediate = true,
        name = "UtilService"
)
public class UtilServiceImpl implements UtilService {
    private static final Logger LOG = LoggerFactory.getLogger(UtilServiceImpl.class);

    @Reference
    ResourceResolverService resourceResolverService;

    @Reference
    SlingSettingsService slingSettingsService;

    @Override
    public String getActionURL(Resource resource) {
        String actionURL= StringUtils.EMPTY;
        try {
            ResourceResolver resourceResolver=resourceResolverService.getResourceResolver();
            String actionType=resource.getValueMap().get("actionType",String.class);
            String selector=resourceResolver.getResource(actionType).getValueMap().get("selector",String.class);
            actionURL=resource.getPath()+"."+selector+".json";
        }catch (Exception e){
            LOG.info("\n Error while getting Action URL - {} ",e.getMessage());
        }

        return actionURL;
    }
//
//    @Override
//    public boolean isPublish(){
//        return slingSettingsService.getRunModes().contains("publish");
//    }
//
//    @Override
//    public boolean isAuthor(){
//        return slingSettingsService.getRunModes().contains("author");
//    }
//


}
