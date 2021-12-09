package example;

import org.slf4j.Logger
import spock.lang.Specification;

// @RunWith attaches a runner with the test class to initialize the test data
public class CarTest extends Specification {

    example.service.CarService service;

    public void "get car property Model"() {
      given: "create a service object"
      service = new example.service.CarServiceImpl();

      when: "create car"
      example.model.Car o = service.createCar();

      then: "value should be 'test'"
      o.getModel() == "test"
    }

    public void "create Car"() {
      given: "create a service object"
      service = new example.service.CarServiceImpl();

      when: "create car"
      example.model.Car o = service.createCar();

      then: "car should exist"
      o != null
    }

    public void "create random Car"() {
      given: "create a service object"
      service = new example.service.CarServiceImpl();

      when: "get random car"
      example.model.Car o = service.createRandomCar();

      then: "car should be created"
      o != null;
    }

    public void "get a predefined list"() {
      given: "create a service object"
      service = new example.service.CarServiceImpl();

      when: "get list"
      List<example.model.Car> lst = service.findAll();

      then: "list size should be 3"
      lst.size() == 3
    }

    public void "add a Car to a list"() {
      given: "create a service object"
      service = new example.service.CarServiceImpl();

      when: "add a car from a list"
      List<example.model.Car> lst = service.addCar();

      then: "size of the list should be 4"
      lst.size() == 4
    }

    public void "delete a Car from list"() {
      given: "create a service object"
      service = new example.service.CarServiceImpl();

      when: "delete a car from a list"
      List<example.model.Car> lst = service.deleteCar();

      then: "list size should be 2"
      lst.size() == 2;
    }
}
