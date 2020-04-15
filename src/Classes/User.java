package Classes;

public class User {
	private String name;
	private String email;
	private String passwd;
	private String type;

	public User(String name, String email, String passwd, String type) {
		super();
		this.name = name;
		this.email = email;
		this.passwd = passwd;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [\n name=" + name + "\n email=" + email + "\n passwd=" + "******" + "\n type=" + type + "]";
	}

}
