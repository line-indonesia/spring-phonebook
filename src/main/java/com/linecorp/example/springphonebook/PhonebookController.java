
package com.linecorp.example.springphonebook;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.io.ByteStreams;

@RestController
@RequestMapping(value="/")
public class PhonebookController
{
    @Autowired
    PersonDao mDao;
    
    @RequestMapping(value="/phonebook", method=RequestMethod.GET)
    public ResponseEntity<String> get(
        @RequestParam(value="name", required=false) String aName)
    {
        return null;
    }
    
    @RequestMapping(value="/phonebook", method=RequestMethod.POST)
    public ResponseEntity<String> post(
        @RequestBody String aPayload)
    {
        return null;
    }

};
