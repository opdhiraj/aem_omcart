package com.omcart.core.models.impl;


import com.omcart.core.models.User;
import com.omcart.core.utils.IDGenerator;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.Objects;


@Model(
        adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {User.class},
        resourceType = {UserImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class UserImpl implements User {
    protected static final String RESOURCE_TYPE = "omcart/components/content/user";
    private static final Logger LOGGER = LoggerFactory.getLogger(UserImpl.class);
    private static final String TAG = UserImpl.class.getSimpleName();

    @ResourcePath(path ="/content/dam/omcart")@Via("resource")
    Resource resource;


    @ValueMapValue
    String id;

    @ValueMapValue
    String name;

    @ValueMapValue
    String gender;

    @ValueMapValue
    String address;

    @SlingObject
    SlingHttpServletRequest request;

    @SlingObject
    ResourceResolver resourceResolver;



    @PostConstruct
    protected void init() {
        // Get the unique id from generator
        String generatedId = IDGenerator.generateUniqueID(8);
        LOGGER.debug("{}: Generated id is: {}", TAG, generatedId);
//        LOGGER.debug("resourceResolver id 68---is: {}", resourceResolverService.getResourceResolver().getUserID());
        LOGGER.debug("resourceResolver id is: {}", resourceResolver.getUserID());

       LOGGER.debug("resource is: {}", resource.listChildren());
        LOGGER.debug("resource is: {}", resource.getName());


        // Getting the reference of the current node
        Node currentNode = request.getResource().adaptTo(Node.class);
        LOGGER.debug("currentNode  is: {}", currentNode);
        // Stored id, if any
        String storedId;
        // Getting the current session
        Session session = request.getResourceResolver().adaptTo(Session.class);
        try {
            if (currentNode != null && !currentNode.hasProperty("id")) {
                currentNode.setProperty("id", generatedId);
            } else {
                // Getting the stored id from the node
                storedId = Objects.requireNonNull(currentNode).getProperty("id").getString();
                if (storedId == null || storedId.isEmpty()) {
                    Objects.requireNonNull(currentNode).setProperty("id", generatedId);
                }
            }
            // Saving the session
            Objects.requireNonNull(session).save();
        } catch (RepositoryException e) {
            LOGGER.error("{}: Error occurred: {}", TAG, e.getMessage());
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getAddress() {
        return address;
    }
//
//    @Override
//    public String getAdd() {
//        LOGGER.debug("resource is: {}", resource);
//        LOGGER.debug("resource is: {}", resource.name());
//        return resource.name();
//    }
}
