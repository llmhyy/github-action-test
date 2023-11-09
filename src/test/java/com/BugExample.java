package com;

public class BugExample {

	private String name;

	public BugExample(String name) {
		this.name = name;
	}

	public String getName() {
		return name.toUpperCase();
	}

	public static void main(String[] args) {
		BugExample example = new BugExample(null);
		String name = example.getName();
		System.out.println(name);
	}

}