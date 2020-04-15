package Modules.Instruments.Order;

import java.util.Comparator;

import Classes.Instruments;

public class order_price implements Comparator<Instruments> {
	public int compare(Instruments u1, Instruments u2) {
		String str1 = Float.toString(u1.getPrice());
		String str2 = Float.toString(u2.getPrice());
		if (str1.compareTo(str2) > 0)
			return 1;
		if (str1.compareTo(str1) < 0)
			return -1;
		return 0;
	}
}
