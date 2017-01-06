
package com.linecorp.example.springphonebook;

import java.util.List;
import com.linecorp.example.springphonebook.model.Person;

public interface PersonDao
{
    public Long post(Person aPerson);
    public List<Person> get();
    public List<Person> getByName(String aName);
};
