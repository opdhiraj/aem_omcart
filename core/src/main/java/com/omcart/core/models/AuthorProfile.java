package com.omcart.core.models;

import java.util.List;

public interface AuthorProfile {
    public String getFirstName();
    public String getLastName();
    public String getEmail();
    public String getPhone();
    public List<String> getBooks();
    public String getThumbnail();
}
