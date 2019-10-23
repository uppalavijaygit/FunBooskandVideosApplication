package com.fun.boos.videos.request;

public class Item {
	
	private String videoTitle;
	private String bookTitle;
	private String memberShipType;
	
	
	public Item(String videoTitle, String bookTitle, String memberShipType) {
		this.videoTitle = videoTitle;
		this.bookTitle = bookTitle;
		this.memberShipType = memberShipType;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getMemberShipType() {
		return memberShipType;
	}
	public void setMemberShipType(String memberShipType) {
		this.memberShipType = memberShipType;
	}
	

}
