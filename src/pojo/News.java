package pojo;

import java.util.Date;

public class News {
	private Integer id;
	private String title;
	private String content;
	private Date time;
	
	public News() {
		super();
	}

	public News(String title, String content, Date time) {
		super();
		this.title = title;
		this.content = content;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content + ", time=" + time + "]";
	}
	
}
