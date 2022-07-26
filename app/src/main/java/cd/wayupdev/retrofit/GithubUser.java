package cd.wayupdev.retrofit;

public class GithubUser {
    private String login;
    private int id;
    private String avatar_url;
    private String name;

    public GithubUser() {
    }

    public GithubUser(String login, int id, String avatar_url, String name) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
