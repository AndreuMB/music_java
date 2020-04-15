package Utils;

import java.util.Iterator;

import Classes.Instruments;
import Modules.Instruments.Classes.Guitars;
import Modules.Instruments.Classes.Keyboards;
import Modules.Instruments.Classes.Percussion;

public class DummiesStart {

	public static void loaddummis(int times) {
		Instruments demo = null;
		String id = "";
		String type = "";
		String material = "";
		int days = -1;
		boolean switch_1 = false;
//		instruments.add((Guitars) new Guitars("A02", "Guitar", "Yamaha", 44.5f, FunctionsDate.dateSys(),
//		FunctionsDate.DefaultDate(), "Carbono", 1)); // CREATE
		for (int i = 0; i < times; i++) {
			id = RandomID(times);
			type = Randomtype();
			material = Randommaterial();
			days = (int) (Math.random() * 99);
			int classr = 0;
			classr = (int) (Math.random() * 4);
			int rn = (int) (Math.random() * 2);
			switch (classr) {
			case 0:
				demo = new Guitars(id, "Guitar", type, 32.0f, FunctionsDate.dateSys(), FunctionsDate.DefaultDate(),
						material, days);
				singleton.instruments.add((Guitars) demo); // CREATE
				break;
			case 1:
				if (rn == 1) {
					switch_1 = true;
				} else {
					switch_1 = false;
				}
				demo = new Keyboards(id, "Keyboard", type, 32.0f, FunctionsDate.dateSys(), FunctionsDate.DefaultDate(),
						switch_1, days);
				singleton.instruments.add((Keyboards) demo); // CREATE
				break;
			case 2:
				if (rn == 1) {
					switch_1 = true;
				} else {
					switch_1 = false;
				}
				demo = new Percussion(id, "Percussion", type, 32.0f, FunctionsDate.dateSys(),
						FunctionsDate.DefaultDate(), switch_1, days);
				singleton.instruments.add((Percussion) demo); // CREATE
				break;
			}

		}
//		try {
//			Thread.sleep(1); // 1 milliseconds
//		} catch (Exception e) {
//			System.out.println(e);
//		}
	}

	public static String RandomID(int times) {// Take a random id from String
		String id2 = "";
		String idd = "";
		int id = 0;

//		for (int i = 0; i < 10; i++) {
//			id = "A0" + i;
//		}
//		for (int i = 10; i < 15; i++) {
//			id = "A" + i;
//		}
		boolean switch_ = false;
		do {
			switch_ = true;
			id = (int) (Math.random() * 99);
//			int length = String.valueOf(times).length();
			System.out.println(id);
			int length = String.valueOf(id).length();
			if (length < 2) {
				idd = "A0" + id;
				System.out.println(idd + " have 1 digit");
			} else {
				idd = "A" + id;
				System.out.println(idd + " have 2 digit");
			}
			System.out.println("not enter");
			Iterator<Instruments> read = singleton.instruments.iterator();
			while (read.hasNext()) {
				System.out.println(read + " only read");
				Instruments idobj = read.next();
				id2 = idobj.getId();
				System.out.println(id2 + " == " + idd);

				if (id2.equals(idd)) {
					System.out.println("SAME");// EXIST
					switch_ = false;

//					JOptionPane.showMessageDialog(null, "The ID exist put other", "Invalid ID",
//							JOptionPane.WARNING_MESSAGE);
//					System.out.println(idobj.getId() + " id seguent");
//					read.remove();
//					System.out.println(read + " remove");
				} else {
					System.out.println(switch_ + " its true");

				}
//				if (id2 == id) { // id
//					System.out.println(idobj.getId() + " id seguent");
//					read.remove();
//					System.out.println(read + " remove");
//				}
			}
		} while (switch_ == false);

		return idd;
	}

	public static String Randomtype() {// Take a random id from String
		String type = "";
		String[] options = { "Yamaha", "Homen", "Static", "Superior" };

		int posicio = (int) (Math.random() * 4);
		return type = options[posicio];
	}

	public static String Randommaterial() {// Take a random id from String
		String type = "";
		String[] options = { "Wood", "Plastic", "Carbon" };
		int posicio = (int) (Math.random() * 3);
		return type = options[posicio];
	}

}
