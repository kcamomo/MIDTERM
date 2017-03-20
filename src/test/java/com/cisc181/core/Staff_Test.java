package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	private static ArrayList<Staff> StaffList = new ArrayList<Staff>();

	@BeforeClass
	public static void setup() throws PersonException {
		StaffList.add(new Staff("Casey", "A", "Morris", new Date(3 / 21 / 96), "111 Blue Road", "(922)-567-8955",
				"cmorris@udel.edu", "9-5", 1, 50000.00, new Date(1 / 1 / 2017), eTitle.MR));
		StaffList.add(new Staff("Jacob", "J", "John", new Date(1 / 2 / 94), "111 Purple Road", "(941)-567-0194",
				"johnjacob@udel.edu", "9-5", 2, 60000.00, new Date(3 / 4 / 2017), eTitle.MR));
		StaffList.add(new Staff("Paul", "C", "Dan", new Date(5 / 1 / 97), "111 Yellow Road", "(532)-049-1846",
				"pauldan@udel.edu", "9-5", 3, 70000.00, new Date(9 / 5 / 2016), eTitle.MR));
		StaffList.add(new Staff("Celine", "L", "Dione", new Date(4 / 1 / 88), "111 Orange Road", "(532)-019-4215",
				"celinedione@udel.edu", "9-5", 4, 80000.00, new Date(5 / 1 / 2014), eTitle.MRS));
		StaffList.add(new Staff("Sam", "C", "Morris", new Date(5 / 6 / 89), "111 Banana Road", "(532)-049-5163",
				"sammorris@udel.edu", "9-5", 5, 90000.00, new Date(4 / 1 / 2010), eTitle.MS));
	}

	@Test
	public void TestStaffSalary() {
		int salary=0;
		
		int staffnum=0;
		
		for(Staff s: StaffList)
		{
			salary += s.getSalary();
			staffnum++;
		}
		
		assertEquals(70000, salary/staffnum);
		
	}

	@Test(expected = PersonException.class)
	public void testPhoneNum() throws PersonException {
		String lastName = "";
		String middleName = "";
		String firstName = "";
		Date DOB = new Date();
		String address = "";
		String phoneNum = new String("30253251421");
		String email = "";
		String officeHours = "";
		int rank = 1;
		double salary = 10.0;
		Date hireDate = new Date();
		eTitle title = eTitle.MR;

		Staff s = new Staff(lastName, middleName, firstName, DOB, address, phoneNum, email, officeHours, rank, salary,
				hireDate, title);
	}

	@Test(expected = PersonException.class)
	public void testDOB() throws PersonException {
		String lastName = "";
		String middleName = "";
		String firstName = "";
		Date DOB = new Date(3 / 2 / 1774);
		String address = "";
		String phoneNum = "";
		String email = "";
		String officeHours = "";
		int rank = 1;
		double salary = 10.0;
		Date hireDate = new Date();
		eTitle title = eTitle.MR;

		Staff s = new Staff(lastName, middleName, firstName, DOB, address, phoneNum, email, officeHours, rank, salary,
				hireDate, title);
	}

}
