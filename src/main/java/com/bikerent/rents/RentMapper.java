package com.bikerent.rents;


import com.bikerent.bikes.BikeService;
import com.bikerent.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentMapper {

    private UserService userService;
    private BikeService bikeService;

    public RentDto mapToRentDto(Rent rent) {
        return new RentDto(rent.getId(),
                rent.getDateOfRent(),
                rent.getDateOfReturn(),
                rent.getUser().getId(),
                rent.getBike().getId());
    }

    public Rent mapToRent(RentDto rentDto) {
        return new Rent(rentDto.getDateOfRent(),
                rentDto.getDateOfReturn(),
                userService.getUser(rentDto.getUserId()),
                bikeService.getBike(rentDto.getBikeId()));
    }

    public List<RentDto> mapToRentListDto(List<Rent> rentList) {
        return rentList.stream()
                .map(this::mapToRentDto)
                .collect(Collectors.toList());
    }
}
