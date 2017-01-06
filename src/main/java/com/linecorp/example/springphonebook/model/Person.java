
package com.linecorp.example.springphonebook.model;

public class Person
{
    public Long mId;
    public String mName;
    public String mPhoneNumber;
    
    public Person(Long aId, String aName, String aPhoneNumber)
    {
        mId=aId;
        mName=aName;
        mPhoneNumber=aPhoneNumber;
    }
};
