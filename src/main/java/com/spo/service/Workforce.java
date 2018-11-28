package com.spo.service;

public class Workforce {

	private int[] rooms = new int[] {} ;
	private int senior;
	private int junior;

	

	public int getSenior() {
		return senior;
	}

	public int[] getRooms() {
		return rooms;
	}

	public void setRooms(int[] rooms) {
		this.rooms = rooms;
	}

	public void setSenior(int senior) {
		this.senior = senior;
	}

	public int getJunior() {
		return junior;
	}

	public void setJunior(int junior) {
		this.junior = junior;
	}

}
