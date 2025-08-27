package com.tutorial.ticketbookingservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author - tutorial(https://www.youtube.com/c/tutorial)
 */
public class FraudCheckResponse {
    private final boolean blacklisted;
    //more fraud flags to go here..

    @JsonCreator
    public FraudCheckResponse(@JsonProperty("blacklisted") final boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }
}
