package Utils;

import javax.swing.JOptionPane;

import Classes.Dates;

public class FunctionsDate {
	public static String Dateini() {
		Dates object = null;
		object = new Dates("01/01/2000");
		System.out.println(object);
//		String date1 = object.dateSys();
		String dateini = object.dateSys();
		return dateini;

	}

	public static Dates DefaultDate() {
		Dates object = null;
		object = new Dates("01/01/2021");
		System.out.println(object);
//		String date1 = object.dateSys();
//		String dateini = object.dateSys();
//		object = new Dates(dateini);

		return object;

	}

	public static String Datefin(int type1) {
		Dates object = null;
		object = new Dates("01/01/2000");
		String datefin = object.arrivedate(type1);
		return datefin;

	}

	public static String Datexpire(Dates expires) {
//		Dates object = null;
//		object = new Dates("01/01/2000");
		String expire = expires.datexpire;
		return expire;

	}

	public static Dates dateSys() {
		Dates object = null;
		object = new Dates("01/01/2000");
		System.out.println(object);
//		String date1 = object.dateSys();
		String dateini = object.dateSys();
		object = new Dates(dateini);

		return object;
	}

	public static Dates dataArrival(int type1) {
		Dates object = null;
		object = new Dates("01/01/2000");
		String datefin = object.arrivedate(type1);
		object = new Dates(datefin);

		return object;
	}

//
	public static Dates expired() {
		boolean result = false;
		Dates expire = null;
		String exUs = "";
		expire = new Dates("01/01/2000");

		do {
			exUs = Functions.validaString("Warranty ", "Put date when expire warranty");
			System.out.println(exUs + " hello?");
			System.out.println(expire + "object");
			result = Regex.v_date(exUs);
			if (result == false) {
				JOptionPane.showMessageDialog(null, "Invalid Format", "The formate", JOptionPane.WARNING_MESSAGE);

			} else {

				if (result == false) {
					JOptionPane.showMessageDialog(null, "Invalid Format", "The formate", JOptionPane.WARNING_MESSAGE);
				} else {
					result = false;
					expire.dateUser(exUs);
					System.out.println(expire.dateUser(exUs) + "okey?");
					result = expire.v_date();// valide date format (01/01/2000");
					System.out.println(result + "false Pls");
					if (result == false) {
						JOptionPane.showMessageDialog(null, "Invalid Format", "The formate",
								JOptionPane.WARNING_MESSAGE);

					} else {
						result = false;
						result = expire.compDates(exUs);
						System.out.println(expire.compDates(exUs));
						if (result == false) {
							JOptionPane.showMessageDialog(null, "Put correct date", "Invalid Date",
									JOptionPane.WARNING_MESSAGE);
						}

					}
				}
			}
			System.out.println(result + "what is true?");
		} while (result == false);
		expire = new Dates(exUs); // CREATE
		expire.expire(); // save variable
		System.out.println(expire.datexpire + " expire saved date");
		System.out.println(exUs + " saved date");
		System.out.println(expire + " object");

		return expire;
	}

	public static Dates borndate() {
		boolean result = false;
		Dates born = null;
		int edad = 0;
		String born_date = "";
		born = new Dates("01/01/2000");

		do {
			born_date = Functions.validaString("Born", "Born date");
			born.dateUser(born_date);
			result = born.v_date();// validate the format "01/01/2000");
			if (result == false) {
				JOptionPane.showMessageDialog(null, "Invalid Format", "The formate", JOptionPane.WARNING_MESSAGE);
			} else {
				result = false;
				edad = born.RestYears();
				System.out.println(edad);
				if (edad < 18 || edad > 80) {// Condicio, per a una edad valida
					JOptionPane.showMessageDialog(null, "Invalid age", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					System.out.println("not ENTER");
					result = true;
				}
			}
			System.out.println(result + "what is ture?");
		} while (result == false);
		born = new Dates(born_date); // CREATE
		System.out.println(born_date + "hello?");
		System.out.println(born + "object");

		return born;
	}

}
