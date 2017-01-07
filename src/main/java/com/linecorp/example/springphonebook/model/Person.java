
package com.linecorp.example.springphonebook.model;

import com.google.gson.annotations.SerializedName;

public class Person
{
    @SerializedName("id")
    public Long mId;
    
    @SerializedName("name")
    public String mName;
    
    @SerializedName("phone_number")
    public String mPhoneNumber;
    
    public Person(Long aId, String aName, String aPhoneNumber)
    {
        mId=aId;
        mName=aName;
        mPhoneNumber=aPhoneNumber;
    }
};
