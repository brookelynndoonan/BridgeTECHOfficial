package com.kenzie.appserver.repositories.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

@DynamoDBTable(tableName = "Career")
public class CareerRecord {

    private String Id;

    private String careerName;
    private String location;
    private String jobDescription;
    private String companyDescription;

    @DynamoDBHashKey(attributeName = "Id")
    public String getId() {
        return Id;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getCareerName() {
        return careerName;
    }

    @DynamoDBAttribute(attributeName = "location")
    public String getLocation() {
        return location;
    }

    @DynamoDBAttribute(attributeName = "jobDescription")
    public String getJobDescription() {
        return jobDescription;
    }

    @DynamoDBAttribute(attributeName = "companyDescription")
    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CareerRecord that = (CareerRecord) o;
        return Id.equals(that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
