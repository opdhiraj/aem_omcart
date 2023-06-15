package com.omcart.core.listeners;

import org.apache.sling.api.SlingConstants;
import org.apache.sling.event.jobs.JobManager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


@Component(service = EventHandler.class,
        immediate = true,
        properties = {
                EventConstants.EVENT_TOPIC+"=org/apache/sling/api/resource/Resource/Added",
                EventConstants.EVENT_FILTER+"=(path=/apps/omcart/components)"

        }
)


public class CustomerJobManager implements EventHandler {
   private  final Logger LOGGER = LoggerFactory.getLogger(CustomerJobManager.class);

    JobManager manager;

    @Override
    public void handleEvent(Event event) {
        Map<String, Object> jobProperties=new HashMap<>();
        jobProperties.put("event",event.getTopic());
        jobProperties.put("event_path",event.getProperty(SlingConstants.PROPERTY_PATH));
        manager.addJob("customJob",jobProperties);

         LOGGER.debug("customjob {} ",jobProperties);
    }
}
