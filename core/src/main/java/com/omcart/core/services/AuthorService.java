package com.omcart.core.services;

import org.apache.sling.api.SlingHttpServletRequest;

public interface AuthorService {
    public String createAuthorNode(String country, SlingHttpServletRequest request);
//    public List<Map<String, String>> getAuthors(final String country);
//    public Resource getAuthorDetails(final String country, final String author);

}
