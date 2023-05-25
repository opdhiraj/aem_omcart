package com.omcart.core.servlets;

import com.omcart.core.constant.AppConstants;
import com.omcart.core.services.AuthorService;
import com.omcart.core.utils.ServiceUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;



@Component(service = Servlet.class)
@SlingServletResourceTypes(
        methods = {HttpConstants.METHOD_POST},
        resourceTypes = AppConstants.ADDAUTHOR_RESOURCE_TYPE,
        selectors = {AppConstants.ADDAUTHOR_SELECTORS},
        extensions = {AppConstants.ADDAUTHOR_EXTENSION}
)

public class AuthorServlet  extends SlingAllMethodsServlet {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorServlet.class);
    @Reference
    AuthorService authorService;

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        try {
            String resp=authorService.createAuthorNode(ServiceUtil.getCountry(request),request);
            response.getWriter().write(resp);
        }
        catch (Exception e){
            LOG.info("\n ERROR IN REQUEST {} ",e.getMessage());
        }
    }
}
