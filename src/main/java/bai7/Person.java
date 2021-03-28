package bai7;

import java.util.Arrays;

public class Person {

	private String firstName;
	private String lastName;
	private byte[] image;

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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Person() {
	}

	public Person(String firstName, String lastName, byte[] image) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", image=" + Arrays.toString(image) + "]";
	}

}
