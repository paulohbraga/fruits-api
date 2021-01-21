package org.acme.rest.json;

public class Peca {
	public Integer id;
	public String name;
	public String description;

	public Peca() {
	}

	public Peca( Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

}
