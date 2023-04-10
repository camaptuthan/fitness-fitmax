package fivemonkey.com.fitnessbackend.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ModelMapperConfiguration <S,T>{


    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }

    public List<T> mapList(List<S> source, Class<T> targetClass) {
        List<T> target = new ArrayList<T>();
        for (S element : source) {
            T t = getModelMapper().map(element, targetClass);
            System.out.println(t.toString());
            target.add(t);
        }
        return target;
    }
}
