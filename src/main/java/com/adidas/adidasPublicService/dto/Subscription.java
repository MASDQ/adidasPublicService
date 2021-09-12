package com.adidas.adidasPublicService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    //Required Values
    @NotNull
    private Integer id;

    @Email
    @NotNull
    private String email;

    @NotNull
    private Date dateOfBirth;

    @NotNull
    private String newsletterId;

    @NotNull
    private Boolean consent;

    //Optional Values
    @Min(3)
    @Max(20)
    @Nullable
    private String gender;

    @Nullable
    @Min(3)
    @Max(20)
    private String firstName;
}
