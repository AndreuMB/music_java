package Modules.Instruments.Order;

import java.util.Comparator;

import Classes.Instruments;

public class order_maker implements Comparator<Instruments> {

	public int compare(Instruments u1, Instruments u2) {

		if (u1.getMaker().compareTo(u2.getMaker()) > 0)
			return 1;
		if (u1.getMaker().compareTo(u2.getMaker()) < 0)
			return -1;
		return 0;
	}
}
