package com.cwm.studentmanagement.config;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cwm.studentmanagement.model.Courses;
import com.cwm.studentmanagement.model.Enrollment;
import com.cwm.studentmanagement.model.Students;
import com.cwm.studentmanagement.model.Users;
import com.cwm.studentmanagement.repository.CourseRepository;
import com.cwm.studentmanagement.repository.EnrollmentRepository;
import com.cwm.studentmanagement.repository.StudentRepository;
import com.cwm.studentmanagement.repository.UsersRepository;

@Configuration
public class DataIntializer {

	@Bean
	CommandLineRunner loadSampleData(UsersRepository usersRepository,
			PasswordEncoder passwordEncoder,
			StudentRepository studentRepository,
			CourseRepository courseRepository,
			EnrollmentRepository enrollmentRepository) {

		return args -> {

			// ── Admin user ──────────────────────────────────────────────────
			if (!usersRepository.existsByUsername("Admin")) {
				Users users = new Users();
				users.setUsername("Admin");
				users.setPassword(passwordEncoder.encode("admin@123"));
				users.setActive(true);
				usersRepository.save(users);
			}

			// ── Skip if mock data already exists ────────────────────────────
			if (courseRepository.count() > 0 || studentRepository.count() > 0) {
				return;
			}

			// ── Courses ─────────────────────────────────────────────────────
			Courses java = course("Java Programming", "CS101", "3 Months",
					new BigDecimal("4999.00"),
					"Comprehensive Java course covering OOP, collections, streams and Spring Boot fundamentals.");

			Courses python = course("Python for Data Science", "DS201", "4 Months",
					new BigDecimal("5999.00"),
					"Learn Python, Pandas, NumPy, Matplotlib, and introductory machine learning.");

			Courses webDev = course("Full Stack Web Development", "WD301", "6 Months",
					new BigDecimal("8999.00"),
					"HTML, CSS, JavaScript, React, Node.js and REST APIs from scratch to production.");

			Courses dbms = course("Database Management Systems", "DB102", "2 Months",
					new BigDecimal("3499.00"),
					"SQL, normalization, transactions, indexing and hands-on MySQL & PostgreSQL.");

			Courses cloudAws = course("AWS Cloud Practitioner", "CL401", "3 Months",
					new BigDecimal("6499.00"),
					"Prepare for AWS CLF-C02 exam. EC2, S3, Lambda, VPC and cloud security essentials.");

			Courses android = course("Android App Development", "AD501", "5 Months",
					new BigDecimal("7499.00"),
					"Build production-ready Android apps using Kotlin, Jetpack Compose and Firebase.");

			Courses cybersec = course("Ethical Hacking & Cybersecurity", "CS601", "4 Months",
					new BigDecimal("6999.00"),
					"Penetration testing, OWASP Top 10, network security and CEH exam prep.");

			Courses uiux = course("UI/UX Design Fundamentals", "UX701", "2 Months",
					new BigDecimal("3999.00"),
					"Figma, wireframing, prototyping and user research for modern product design.");

			List<Courses> savedCourses = courseRepository.saveAll(
					List.of(java, python, webDev, dbms, cloudAws, android, cybersec, uiux));

			Courses c_java = savedCourses.get(0);
			Courses c_python = savedCourses.get(1);
			Courses c_webDev = savedCourses.get(2);
			Courses c_dbms = savedCourses.get(3);
			Courses c_aws = savedCourses.get(4);
			Courses c_android = savedCourses.get(5);
			Courses c_cyber = savedCourses.get(6);
			Courses c_uiux = savedCourses.get(7);

			// ── Students ─────────────────────────────────────────────────────
			Students aarav = student("Aarav", "Sharma", "aarav.sharma@gmail.com", "9876543210",
					"12, MG Road, Bangalore, Karnataka");
			Students priya = student("Priya", "Patel", "priya.patel@gmail.com", "9123456789",
					"45, Nehru Street, Ahmedabad, Gujarat");
			Students rohan = student("Rohan", "Mehta", "rohan.mehta@outlook.com", "8765432109",
					"7, Lal Bagh, Pune, Maharashtra");
			Students ananya = student("Ananya", "Singh", "ananya.singh@yahoo.com", "7654321098",
					"89, Civil Lines, Lucknow, UP");
			Students vikram = student("Vikram", "Nair", "vikram.nair@gmail.com", "9988776655",
					"22, Park Street, Kolkata, WB");
			Students sneha = student("Sneha", "Reddy", "sneha.reddy@gmail.com", "8899001122",
					"55, Banjara Hills, Hyderabad, Telangana");
			Students arjun = student("Arjun", "Kumar", "arjun.kumar@hotmail.com", "7711223344", "3, Saket, New Delhi");
			Students pooja = student("Pooja", "Iyer", "pooja.iyer@gmail.com", "9900112233",
					"78, Anna Nagar, Chennai, TN");
			Students rahul = student("Rahul", "Gupta", "rahul.gupta@gmail.com", "8822334455",
					"34, Sector 15, Chandigarh");
			Students kavya = student("Kavya", "Verma", "kavya.verma@outlook.com", "9811223344",
					"19, Model Town, Jalandhar, Punjab");
			Students aditya = student("Aditya", "Joshi", "aditya.joshi@gmail.com", "7799001100",
					"6, Tilak Nagar, Jaipur, Rajasthan");
			Students meera = student("Meera", "Nambiar", "meera.nambiar@gmail.com", "8833445566",
					"101, Vytila, Kochi, Kerala");
			Students siddharth = student("Siddharth", "Bose", "siddharth.bose@gmail.com", "9944556677",
					"5, Salt Lake, Kolkata, WB");
			Students lakshmi = student("Lakshmi", "Pillai", "lakshmi.pillai@yahoo.com", "8866778899",
					"33, Pondicherry Main Rd, Pondicherry");
			Students nikhil = student("Nikhil", "Tiwari", "nikhil.tiwari@gmail.com", "9955667788",
					"50, Hazratganj, Lucknow, UP");

			List<Students> saved = studentRepository.saveAll(
					List.of(aarav, priya, rohan, ananya, vikram, sneha, arjun,
							pooja, rahul, kavya, aditya, meera, siddharth, lakshmi, nikhil));

			Students s1 = saved.get(0); // Aarav
			Students s2 = saved.get(1); // Priya
			Students s3 = saved.get(2); // Rohan
			Students s4 = saved.get(3); // Ananya
			Students s5 = saved.get(4); // Vikram
			Students s6 = saved.get(5); // Sneha
			Students s7 = saved.get(6); // Arjun
			Students s8 = saved.get(7); // Pooja
			Students s9 = saved.get(8); // Rahul
			Students s10 = saved.get(9); // Kavya
			Students s11 = saved.get(10); // Aditya
			Students s12 = saved.get(11); // Meera
			Students s13 = saved.get(12); // Siddharth
			Students s14 = saved.get(13); // Lakshmi
			Students s15 = saved.get(14); // Nikhil

			// ── Enrollments ──────────────────────────────────────────────────
			enrollmentRepository.saveAll(List.of(
					enroll(s1, c_java, daysAgo(90)),
					enroll(s1, c_webDev, daysAgo(60)),
					enroll(s2, c_python, daysAgo(75)),
					enroll(s2, c_uiux, daysAgo(30)),
					enroll(s3, c_java, daysAgo(45)),
					enroll(s3, c_dbms, daysAgo(45)),
					enroll(s4, c_webDev, daysAgo(20)),
					enroll(s4, c_uiux, daysAgo(20)),
					enroll(s5, c_aws, daysAgo(55)),
					enroll(s5, c_cyber, daysAgo(40)),
					enroll(s6, c_python, daysAgo(35)),
					enroll(s6, c_android, daysAgo(35)),
					enroll(s7, c_java, daysAgo(10)),
					enroll(s8, c_uiux, daysAgo(15)),
					enroll(s8, c_python, daysAgo(15)),
					enroll(s9, c_dbms, daysAgo(50)),
					enroll(s9, c_aws, daysAgo(50)),
					enroll(s10, c_android, daysAgo(25)),
					enroll(s11, c_webDev, daysAgo(5)),
					enroll(s12, c_cyber, daysAgo(65)),
					enroll(s13, c_java, daysAgo(80)),
					enroll(s13, c_dbms, daysAgo(80)),
					enroll(s14, c_uiux, daysAgo(12)),
					enroll(s15, c_python, daysAgo(7)),
					enroll(s15, c_aws, daysAgo(7))));
		};
	}

	// ── Helpers ──────────────────────────────────────────────────────────────

	private Courses course(String name, String code, String duration,
			BigDecimal fee, String description) {
		Courses c = new Courses();
		c.setCourseName(name);
		c.setCourseCode(code);
		c.setDuration(duration);
		c.setFee(fee);
		c.setDescription(description);
		c.setActive(true);
		return c;
	}

	private Students student(String firstName, String lastName,
			String email, String phone, String address) {
		Students s = new Students();
		s.setFirstName(firstName);
		s.setLastName(lastName);
		s.setEmail(email);
		s.setPhoneNumber(phone);
		s.setAddress(address);
		s.setActive(true);
		return s;
	}

	private Enrollment enroll(Students student, Courses course, LocalDateTime date) {
		Enrollment e = new Enrollment();
		e.setStudent(student);
		e.setCourse(course);
		e.setEnrolledDate(date);
		return e;
	}

	private LocalDateTime daysAgo(int days) {
		return LocalDateTime.now().minusDays(days);
	}
}
