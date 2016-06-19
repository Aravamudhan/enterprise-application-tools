package com.amudhan.springcore.springExpressionLanguage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomNumberGenerator {
	/*Random numbers are generated and injected*/
	@Value("#{T(java.lang.Math).random() * 10}")
	private int digitOneRandomNumber;
	
	@Value("#{T(java.lang.Math).random() * 100}")
	private int digitTwoRandomNumber;
	
	@Value("#{T(java.lang.Math).random() * 1000}")
	private int digitThreeRandomNumber;

	@Value("#{systemProperties['user.country']}")
	private String userCountry;

	@Override
	public String toString() {
		return "RandomNumberGenerator [digitOneRandomNumber="
				+ digitOneRandomNumber + ", digitTwoRandomNumber="
				+ digitTwoRandomNumber + ", digitThreeRandomNumber="
				+ digitThreeRandomNumber + ", userCountry=" + userCountry + "]";
	}

	public int getDigitOneRandomNumber() {
		return digitOneRandomNumber;
	}

	public void setDigitOneRandomNumber(int digitOneRandomNumber) {
		this.digitOneRandomNumber = digitOneRandomNumber;
	}

	public int getDigitTwoRandomNumber() {
		return digitTwoRandomNumber;
	}

	public void setDigitTwoRandomNumber(int digitTwoRandomNumber) {
		this.digitTwoRandomNumber = digitTwoRandomNumber;
	}

	public int getDigitThreeRandomNumber() {
		return digitThreeRandomNumber;
	}

	public void setDigitThreeRandomNumber(int digitThreeRandomNumber) {
		this.digitThreeRandomNumber = digitThreeRandomNumber;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}
}
