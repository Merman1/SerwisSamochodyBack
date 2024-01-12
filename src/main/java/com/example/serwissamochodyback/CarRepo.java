package com.example.serwissamochodyback;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Optional;
@Repository
public interface CarRepo extends JpaRepository<Car,Long> {

    List<Car> findByMarka(String marka);

    List<Car> findByCenaLessThanEqual(double cena);

    List<Car> findByModel(String model);

    List<Car> findByRok(int rok);


    void deleteCarById(Long id);

    Optional<Car> findById(Long id);
}
