package utilities;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class DataHelper {
	private Locale local = new Locale("en");
	private Faker faker = new Faker(local);

	public static DataHelper getDataHelper() {
		return new DataHelper();
	}

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public String getCityName() {
		return faker.address().city();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getAddress() {
		return faker.address().streetAddress();
	}

	// Number/Text/Special
	public String getPassword() {
		return faker.internet().password(8, 12, true, true);
	}

	public int getNumber() {
		return faker.number().numberBetween(0, 1000);
	}

	public String generateRandomPrice() {
		Random random = new Random();
		// Sinh giá tiền ngẫu nhiên từ 1 đến 100 với hai chữ số thập phân
		double price = 1 + (100 - 1) * random.nextDouble();
		// Định dạng giá tiền theo ý muốn (ví dụ: hai chữ số thập phân)
		String formattedPrice = String.format("%.2f", price);
		return formattedPrice;
	}

	public static String generateRandomPriceGreaterThan(String minValue) {
		// Chuyển đổi giá trị giá tiền nhỏ nhất thành số để so sánh
		double minValueDouble = Double.parseDouble(minValue);

		// Tạo một giá tiền ngẫu nhiên lớn hơn giá tiền nhỏ nhất
		Random random = new Random();
		double price = minValueDouble + random.nextDouble() * (100 - minValueDouble);

		// Định dạng giá tiền theo ý muốn (ví dụ: hai chữ số thập phân)
		String formattedPrice = String.format("%.2f", price);

		return formattedPrice;
	}

}
