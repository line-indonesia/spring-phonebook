
package com.linecorp.example.springphonebook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Vector;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import com.linecorp.example.springphonebook.model.Person;

public class PersonDaoImpl implements PersonDao
{
    private final static String SQL_SELECT_ALL="SELECT id, name, phone_number FROM phonebook";
    private final static String SQL_GET_BY_NAME=SQL_SELECT_ALL + " WHERE LOWER(name) LIKE LOWER(?) ORDER BY name";
    
    private JdbcTemplate mJdbc;
    
    private final static ResultSetExtractor<Person> SINGLE_RS_EXTRACTOR=new ResultSetExtractor<Person>()
    {
        @Override
        public Person extractData(ResultSet aRs)
				throws SQLException, DataAccessException
        {
            while(aRs.next())
            {
                Person p=new Person(
                    aRs.getLong("id"),
                    aRs.getString("name"),
                    aRs.getString("phone_number"));
                return p;
            }
            return null;
        }
    };

    private final static ResultSetExtractor< List<Person> > MULTIPLE_RS_EXTRACTOR=new ResultSetExtractor< List<Person> >()
    {
        @Override
        public List<Person> extractData(ResultSet aRs)
            throws SQLException, DataAccessException
        {
            List<Person> list=new Vector<Person>();
            while(aRs.next())
            {
                Person p=new Person(
                aRs.getLong("id"),
                aRs.getString("name"),
                aRs.getString("phone_number"));
                list.add(p);
            }
            return list;
        }
    };

    public PersonDaoImpl(DataSource aDataSource)
    {
        mJdbc=new JdbcTemplate(aDataSource);
    }

    public Long post(Person aPerson)
    {
        SimpleJdbcInsert insert=new SimpleJdbcInsert(mJdbc)
            .withTableName("phonebook")
            .usingGeneratedKeyColumns("id");
        Map<String, Object> fields=new HashMap<String, Object>();
        fields.put("name", aPerson.mName);
        fields.put("phone_number", aPerson.mPhoneNumber);
        return insert.executeAndReturnKey(fields).longValue();
    }

    public List<Person> get()
    {
        return mJdbc.query(SQL_SELECT_ALL, MULTIPLE_RS_EXTRACTOR);
    }

    public List<Person> getByName(String aName)
    {
        return mJdbc.query(SQL_GET_BY_NAME, new Object[]{aName}, MULTIPLE_RS_EXTRACTOR);
    }
};
