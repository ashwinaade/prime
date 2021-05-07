package com.example.prime.restController;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.prime.exceptionHandling.NotPrimeNumberException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.prime.model.primPojo;

@RestController
@RequestMapping("/primes")
public class primeRestcontroller {
	
	@GetMapping("/{limitprimnumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object produceJSON( @PathVariable("limitprimnumber") Integer limitprimnumber ) {
		//Integer limitprimnumber=100;
		
			if (limitprimnumber < 2 ) {
			 NotPrimeNumberException np=new NotPrimeNumberException("Please use number >=2");
			 return new ResponseEntity<>(np,HttpStatus.BAD_REQUEST);
		    }
			List<Integer> primes = IntStream.rangeClosed(2, limitprimnumber)
                    .filter(n -> isPrime(n))
                    .boxed()
                    .collect(Collectors.toList());
		
		primPojo st = new primPojo(limitprimnumber,primes);
		return st;
	}
	
	
	static boolean isPrime(int number) {
        if(number <= 2)
            return number == 2;
        else
            return  (number % 2) != 0 && IntStream.rangeClosed(3, (int) Math.sqrt(number))
                    .filter(n -> n % 2 != 0)
                    .noneMatch(n -> (number % n == 0));
    }
	
	
	
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public Object handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
	    NotPrimeNumberException np=new NotPrimeNumberException("Please use valid number");
	      return np;
	}
	
	@ExceptionHandler(Exception.class)
	public Object otherException(Exception ex) {
	    NotPrimeNumberException np=new NotPrimeNumberException("Please put valid url");
	      return np;
	}
	
	
	
}