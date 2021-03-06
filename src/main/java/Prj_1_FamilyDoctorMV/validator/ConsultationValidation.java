package Prj_1_FamilyDoctorMV.validator;

import Prj_1_FamilyDoctorMV.exceptions.PatientException;
import Prj_1_FamilyDoctorMV.repository.Repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsultationValidation {
	public static void ssidValidate(String name, Repository rep) throws PatientException {
		if (name.length() == 0) {
			throw new PatientException("One of the required fields is empty!");
		}
		Pattern pattern = Pattern.compile("^[a-zA-Z -]+$");
		Matcher matcher = pattern.matcher(name);
		if (!matcher.find()) {
			throw new PatientException("The \"name\" field has an invalid format!");
		}
	}
	
	public static void ssnValidate(String ssn) throws PatientException {
		if (ssn.length() != 13) {
			throw new PatientException("SSN has the length != 13");
		}
		Pattern pattern = Pattern.compile("^\\d+$");
		Matcher matcher = pattern.matcher(ssn);
		if (!matcher.find()) {
			throw new PatientException("The \"ssn\" field has an invalid format!");
		}
	}
	
	public static void addressValidate(String address) throws PatientException {
		if (address.length() == 0) {
			throw new PatientException("One of the required fields is empty!");
		}
	}
}
