package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.PackageDTO;
import fivemonkey.com.fitnessbackend.entities.Package;
import fivemonkey.com.fitnessbackend.repository.PackageRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class PackageServiceTest {

    @Autowired
    private PackageRepository packageRepository;

    @Test
    void getAllPackages() {
        List<Package> list = packageRepository.findAll();
        Assertions.assertThat(list).hasSizeGreaterThan(0);
        for (Package p: list) {
            System.out.println(p.toString());
        }
    }

    @Test
    void getPackageById() {
        String id = "PKG0001";
        Package p = packageRepository.getById(id);
        Assertions.assertThat(p).isNotNull();
        Assertions.assertThat(p.getId()).isNotNull();
    }

    @Test
    void getPackageById2() {
//        String id = "abc";
//        Package p = packageRepository.getById(id);
    }

    @Test
    void save() {
        Package p = new Package();
        p.setName("Basic workout 10");
        p.setDuration(10);
        p.setPrice(100f);
        Package aPackage = packageRepository.save(p);
        Assertions.assertThat(aPackage).isNotNull();
        Assertions.assertThat(aPackage.getName()).isNotNull();
        Assertions.assertThat(aPackage.getDuration()).isEqualTo(10);
    }

    @Test
    void update() {
        String id = "PKG0001";
        Package p = packageRepository.getById(id);
        p.setName("test update");
        Assertions.assertThat(p.getName()).isNotNull();
        Assertions.assertThat(p.getName()).isEqualTo("test update");
    }

    @Test
    void disablePackageById() {
        Package p = packageRepository.getById("PKG0001");
        p.setStatus(false);
        Assertions.assertThat(p.isStatus()).isFalse();
    }

    @Test
    void enablePackageById() {
        Package p = packageRepository.getById("PKG0001");
        p.setStatus(true);
        Assertions.assertThat(p.isStatus()).isTrue();
    }

    @Test
    void findPaginated() {
    }

    @Test
    void searchPackage() {
    }
}