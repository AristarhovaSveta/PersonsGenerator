package core.domain.dto;

import lombok.Getter;

@Getter
public class PersonDto {
    private String gender;
    private NameDto name;
    private LocationDto location;
    private String email;
    private LoginDto login;
    private DateAgeDto dob;
    private DateAgeDto registered;
    private String phone;
    private String cell;
    private IdDto id;
    private PictureDto picture;
    private String nat;
}
