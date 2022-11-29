package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private static final List<Car> carList = new ArrayList<>();

    static {
        carList.add(new Car("Lada", "Vesta", 2016));
        carList.add(new Car("Niva", "Legend", 2022));
        carList.add(new Car("ZAZ", "965", 1992));
        carList.add(new Car("UAZ", "Patriot", 1999));
        carList.add(new Car("Kia", "Sorento", 2002));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return carList;
        }

        return carList.stream().limit(count).collect(Collectors.toList());
    }
}