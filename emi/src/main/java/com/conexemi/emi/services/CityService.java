package com.conexemi.emi.services;

import com.conexemi.emi.DTO.CityDTO;
import com.conexemi.emi.Mapper.CityMapper;
import com.conexemi.emi.model.City;
import com.conexemi.emi.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;


    public CityDTO createCity(CityDTO cityDTO) {
        City city = CityMapper.toEntity(cityDTO);
        City savedCity = cityRepository.save(city);
        return CityMapper.toDTO(savedCity);
    }

    public Optional<CityDTO> getCityById(Integer idCity) {
        Optional<City> city = cityRepository.findById(idCity);
        return city.map(CityMapper::toDTO);
    }

    public Optional<CityDTO> getCityByName(String nameCity) {
        Optional<City> city = cityRepository.findByCityName(nameCity);
        return city.map(CityMapper::toDTO);
    }

    public List<CityDTO> getAllCities() {
        List<City> cities = cityRepository.findAll();
        return cities.stream()
                .map(CityMapper::toDTO)
                .collect(Collectors.toList());
    }


}
