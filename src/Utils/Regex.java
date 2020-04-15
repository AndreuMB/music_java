package Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	private static final String name = "^[a-zA-Z\\s]*$";
	private static final String id = "^([A-Z]{1})([0-9]{2})$";// 2 digits
	private static final String dni = "([0-9]{8})([A-Z])";
	private static final String email = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private static final String date = "(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/]((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))";
	private static final String age = "^[0-9]{1,2}$";

	// validate name
	public static boolean v_name(String namei) {
		Pattern pattern = Pattern.compile(name);
		Matcher matcher = pattern.matcher(namei);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public static boolean v_id(String idi) {
		Pattern pattern = Pattern.compile(id);
		Matcher matcher = pattern.matcher(idi);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public static boolean v_dni(String dnii) {
		Pattern pattern = Pattern.compile(dni);
		Matcher matcher = pattern.matcher(dnii);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public static boolean v_email(String emaili) {
		Pattern pattern = Pattern.compile(email);
		Matcher matcher = pattern.matcher(emaili);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public static boolean v_date(String datei) {
		Pattern pattern = Pattern.compile(date);
		Matcher matcher = pattern.matcher(datei);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public static boolean v_age(String agei) {
		Pattern pattern = Pattern.compile(age);
		Matcher matcher = pattern.matcher(agei);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public static String format0(double num) {
		DecimalFormat formatd = new DecimalFormat(".#");
		return formatd.format(num);
	}

	public static String format00(double num) {
		DecimalFormat formatd = new DecimalFormat(".##");
		return formatd.format(num);
	}

	public static String format000(double num) {
		DecimalFormat formatd = new DecimalFormat(".###");
		return formatd.format(num);
	}

	public static String FormatDollar(double money) {
		NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.US);
		return coin.format(money);
	}

	public static String FormatPound(double money) {
		NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.UK);
		return coin.format(money);
	}

	public static String FormatEuro(double money) {
		NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		return coin.format(money);
	}

}
