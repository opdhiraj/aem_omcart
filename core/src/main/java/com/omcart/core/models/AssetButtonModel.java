package com.omcart.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)


public class AssetButtonModel {

    private  static final Logger LOGGER= LoggerFactory.getLogger(AssetButtonModel.class);


   @Inject
   private String linkURL;


   @Self
   Resource resource;

    public String getLinkURL() {
        return linkURL;
    }
//    List<String>valuemaplist=null;
     List<String> valuemaplist=new ArrayList<String>();
    @PostConstruct
    protected void init(){
        ResourceResolver resourceResolver= resource.getResourceResolver();
        ValueMap valueMap=resource.getValueMap();

        for(Map.Entry<String,Object > vm:valueMap.entrySet()){

          String  oneproperty=vm.getKey() +"="+ vm.getValue();

            valuemaplist.add(oneproperty);
            LOGGER.debug("oneproperty {}" ,oneproperty);
//            LOGGER.debug("vm {}" ,vm.getKey() +"---------->"+ vm.getValue());
        }



        LOGGER.debug("valuemaplist=====>  {} " ,valuemaplist);
       LOGGER.debug("linkURL  {} " ,linkURL);


    }

    public List<String> getValuemaplist() {
        return valuemaplist;
    }
}
