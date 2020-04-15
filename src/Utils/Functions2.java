package Utils;

import javax.swing.JOptionPane;

public class Functions2 {
	public static void Exer1(String title, String message) {
		String result = "";
		boolean switch_ = false;
		int n = 0, n2 = 0, average = 0, odd = 0;
		int cont = 0, cont2 = 0;
		do {
			n = Functions.validaInt("Number", "Put a number");
			if ((n < 80) && (n > 20)) {
				for (int i = 0; i < 10; i++) {
					if ((n % 2) == 0) {
						odd = n + 1;
					} else {
						if (cont2 == 0) {
							n2 = n + 2;
							odd = n2;
							System.out.println(odd);
						}
						cont2++;
						n2 = n2 + 2;
						odd = odd + n2;
						System.out.println(odd);
					}
				}
				average = odd / 10;
				result = result + (n + "=" + average + "\n");
				cont++;

				if (cont == 4) {
					switch_ = true;
				}
			}
		} while (switch_ == false);
		JOptionPane.showMessageDialog(null, result, "Output", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void Exer2(String title, String message) {
		int n = 0;
		boolean switch_1 = false, switch_2 = false;
		int prod = 1, rest = 0, sum = 0, no = 0;
		String result = "";

		do { // start while

			n = Functions.validaInt(message, title);

			if (n == -1) { // if x finish
				switch_1 = true;
			} else { // if not x do...
				switch_2 = false;
				prod = 1;
				sum = 0;
				no = n;
				System.out.println(no);
				while (switch_2 == false) { // start while
					if (n == 0) {
						switch_2 = true; // when division = 0 (no more nums) while finish
					} else { // else save digit in rest
						rest = n % 10; // digit
						n = n / 10;
						if ((rest % 2) == 0) { // if is pair digits
							prod = prod * rest;
							System.out.println(prod);
						} else {
							sum = sum + rest; // sum pair digits
							System.out.println(sum);
						}
					}
				}
				if (prod != 1) {
					result = result + (no + " pair digits prod is = " + prod + "\n");
				}
				System.out.println(sum + "suma");
				if (sum > 0) {
					result = result + (no + " odd digits sum is = " + sum + "\n");
				}
			}
		} while (switch_1 == false); // end while

		JOptionPane.showMessageDialog(null, result, "Output", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void Exer3(String title, String message) {
		// 1 to x num you put
		int n = 0, n2 = 0, cont = 0, contodd = 0;
		String check = "";
		int prod = 1, oddd = 0, average = 0;

		n = Functions.validaInt(message, title);
		n2 = Functions.validaInt("Put number", "Number");

		for (int i = 1; i <= n; i++) { // start for, while 1 to x introduced num, inside put things you want to do

			for (int j = 1; j <= i; j++) { // j is divider
				if ((i % j) == 0) { // check if is divider
					if ((j % 2) != 0) { // check if is odd
						System.out.println(j);
						prod = prod * j;
						cont++;
					}
				}
			} // Finish dividers of number
			if (prod == n2) {
				check = check + ("Product of odd dividers of number " + i + " its same as " + n2 + "\n");
			}
			if (cont == 3) {
				oddd = oddd + i;
				contodd++;
				System.out.println(i + "have 3 odd dividers");
			}
			cont = 0;
			prod = 1;
		}
		System.out.println(oddd + "/" + contodd);
		if (contodd != 0) {
			average = oddd / contodd;
			check = check + ("Average of numbers have 3 odd dividers is " + average);
		} else {
			check = check + ("Not are any number have 3 odd dividers");
		}
		JOptionPane.showMessageDialog(null, check, "Outcome", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void Exer4(String title, String message) {
		int n = 0;
		boolean switch_1 = false, switch_2 = false;
		int multiple = 0, rest = 0, no = 0, cont = 0, average = 0, first = 0, higher = 0, conth = 0, contp = 0, sum = 0;
		String result = "";

		do { // start while

			n = Functions.validaInt(message, title);

			if (n == -5) { // if x finish
				switch_1 = true;
			} else { // if not x do...
				switch_2 = false;
				contp = 0;
				no = n; // n changes for know digits her save initial n
				System.out.println(no);
				while (switch_2 == false) { // start while of digits of n
					if (n == 0) {
						switch_2 = true; // when division = 0 (no more nums) while finish
					} else { // else save digit in rest
						rest = n % 10; // digit
						n = n / 10;
						if (first == 0) {
							higher = rest;
							first++;
						} else {
							if (higher == rest) {
								conth++;
							}
						}
						if (rest > higher) {
							conth = 0;
							higher = rest;
						}
						if ((rest % 3) == 0) { // if digit is multiple of 3
							multiple = multiple + rest;
							System.out.println(multiple);
							cont++;
						}
						if ((rest % 2) == 0) { // if is pair digits
							contp++;
						}
					}
				}
				if (contp == 2) {
					sum = sum + no;
				}
			}
		} while (switch_1 == false); // end while
		if (multiple != 0) {
			average = multiple / cont;
		}
		result = result + ("Average = " + average + "\nHigher num = " + higher + " repeated " + conth + " times\n"
				+ "Sum of numbers have pair digits is " + sum);
		JOptionPane.showMessageDialog(null, result, "Output", JOptionPane.INFORMATION_MESSAGE);
	}
}
