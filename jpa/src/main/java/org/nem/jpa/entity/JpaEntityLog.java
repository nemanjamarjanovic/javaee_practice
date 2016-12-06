package org.nem.jpa.entity;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author nemanja
 */
@MappedSuperclass
public abstract class JpaEntityLog extends JpaEntity {

    private String createdBy;
    private String lastModifiedBy;
    private LocalDateTime createdTimestamp;
    private LocalDateTime lastModifiedTimestamp;

    @PrePersist
    public void persist() {
        this.createdBy = "SYSTEM";
        this.lastModifiedBy = "SYSTEM";
        this.createdTimestamp = LocalDateTime.now();
        this.lastModifiedTimestamp = LocalDateTime.now();
    }

    @PreUpdate
    public void update() {
        this.lastModifiedBy = "SYSTEM";
        this.lastModifiedTimestamp = LocalDateTime.now();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public LocalDateTime getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(LocalDateTime lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    @Override
    public String toString() {
        return "JpaEntityLog{" + super.toString() + ", createdBy=" + createdBy
                + ", lastModifiedBy=" + lastModifiedBy + ", createdTimestamp="
                + createdTimestamp + ", lastModifiedTimestamp="
                + lastModifiedTimestamp + '}';
    }

}
