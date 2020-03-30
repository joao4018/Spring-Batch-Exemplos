package com.decider.decider.core.rowMapper;

import com.decider.decider.core.domain.Person;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.boot.context.properties.bind.BindException;


public class PersonFieldSetMapper implements FieldSetMapper<Person> {

    /**
     *
     */
    @Override
    public Person mapFieldSet(FieldSet fieldSet) throws BindException {
        return new Person(fieldSet.readLong("id"),
                fieldSet.readString("firstName"),
                fieldSet.readString("lastName"),
                fieldSet.readDate("birthdate", "dd/MM/yyyy"));
    }
}
