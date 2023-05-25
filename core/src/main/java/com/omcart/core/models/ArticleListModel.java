package com.omcart.core.models;


import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;
import com.omcart.core.beans.ArticleListDataBean;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class ArticleListModel {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleListModel.class);

    @Inject
    private String articleRootPath;


    //declaring articleListDataBeanArray as global variable
    List<ArticleListDataBean> articleListDataBeanArray=null;

    @Self
    Resource resource;

    public String getArticleRootPath() {
        return articleRootPath;
    }


    @PostConstruct
    protected void init() {
        ResourceResolver resourceResolver = resource.getResourceResolver();
        Session session = resourceResolver.adaptTo(Session.class);
        QueryBuilder builder = resourceResolver.adaptTo(QueryBuilder.class);

        Map<String, String> predicate = new HashMap<>();
        predicate.put("path", articleRootPath);
        predicate.put("type", "cq:Page");
        Query query = null;

        try {
            query = builder.createQuery(PredicateGroup.create(predicate), session);

        } catch (Exception e) {
            LOGGER.error("error in query ", e);

        }


        SearchResult searchResult = query.getResult();

         articleListDataBeanArray =new ArrayList<ArticleListDataBean>();



        for (Hit hit : searchResult.getHits()) {

            //created object for class ArticleListDataBean to store title and path of page  ;

            ArticleListDataBean articleListDataBean=new ArticleListDataBean();
            String path = null;
            try {
                path = hit.getPath();
                Resource articleResource = resourceResolver.getResource(path);
                Page articlePage = articleResource.adaptTo(Page.class);
                String title = articlePage.getTitle();


               // LOGGER.debug("name->8-9--> {} ", articlePage.getProperties().get("cq:lastModified",toString()));
                LOGGER.debug("name->8-9--> {} ", articlePage.getProperties().toString());



                // setting to values to ArticleListDataBean
                // this is one ArticleListDataBean , for every iteration it will create another ArticleListDataBean to store values
                articleListDataBean.setPath(path);
                articleListDataBean.setTitle(title);

               // LOGGER.debug(" path=== {} \n title=== {} ", path ,title);

                //adding ArticleListDataBean to array (articleListDataBeanArray)
                articleListDataBeanArray.add(articleListDataBean);

            } catch (RepositoryException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<ArticleListDataBean> getArticleListDataBeanArray() {
        return articleListDataBeanArray;
    }
}
