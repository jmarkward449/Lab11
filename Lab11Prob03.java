import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* File: Lab11Prob01
* Class: CSCI 1302
* Author: Jacob Markward, Natalia Mar Morales
* Created on: 11/14/25
* Last Modified: 11/14/25
* Description: Binary IO Shinanigans
*/

import java.io.*;

public class Lab11Prob03 {
    public static void main(String[] args){
    	ArrayList<Person> people = new ArrayList<>();
    	
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/people.dat"));
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/people-copy.dat"));
        ){
            while ((input.read()) != -1){
     
            	people.add(new Person(input.readInt(), input.readUTF(), input.readUTF(), input.readInt(), input.readDouble()));
                
            }
        } catch (IOException e) {
    
        }
        
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/people-salary-sorted-objects.dat"));){
        	for (Person p : people) {
        		output.writeObject(p);
        	}
        } catch (IOException e) {
        	
        }
        
        Collections.sort(people);
        
        for (Person p : people){
        	System.out.println(p);
        }
        
        
    }
} class Person implements Comparable<Person>, Serializable{
	private int age;
	private String name;
	private String address;
	private int zipcode;
	private double salary;
	
	public Person() {
		setAge(this.age);
		setName(this.name);
		setAddress(this.address);
		setZipcode(this.zipcode);
		setSalary(this.salary);
	}
	
	public Person(int age, String name, String address, int zipcode, double salary) {
		setAge(this.age);
		setName(this.name);
		setAddress(this.address);
		setZipcode(this.zipcode);
		setSalary(this.salary);
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int compareTo(Person o) {
		if (getSalary() > o.getSalary()) {
			return 1;
		} else if (getSalary() < o.getSalary()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return String.format("Age : %d%nFirst and Last Name: %s%nAddress: %s%nZip Code: %d%nSalary: %.2f", getAge(), getName(), getAddress(), getZipcode(), getSalary());
	}
	
}
