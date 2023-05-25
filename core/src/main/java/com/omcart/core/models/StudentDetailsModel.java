package com.omcart.core.models;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class StudentDetailsModel {

    @ValueMapValue
    @Default(values = "Enter the student id ")
    String studentID;

    @ValueMapValue
    @Default(values = "Enter the student name ")
    String studentName;

    @Inject
    @Via("resource")
    String stream;

    @Named("jcr:createdBy")
    @Inject
    @Via("resource")
    String createdBy;


    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStream() {
        return stream;
    }

    public String getCreatedBy() {
        return createdBy;
    }

//The  streamCreate() method will be executed after injecting all the properties. If the stream property does not hold any value, “Science” will be stored as the default value.

    @PostConstruct
    private  void  streamCreate(){
        if(stream ==null){
            stream="Science";
        }
    }
}
