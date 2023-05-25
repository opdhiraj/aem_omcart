package com.omcart.core.services.impl;

import com.omcart.core.configs.CardConfiguration;
import com.omcart.core.services.CardService;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = CardService.class,
        immediate = true,
        property = {
                Constants.SERVICE_ID + "=Card Service",
                Constants.SERVICE_DESCRIPTION + "=This service reads values from Card Configuration"
        })
@Designate(ocd = CardConfiguration.class)

public class CardServiceImpl implements CardService {


    private static final String TAG = CardServiceImpl.class.getSimpleName();
    private static final Logger LOGGER = LoggerFactory.getLogger(CardServiceImpl.class);

    private CardConfiguration configuration;

    @Activate
    protected void activate(CardConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String getOrganizationName() {
        LOGGER.info("{}: reading organization name", TAG);
        return configuration.getOrganizationName();
    }

    @Override
    public String getHomepageURL() {
        LOGGER.info("{}: reading homepage url", TAG);
        return configuration.getHomepageURL();
    }


}
