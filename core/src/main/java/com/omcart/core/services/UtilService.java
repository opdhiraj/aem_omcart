package com.omcart.core.services;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;

public interface UtilService {
    public String getActionURL(Resource resource) throws LoginException;
//    public boolean isPublish();
//    public boolean isAuthor();
}
