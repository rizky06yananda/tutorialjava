package com.test.rizky.mapper;

import com.test.rizky.domain.Mahasiswa;
import com.test.rizky.dto.MahasiswaDTO;
import com.test.rizky.repository.MahasiswaRepository;
import com.test.rizky.shared.EntityDTOMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Configuration
public class MahasiswaMapper implements EntityDTOMapper<Mahasiswa, MahasiswaDTO> {
    private final ModelMapper modelMapper;
    private final MahasiswaRepository mahasiswaRepository;

    @Autowired
    public MahasiswaMapper(ModelMapper modelMapper, MahasiswaRepository mahasiswaRepository) {
        this.modelMapper = modelMapper;
        this.mahasiswaRepository = mahasiswaRepository;
    }

    @Override
    public MahasiswaDTO convertToDto(Mahasiswa mahasiswa){
        return modelMapper.map(mahasiswa, MahasiswaDTO.class);
    }

    @Override
    public List<MahasiswaDTO> convertToDto(List<Mahasiswa> mahasiswaList){
        return mahasiswaList.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    @Override
    public Mahasiswa convertToEntity(MahasiswaDTO mahasiswaDTO){
        Mahasiswa mahasiswa;

        if (mahasiswaDTO.getId() != null){
            mahasiswa = mahasiswaRepository.findById(mahasiswaDTO.getId()).orElse(null);
        } else {
            mahasiswa = new Mahasiswa();
        }
        mahasiswa.setName(mahasiswaDTO.getName());
        mahasiswa.setMajor(mahasiswaDTO.getMajor());
        mahasiswa.setNim(mahasiswaDTO.getNim());

        return mahasiswa;
    }

    @Override
    public List<Mahasiswa> convertToEntity(List<MahasiswaDTO> mahasiswaDTOList){
        return mahasiswaDTOList.stream().map(this::convertToEntity).collect(Collectors.toList());
    }

}
