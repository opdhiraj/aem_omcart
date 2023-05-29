package com.omcart.core.servlets;


import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    private  static final String QUERY_PATH="/content/dam/omcart";

    private static final Logger LOGGER= LoggerFactory.getLogger(AssetServlet.class);

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {
        //        Resource resource=request.getResource();
        ResourceResolver resourceResolver=request.getResourceResolver();
        Session session=resourceResolver.adaptTo(Session.class);
        QueryBuilder qb=resourceResolver.adaptTo(QueryBuilder.class);

        Map<String, String>predicate=new HashMap<>();
        predicate.put("path",QUERY_PATH);
        predicate.put("type","dam:Asset");
        Query query=null;

        List<String>list=new ArrayList<>();
        List<String>listone=new ArrayList<>();

        try {

            query=qb.createQuery(PredicateGroup.create(predicate),session);
//            LOGGER.debug("query {}",query.getResult());

        }catch (Exception e){
            LOGGER.error("err",e);
        }
        SearchResult searchResult=query.getResult();

        for (Hit hit :searchResult.getHits()){
            try {
             String path= hit.getPath();
             list.add(path);
                LOGGER.debug("path ----> {} " ,path);
//              LOGGER.debug("single hit--> {} ,</br>res::::: {} ",hit.getPath(),hit.getResource().getValueMap().keySet());

            }catch (Exception e){
                LOGGER.error("err {} ",e);
            }

        }

        LOGGER.debug("list {} " ,list);
//        LOGGER.debug("AssetServlet {}", resource.getName());

        response.setContentType("text/html");
//        response.getWriter().write("page title "+" <h1>"+resource.getName()+"</h1>" );
    }


}
