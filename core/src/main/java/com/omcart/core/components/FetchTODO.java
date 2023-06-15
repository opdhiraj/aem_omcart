package com.omcart.core.components;

import com.omcart.core.services.WriteTODOService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.sling.api.resource.LoginException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;

import static com.omcart.core.components.FetchTODO.COMPONENT_NAME;
import static com.omcart.core.constant.AppConstants.TODO_ENDPOINT;


@Component(immediate = true, name = COMPONENT_NAME)
public class FetchTODO {

        private static final String TAG = FetchTODO.class.getSimpleName();
        private static final Logger LOGGER = LoggerFactory.getLogger(FetchTODO.class);
        protected static final String COMPONENT_NAME = "Fetch Todo Component";

        @Reference
        WriteTODOService writeTODOService;

        @Activate
        protected void activate() {
            LOGGER.debug("{} - activated", COMPONENT_NAME);
        //    Runnable task = () -> {
                try {
                   // Thread.sleep(TODO_THREAD_SLEEP_TIME);
                    //while (!Thread.currentThread().isInterrupted()) {
                        // Get output from the API
                        String todoData = fetchData();
                        // Call the OSGi service which will write data into the repository
                        writeTODOService.writeData(todoData);
                        LOGGER.debug("Trying to write TODO data in repository at: {}", LocalDateTime.now());
                    //}
                } catch ( LoginException e) {
                    LOGGER.error(" Exception occurred: {}", e.getMessage());
                }
            };
            // Create a new Thread with the above Runnable
          //  Thread todoThread = new Thread(task);
            // Set the name of the thread
         //   todoThread.setName("TODO Thread");
            // Start the thread
          //  todoThread.start();


        private String fetchData() {
            HttpClient httpClient = HttpClientBuilder.create().build();
            // Output in String format
            String output = StringUtils.EMPTY;
            try {
                // GET Request
                HttpGet request = new HttpGet(TODO_ENDPOINT);
                // Set the API media type in http accept header
                request.setHeader("accept", "application/json");
                // Send the request, It will immediately return the response in HttpResponse object
                HttpResponse response = httpClient.execute(request);
                // Get the status code
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    throw new RuntimeException(": Failed with error code: " + statusCode);
                }
                // Pull back the response object
                HttpEntity httpEntity = response.getEntity();
                // Getting output in String
                output = EntityUtils.toString(httpEntity);
             //   LOGGER.debug("output 81  {}", output);
            } catch (IOException e) {
                LOGGER.error("{}: Exception occurred: {}", e.getMessage());
            }
            return output;
        }
    }

