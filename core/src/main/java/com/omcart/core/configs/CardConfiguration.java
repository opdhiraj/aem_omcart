package com.omcart.core.configs;


import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@ObjectClassDefinition(
        name = "omcart Card Configuration",
        description = "This configuration captures the card details"
)

public  @interface CardConfiguration {

    @AttributeDefinition(
            name = "Organization Name",
            description = "Name of the organization you wish to display on the card"
    )
    String getOrganizationName();

    @AttributeDefinition(
            name = "Homepage URL",
            description = "URL of the website's homepage"
    )
    String getHomepageURL();
}
