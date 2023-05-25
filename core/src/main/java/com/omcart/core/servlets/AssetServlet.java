package com.omcart.core.servlets;


import com.day.crx.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class,
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths=" + "/bin/omcart/assetservlet"
        }

)


//@SlingServletResourceTypes(
//        resourceTypes ="omcart/components/assetservlet",
//        selectors = "assetpage",
//        extensions = "html",
//        methods = HttpConstants.METHOD_GET
//      //  resourceTypes = "omcart/components/structure/page"
//
//)
public class AssetServlet extends SlingSafeMethodsServlet {

    private static final Logger LOGGER= LoggerFactory.getLogger(AssetServlet.class);

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {
        Resource resource=request.getResource();
        LOGGER.debug("AssetServlet test=test=tttttt");

        response.setContentType("text/plain");
        response.getWriter().write("page title "+ resource.getValueMap().get(JcrConstants.JCR_PRIMARYTYPE));
    }


}
