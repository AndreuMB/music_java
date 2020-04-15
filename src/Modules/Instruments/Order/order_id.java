package Modules.Instruments.Order;

import java.util.Comparator;

import Classes.Instruments;

public class order_id implements Comparator<Instruments> {
	public int compare(Instruments u1, Instruments u2) {

		if (u1.getId().compareTo(u2.getId()) > 0)
			return 1;
		if (u1.getId().compareTo(u2.getId()) < 0)
			return -1;
		return 0;
	}
}
