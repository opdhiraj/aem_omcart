package com.omcart.core.listeners;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(service = JobConsumer.class,
        immediate = true,
        property = {
        JobConsumer.PROPERTY_TOPICS+"=customJob"

        })



public class CustomJobConsumer implements JobConsumer {
     private  final Logger LOGGER= LoggerFactory.getLogger(CustomJobConsumer.class);

    @Reference
    ResourceResolver resourceResolver;

    @Override
    public JobResult process(Job job) {
        //write business logic
      LOGGER.debug("resourceResolver customjobconsumer  {} ",resourceResolver.getUserID());
        return JobResult.OK;
        //return whether the event is successful or not
    }
}
