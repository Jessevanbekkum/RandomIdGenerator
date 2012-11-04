package randomidprovider;

import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class PersonGeneratorImpl implements PersonGenerator {


    PersonGeneratorImpl(RandomParameterReader firstNameReader, RandomParameterReader lastNameReader) {

    }


    @Override
    public Person getPerson() {
        Person person = new Person();
        person.setFirstName("Henk");
        return person;
    }
}
