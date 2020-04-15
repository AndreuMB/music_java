package Modules.Instruments.Order;

import java.util.Comparator;

import Classes.Instruments;

public class order_date implements Comparator<Instruments> {
	public int compare(Instruments u1, Instruments u2) {
		return u1.getDate2().comparedate(u2.getDate2());
	}
}
