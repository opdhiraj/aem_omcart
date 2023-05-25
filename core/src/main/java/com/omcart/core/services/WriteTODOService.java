package com.omcart.core.services;

import org.apache.sling.api.resource.LoginException;

public interface WriteTODOService {
    void writeData(String todoData) throws LoginException;
}
