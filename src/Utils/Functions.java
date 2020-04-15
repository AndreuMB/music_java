package Utils;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Functions {

	// validate int
	public static int validaInt(String title, String message) {
		int n = 0;
		String num = "";
		boolean switch_ = false;

		do { // start while
			try {
				num = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
				if (num == null) {
					JOptionPane.showMessageDialog(null, "You exit", "Exit", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0); // user exit or cancel app close
				} else {
					n = Integer.parseInt(num); // string to int
					switch_ = true;
				}
			} catch (Exception e) { // when error jump here
				JOptionPane.showMessageDialog(null, "Error, try it other time", "Error", JOptionPane.ERROR_MESSAGE);
				switch_ = false;
			}
		} while (switch_ == false); // end while
		return n;
	}

	// Desplegable
	public static String combo(String[] combo_options, String title, String message) {
		/**
		 * This is secondary menu
		 */
		java.lang.Object combo = null;
		combo = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE, null, combo_options,
				combo_options[0]);
		System.out.println(combo + "here");
		if (combo == null) {
			JOptionPane.showMessageDialog(null, "You exit", "Exit", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(combo + " es null2");
			return "return";
		} else {
			return combo.toString();
		}
//		return combo.toString();

	}

	// botons
	public static int buttons(String[] options, String title, String message) {

		int n = 0;

		n = JOptionPane.showOptionDialog(null, message, title, 0, JOptionPane.QUESTION_MESSAGE, null, options,
				options[0]);

		return n;
	}

	public static int buttonsA(ArrayList<String> optionsA, String title, String message) {

		int n = 0;
		String array[] = new String[optionsA.size()];
		Iterator<String> read = optionsA.iterator();

		for (int i = 0; i < optionsA.size(); i++) {
			array[i] = read.next().toString(); // Assigned value to array
		}
		n = JOptionPane.showOptionDialog(null, message, title, 0, JOptionPane.QUESTION_MESSAGE, null, array, array[0]);

		return n;
	}

	// validate_String
	public static String validaString(String title, String message) {
		String cad = "";
		boolean switch_ = false;

//		do {
//			try {
//				cad = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
//				switch_ = false;
//				if (!cad.equals("")) {
//					JOptionPane.showMessageDialog(null, "Saliendo de la aplicación", "Saliendo",
//							JOptionPane.INFORMATION_MESSAGE);
//					System.exit(0); // user exit or cancel app close
//				} else {
//					JOptionPane.showMessageDialog(null, "Error de introducción de datos", "Error",
//							JOptionPane.ERROR_MESSAGE);
//					switch_ = false; // if answer is null
//				}
//			} catch (Exception e) {
//				JOptionPane.showMessageDialog(null, "No has introducido una cadena", "Error",
//						JOptionPane.ERROR_MESSAGE);
//				switch_ = false;
//			}
//		} while (switch_ == false);
//		return cad;

		do {
			try {
				cad = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
				switch_ = true;
				if (cad.equals("")) {
					JOptionPane.showMessageDialog(null, "Error itroduced dates", "Error", JOptionPane.ERROR_MESSAGE);
					switch_ = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Closing application", "Exit", JOptionPane.INFORMATION_MESSAGE);
//				System.exit(0);
				return "exit";
//				JOptionPane.showMessageDialog(null, "No ha introducido una cadena", "Error", JOptionPane.ERROR_MESSAGE);
//				switch_ = false;
			}
		} while (switch_ == false);
		return cad;
	}

	// valida float

	public static float validafloat(String message, String title) {
		String string = "";
		float num = 0.0f;
		boolean correct = false;

		do {
			try {
				string = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);

				if (string == null) {
					JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion", "Saliendo",
							JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				} else {
					num = Float.parseFloat(string);
					correct = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido un numero", "Error", JOptionPane.ERROR_MESSAGE);
				correct = false;
			}
		} while (correct == false);

		return num;
	}

//	public static void percussion(int type) {
//		int select = 0;
//		String[] options = { "C", "R", "U", "D", "Exit" };
//		Instruments drum1 = null;
//
//		do {
//			/**
//			 * Here is the main manu
//			 */
//			select = Functions.buttons(options, "Main menu", "Select one");
//
//			switch (select) {
//			case 0:
//				drum1 = FunctionsCRUDmusic.CreateDisk(type); // Create
//				break;
//			case 1:
//				if (drum1 == null) {
//					JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
//				} else {
//					JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.ReadDisk(drum1)); // READ
//				}
//				break;
//			case 2:
//				if (drum1 == null) {
//					JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
//				} else {
//					JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.UpdateDisk(drum1)); // UPDATE
//				}
//				break;
//			case 3:
//				if (drum1 == null) {
//					JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
//				} else {
//					FunctionsCRUDmusic.DeleteDisk(drum1); // DELETE
//					drum1 = null;
//					JOptionPane.showMessageDialog(null, "You delete the object", "Delete",
//							JOptionPane.INFORMATION_MESSAGE);
//				}
//				break;
//			case 4:
//				JOptionPane.showMessageDialog(null, "You select " + options[4], "Output",
//						JOptionPane.INFORMATION_MESSAGE);
//				break;
//			}
//
//		} while ((select != 4));
//	}
//
//	public static void keyboard(int type) {
//		int select = 0;
//		String[] options = { "C", "R", "U", "D", "Exit" };
//		Instruments keyboard1 = null;
//
//		do {
//			/**
//			 * Here is the main manu
//			 */
//			select = Functions.buttons(options, "Main menu", "Select one");
//
//			switch (select) {
//			case 0:
//				keyboard1 = FunctionsCRUDmusic.CreateDisk(type); // Create
//				break;
//			case 1:
//				if (keyboard1 == null) {
//					JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
//				} else {
//					JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.ReadDisk(keyboard1)); // READ
//				}
//				break;
//			case 2:
//				if (keyboard1 == null) {
//					JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
//				} else {
//					JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.UpdateDisk(keyboard1)); // UPDATE
//				}
//				break;
//			case 3:
//				if (keyboard1 == null) {
//					JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
//				} else {
//					FunctionsCRUDmusic.DeleteDisk(keyboard1); // DELETE
//					keyboard1 = null;
//					JOptionPane.showMessageDialog(null, "You delete the object", "Delete",
//							JOptionPane.INFORMATION_MESSAGE);
//				}
//				break;
//			case 4:
//				JOptionPane.showMessageDialog(null, "You select " + options[4], "Output",
//						JOptionPane.INFORMATION_MESSAGE);
//				break;
//			}
//
//		} while ((select != 4));
//	}
//
//	public static void guitar(int type) {
//		int select = 0;
//		String[] options = { "C", "R", "U", "D", "Exit" };
//		boolean switch_1 = true;
//		Guitars guitar1 = null;
//
//		do {
//			/**
//			 * Here is the main manu
//			 */
//			select = Functions.buttons(options, "Main menu", "Select one");
//
//			switch (select) {
//			case 0:
//				guitar1 = (Guitars) FunctionsCRUDmusic.CreateDisk(type); // Create
//				switch_1 = true;
//				break;
//			case 1:
//				if (switch_1 == false) {
//					JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
//				} else {
//					JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.ReadDisk(guitar1)); // READ
//				}
//				break;
//			case 2:
//				if (switch_1 == false) {
//					JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
//				} else {
//					JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.UpdateDisk(guitar1)); // UPDATE
//				}
//				break;
//			case 3:
//				if (switch_1 == false) {
//					JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
//				} else {
//					FunctionsCRUDmusic.DeleteDisk(guitar1); // DELETE
//					guitar1 = null;
//					JOptionPane.showMessageDialog(null, "You delete the object", "Delete",
//							JOptionPane.INFORMATION_MESSAGE);
//				}
//				break;
//			case 4:
//				JOptionPane.showMessageDialog(null, "You select " + options[4], "Output",
//						JOptionPane.INFORMATION_MESSAGE);
//				break;
//			}
//
//		} while ((select != 4));
//	}
}
