package com.hamidou;

import org.javers.core.metamodel.annotation.DiffIgnore;
import org.javers.core.metamodel.annotation.Id;
import org.javers.core.metamodel.annotation.TypeName;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

@TypeName("Employee")
public class Employee {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private BigDecimal salary;
    private Instant hireDate;
    private List<Address> addressList = new ArrayList<>();

    @DiffIgnore
    private JobFunction jobFunction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Instant getHireDate() {
        return hireDate;
    }

    public void setHireDate(Instant hireDate) {
        this.hireDate = hireDate;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public JobFunction getJobFunction() {
        return jobFunction;
    }

    public void setJobFunction(JobFunction jobFunction) {
        this.jobFunction = jobFunction;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("birthDate=" + birthDate)
                .add("salary=" + salary)
                .add("hireDate=" + hireDate)
                .add("addressList=" + addressList)
                .add("jobFunction=" + jobFunction)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(birthDate, employee.birthDate) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(hireDate, employee.hireDate) &&
                Objects.equals(addressList, employee.addressList) &&
                Objects.equals(jobFunction, employee.jobFunction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, salary, hireDate, addressList, jobFunction);
    }
}
