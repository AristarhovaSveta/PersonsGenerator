package core.domain.dto;

import lombok.Getter;

@Getter
public class LocationDto {
    private String street;
    private String city;
    private String state;
    private String postcode;
    private CoordinatesDto coordinates;
    private TimeZoneDto timezone;
}
