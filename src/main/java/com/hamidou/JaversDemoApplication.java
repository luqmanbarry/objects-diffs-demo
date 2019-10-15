package com.hamidou;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class JaversDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaversDemoApplication.class, args);

		computeDiff();
	}

	private static void computeDiff() {
		Employee hamidouOld = new Employee();
		hamidouOld.setId(1);
		hamidouOld.setFirstName("Hamidou");
		hamidouOld.setLastName("Barry");
   		hamidouOld.setHireDate(Instant.now());
    	hamidouOld.setSalary(BigDecimal.valueOf(20000));
    	hamidouOld.setBirthDate(new Date());
    	hamidouOld.getAddressList().add(new Address(1, "111 job road", "Awesome City", "Vibrant State", 12345));
		hamidouOld.getAddressList().add(new Address(2, "222 job road", "Great City", "Rocky State", 35689));

		Employee hamidouNew = new Employee();
		hamidouNew.setId(1);
		hamidouNew.setFirstName("Hamidou New");
		hamidouNew.setLastName("Barry New");
		hamidouNew.setHireDate(Instant.now());
		hamidouNew.setSalary(BigDecimal.valueOf(50000));
		hamidouNew.setBirthDate(new Date());
		hamidouNew.getAddressList().add(new Address(1, "111 job avenue", "Awesome City", "Vibrant State", 12345));
		hamidouNew.getAddressList().add(new Address(2, "222 Guess Drive", "Great City", "Rocky State", 35689));

		Javers javers = JaversBuilder.javers().build();
		Diff objectDiffs = javers.compare(hamidouOld, hamidouNew);

		System.out.println(objectDiffs);
	}

}
