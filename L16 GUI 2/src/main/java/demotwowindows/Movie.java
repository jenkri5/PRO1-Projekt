package demotwowindows;

public class Movie {
    private String title;
    private String actor;

    public Movie(String title, String actor) {
        this.title = title;
        this.actor = actor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return title + " " + actor;
    }
}
