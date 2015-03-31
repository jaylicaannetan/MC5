package model;

public class Picture {

	private int pic_id;
	private String username;
	private String picture;
	private String caption;
	
	public Picture(int pic_id, String username, String picture, String caption)
	{
		this.pic_id = pic_id;
		this.username = username;
		this.picture = picture;
		this.caption = caption;
	}
	
	public void setPic_Id(int pic_id)
	{
		this.pic_id = pic_id;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPicture(String picture)
	{
		this.picture = picture;
	}
	
	public void setCaption(String caption)
	{
		this.caption = caption;
	}
	
	public int getPic_Id()
	{
		return pic_id;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPicture()
	{
		return picture;
	}
	
	public String getCaption()
	{
		return caption;
	}
}
