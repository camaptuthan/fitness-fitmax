package fivemonkey.com.fitnessbackend.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class ModelMapperConfiguration<S, T> {


    private final ModelMapper modelMapper;


    public ModelMapperConfiguration() {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public T map(S source, Class<T> target) {
        if (source == null)
            return null;
        return modelMapper.map(source, target);
    }

    public List<T> mapList(List<S> source, Class<T> targetClass) {
        List<T> target = new ArrayList<T>();
        for (S element : source) {
            T t = modelMapper.map(element, targetClass);
            System.out.println("Root: " + element.toString());
            System.out.println("DTO: " + t.toString());
            target.add(t);
        }
        return target;
    }
 
}
