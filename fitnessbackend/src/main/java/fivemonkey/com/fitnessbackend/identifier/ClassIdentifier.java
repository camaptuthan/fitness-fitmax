package fivemonkey.com.fitnessbackend.identifier;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.stream.Stream;

public class ClassIdentifier implements IdentifierGenerator {

    private String prefix = "CL";
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object obj) throws HibernateException {
        String query = "select c.id from Clazz c";
        Stream<String> ids = sharedSessionContractImplementor.createQuery(query,String.class).stream();
        Long max = ids.map(o -> o.replace(prefix,"")).mapToLong(Long::parseLong).max().orElse(0L);
        LocalDate current_date = LocalDate.now();
        return prefix + (String.format("%02d",max + 1))+ current_date.getYear();
    }
}
