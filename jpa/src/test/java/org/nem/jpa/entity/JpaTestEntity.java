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
public class JpaTestEntity extends JpaEntityLog<Integer> {

    @Size(min = 5, max = 10)
    @Pattern(regexp = "[A-Za-z]+")
    @NotNull
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "JpaTestEntity{" + super.toString() + ", title=" + title + '}';
    }

}
