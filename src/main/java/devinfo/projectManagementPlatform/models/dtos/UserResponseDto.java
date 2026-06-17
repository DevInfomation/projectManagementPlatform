package devinfo.projectManagementPlatform.models.dtos;

public record UserResponseDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        String mobileNumber
) { }
