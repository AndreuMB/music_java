package Utils;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import Classes.Dates;
import Classes.Instruments;
import Modules.Instruments.Classes.Guitars;
import Modules.Instruments.Classes.Keyboards;
import Modules.Instruments.Classes.Percussion;

public class FunctionsCRUDmusic {

	public static Instruments CreateDisk(int type1, ArrayList<Instruments> instrument2) {

		String[] options = { "Guitar", "Keyboard", "Percussion" };
		String[] options2 = { "Yamaha", "Homen", "Static", "Superior" };
		String[] materials = { "Wood", "Plastic", "Carbon" };
		String[] choose = { "Yes", "No" };
		int wheels = 0;
		boolean wheels1 = false;
		int drumsticks = 0;
		boolean drumsticks1 = false;
		String material = "";
//		boolean switch_ = false;
		String id = "";
		String[] optionsd = { "Yes", "No" };
		int dummies = Functions.buttons(optionsd, "Dummies", "Create with dummies?");
		if (dummies == 0) {
			Instruments demo = null;
			String type = DummiesStart.Randomtype();
			int days = -1;
			boolean switch_1 = false;
//			instruments.add((Guitars) new Guitars("A02", "Guitar", "Yamaha", 44.5f, FunctionsDate.dateSys(),
//			FunctionsDate.DefaultDate(), "Carbono", 1)); // CREATE
			id = DummiesStart.RandomID(1);
			material = DummiesStart.Randommaterial();
			days = (int) (Math.random() * 99);
			int rn = (int) (Math.random() * 2);

			switch (type1) {
			case 0:
				demo = new Guitars(id, "Guitar", type, 32.0f, FunctionsDate.dateSys(), FunctionsDate.DefaultDate(),
						material, days);
//				singleton.instruments.add((Guitars) demo); // CREATE
				break;
			case 1:
				if (rn == 1) {
					switch_1 = true;
				} else {
					switch_1 = false;
				}
				demo = new Keyboards(id, "Keyboard", type, 32.0f, FunctionsDate.dateSys(), FunctionsDate.DefaultDate(),
						switch_1, days);
//				singleton.instruments.add((Keyboards) demo); // CREATE
				break;
			case 2:
				if (rn == 1) {
					switch_1 = true;
				} else {
					switch_1 = false;
				}
				demo = new Percussion(id, "Percussion", type, 32.0f, FunctionsDate.dateSys(),
						FunctionsDate.DefaultDate(), switch_1, days);
//				singleton.instruments.add((Percussion) demo); // CREATE
				break;
			}
			return demo;
		} else {
			id = Functions_data.create_CP(instrument2);
//			do {
//				switch_ = true;
//				id = Functions_data.val_id("Put id", "ID");
//				Iterator<Instruments> read = instrument2.iterator();
//				while (read.hasNext()) {
//					switch_ = false;
//					System.out.println(read + " only read");
//					Instruments idobj = read.next();
//					System.out.println(idobj.getId() + " == " + id);
//					String id2 = idobj.getId();
			//
//					if (id2.equals(id)) {
//						System.out.println("SAME");
//						JOptionPane.showMessageDialog(null, "The ID exist put other", "Invalid ID",
//								JOptionPane.WARNING_MESSAGE);
////						System.out.println(idobj.getId() + " id seguent");
////						read.remove();
////						System.out.println(read + " remove");
//					} else {
//						switch_ = true;
//						System.out.println(switch_ + " its true");
			//
//					}
//					if (id2 == id) { // id
//						System.out.println(idobj.getId() + " id seguent");
//						read.remove();
//						System.out.println(read + " remove");
//					}
//		}}while(switch_==false);

//			for (int i : instrument2) {
//				System.out.println(i);
//			}
//			instrument2.removeIf(id2 -> (id2 != id));

//			instrument2.removeIf(id == "A32");
//			String type = Functions.combo(options, "Slect type", "Type");
			String maker = Functions.combo(options2, "Slect maker", "Type");
			Dates dateini = FunctionsDate.dateSys();
			Dates datefin = FunctionsDate.dataArrival(type1);
			Dates expire = FunctionsDate.expired();
			System.out.println(dateini + "dateini");
			System.out.println(datefin + "datefin");
			System.out.println(expire + "expire");
			Instruments instrument = null;

			int pWood = 3;
			int pPlastic = 1;
			int pCarbon = 5;
			float price = 0.0f;

			switch (type1) {
			case 0:
				material = Functions.combo(materials, "Slect material", "Material");
				switch (material) {
				case "Wood":
					price = pWood * 2.5f;
					break;
				case "Plastic":
					price = pPlastic * 1.5f;
					break;
				case "Carbon":
					price = pCarbon * 5.5f;
					break;
				}
//				Guitars guitar1 = new Guitars(id, options[type1], maker, price, null, null, material); // CREATE
//				return guitar1;
				instrument = new Guitars(id, options[type1], maker, price,
//						Dates.this.StringToCalendar(Dates.this.dateSys()),
						dateini, expire
//						Dates.this.StringToCalendar(FunctionsDate.dataArrival(type1)), 
						, material, type1); // CREATE
				System.out.println(expire + " EXPIRE");
				instrument.getDays();

				break;

			case 1:
				price = 50.0f;
				wheels = Functions.buttons(choose, "Weels", "Select one");
				if (wheels == 0) {
					wheels1 = true;
				}
//				Keyboards keyboard1 = new Keyboards(id, options[type1], maker, price, null, null, wheels1); // CREATE
//				return keyboard1;
				instrument = new Keyboards(id, options[type1], maker, price, dateini, expire, wheels1, type1); // CREATE
				instrument.getDays();
				System.out.println(expire + " EXPIRE");

				break;

			case 2:
				price = 20.0f;
				drumsticks = Functions.buttons(choose, "Drumsticks", "Select one");
				if (drumsticks == 0) {
					drumsticks1 = true;
				}

//				Percussion dumb1 = new Percussion(id, options[type1], maker, price, null, null, drumsticks1); // CREATE
//				return dumb1;
				instrument = new Percussion(id, options[type1], maker, price, dateini, expire, drumsticks1, type1); // CREATE
				instrument.getDays();
				System.out.println(expire + " EXPIRE");

				break;

			}
			return instrument;
		}

	}

	public static String ReadDisk(ArrayList<Instruments> instrument, int type) {

		String objects = "";
		if (singleton.instruments.isEmpty()) {
			JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		} else {
			String[] options2 = { "ONLY", "ALL" };
			int readop = Functions.buttons(options2, "Read", "Select one");
			switch (readop) {
			case 0:
				Instruments object = null;
				int cont = 0;
				Iterator<Instruments> read = instrument.iterator();
				System.out.print("start while" + " \n ");

				int size = Functions_data.sizesons(instrument, type);
				System.out.println(size + " size");
				String array[] = new String[size]; // Intilized array of size x (this array is for see in the menu)
				String array2[] = new String[instrument.size()]; // Intilized array of size x (this array is for find
																	// the
																	// object)
				int updateo = 0;
//				String[] combo_options = new { instrument.size() };
				String[] options = { "Guitar", "Keyboard", "Percussion" };

				array2 = Functions_data.all_instr();
				while (read.hasNext()) {
					object = read.next();
					String typeo = object.getType();
					System.out.println(typeo + " == " + options[type]);
					if (!typeo.equals(options[type])) {
						System.out.println("not type");
					} else {
						System.out.println("type");
						array[cont] = object.getId().toString(); // Assigned value to array
//						array[cont] = array[cont] + ("  " + object.getType().toString()); // Assigned value to array

						cont++;
					}
				}
				System.out.println("HELLO");

//				Instruments selected = null;
				String selected = Functions.combo(array, "Update", "Select 1");
				System.out.println("HERE!! " + selected + " Any ERROR?");

//				String[] array2 = 
				if (!selected.equals("return")) {
					for (int i = 0; i < instrument.size(); i++) {
//						String next = read.next().toString();
						System.out.println(array2[i] + " array \n" + selected + " selected");
						if (array2[i] == selected) {
							updateo = i;
							System.out.println(updateo + " updateobject");
						}
					}
					System.out.println("only one");
					JOptionPane.showMessageDialog(null, instrument.get(updateo).toString());
				}
				break;
			case 1:
				objects = Functions_data.readCP(instrument, type);
				JOptionPane.showMessageDialog(null, objects);
				break;
			}

			// ---------------------------------------------------
//			Iterator<Instruments> read = instrument.iterator();
//			while (read.hasNext()) {
////				Instruments now = read.next();
//				System.out.println(read + " next");
////				allobjects = allobjects + (read.toString() + "\n"); // READ
////				Instruments object = read.next();
//				Instruments typeob = read.next();
//				System.out.println(typeob.getType() + " == " + typeob);
//				String typeo = typeob.getType();
//				String[] options = { "Guitar", "Keyboard", "Percussion" };
//
//				if (!typeo.equals(options[type])) {
//					System.out.println("SAME");
////					JOptionPane.showMessageDialog(null, "The ID exist put other", "Invalid ID",
////							JOptionPane.WARNING_MESSAGE);
////					System.out.println(idobj.getId() + " id seguent");
////					read.remove();
////					System.out.println(read + " remove");
//				} else {
//					objects = objects + (typeob.toString() + "\n");
//					System.out.print(objects + " \n ");
//				}
//			}
		}
//		Iterator<Instruments> read = instrument2.iterator();
//		while (read.hasNext()) {
//			switch_ = false;
//			System.out.println(read + " only read");
//			Instruments idobj = read.next();
//			System.out.println(idobj.getId() + " == " + id);
//			String id2 = idobj.getId();

//		JOptionPane.showMessageDialog(null, instrument.toString()); // READ
		return objects; // READ

	}

	public static String Updatev2Disk(ArrayList<Instruments> instrument, int type) {
		String objects = "";
		Instruments object = null;
		int cont = 0;
//		String option = "";
		if (singleton.instruments.isEmpty()) {
			JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		} else {
			Iterator<Instruments> read = instrument.iterator();
			System.out.print("start while" + " \n ");
//			while (read.hasNext()) {
////				allobjects = allobjects + (read.toString() + "\n"); // READ
////				Instruments object = read.next();
//				objects = objects + (read.next().toString() + "\n");
//				System.out.print(objects + " \n ");
////				option = option + (read.next().toString());
//
//			}
			int size = Functions_data.sizesons(instrument, type);
			System.out.println(size + " size");
			String array[] = new String[size]; // Intilized array of size x (this array is for see in the menu)
			String array2[] = new String[instrument.size()]; // Intilized array of size x (this array is for find the
																// object)
			int updateo = 0;
//			String[] combo_options = new { instrument.size() };
			String[] options = { "Guitar", "Keyboard", "Percussion" };
//			for (int i = 0; i < size; i++) {
//				Instruments object2 = read.next();
//				String typeo = object2.getType();
//				System.out.println(typeo + " == " + options[type]);
//				if (!typeo.equals(options[type])) {
//					System.out.println("not type");
//				} else {
//					System.out.println("type");
//					array2[i] = object2.getId().toString(); // Assigned value to array
//					System.out.println(array2[i] + " array2");
//				}
//			}
//			for (int i = 0; i < instrument.size(); i++) {
//				String typeo = object.getType();
//				System.out.println(typeo + " == " + options[type]);
//				System.out.println("type");
//				array2[i] = object.getId().toString(); // Assigned value to array
//				System.out.println(array2[i] + " array2");
//			}
			array2 = Functions_data.all_instr();
			while (read.hasNext()) {
				object = read.next();
				String typeo = object.getType();
				System.out.println(typeo + " == " + options[type]);
				if (!typeo.equals(options[type])) {
					System.out.println("not type");
				} else {
					System.out.println("type");
					array[cont] = object.getId().toString(); // Assigned value to array
//					array[cont] = array[cont] + ("  " + object.getType().toString()); // Assigned value to array

					cont++;
				}
			}
			System.out.println("HELLO");
//			System.out.println("Values are :" + array[2]);
//			String[] options = { "fads" };
//			System.out.print("fin while" + " \n ");
//			Instruments selected = null;
			String selected = Functions.combo(array, "Update", "Select 1");
			System.out.println("HERE!! " + selected + " Any ERROR?");

//			String[] array2 = 
			if (!selected.equals("return")) {
				for (int i = 0; i < instrument.size(); i++) {
//					String next = read.next().toString();
					System.out.println(array2[i] + " array \n" + selected + " selected");
					if (array2[i] == selected) {
						updateo = i;
						System.out.println(updateo + " updateobject");
					}
				}

//				System.out.println(updateo);

//				JOptionPane.showMessageDialog(null, objects);
				int select = 0;
//				String type = "";
//				float price = 0.0f;
				String[] selection1 = { "ID", "MAKER", "WARRANTY", "MATERIAL", "EXIT" };
				String[] selection2 = { "ID", "MAKER", "MATERIAL", "WHEELS", "EXIT" };
				String[] selection3 = { "ID", "MAKER", "MATERIAL", "DRUMSTICKS", "EXIT" };

//				String[] options = { "Guitar", "Keyboard", "Percussion" };
				String[] options2 = { "Yamaha", "Homen", "Static", "Superior" };
				boolean switch_ = false;
//				String[] options = { "Guitar", "Keyboard", "Percussion" };
//				String[] materials = { "Wood", "Plastic", "Carbon" };
//				String[] choose = { "Yes", "No" };
				String maker = "";
//				int wheels = 0;
//				boolean wheels1 = false;
//				int drumsticks = 0;
//				boolean drumsticks1 = false;
//				String material = "";
				String id = "";
//				String type = Functions.combo(options, "Slect type", "Type");
//				int pWood = 3;
//				int pPlastic = 1;
//				int pCarbon = 5;
				JOptionPane.showMessageDialog(null, instrument.get(updateo).toString());
				System.out.println("menu?");
				System.out.println((instrument.get(updateo).getType()) + " what drop");
				if (instrument.get(updateo).getType() == "Guitar") {

					do {
						select = Functions.buttons(selection1, "Main menu", "Select one");
						switch (select) {
						case 0:
							System.out.println("menu");
							id = Functions_data.val_id("Introduce ID (A01)", "ID");
							((Instruments) instrument.get(updateo)).setId(id);
							System.out.println(instrument.get(updateo) + "modif");
							JOptionPane.showMessageDialog(null, instrument.get(updateo).toString());

							break;
						case 1:
							maker = Functions.combo(options2, "Slect maker", "Type");
							((Instruments) instrument.get(updateo)).setMaker(maker);
							JOptionPane.showMessageDialog(null, instrument.get(updateo).toString());
							break;
						case 2:
							Dates expire = FunctionsDate.expired();
							((Instruments) instrument.get(updateo)).setDate2(expire);
							JOptionPane.showMessageDialog(null, instrument.get(updateo).toString());
							break;
						case 3:
							int pWood = 3;
							int pPlastic = 1;
							int pCarbon = 5;
							float price = 0.0f;
							String[] materials = { "Wood", "Plastic", "Carbon" };
							String material = "";
							material = Functions.combo(materials, "Slect material", "Material");
							switch (material) {
							case "Wood":
								price = pWood * 2.5f;
								break;
							case "Plastic":
								price = pPlastic * 1.5f;
								break;
							case "Carbon":
								price = pCarbon * 5.5f;
								break;
							}
							((Guitars) instrument.get(updateo)).setMaterial(material);
							((Instruments) instrument.get(updateo)).setPrice(price);
							JOptionPane.showMessageDialog(null, instrument.get(updateo).toString());
							break;
						default:
							switch_ = true;
						}
					} while (switch_ == false);
				}

				if (instrument.get(updateo).getType() == "Keyboard") {
					do {
						select = Functions.buttons(selection2, "Main menu", "Select one");
						switch (select) {
						case 0:
							System.out.println("menu");
							id = Functions_data.val_id("Introduce ID (A01)", "ID");
							((Instruments) instrument.get(updateo)).setId(id);
							System.out.println(instrument.get(updateo) + "modif");
							break;
						case 1:
							maker = Functions.combo(options2, "Slect maker", "Type");
							((Instruments) instrument.get(updateo)).setMaker(maker);
							break;
						case 2:
							Dates expire = FunctionsDate.expired();
							((Instruments) instrument.get(updateo)).setDate2(expire);
							break;
						case 3:
							boolean wheels1 = false;
							String[] choose = { "Yes", "No" };
							int wheels = Functions.buttons(choose, "Weels", "Select one");
							if (wheels == 0) {
								wheels1 = true;
							}
							((Keyboards) instrument.get(updateo)).setWheels(wheels1);
						default:
							switch_ = true;
						}
					} while (switch_ == false);
				}

				if (instrument.get(updateo).getType() == "Percussion") {
					do {
						select = Functions.buttons(selection3, "Main menu", "Select one");
						switch (select) {
						case 0:
							System.out.println("menu");
							id = Functions_data.val_id("Introduce ID (A01)", "ID");
							((Instruments) instrument.get(updateo)).setId(id);
							System.out.println(instrument.get(updateo) + "modif");
							break;
						case 1:
							maker = Functions.combo(options2, "Slect maker", "Type");
							((Instruments) instrument.get(updateo)).setMaker(maker);
							break;
						case 2:
							Dates expire = FunctionsDate.expired();
							((Instruments) instrument.get(updateo)).setDate2(expire);
							break;
						case 3:
							boolean drumsticks1 = false;
							String[] choose = { "Yes", "No" };
							int drumsticks = Functions.buttons(choose, "Weels", "Select one");
							if (drumsticks == 0) {
								drumsticks1 = true;
							}
							((Percussion) instrument.get(updateo)).setDrumsticks(drumsticks1);
						default:
							switch_ = true;
						}
					} while (switch_ == false);
				}
			}

			return objects;

		}

//		JOptionPane.showMessageDialog(null, instrument.toString()); // READ
	}

//	public static Instruments UpdateDisk(Instruments instrument, int type1) {
//
//		int select = 0;
////		String type = "";
//		float price = 0.0f;
//		String[] selection1 = { "ID", "MAKER", "MATERIAL", "EXIT" };
////		String[] selection2 = { "ID", "MAKER", "MATERIAL", "EXIT" };
////		String[] selection3 = { "ID", "MAKER", "MATERIAL", "EXIT" };
//
////		String[] options = { "Guitar", "Keyboard", "Percussion" };
//		String[] options2 = { "Yamaha", "Homen", "Static", "Superior" };
//		boolean switch_ = false;
//		String[] options = { "Guitar", "Keyboard", "Percussion" };
//		String[] materials = { "Wood", "Plastic", "Carbon" };
//		String[] choose = { "Yes", "No" };
//		String maker = "";
//		int wheels = 0;
//		boolean wheels1 = false;
//		int drumsticks = 0;
//		boolean drumsticks1 = false;
//		String material = "";
//		String id = "";
////		String type = Functions.combo(options, "Slect type", "Type");
//		int pWood = 3;
//		int pPlastic = 1;
//		int pCarbon = 5;
//		if (instrument == null) {
//			JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
//			return null;
//		} else {
//
//			do {
//				switch (type1) {
//				case 0:
//					switch (select) {
//					case 0:
//						select = Functions.buttons(selection1, "Main menu", "Select one");
//						id = Functions_data.val_id("Introduce ID", "ID");
//						instrument.setId(id);
//						break;
//					case 1:
//						maker = Functions.combo(options2, "Slect maker", "Type");
//						instrument.setMaker(maker);
//						break;
//					case 2:
//						material = Functions.combo(materials, "Slect material", "Material");
//						switch (material) {
//						case "Wood":
//							price = pWood * 1.5f;
//							instrument.setPrice(price);
//							break;
//						case "Plastic":
//							price = pPlastic * 1.5f;
//							instrument.setPrice(price);
//							break;
//						case "Carbon":
//							price = pCarbon * 1.5f;
//							instrument.setPrice(price);
//							break;
//						}
//
//					}
//
////					Guitars guitar1 = new Guitars(id, options[type1], maker, price, null, null, material); // CREATE
////					return guitar1;
////					instrument = new Guitars(id, options[type1], maker, price, null, null, material); // CREATE
//					break;
//
//				case 1:
//					wheels = Functions.buttons(choose, "Weels", "Select one");
//					if (wheels == 0) {
//						wheels1 = true;
//					}
////					Keyboards keyboard1 = new Keyboards(id, options[type1], maker, price, null, null, wheels1); // CREATE
////					return keyboard1;
//					instrument = new Keyboards(id, options[type1], maker, price, null, null, wheels1, type1); // CREATE
//					break;
//
//				case 2:
//					drumsticks = Functions.buttons(choose, "Weels", "Select one");
//					if (drumsticks == 0) {
//						drumsticks1 = true;
//					}
//
////					Percussion dumb1 = new Percussion(id, options[type1], maker, price, null, null, drumsticks1); // CREATE
////					return dumb1;
//					instrument = new Percussion(id, options[type1], maker, price, null, null, drumsticks1, type1); // CREATE
//					break;
//				default:
//					switch_ = true;
//					break;
//
//				}
//
//			} while (switch_ == false);
//			return instrument;
//		}
//
//	}
//
//	public static void DeleteDisk(Instruments instrument) {
//		if (instrument == null) {
//			JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
//		} else {
//			JOptionPane.showMessageDialog(null, "You delete the object"); // READ
//			instrument = null; // DELETE
//			System.out.println(instrument);
//		}
//
//	}

	public static void DeleteDiskv2(ArrayList<Instruments> instrument) {
//		String option = "";
		if (singleton.instruments.isEmpty()) {
			JOptionPane.showMessageDialog(null, "First create an object", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			Iterator<Instruments> read = instrument.iterator();
			System.out.print("start while" + " \n ");
//			while (read.hasNext()) {
////				allobjects = allobjects + (read.toString() + "\n"); // READ
////				Instruments object = read.next();
//				objects = objects + (read.next().toString() + "\n");
//				System.out.print(objects + " \n ");
////				option = option + (read.next().toString());
//
//			}
			String array[] = new String[instrument.size()]; // Intilized array of size 5
			int updateo = 0;
//			String[] combo_options = new { instrument.size() };
			for (int i = 0; i < instrument.size(); i++) {
				array[i] = read.next().toString(); // Assigned value to array
			}
			System.out.println("HELLO");
//			System.out.println("Values are :" + array[2]);
//			String[] options = { "fads" };
//			System.out.print("fin while" + " \n ");
//			Instruments selected = null;
			String selected = Functions.combo(array, "Update", "Select 1");

			for (int i = 0; i < instrument.size(); i++) {
//				String next = read.next().toString();
				if (array[i] == selected) {
					updateo = i;
					System.out.println(updateo + "updateobject");
				}
			}
			instrument.remove(updateo);
		}
	}

}
