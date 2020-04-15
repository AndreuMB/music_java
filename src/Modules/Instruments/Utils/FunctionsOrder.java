package Modules.Instruments.Utils;

import java.util.Collections;

import javax.swing.JOptionPane;

import Modules.Instruments.Order.order_date;
import Modules.Instruments.Order.order_maker;
import Modules.Instruments.Order.order_price;
import Utils.Functions;
import Utils.Functions_data;
import Utils.singleton;

public class FunctionsOrder {
	public static void order(int type) {

		int menu = 0;
		if (singleton.instruments.isEmpty()) {
			JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
//		ArrayList<Instruments> instruments = new ArrayList<Instruments>();
			String[] options = { "ID", "DATE", "MAKER", "PRICE" };
			menu = Functions.buttons(options, "Order", "¿What order are you prefer?");
//		instruments.add((Guitars) new Guitars("A02", "Guitar", "Yamaha", 44.5f, FunctionsDate.dateSys(),
//				FunctionsDate.DefaultDate(), "Carbono", 1)); // CREATE
//		instruments.add((Guitars) new Guitars("A01", "Guitar", "Yamaha", 44.5f, FunctionsDate.dateSys(),
//				FunctionsDate.DefaultDate(), "Carbono", 1)); // CREATE

			switch (menu) {
			case 0:
				Collections.sort(singleton.instruments);
				System.out.println(singleton.instruments + " any");
//			JOptionPane.showMessageDialog(null, singleton.instruments);
				Functions_data.readCP(singleton.instruments, type);
				break;
			case 1:
				Collections.sort(singleton.instruments, new order_date());
				break;
			case 2:
				Collections.sort(singleton.instruments, new order_maker());
			case 3:
				Collections.sort(singleton.instruments, new order_price());

//		case 3:
//			Collections.sort(singleton.instruments, new order_id());
//			break;
			}
		}
	}
}
