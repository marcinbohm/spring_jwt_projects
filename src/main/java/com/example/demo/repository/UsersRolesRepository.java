package com.example.demo.repository;

import com.example.demo.models.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRolesRepository extends JpaRepository<UsersRoles, Long> {

    @Query(value = "SELECT dbo.users_roles_view.id AS user_id," +
            " dbo.users_roles_view.username AS user_username," +
            " dbo.users_roles_view.name AS user_role " +
            "FROM dbo.users_roles_view", nativeQuery = true)
    List<UsersRoles> getAllUsersRoles();
}
