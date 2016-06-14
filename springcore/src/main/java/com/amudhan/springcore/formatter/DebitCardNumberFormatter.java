package com.amudhan.springcore.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

/*This is a user defined formatter. 
 *This is very helpful with web applications where the data coming from the front-end is mostly string.*/
/*To create a custom formatter, Format interface must be implemented along with print and parse methods,
*overriden*/
@Component("debitCardNumberFormatter")
public class DebitCardNumberFormatter implements Formatter<DebitCardNumber> {

	/*The overridden print method must return the object to be formatted in the printable format (i.e.) string*/
	@Override
	public String print(DebitCardNumber debitCardNumber, Locale locale) {
		return debitCardNumber.getFirstFourDigits()+"-"+debitCardNumber.getSecondFourDigits()+"-"+
				debitCardNumber.getThirdFourDigits()+"-"+debitCardNumber.getLastFourDigits();
	}

	@Override
	public DebitCardNumber parse(String text, Locale locale) throws ParseException {
		String[] debitCardNumbers = text.split("-");
		if(debitCardNumbers.length!=4){
			throw new org.springframework.expression.ParseException(-1, "Debit card number is invalid");
		}
		DebitCardNumber debitCardNumber=new DebitCardNumber();
		debitCardNumber.setFirstFourDigits(Integer.parseInt(debitCardNumbers[0]));
		debitCardNumber.setSecondFourDigits(Integer.parseInt(debitCardNumbers[1]));
		debitCardNumber.setThirdFourDigits(Integer.parseInt(debitCardNumbers[2]));
		debitCardNumber.setLastFourDigits(Integer.parseInt(debitCardNumbers[3]));
		return debitCardNumber;
	}

}
