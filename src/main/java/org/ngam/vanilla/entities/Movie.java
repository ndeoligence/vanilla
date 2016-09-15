package org.ngam.vanilla.entities;

public class Movie {
	private int id;
    private String title;
    private String director;
    private String synopsis;
    public Movie() {
    }

    public Movie(int id, String title, String director, String synopsis) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.synopsis = synopsis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        return new org.apache.commons.lang.builder.EqualsBuilder()
                .append(id, movie.id)
                .append(title, movie.title)
                .append(director, movie.director)
                .append(synopsis, movie.synopsis)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang.builder.HashCodeBuilder(17, 37)
                .append(id)
                .append(title)
                .append(director)
                .append(synopsis)
                .toHashCode();
    }*/
}
