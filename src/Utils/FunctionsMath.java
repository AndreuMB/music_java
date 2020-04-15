package Utils;

import javax.swing.JOptionPane;

public class FunctionsMath {
	public static int sum(String title, String message) {
		// Diseña un algoritmo que imprima la suma de num introducidos por teclado. El
		// algoritmo para al introducir un 0.
		String num = "";
		int n = 0;
		boolean switch_ = false;
		boolean switch_1 = false;
		int sum = 0;

		do {

			do {
				try {
					num = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
					if (num == null) {
						JOptionPane.showMessageDialog(null, "You exit", "Exit", JOptionPane.INFORMATION_MESSAGE);
						return 0;
//						System.exit(0);
					} else {
						n = Integer.parseInt(num);
						switch_ = true;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error, try it other time", "Error", JOptionPane.ERROR_MESSAGE);
					switch_ = false;
				}
			} while (switch_ == false);

			if (n == 0) {
				switch_1 = true;
			} else {
				sum = sum + n;
				System.out.println(sum);
			}
		} while (switch_1 == false);

		JOptionPane.showMessageDialog(null, sum, "Sum", JOptionPane.INFORMATION_MESSAGE);
		return sum;
	}

	public static int rest(String title, String message) {
		// Diseña un algoritmo que imprima la resta de num introducidos por teclado. El
		// algoritmo para al introducir un 0.
		int n1 = 0;
		boolean switch_ = false, switch_1 = false;
		String num1 = "";
		int math = 0;
		int cont = 0;

		do {
			do {
				try {
					num1 = JOptionPane.showInputDialog(null, "Put number, for finish put 0", "Number",
							JOptionPane.QUESTION_MESSAGE);
					if (num1 == null) {
						JOptionPane.showMessageDialog(null, "You exit", "Exit", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					} else {
						n1 = Integer.parseInt(num1);
						switch_ = true;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error, try it other time", "Error", JOptionPane.ERROR_MESSAGE);
					switch_ = false;
				}
			} while (switch_ == false);
			System.out.println(n1);
			if (n1 == 0) { // if 0 finish
				switch_1 = true;
			} else { // if not 0 do...
				cont++;
				if (cont == 1) {
					math = n1;
				} else {
					math = math - n1;
					System.out.println(math);
				}
			}
		} while (switch_1 == false); // end while
		JOptionPane.showMessageDialog(null, "Rest: " + math);
		return math;
	}

	public static int prod(String title, String message) {
		// Diseña un algoritmo que imprima el producto de num introducidos por teclado.
		// El algoritmo para al introducir un 0.
		int n1 = 0;
		boolean switch_ = false, switch_1 = false;
		String num1 = "";
		int math = 1;

		do {
			do {
				try {
					num1 = JOptionPane.showInputDialog(null, "Put number, for finish put 0", "Number",
							JOptionPane.QUESTION_MESSAGE);
					if (num1 == null) {
						JOptionPane.showMessageDialog(null, "You exit", "Exit", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					} else {
						n1 = Integer.parseInt(num1);
						switch_ = true;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error, try it other time", "Error", JOptionPane.ERROR_MESSAGE);
					switch_ = false;
				}
			} while (switch_ == false);

			if (n1 == 0) { // if 0 finish
				switch_1 = true;
			} else { // if not 0 do...
				math = math * n1;
				System.out.println(math);
			}
		} while (switch_1 == false); // end while
		JOptionPane.showMessageDialog(null, "Product: " + math);
		return math;

	}

	public static int div(String title, String message) {
		// Diseña un algoritmo que imprima la division de num introducidos por teclado.
		// El
		// algoritmo para al introducir un 0.
		int n1 = 0;
		boolean switch_ = false, switch_1 = false;
		String num1 = "";
		int math = 0;
		int cont = 0;

		do {
			do {
				try {
					num1 = JOptionPane.showInputDialog(null, "Put number, for finish put 0", "Number",
							JOptionPane.QUESTION_MESSAGE);
					if (num1 == null) {
						JOptionPane.showMessageDialog(null, "You exit", "Exit", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					} else {
						n1 = Integer.parseInt(num1);
						switch_ = true;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error, try it other time", "Error", JOptionPane.ERROR_MESSAGE);
					switch_ = false;
				}
			} while (switch_ == false);

			if (n1 == 0) { // if 0 finish
				switch_1 = true;
				System.out.println(n1);
			} else { // if not 0 do...
				cont++;
				if (cont == 1) {
					math = n1;

				} else {
					math = math / n1;
					System.out.println(math);
				}
			}
		} while (switch_1 == false); // end while
		JOptionPane.showMessageDialog(null, "Div: " + math);
		return math;
	}
}
