package com.cooldatasoft.repository.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;

import com.cooldatasoft.jpa.data.Customer;
import com.cooldatasoft.jpa.data.CustomerList;
import com.cooldatasoft.jpa.data.CustomerListPhone;
import com.cooldatasoft.jpa.data.Person;
/**
 * 
 * @author Fatih Mehmet UCAR
 *
 */
public class ObjectSampler {

	public static <T> T sample(Class<T> clazz) {
		try {
			T instance = clazz.newInstance();
			Field[] declaredFields = clazz.getDeclaredFields();

			for (Field field : declaredFields) {
				if (Modifier.isFinal(field.getModifiers())) {
					continue;
				}
				String typeStr = field.getType().getName();

				field.setAccessible(true);
				if (typeStr.equals("int") || typeStr.equals("java.lang.Integer")) {
					field.set(instance, (int) (Math.random() * Integer.MAX_VALUE));
				} else if (typeStr.equals("long") || typeStr.equals("java.lang.Long")) {
					field.set(instance, (long) (Math.random() * Long.MAX_VALUE));
				} else if (typeStr.equals("boolean") || typeStr.equals("java.lang.Boolean")) {
					field.set(instance, ((int) (Math.random() * 2) == 1) ? true : false);
				} else if (typeStr.equals("short") || typeStr.equals("java.lang.Short")) {
					field.set(instance, (short) (Math.random() * Short.MAX_VALUE));
				} else if (typeStr.equals("double") || typeStr.equals("java.lang.Double")) {
					field.set(instance, Math.random() * Double.MAX_VALUE);
				} else if (typeStr == "java.lang.String") {
					field.set(instance, RandomString.getString("**********"));
				} else if (typeStr == "java.util.Date") {
					field.set(instance, new Date());
				} else {
					System.out.println("CUSTOM : " + typeStr);
					field.set(instance, sample(field.getType()));
				}
			}

			return instance;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Customer createCustomer() {
		Customer customer = sample(Customer.class);
		customer.setEmail("email@email.net");
		return customer;
	}

	public static CustomerList createCustomerList() {
		CustomerList customerList = sample(CustomerList.class);
		customerList.setCustomer(createCustomer());
		customerList.setStatus(0);
		return customerList;
	}

	public static CustomerListPhone createCustomerListPhone() {
		CustomerListPhone customerListPhone = sample(CustomerListPhone.class);
		customerListPhone.setCustomerList(createCustomerList());
		customerListPhone.setPerson(createPerson());
		customerListPhone.setStatus(0);
		return customerListPhone;
	}

	public static Person createPerson() {
		Person person = sample(Person.class);
		person.setAge(30);
		return person;
	}

}
