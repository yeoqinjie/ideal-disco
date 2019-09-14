package org.apache.struts.user.model;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
	private int type;
	
	public User() {
		
	}

    public User(int id, String firstName, String lastName, String email, String password, int type) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setType(type);
    }

    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public int getId() {
        return id;
    }

	public void setId(int id) {
        this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
        if (type != 1) {
            type = 2;
        }
		this.type = type;
	}
}