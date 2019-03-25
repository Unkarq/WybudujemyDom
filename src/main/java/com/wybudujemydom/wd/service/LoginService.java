package com.wybudujemydom.wd.service;

import com.wybudujemydom.wd.model.AppUser;
import com.wybudujemydom.wd.model.UserRole;
import com.wybudujemydom.wd.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class LoginService implements UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUserOptional = appUserRepository.findByUsername(username);
        if(appUserOptional.isPresent()){
            AppUser appUser = appUserOptional.get();
            Set<String> grantedAuthoritySet = new HashSet<>();

            for (UserRole role : appUser.getUserRoles()){

                grantedAuthoritySet.add(role.getName().replace("ROLE_", ""));
            }
            String[] authorities = grantedAuthoritySet.toArray(new String[grantedAuthoritySet.size()]);

            return User.builder()
                    .username(appUser.getUsername())
                    .password(appUser.getPassword())
                    .disabled(false)
                    .roles(authorities)
                    .build();
        }
        throw new UsernameNotFoundException("Username: " +username + " could not be found.");
    }

}