package com.example.backend.registration;

import com.example.backend.appUser.AppUser;
import com.example.backend.appUser.AppUserRole;
import com.example.backend.appUser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("EMAIL_NOT_VALID");
        }
        return appUserService.singUpUser(
                new AppUser(
                        request.getFirstname(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
