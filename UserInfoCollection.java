package com.edpedia.leads.collections;

import com.edpedia.leads.enums.RoleEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "EDPEDIA_LEADS_USER_INFO")
public class UserInfoCollection  implements UserDetails {
    @Id
    private UUID id = UUID.randomUUID();

    private String firstName;

    private String lastName;

    private String email;
    private RoleEnum roleEnum;
    private Boolean isRoot = false;
    private String password;
    private String userName;
    private String encodedPassword;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> roleNames = Collections.singletonList(roleEnum.toString());

        return roleNames.stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
    }


    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public String getPassword() {
        return encodedPassword;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
