import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classes.Instruments;
import Classes.User;
import Modules.Instruments.Classes.Guitars;
import Modules.Instruments.Classes.Keyboards;
import Modules.Instruments.Classes.Percussion;
import Modules.Instruments.Utils.FunctionsOrder;
import Utils.DummiesStart;
import Utils.Functions;
import Utils.FunctionsCRUDmusic;
import Utils.Functions_data;
import Utils.singleton;

public class Menu {

	public static void main(String[] args) {
//
//		float price = 0;
//
//		Music disk = new Music(1, "Rock", 22.3f); // CREATE
//
//		JOptionPane.showMessageDialog(null, disk.toString()); // READ
//
//		price = Functions.validafloat("New price", "Price");
//		disk.setPrice(price); // UPDATE
//
//		JOptionPane.showMessageDialog(null, disk.toString()); // READ
//
//		disk = null; // DELETE

		int select1 = 0;
		String[] options1 = { "Guitar", "Keyboard", "Percussion", "Logout", "Exit" };
//		int select = 0;
//		boolean switch_1 = false;
//		boolean switch_2 = false;
//		boolean switch_3 = false;
//		Guitars guitar1 = null;
//		String[] options = { "C", "R", "U", "D", "O", "Exit" };

//		Keyboards keyboard1 = null;
//		Percussion drum1 = null;
		boolean switch_ = false;
		int realopf = 0;
		int realopf2 = 0;
//		ArrayList<Instruments> instruments = null;
//		ArrayList<Guitars> guitar = new ArrayList<Guitars>();
//		ArrayList<Keyboards> keyboard = new ArrayList<Keyboards>();
//		ArrayList<Percussion> percussion = new ArrayList<Percussion>();
//		ArrayList<Instruments> instruments = new ArrayList<Instruments>();
		ArrayList<Instruments> instruments = singleton.instruments = new ArrayList<Instruments>();
		singleton.users = new ArrayList<User>();
		singleton.menu = new ArrayList<String>();
		singleton.menu2 = new ArrayList<String>();

		singleton.users.add(new User("admin", "admin@admin.com", "admin", "admin")); // Create a default admin user for
																						// test
//		ArrayList<User> users = singleton.users = new ArrayList<User>();

		String[] optionsd = { "Yes", "No" };
		String[] optionsus = { "Register", "Login", "Guest", "Exit" };
		String username = "";
		String useremail = "";
		String realop = "";
		String userpasswd = "";
		String typeuser = "";
		int actualuser = 0;
		int position = 0;
		User usernow = null;
		boolean switch_user = false;
		boolean correctuser = false;
		boolean correctpasswd = false;
		boolean userexist = false;
		int user = 0;
		boolean switch_times = false;
		int times = 0;
		do {
			do {

				user = Functions.buttons(optionsus, "User", "Have an account?");
				switch (user) {
				case 0: // reguister
					switch_user = false;
					do {
						username = Functions_data.val_name("User name", "Introducre your name");
						userexist = Functions_data.user_CP(username);
					} while (userexist == false);
					useremail = Functions_data.val_email("User email", "Introducre your email");
					userpasswd = Functions.validaString("User password", "Introducre your passwd");
					String[] usertypes = { "Admin", "Worker" };
					int typeu = Functions.buttons(usertypes, "User", "What class you are?");
					switch (typeu) {
					case 0:
						System.out.println("admin");
						typeuser = "admin";
						break;
					case 1:
						System.out.println("worker");
						typeuser = "worker";
						break;
					}
					User user1 = new User(username, useremail, userpasswd, typeuser);
					singleton.users.add(user1);
					break;
				case 1: // login
					do {
						username = Functions.validaString("User name", "Introducre your name");
						correctuser = Functions_data.loginname(username);
						System.out.println(username + " USERNAME");
					} while ((correctuser == false) && (username != "exit"));
					if (username != "exit") {
						do {
							userpasswd = Functions.validaString("User password", "Introducre your passwd");
							correctpasswd = Functions_data.loginpasswd(username, userpasswd);
						} while ((correctpasswd == false) && (userpasswd != "exit"));
						if (correctpasswd == true) {
							switch_user = true;
							JOptionPane.showMessageDialog(null, "You log correctly", "Log",
									JOptionPane.INFORMATION_MESSAGE);
						}
						usernow = Functions_data.logeduser(username);
						position = singleton.users.indexOf(usernow);
						System.out.println(position + " position");
					}

//			String typeuserm = user1.getType();
//			user1.setType(typeuser);
					break;
				case 2: // guest
					singleton.users.add(new User("Guest", "guest@guest.com", "guest", "guest"));
//				System.out.println(guest);
//				singleton.users.add(guest);
//				guest.setType("Guest");
//				actualuser = singleton.users.size();
					System.out.println(actualuser + "actualuser");
					usernow = Functions_data.usernow(singleton.users, 2); // usernow == user guest
					System.out.println(usernow + " usernow");
					position = singleton.users.indexOf(usernow); // return postion of user guest
//				if (!usernow.equals("return")) {
//					for (int i = 0; i < singleton.users.size(); i++) {
////						String next = read.next().toString();
//						if (array[i] == selected) {
//							updateo = i;
//							System.out.println(updateo + "updateobject");
//						}
//					}
					System.out.println(actualuser);
					switch_user = true;
					break;

				default:
					JOptionPane.showMessageDialog(null, "You exit", "Exit", JOptionPane.ERROR_MESSAGE);
					System.exit(0);

				}
			} while (switch_user == false);
			System.out.println(position + " here");
			if (singleton.users.get(position).getType() == "admin") {
				int dummies = Functions.buttons(optionsd, "Dummies", "Do you want create dummies?");
				if (dummies == 0) {
					do {
						times = Functions.validaInt("Dummies", "How many objects want create");
						if (times > 99) {
							JOptionPane.showMessageDialog(null, "Put number less than 100", "Error",
									JOptionPane.ERROR_MESSAGE);
						} else {
							switch_times = true;
						}
					} while (switch_times == false);
					DummiesStart.loaddummis(times);

				}
			}

			do { // menu1

//				select1 = Functions.buttons(options1, "Main menu",
//						"Hello " + singleton.users.get(position).getName() + "!!");
				switch_ = false;
				realopf2 = Functions_data.varmenu2(position);// menu depends of user type
				switch (realopf2) {
				case 0: // guitar
//				Functions.guitar(select1);
					do { // menu 2
						realopf = Functions_data.varmenu(position);// menu depends of user type
//						if (singleton.users.get(position).getType() == "admin") {
//							System.out.println("admin");
//							singleton.menu.clear();
//							singleton.menu.add("C");
//							singleton.menu.add("R");
//							singleton.menu.add("U");
//							singleton.menu.add("D");
//							singleton.menu.add("O");
//							singleton.menu.add("Exit");
//
//						}
//						if (singleton.users.get(position).getType() == "worker") {
//							System.out.println("worker");
//							singleton.menu.clear();
//							singleton.menu.add("R");
//							singleton.menu.add("U");
//							singleton.menu.add("O");
//							singleton.menu.add("Exit");
//						}
//
//						if (singleton.users.get(position).getType() == "guest") {
//							System.out.println("guest");
//							singleton.menu.clear();
//							singleton.menu.add("R");
//							singleton.menu.add("O");
//							singleton.menu.add("Exit");
//						}
//
//						select = Functions.buttonsA(singleton.menu, "Secondary menu", "Select one");
//						realop = singleton.menu.get(select);
//						System.out.println(realop);
//						System.out.println(options.length + " lenght");
//
//						for (int i = 0; i < options.length; i++) {
//							if (realop == options[i]) {
//								realopf = i;
//							}
//						}
//						System.out.println(realopf + " select num");
						switch (realopf) {
						case 0: // create

							instruments.add((Guitars) FunctionsCRUDmusic.CreateDisk(realopf2, instruments));

//						guitar1 = (Guitars) FunctionsCRUDmusic.CreateDisk(realopf2); // Create

//						switch_1 = true;
							break;
						case 1: // read
							FunctionsCRUDmusic.ReadDisk(instruments, realopf2);
//						if (switch_1 == false) {
//							JOptionPane.showMessageDialog(null, "First create an object", "Error",
//									JOptionPane.ERROR_MESSAGE);
//						} else {
//						JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.ReadDisk(guitar1)); // READ
//						}
							break;
						case 2: // update
							FunctionsCRUDmusic.Updatev2Disk(instruments, realopf2);
//						if (switch_1 == false) {
//							JOptionPane.showMessageDialog(null, "First create an object", "Error",
//									JOptionPane.ERROR_MESSAGE);
//						} else {
//							JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.UpdateDisk(guitar1)); // UPDATE
//						}
							break;
						case 3: // delete
//						FunctionsCRUDmusic.DeleteDisk(guitar1); // DELETE
							FunctionsCRUDmusic.DeleteDiskv2(instruments);
//						if (switch_1 == false) {
//							JOptionPane.showMessageDialog(null, "First create an object", "Error",
//									JOptionPane.ERROR_MESSAGE);
//						} else {
//							FunctionsCRUDmusic.DeleteDisk(guitar1); // DELETE
//							guitar1 = null;
//							JOptionPane.showMessageDialog(null, "You delete the object", "Delete",
//									JOptionPane.INFORMATION_MESSAGE);
//							switch_1 = false;
//						}
							break;
						case 4: // order
							FunctionsOrder.order(realopf2);
							break;
						default: // exit
//						JOptionPane.showMessageDialog(null, "You select " + options[4], "Output",
//								JOptionPane.INFORMATION_MESSAGE);
							switch_ = true;
							break;
						}

					} while ((switch_ == false));
					break;
				case 1: // keyboards
//				Functions.keyboard(select1);
					do {
//						select = Functions.buttons(options, "Secondary menu", "Select one");
						realopf = Functions_data.varmenu(position);// menu depends of user type
						switch (realopf) {
						case 0: // create
							instruments.add((Keyboards) FunctionsCRUDmusic.CreateDisk(realopf2, instruments));
//						switch_2 = true;
							break;
						case 1: // read
							FunctionsCRUDmusic.ReadDisk(instruments, realopf2);
//						if (switch_2 == false) {
//							JOptionPane.showMessageDialog(null, "First create an object", "Error",
//									JOptionPane.ERROR_MESSAGE);
//						} else {
//							JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.ReadDisk(keyboard1)); // READ
//						}
							break;
						case 2: // update
							FunctionsCRUDmusic.Updatev2Disk(instruments, realopf2);
//						if (switch_2 == false) {
//							JOptionPane.showMessageDialog(null, "First create an object", "Error",
//									JOptionPane.ERROR_MESSAGE);
//						} else {
//							JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.UpdateDisk(keyboard1)); // UPDATE
//						}
							break;
						case 3: // delete
//						FunctionsCRUDmusic.DeleteDisk(keyboard1); // DELETE
							FunctionsCRUDmusic.DeleteDiskv2(instruments);
//						if (switch_2 == false) {
//							JOptionPane.showMessageDialog(null, "First create an object", "Error",
//									JOptionPane.ERROR_MESSAGE);
//						} else {
//							FunctionsCRUDmusic.DeleteDisk(keyboard1); // DELETE
//							keyboard1 = null;
//							JOptionPane.showMessageDialog(null, "You delete the object", "Delete",
//									JOptionPane.INFORMATION_MESSAGE);
//							switch_2 = false;
//						}
							break;
						case 4:
							FunctionsOrder.order(realopf2);
							break;
						default: // exit
//						JOptionPane.showMessageDialog(null, "You select " + options[4], "Output",
//								JOptionPane.INFORMATION_MESSAGE);
							switch_ = true;
							break;
						}

					} while ((switch_ == false));
					break;
				case 2: // percussion
//				Functions.percussion(select1);
					do {
						realopf = Functions_data.varmenu(position);// menu depends of user type
						switch (realopf) {
						case 0: // create
							instruments.add((Percussion) FunctionsCRUDmusic.CreateDisk(select1, instruments));
//						switch_3 = true;
							break;
						case 1: // read
							FunctionsCRUDmusic.ReadDisk(instruments, realopf2);
//						if (switch_3 == false) {
//							JOptionPane.showMessageDialog(null, "First create an object", "Error",
//									JOptionPane.ERROR_MESSAGE);
//						} else {
//							JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.ReadDisk(drum1)); // READ
//						}
							break;
						case 2: // update
							FunctionsCRUDmusic.Updatev2Disk(instruments, realopf2);
//						if (switch_3 == false) {
//							JOptionPane.showMessageDialog(null, "First create an object", "Error",
//									JOptionPane.ERROR_MESSAGE);
//						} else {
//							JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.UpdateDisk(drum1)); // UPDATE
//						}
							break;
						case 3: // delete
//						FunctionsCRUDmusic.DeleteDisk(drum1);
							FunctionsCRUDmusic.DeleteDiskv2(instruments);

//						if (switch_3 == false) {
//							JOptionPane.showMessageDialog(null, "First create an object", "Error",
//									JOptionPane.ERROR_MESSAGE);
//						} else {
//							FunctionsCRUDmusic.DeleteDisk(drum1); // DELETE
//							drum1 = null;
//							JOptionPane.showMessageDialog(null, "You delete the object", "Delete",
//									JOptionPane.INFORMATION_MESSAGE);
//							switch_3 = false;
//						}
							break;
						case 4:
							FunctionsOrder.order(realopf2);
							break;
						default: // exit
//						JOptionPane.showMessageDialog(null, "You select " + options[4], "Output",
//								JOptionPane.INFORMATION_MESSAGE);
							switch_ = true;
							break;
						}

					} while ((switch_ == false));
					break;
				case 3: // user
					int moduser = 0;
					do {
						// Intilized array of size x (this array is for find the object)
//						String array2[] = new String[singleton.users.size()];
						int updateo = 0;
						String[] optuser = { "Username", "Password", "Email", "Exit" };
						moduser = Functions.buttons(optuser, "User", Functions_data.usernow2(username));
						switch (moduser) {
						case 0:

							do {
								username = Functions_data.val_name("User name", "Introducre your name");
								userexist = Functions_data.user_CP(username);
							} while (userexist == false);
//							array2 = Functions_data.all_users2();
//
//							for (int i = 0; i < singleton.users.size(); i++) {
//								System.out.println(array2[i] + " array \n" + "test" + " selected");
//								if (array2[i] == username) {
//									updateo = i;
//									System.out.println(updateo + " updateobject");
//								}
//							}
							singleton.users.get(position).setName(username);
							break;
						case 1:
							boolean switch_passwd = false;
							do {
								userpasswd = Functions.validaString("User password",
										"Introducre the password you have now");
								correctpasswd = Functions_data.loginpasswd(username, userpasswd);
								if (correctpasswd == true) {
									userpasswd = Functions.validaString("User password",
											"Introducre your new password");
//									array2 = Functions_data.all_users2();
//
//									for (int i = 0; i < singleton.users.size(); i++) {
//										System.out.println(array2[i] + " array \n" + "test" + " selected");
//										if (array2[i] == username) {
//											updateo = i;
//											System.out.println(updateo + " updateobject");
//										}
//									}
									singleton.users.get(position).setPasswd(userpasswd);
									switch_passwd = true;
								}
								System.out.println("HERE");
							} while ((!userpasswd.equals("return")) && (switch_passwd == false));

							break;
						case 2:
							useremail = Functions_data.val_email("User email", "Introducre your email");
//							array2 = Functions_data.all_users2();
//
//							for (int i = 0; i < singleton.users.size(); i++) {
//								System.out.println(array2[i] + " array \n" + username + " selected");
//								if (array2[i] == username) {
//									updateo = i;
//									System.out.println(updateo + " updateobject");
//								}
//							}
							System.out.println(position + "position");
							singleton.users.get(position).setEmail(useremail);
							System.out.println(singleton.users.get(updateo).toString());
							break;
						default:
							break;
						}
					} while ((moduser != -1) && (moduser != 3));

					break;

				case 4:

					JOptionPane.showMessageDialog(null, Functions_data.all_users(), "Users",
							JOptionPane.INFORMATION_MESSAGE);
					break;
				case 5:
					JOptionPane.showMessageDialog(null, "You select " + options1[3] + ". Bye!!", "Output",
							JOptionPane.INFORMATION_MESSAGE);
					break;
				case 6: // exit
					System.exit(0);
					break;
				}

			} while ((realopf2 != -1) && (realopf2 != 5));// LOGOUT
		} while ((user != -1) && (user != 3)); // EXIT
//		int select = 0;
//		String combo = "";
//		String[] options = { "C", "R", "U", "D", "Exit" };
//
//		do {
//			/**
//			 * Here is the main manu
//			 */
//			select = Functions.buttons(options, "Main menu", "Select one");
//
//			switch (select) {
//			case 0:
//				disk = FunctionsCRUDmusic.CreateDisk(); // Create
//				break;
//			case 1:
//				JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.ReadDisk(disk)); // READ
//				break;
//			case 2:
//				JOptionPane.showMessageDialog(null, FunctionsCRUDmusic.UpdateDisk(disk));
//				break;
//			case 3:
//				FunctionsCRUDmusic.DeleteDisk(disk);
//				disk = null;
//				JOptionPane.showMessageDialog(null, "You delete the disk", "Delete", JOptionPane.INFORMATION_MESSAGE);
//				break;
//			case 4:
//				JOptionPane.showMessageDialog(null, "You select " + options[4], "Output",
//						JOptionPane.INFORMATION_MESSAGE);
//				break;
//			}
//
//		} while ((select != 4) && (!combo.equals("Exit")));
	}

}