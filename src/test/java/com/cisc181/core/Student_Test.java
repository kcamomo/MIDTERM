package com.cisc181.core;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	private static ArrayList<Course> CourseList = new ArrayList<Course>();
	private static ArrayList<Semester> SemesterList = new ArrayList<Semester>();
	private static ArrayList<Section> SectionList = new ArrayList<Section>();
	private static ArrayList<Student> StudentList = new ArrayList<Student>();
	private static ArrayList<Enrollment> EnrollmentList = new ArrayList<Enrollment>();

	@BeforeClass
	public static void setup() throws PersonException {
		CourseList.add(new Course(UUID.randomUUID(), "CISC181", 3, eMajor.PHYSICS));
		CourseList.add(new Course(UUID.randomUUID(), "CISC181", 3, eMajor.NURSING));
		CourseList.add(new Course(UUID.randomUUID(), "CISC181", 3, eMajor.CHEM));

		SemesterList.add(new Semester(UUID.randomUUID(), new Date(9 / 31 / 2018), new Date(12 / 15 / 2018)));
		SemesterList.add(new Semester(UUID.randomUUID(), new Date(2 / 7 / 2019), new Date(5 / 30 / 2019)));

		SectionList.add(new Section(CourseList.get(0).getCourseID(), SemesterList.get(0).getSemesterID(),
				UUID.randomUUID(), 123));
		SectionList.add(new Section(CourseList.get(1).getCourseID(), SemesterList.get(0).getSemesterID(),
				UUID.randomUUID(), 456));
		SectionList.add(new Section(CourseList.get(2).getCourseID(), SemesterList.get(0).getSemesterID(),
				UUID.randomUUID(), 678));

		SectionList.add(new Section(CourseList.get(0).getCourseID(), SemesterList.get(1).getSemesterID(),
				UUID.randomUUID(), 123));
		SectionList.add(new Section(CourseList.get(1).getCourseID(), SemesterList.get(1).getSemesterID(),
				UUID.randomUUID(), 456));
		SectionList.add(new Section(CourseList.get(2).getCourseID(), SemesterList.get(1).getSemesterID(),
				UUID.randomUUID(), 678));

		StudentList.add(new Student("Tom", "J", "Smith", new Date(3 / 21 / 96), eMajor.PHYSICS, "111 Purple Road",
				"(432)-953-0285", "tomsmith@udel.edu"));
		StudentList.add(new Student("Willy", "J", "Smith", new Date(3 / 21 / 96), eMajor.BUSINESS, "112 Purple Road",
				"(321)-928-4729", "willsmith@udel.edu"));
		StudentList.add(new Student("Sally", "J", "Smith", new Date(3 / 21 / 96), eMajor.PHYSICS, "113 Purple Road",
				"(029)-384-7591", "sallysmith@udel.edu"));
		StudentList.add(new Student("Harry", "J", "Smith", new Date(3 / 21 / 96), eMajor.NURSING, "114 Purple Road",
				"(123)-495-8371", "harrysmith@udel.edu"));
		StudentList.add(new Student("Louie", "J", "Smith", new Date(3 / 21 / 96), eMajor.COMPSI, "115 Purple Road",
				"(531)-239-4851", "louiesmith@udel.edu"));
		StudentList.add(new Student("Mike", "J", "Smith", new Date(3 / 21 / 96), eMajor.CHEM, "116 Purple Road",
				"(531)-235-0391", "mikesmith@udel.edu"));
		StudentList.add(new Student("Ted", "J", "Smith", new Date(3 / 21 / 96), eMajor.PHYSICS, "117 Purple Road",
				"(531)-249-5872", "tedsmith@udel.edu"));
		StudentList.add(new Student("Dad", "J", "Smith", new Date(3 / 21 / 96), eMajor.COMPSI, "118 Purple Road",
				"(532)-920-5837", "dadsmith@udel.edu"));
		StudentList.add(new Student("Po", "J", "Smith", new Date(3 / 21 / 96), eMajor.CHEM, "119 Purple Road",
				"(532)-349-3015", "posmith@udel.edu"));
		StudentList.add(new Student("K", "J", "Smith", new Date(3 / 21 / 96), eMajor.PHYSICS, "120 Purple Road",
				"(539)-185-7102", "ksmith@udel.edu"));

	}

	@Test
	public void TestEnrollment() {
		for (Student student : StudentList) {
			for (Section section : SectionList) {
				Enrollment e = new Enrollment(student.getStudentID(), section.getCourseID());
				e.setGrade(4.0);
				EnrollmentList.add(e);
			}
		}
	}

	@Test
	public void TestGPA() {
		for (Student s : StudentList) {
			double GPA = 0;
			for (Enrollment e : EnrollmentList) 
			{
				GPA = +e.getGrade();
			}

			assertEquals(4.0, GPA, .01);
		}
	}

	@Test
	public void TestCourseAvgGrades() {
		for (Course c : CourseList) {
			double avg = 0;
			{
				avg += c.getGradePoints();
			}
			assertEquals(3.0, avg, .01);
		}
	}

	@Test
	public void TestChangeMajor() {
		StudentList.get(0).setMajor(eMajor.NURSING);
		assertEquals(eMajor.NURSING, StudentList.get(0).getMajor());
	}
}