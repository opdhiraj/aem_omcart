package com.omcart.core.models.impl;

import com.day.cq.wcm.api.Page;
import com.omcart.core.models.AuthorProfile;
import com.omcart.core.services.AuthorService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.List;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = AuthorProfile.class,
        resourceType = AuthorProfileImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class AuthorProfileImpl implements AuthorProfile {
    private static final Logger LOG = LoggerFactory.getLogger(AuthorProfileImpl.class);
    final protected static String RESOURCE_TYPE="omcart/components/custom/authorsinfo";

    @SlingObject
    ResourceResolver resourceResolver;

    @ScriptVariable
    Page currentPage;

    @OSGiService
    AuthorService authorService;

    @SlingObject
    SlingHttpServletRequest request;

    String firstName;
    String lastName;
    String email;
    String phone;
    List<String> books;
    String thumbnail;


    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public List<String> getBooks() {
        return books;
    }

    @Override
    public String getThumbnail() {
        return thumbnail;
    }

    @PostConstruct
    protected void init(){
        String country=currentPage.getPath().split("/")[3];
        String authorPath=request.getRequestParameter("author").getString();
//        Resource author=authorService.getAuthorDetails(country,authorPath);
//        ValueMap authorMap=author.getValueMap();
//        firstName=authorMap.get("fname",String.class);
//        lastName=authorMap.get("lname",String.class);
//        email=authorMap.get("email",String.class);
//        phone=authorMap.get("phone",String.class);
//        books= Arrays.asList(authorMap.get("books",String[].class));
//        thumbnail=author.getPath()+"/photo/image";
//        LOG.info("\n Resource Path - {} : {} ",author.getPath(),books.size());
    }
}
