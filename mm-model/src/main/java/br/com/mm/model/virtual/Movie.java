package br.com.mm.model.virtual;

import java.util.List;

public class Movie {

    private Integer id;
    private String title;
    private String poster;
    private List<String> sessions;

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

    public String getPoster() {
	return poster;
    }

    public void setPoster(String poster) {
	this.poster = poster;
    }

    public List<String> getSessions() {
	return sessions;
    }

    public void setSessions(List<String> sessions) {
	this.sessions = sessions;
    }

}
