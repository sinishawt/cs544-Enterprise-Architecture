package edu.miu.cs544;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsControler {
	
	@RequestMapping("/")
	public String hello() {
		return "WW Auto Shop";
	}
	
	@RequestMapping("/cars")
	public List<Car> getCars(){
		Car car1 = new Car("Toyota", "Yaris", 2006);
		Car car2 = new Car("Mercedes", "C class", 2020);
		Car car3 = new Car("Bugati", "Veron", 2009);
		
		return Arrays.asList(car1, car2, car3);
	}

}
