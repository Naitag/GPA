package pl.npe.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NpeView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idn;
    private String name;
    private String path;
    private String component;//VueConstructor<Vue>
    private boolean showInNav = true;

    @ElementCollection(targetClass = NpeView.class)
    private List<NpeView> children = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdn() {
        return idn;
    }

    public void setIdn(String idn) {
        this.idn = idn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public boolean isShowInNav() {
        return showInNav;
    }

    public void setShowInNav(boolean showInNav) {
        this.showInNav = showInNav;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }
}
