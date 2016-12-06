package org.nem.jpa.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author nemanja
 */
@Entity
public class Example extends JpaEntityLog {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Example{" + super.toString() + ", title=" + title + '}';
    }

}
