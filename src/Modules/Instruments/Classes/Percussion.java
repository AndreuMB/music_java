package Modules.Instruments.Classes;

import Classes.Dates;
import Classes.Instruments;
import Utils.FunctionsDate;

public class Percussion extends Instruments {
	boolean drumsticks;

	public Percussion(String id, String type, String maker, float price, Dates date1, Dates date2, boolean drumsticks,
			int this1) {
		super(id, type, maker, price, date1, date2, this1);
		this.drumsticks = drumsticks;
	}

	public boolean isDrumsticks() {
		return drumsticks;
	}

	public void setDrumsticks(boolean drumsticks) {
		this.drumsticks = drumsticks;
	}

	@Override
	public String toString() {
//		return "Percussion [id= " + getId() + ", type=" + getType() + ", price=" + getPrice() + ", maker=" + getMaker()
//				+ ", drumsticks= " + drumsticks + ", dateini=" + FunctionsDate.Dateini() + ", datefin="
//				+ FunctionsDate.Datefin(getType1()) + ", days=" + getDays() + "]";
		return "Instruments [id=" + getId() + "\n type=" + getType() + "\n price=" + getPrice() + "\n maker="
				+ getMaker() + "\n drumsticks= " + drumsticks + "\n Date when made the order=" + FunctionsDate.Dateini()
				+ "\n Warranty finish=" + FunctionsDate.Datexpire(getDate2()) + "\n Days until arrive=" + getDays()
				+ "]";
	}

}
