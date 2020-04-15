package Utils;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import Classes.Instruments;
import Classes.User;

public class Functions_data {
	public static String val_name(String message, String title) {
		String cad = "";
		boolean switch_ = false;
		boolean check = false;
		do {
			try {
				cad = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
				check = Regex.v_name(cad);
				if (check == false) {
					JOptionPane.showMessageDialog(null, "Error instroducing dates", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					switch_ = true;
				}
			} catch (Exception e) { // when error jump here
				JOptionPane.showMessageDialog(null, "You exit", "Exit", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0); // user exit or cancel app close
			}
		} while (switch_ == false);
		return cad;
	}

	public static String val_date(String message, String title) {
		String cad = "";
		boolean switch_ = false;
		boolean check = false;
		do {
			try {
				cad = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
				check = Regex.v_date(cad);
				if (check == false) {
					JOptionPane.showMessageDialog(null, "Error instroducing dates", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					switch_ = true;
				}
			} catch (Exception e) { // when error jump here
				JOptionPane.showMessageDialog(null, "You exit", "Exit", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0); // user exit or cancel app close
			}
		} while (switch_ == false);
		return cad;
	}

	public static String readCP(ArrayList<Instruments> instrument, int type) {
		String objects = "";
		Iterator<Instruments> read = instrument.iterator();
		while (read.hasNext()) {
//			Instruments now = read.next();
			System.out.println(read + " next");
//			allobjects = allobjects + (read.toString() + "\n"); // READ
//			Instruments object = read.next();
			Instruments typeob = read.next();
			System.out.println(typeob.getType() + " == " + typeob);
			String typeo = typeob.getType();
			String[] options = { "Guitar", "Keyboard", "Percussion" };

			if (!typeo.equals(options[type])) {
				System.out.println("SAME");
//				JOptionPane.showMessageDialog(null, "The ID exist put other", "Invalid ID",
//						JOptionPane.WARNING_MESSAGE);
//				System.out.println(idobj.getId() + " id seguent");
//				read.remove();
//				System.out.println(read + " remove");
//				JOptionPane.showMessageDialog(null, "Error de introducción de datos", "Error",
//						JOptionPane.ERROR_MESSAGE);
			} else {
				objects = objects + (typeob.toString() + "\n");
				System.out.print(objects + " \n ");
			}
		}
		return objects;

	}

	public static int sizesons(ArrayList<Instruments> instrument, int type) {
		String objects = "";
		int cont = 0;
		Iterator<Instruments> read = instrument.iterator();
		while (read.hasNext()) {
//			Instruments now = read.next();
			System.out.println(read + " next");
//			allobjects = allobjects + (read.toString() + "\n"); // READ
//			Instruments object = read.next();
			Instruments typeob = read.next();
			System.out.println(typeob.getType() + " == " + typeob);
			String typeo = typeob.getType();
			String[] options = { "Guitar", "Keyboard", "Percussion" };

			if (!typeo.equals(options[type])) {
				System.out.println("SAME");
//				JOptionPane.showMessageDialog(null, "The ID exist put other", "Invalid ID",
//						JOptionPane.WARNING_MESSAGE);
//				System.out.println(idobj.getId() + " id seguent");
//				read.remove();
//				System.out.println(read + " remove");
//				JOptionPane.showMessageDialog(null, "Error de introducción de datos", "Error",
//						JOptionPane.ERROR_MESSAGE);
			} else {
				cont++;
				objects = objects + (typeob.toString() + "\n");
				System.out.print(objects + " \n ");
			}
		}
		return cont;

	}

	public static boolean loginname(String data) {
		boolean result = false;
		Iterator<User> read = singleton.users.iterator();
		while (read.hasNext()) {
//			Instruments now = read.next();
			System.out.println(read + " next");
//			allobjects = allobjects + (read.toString() + "\n"); // READ
//			Instruments object = read.next();
			User typeob = read.next();
			String name = typeob.getName();

			if (name.equals(data)) {
				System.out.println("EXIST");
				result = true;

//				JOptionPane.showMessageDialog(null, "The ID exist put other", "Invalid ID",
//						JOptionPane.WARNING_MESSAGE);
//				System.out.println(idobj.getId() + " id seguent");
//				read.remove();
//				System.out.println(read + " remove");
//				JOptionPane.showMessageDialog(null, "Error de introducción de datos", "Error",
//						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (result != true) {
			JOptionPane.showMessageDialog(null, "This user not exist", "Log", JOptionPane.INFORMATION_MESSAGE);
		}
		return result;

	}

	public static int varmenu(int position) {
		String[] options = { "C", "R", "U", "D", "O", "Exit" };
		int realopf = 0;
		if (singleton.users.get(position).getType() == "admin") {
			System.out.println("admin");
			singleton.menu.clear();
			singleton.menu.add("C");
			singleton.menu.add("R");
			singleton.menu.add("U");
			singleton.menu.add("D");
			singleton.menu.add("O");
			singleton.menu.add("Exit");

		}
		if (singleton.users.get(position).getType() == "worker") {
			System.out.println("worker");
			singleton.menu.clear();
			singleton.menu.add("R");
			singleton.menu.add("U");
			singleton.menu.add("O");
			singleton.menu.add("Exit");
		}

		if (singleton.users.get(position).getType() == "guest") {
			System.out.println("guest");
			singleton.menu.clear();
			singleton.menu.add("R");
			singleton.menu.add("O");
			singleton.menu.add("Exit");
		}

		int select = Functions.buttonsA(singleton.menu, "Secondary menu", "Select one");
		String realop = singleton.menu.get(select);
		System.out.println(realop);
		System.out.println(options.length + " lenght");

		for (int i = 0; i < options.length; i++) {
			if (realop == options[i]) {
				realopf = i;
			}
		}
		System.out.println(realopf + " select num");
		return realopf;
	}

	public static int varmenu2(int position) {
		String[] options1 = { "Guitar", "Keyboard", "Percussion", "User", "Users", "Logout", "Exit" };
		int realopf = 0;
		if (singleton.users.get(position).getType() == "admin") {
			System.out.println("admin");
			singleton.menu2.clear();
			singleton.menu2.add("Guitar");
			singleton.menu2.add("Keyboard");
			singleton.menu2.add("Percussion");
			singleton.menu2.add("User");
			singleton.menu2.add("Users");
			singleton.menu2.add("Logout");
			singleton.menu2.add("Exit");

		}
		if (singleton.users.get(position).getType() == "worker") {
			System.out.println("worker");
			singleton.menu2.clear();
			singleton.menu2.add("Guitar");
			singleton.menu2.add("Keyboard");
			singleton.menu2.add("Percussion");
			singleton.menu2.add("User");
			singleton.menu2.add("Logout");
			singleton.menu2.add("Exit");
		}

		if (singleton.users.get(position).getType() == "guest") {
			System.out.println("guest");
			singleton.menu2.clear();
			singleton.menu2.add("Guitar");
			singleton.menu2.add("Keyboard");
			singleton.menu2.add("Percussion");
			singleton.menu2.add("Logout");
			singleton.menu2.add("Exit");
		}

		int select = Functions.buttonsA(singleton.menu2, "Secondary menu", "Select one");
		String realop = singleton.menu2.get(select);
		System.out.println(realop);
		System.out.println(options1.length + " lenght");

		for (int i = 0; i < options1.length; i++) {
			if (realop == options1[i]) {
				realopf = i;
			}
		}
		System.out.println(realopf + " select num");
		return realopf;
	}

	public static boolean loginpasswd(String name, String passwd) {
		boolean result = false;
		Iterator<User> read = singleton.users.iterator();
		while (read.hasNext()) {
//			Instruments now = read.next();
			System.out.println(read + " next");
//			allobjects = allobjects + (read.toString() + "\n"); // READ
//			Instruments object = read.next();
			User typeob = read.next();
			String passwd1 = typeob.getPasswd();
			String name1 = typeob.getName();

			if (name1.equals(name)) {
				if (passwd1.equals(passwd)) {
					result = true;
				} else {
					JOptionPane.showMessageDialog(null, "User and password not match", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

//				JOptionPane.showMessageDialog(null, "The ID exist put other", "Invalid ID",
//						JOptionPane.WARNING_MESSAGE);
//				System.out.println(idobj.getId() + " id seguent");
//				read.remove();
//				System.out.println(read + " remove");
//				JOptionPane.showMessageDialog(null, "Error de introducción de datos", "Error",
//						JOptionPane.ERROR_MESSAGE);
			}
		}
		return result;

	}

	public static User logeduser(String name) {
		boolean result = false;
		Iterator<User> read = singleton.users.iterator();
		while (read.hasNext()) {
//			Instruments now = read.next();
			System.out.println(read + " next");
//			allobjects = allobjects + (read.toString() + "\n"); // READ
//			Instruments object = read.next();
			User typeob = read.next();
			String passwd1 = typeob.getPasswd();
			String name1 = typeob.getName();

			if (name1.equals(name)) {
				return typeob;
			}

//				JOptionPane.showMessageDialog(null, "The ID exist put other", "Invalid ID",
//						JOptionPane.WARNING_MESSAGE);
//				System.out.println(idobj.getId() + " id seguent");
//				read.remove();
//				System.out.println(read + " remove");
		}
		return null;

	}

	public static String usernow2(String name) {
		String user = "";
		Iterator<User> read = singleton.users.iterator();
		while (read.hasNext()) {
//			Instruments now = read.next();
			System.out.println(read + " next");
//			allobjects = allobjects + (read.toString() + "\n"); // READ
//			Instruments object = read.next();
			User typeob = read.next();
			String name1 = typeob.getName();

			if (name1.equals(name)) {
				user = typeob.toString();
				return user;
			}

//				JOptionPane.showMessageDialog(null, "The ID exist put other", "Invalid ID",
//						JOptionPane.WARNING_MESSAGE);
//				System.out.println(idobj.getId() + " id seguent");
//				read.remove();
//				System.out.println(read + " remove");
		}
		return null;

	}

	public static User usernow(ArrayList<User> instrument, int type) {
		String objects = "";
		Iterator<User> read = instrument.iterator();
		while (read.hasNext()) {
//			Instruments now = read.next();
			System.out.println(read + " next");
//			allobjects = allobjects + (read.toString() + "\n"); // READ
//			Instruments object = read.next();
			User typeob = read.next();
			String typeo = typeob.getType();
			System.out.println(typeob.getType() + " == " + typeo);
			String[] options = { "Admin", "VIP", "guest" };
			System.out.println(options[type] + " == " + typeo);

			if (typeo.equals(options[type])) {
				System.out.println("EXIST");
				return typeob;

//				JOptionPane.showMessageDialog(null, "The ID exist put other", "Invalid ID",
//						JOptionPane.WARNING_MESSAGE);
//				System.out.println(idobj.getId() + " id seguent");
//				read.remove();
//				System.out.println(read + " remove");
//				JOptionPane.showMessageDialog(null, "Error de introducción de datos", "Error",
//						JOptionPane.ERROR_MESSAGE);
			} else {
				objects = objects + (typeob.toString() + "\n");
				System.out.print(objects + " \n ");
			}
		}
		return null;

	}

	public static String val_id(String message, String title) {
		String cad = "";
		boolean switch_ = false;
		boolean check = false;
		do {
			try {
				cad = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
				check = Regex.v_id(cad);
				if (check == false) {
					JOptionPane.showMessageDialog(null, "Error instroducing dates", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					switch_ = true;
				}
			} catch (Exception e) { // when error jump here
				JOptionPane.showMessageDialog(null, "You exit", "Exit", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0); // user exit or cancel app close
			}
		} while (switch_ == false);
		return cad;
	}

	public static String val_email(String message, String title) {
		String cad = "";
		boolean switch_ = false;
		boolean check = false;
		do {
			try {
				cad = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
				check = Regex.v_email(cad);
				if (check == false) {
					JOptionPane.showMessageDialog(null, "Incorrect format \n Ex: email@example.com", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					switch_ = true;
				}
			} catch (Exception e) { // when error jump here
				JOptionPane.showMessageDialog(null, "You exit", "Exit", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0); // user exit or cancel app close
			}
		} while (switch_ == false);
		return cad;
	}

	public static boolean user_CP(String name1) {
		boolean switch_ = true;
		ArrayList<User> name = singleton.users;
		String id = "";
		switch_ = true;
		Iterator<User> read = name.iterator();
		while (read.hasNext()) {
			System.out.println(read + " only read");
			User idobj = read.next();
			System.out.println(idobj.getName() + " == " + id);
			String id2 = idobj.getName();

			if (id2.equals(name1)) {
				System.out.println("SAME");
				switch_ = false;
				JOptionPane.showMessageDialog(null, "The name exist put other", "Invalid ID",
						JOptionPane.WARNING_MESSAGE);
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

		return switch_;
	}

	public static String[] all_instr() {
		String array2[] = new String[singleton.instruments.size()];
		Instruments object = null;
		Iterator<Instruments> read = singleton.instruments.iterator();
		for (int i = 0; i < singleton.instruments.size(); i++) {
			object = read.next();
			System.out.println("type");
			array2[i] = object.getId().toString(); // Assigned value to array
			System.out.println(array2[i] + " array2");
		}
		return array2;
	}

	public static String[] all_users2() {
		String array2[] = new String[singleton.users.size()];
		User object = null;
		Iterator<User> read = singleton.users.iterator();
		for (int i = 0; i < singleton.users.size(); i++) {
			object = read.next();
			System.out.println("type");
			array2[i] = object.getName().toString(); // Assigned value to array
			System.out.println(array2[i] + " array2");
		}
		return array2;
	}

	public static String all_users() {
		User object = null;
		String users = "";
		Iterator<User> read = singleton.users.iterator();
		for (int i = 0; i < singleton.users.size(); i++) {
			object = read.next();
			System.out.println("type");
			users = users + (object.toString() + "\n"); // Assigned value to array
		}
		return users;
	}

	public static Instruments find_inst(String idi) {
		boolean switch_ = true;
		Instruments inst = null;
		ArrayList<Instruments> name = singleton.instruments;
		String id = "";
		switch_ = true;
		Iterator<Instruments> read = name.iterator();
		while (read.hasNext()) {
			System.out.println(read + " only read");
			Instruments idobj = read.next();
			System.out.println(idobj.getId() + " == " + id);
			String id2 = idobj.getId();

			if (id2.equals(idi)) {
				System.out.println("SAME");
				switch_ = false;
				JOptionPane.showMessageDialog(null, "The name exist put other", "Invalid ID",
						JOptionPane.WARNING_MESSAGE);
				inst = idobj;
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

		return inst;
	}

	public static String create_CP(ArrayList<Instruments> instrument2) {
		boolean switch_ = false;
		String id = "";
		do {
			switch_ = true;
			id = Functions_data.val_id("Put id (A01)", "ID");
			Iterator<Instruments> read = instrument2.iterator();
			while (read.hasNext()) {
//				switch_ = false;
				System.out.println(read + " only read");
				Instruments idobj = read.next();
				System.out.println(idobj.getId() + " == " + id);
				String id2 = idobj.getId();

				if (id2.equals(id)) {
					System.out.println("SAME");
					JOptionPane.showMessageDialog(null, "The ID exist put other", "Invalid ID",
							JOptionPane.WARNING_MESSAGE);
					switch_ = false;

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
		return id;
	}

}
