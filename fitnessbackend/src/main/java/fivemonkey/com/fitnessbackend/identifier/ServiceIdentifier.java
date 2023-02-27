package fivemonkey.com.fitnessbackend.identifier;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.stream.Stream;

public class ServiceIdentifier implements IdentifierGenerator {

    private String prefix = "SER";
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object obj) throws HibernateException {
        String query = "select s.id from Services s";
        Stream<String> ids = sharedSessionContractImplementor.createQuery(query,String.class).stream();
        Long max = ids.map(o -> o.replace(prefix,"")).mapToLong(Long::parseLong).max().orElse(0L);

        return prefix + (String.format("%04d",max + 1));
    }
}
