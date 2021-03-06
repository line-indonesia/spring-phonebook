
package com.linecorp.example.springphonebook;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.linecorp.example.springphonebook.model.Person;

@RestController
@RequestMapping(value="/")
public class PhonebookController
{
    @Autowired
    PersonDao mDao;
    
    @GetMapping(value="/phonebook")
    public ResponseEntity< List<Person> > get(
        @RequestParam(value="name", required=false) String aName)
    {
        List<Person> pl=null;
        if(aName!=null && aName.length() > 0)
        {
            pl=mDao.getByName(aName);
        }
        else
        {
            pl=mDao.get();
        }
        
        return new ResponseEntity< List<Person> >(pl, HttpStatus.OK);
    }
    
    @PostMapping(value="/phonebook")
    public ResponseEntity<String> post(
        @RequestBody Person aPayload)
    {
        if(aPayload!=null)
        {
            try
            {
                Long id=mDao.post(aPayload);
                return new ResponseEntity<String>("{\"status\":\"OK\", \"id\":"+id+"}", HttpStatus.OK);
            }
            catch(Exception e)
            {
                return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
            }
        }
        else
        {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

};
