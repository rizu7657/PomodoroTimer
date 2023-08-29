package za.co.polstech;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named(value = "helloBean")
@RequestScoped
public class HelloBean {

    private String name;

    public HelloBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String user_name) {
        this.name = user_name;
    }
}