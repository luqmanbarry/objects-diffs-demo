package com.hamidou;

public enum ChangeType {
	NEW_OBJECT ("NEW OBJECT"),
	ADDED ("ADDED"),
	CHANGED ("CHANGED"),
	REMOVED ("REMOVED");

	private String displayName;

	ChangeType(String displayName) {
		this.displayName = displayName;
	}

	public String displayName() {
		return displayName;
	}

	@Override
	public String toString() {
		return displayName;
	}
}
