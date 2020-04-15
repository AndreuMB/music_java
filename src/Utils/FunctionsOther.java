package Utils;

import javax.swing.JOptionPane;

public class FunctionsOther {

	public static int digit(String title, String message) {
		// Diseña un algoritmo en el que dado un num introducido por teclado, que sume
		// sus dígitos pares.
		int n = 0;
		String num = "";
		boolean switch_ = false, switch_1 = false;
		int sum = 0, rest = 0;

		do { // start while
			try {
				num = JOptionPane.showInputDialog(null, "Put number ", "Number", JOptionPane.QUESTION_MESSAGE);
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

		while (switch_1 == false) { // start while
			if (n == 0) {
				switch_1 = true; // when division = 0 (no more nums) while finish
			} else { // else save digit in rest
				rest = n % 10; // digit
				n = n / 10;
				System.out.println(rest);
				if ((rest % 2) == 0) { // take pair digits and sum
					sum = sum + rest;
				}
			}
		} // end while
		JOptionPane.showMessageDialog(null, sum, "Number", JOptionPane.INFORMATION_MESSAGE);
		return sum;

	}

}
