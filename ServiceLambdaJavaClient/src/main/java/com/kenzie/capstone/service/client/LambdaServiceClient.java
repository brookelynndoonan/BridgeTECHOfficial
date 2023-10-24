package com.kenzie.capstone.service.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenzie.capstone.service.model.UserAccounts;
import com.kenzie.capstone.service.model.UserAccountsRequest;
import com.kenzie.capstone.service.model.UserAccountsResponse;


public class LambdaServiceClient {

    private static final String SET_USERACCOUNT_ENDPOINT = "user";

    private static final String GET_USERACCOUNT_ENDPOINT = "user/{id}";

    private ObjectMapper mapper;

    // Elise helped us find all the tiny discrepancies that prevented our Lambda from working.
    // She also showed us how to test the Lambda directly on AWS. IT WORKS!
    // Sadly, it was the difference between 'id' and 'Id' that held us back.

    public LambdaServiceClient() {
        this.mapper = new ObjectMapper();
    }

    public UserAccounts getUserAccounts(String id) {
        EndpointUtility endpointUtility = new EndpointUtility();
        String response = endpointUtility.getEndpoint(GET_USERACCOUNT_ENDPOINT.replace("{id}", id));
        UserAccounts userAccounts;
        try {
            userAccounts = mapper.readValue(response, UserAccounts.class);
        } catch (Exception e) {
            throw new ApiGatewayException("Unable to map deserialize JSON: " + e);
        }
        return userAccounts;
    }

    public UserAccountsResponse setUserAccounts(UserAccountsRequest userAccountsRequest) {
        EndpointUtility endpointUtility = new EndpointUtility();
        String request;

        try {
            request = mapper.writeValueAsString(userAccountsRequest);
        } catch (JsonProcessingException e) {
            throw new ApiGatewayException("Unable to serialize request: " + e);
        }
        String response = endpointUtility.postEndpoint(SET_USERACCOUNT_ENDPOINT, request);
        UserAccountsResponse userAccounts;
        try {
            userAccounts = mapper.readValue(response, UserAccountsResponse.class);
        } catch (Exception e) {
            throw new ApiGatewayException("Unable to map deserialize JSON: " + e);
        }
        return userAccounts;
    }

}
