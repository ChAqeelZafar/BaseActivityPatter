package com.islamicappsworld.kidskalma;

public class KalmaArray {
	int Id;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int kalmaimage() {
		return kalmaimage;
	}
	public void kalmaimage(int kalmaimage) {
		this.kalmaimage = kalmaimage;
	}
	public String pro() {
		return pro;
	}
	public void Duatext(String pro) {
		this.pro = pro;
	}
	
	public String translation() {
		return translation;
	}
	public void translation(String translation) {
		this.translation = translation;
	}
	public String titlepro() {
		return title;
	}
	public void titlepro(String titlepro) {
		this.title = titlepro;
	}
	public KalmaArray(int id,String titlepro, String pro,String translation,int kalmaimage) {
		super();
		Id = id;
		this.pro = pro;
		this.translation = translation;
		this.kalmaimage=kalmaimage;
		this.title=titlepro;
	}
	String pro;
	String translation;
	int kalmaimage;
	String title;

}