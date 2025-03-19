package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class RandomAccessUtilities {
	static Faker faker;

	public static String getCategoryName() {
		faker = new Faker();
		return faker.commerce().department();// to generate random product category
	}
	public static String getpassword() {
		faker = new Faker();
		return faker.internet().password();
	}
	
	public static String getFirstName() {
		faker = new Faker(new Locale("en-IND"));// to get the local names in india.if you want us,then provide us
		return faker.name().firstName();

	}
	
	// lastName
	public static String getLastName() {
		faker = new Faker(new Locale("en-IND"));// to get the local names in india.if you want us,then provide us
		return faker.name().lastName();

	}
	// fullName

	public static String getFullAddress() {
		faker = new Faker(new Locale("en-IND"));
		return faker.address().fullAddress();
	}

	public static String getBuildingNumberWithStreetAddress() {
		faker = new Faker(new Locale("en-IND"));
		String buildingNumber = faker.address().buildingNumber();
		String streetAddress = faker.address().streetAddress();
		return buildingNumber + streetAddress;
	}
	// country
	// state

	public static String getPhoneNumber() {
		faker = new Faker(new Locale("en-IND"));
		String extension = faker.phoneNumber().extension();
		String phoneNumber = faker.phoneNumber().cellPhone().concat(extension);
		return phoneNumber;
	}

	public static String getEmail() {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 5;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String randomStringEmail = sb.toString() + "@gmail.com";
		return randomStringEmail;
	}

	public static String getDateOfBirth_Day() {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("dd");// month-mm//year yyyy
		faker = new Faker();
		String date = simpledateformat.format(faker.date().birthday());
		return date;

	}

	// to generate age between 18 to 60
	public static Date getAge() {
		faker = new Faker();
		return faker.date().birthday(18, 60);
	}

	public static String getDateOfBirth() {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-mm-yyyy");// month-mm//year yyyy
		faker = new Faker();
		Date date = faker.date().birthday(18, 60);
		return simpledateformat.format(date);

	}

	// generate random quantity
	public int getQuantity() {
		faker = new Faker();
		return faker.number().numberBetween(1, 1000);
	}

}
