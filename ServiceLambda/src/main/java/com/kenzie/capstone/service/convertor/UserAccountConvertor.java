package com.kenzie.capstone.service.convertor;

import com.kenzie.capstone.service.model.UserAccountRecord;
import com.kenzie.capstone.service.model.UserAccountsRequest;
import com.kenzie.capstone.service.model.UserAccountsResponse;

public class UserAccountConvertor {

    public static UserAccountRecord fromRequestToRecord(UserAccountsRequest request) {
        UserAccountRecord record = new UserAccountRecord();

        record.setName(request.getUserName());
        record.setAccountType(request.getAccountType());
        record.setPassword(request.getPassword());
        record.setEmail(request.getEmail());

        return record;
    }

    public static UserAccountsResponse fromRecordToResponse(UserAccountRecord record) {
        UserAccountsResponse response = new UserAccountsResponse();

        response.setId(record.getId());
        response.setUserName(record.getName());
        response.setAccountType(record.getAccountType());
        response.setPassword(record.getPassword());
        response.setEmail(record.getEmail());

        return response;
    }
}
