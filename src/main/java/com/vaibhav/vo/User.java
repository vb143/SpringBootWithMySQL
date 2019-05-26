package com.vaibhav.vo;

/**
 * @author Vaibhav
 *
 */
public class User {

    private String name;
    private String city;

    public User() {}

    public User(String name, String city) {
        this.name = name;
        this.city = city;
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", city=" + city + "]";
	}

}
