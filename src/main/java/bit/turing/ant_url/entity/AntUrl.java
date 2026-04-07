package bit.turing.ant_url.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "anturl")
public class AntUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 512, nullable = true)
    private String title;

    @Column(name = "url", length = 4000, nullable = false)
    private String url;

    @Column(name = "domain", length = 1024, nullable = true)
    private String domain;

    @Column(name = "alias", length = 1024, nullable = false)
    private String alias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
