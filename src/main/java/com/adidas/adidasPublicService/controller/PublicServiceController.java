package com.adidas.adidasPublicService.controller;

import com.adidas.adidasPublicService.common.Constants;
import org.apache.log4j.Logger;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Controller for the application, contains methods to create subscription, delete, get and getall
 */
@RestController
@RequestMapping(path="/subscription", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PublicServiceController {

    final static Logger log = Logger.getLogger(PublicServiceController.class);

    /**
     * Method for create a subscription, it MUST receive a Subscription and send it to the SubscriptionService
     * There is a bug wich the body is received as LinkedHashMap<String, LinkedHashMap<String, ArrayList>>
     * @param body
     * @return the response Entity received from the SubscriptionService
     * @throws Exception
     */
    @PostMapping
    public ResponseEntity<?> createSubscription(@RequestBody Object body) throws Exception {
        log.debug("createSubscription begin");
        try {
            return sendPetition(Constants.URIs.CREATE_SUBSCRIPTION_URI, body, "put");
        } catch (HttpClientErrorException e) {
            log.error("createSubscription httpClientException");
            throw new HttpClientErrorException(e.getStatusCode(), e.getStatusText());
        } catch (Exception e) {
            log.error("createSubscription unexpecteException");
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Method for delete a subscription, it receive an ID via parameter
     * @param body
     * @return the response Entity received from the SubscriptionService
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubscription(@PathVariable String id, @RequestBody Object body) throws Exception {
        log.debug("deleteSubscription begin");
        try {
            return sendPetition(Constants.URIs.DELETE_SUBSCRIPTION_URI + id, body, "delete");
        } catch (HttpClientErrorException e) {
            log.error("createSubscription httpClientException");
            throw new HttpClientErrorException(e.getStatusCode(), e.getStatusText());
        } catch (Exception e) {
            log.error("createSubscription unexpecteException");
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Method for recover a single subscription, it receive an ID from param and returns a possitive message to confirm
     * deletion or an error message if deletion fails
     * @param id
     * @return the response Entity received from the SubscriptionService
     * @throws Exception
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleSubscription(@PathVariable String id) throws Exception {
        log.debug("getSingleSubscription begin");
        try {
            return sendPetition(Constants.URIs.RECOVER_SUBSCRIPTION_URI + id, "", "getSingle");
        } catch (HttpClientErrorException e) {
            log.error("createSubscription httpClientException");
            throw new HttpClientErrorException(e.getStatusCode(), e.getStatusText());
        } catch (Exception e) {
            log.error("createSubscription unexpecteException");
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Method for recover many Subscriptions, it MUST receive a list of Subscription IDs
     * There is a bug which the body is received as LinkedHashMap<String, LinkedHashMap<String, ArrayList>>
     * There is another bug which SubscriptionService doesn't receive the body through GET Method
     * @param body
     * @return the response Entity received from the SubscriptionService
     * @throws Exception
     */
    @GetMapping
    public ResponseEntity<?> getAllSubscriptions(@RequestBody Object body) throws Exception {
        log.debug("getAllSubscriptions begin");
        try {
            return sendPetition(Constants.URIs.RECOVER_ALL_SUBSCRIPTION_URI, body, "getAll");
        } catch (HttpClientErrorException e) {
            log.error("createSubscription httpClientException");
            throw new HttpClientErrorException(e.getStatusCode(), e.getStatusText());
        } catch (Exception e) {
            log.error("createSubscription unexpecteException");
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Method for make petitions to SubscriptionService and process it responses
     * @param uri the URI to call the service
     * @param petition the body of the petition
     * @param method 'method' to redirect to certain service on the SubscriptionService
     * @return
     */
    public ResponseEntity<?> sendPetition(String uri, Object petition, String method) {
        final String url = Constants.URIs.BASE_PATH + uri;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> entity = new HttpEntity<>(petition, headers);

        ResponseEntity<?> responseEntity = null;

        switch (method) {
            case "getSingle":
            case "getAll":
                responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
                break;
            case "put":
                responseEntity = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
                break;
            case "delete":
                responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
                break;
        }

        log.debug("createSubscription finish");
        return responseEntity;
    }
}
