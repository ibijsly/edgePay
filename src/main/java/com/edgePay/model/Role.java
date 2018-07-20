package com.edgePay.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    private String roleCode;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Date createdAt;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Date UpdatedAt;

    @ManyToMany(mappedBy = "role")
    @JsonBackReference
    private Set<RoleGroup> roleGroups;

    @Column
    private String description;

    @Column(length = 1024)
    private String priviledges;

    @Transient
    private boolean dashboard = false;

    @Transient
    private boolean users;

    @Transient
    private boolean transactions;

    @Transient
    private boolean roleView;


    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        UpdatedAt = updatedAt;
    }

    public Set<RoleGroup> getRoleGroups() {
        return roleGroups;
    }

    public void setRoleGroups(Set<RoleGroup> roleGroups) {
        this.roleGroups = roleGroups;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriviledges() {
        return priviledges;
    }

    public void setPriviledges(String priviledges) {
        this.priviledges = priviledges;
    }

    public boolean isDashboard() {
        return dashboard;
    }

    public void setDashboard(boolean dashboard) {
        this.dashboard = dashboard;
    }

    public boolean isUsers() {
        return users;
    }

    public void setUsers(boolean users) {
        this.users = users;
    }

    public boolean isTransactions() {
        return transactions;
    }

    public void setTransactions(boolean transactions) {
        this.transactions = transactions;
    }

    public boolean isRoleView() {
        return roleView;
    }

    public void setRoleView(boolean roleView) {
        this.roleView = roleView;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleCode='" + roleCode + '\'' +
                '}';
    }
}
