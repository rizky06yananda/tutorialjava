package com.test.rizky.service.impl;

import com.test.rizky.domain.Mahasiswa;
import com.test.rizky.dto.MahasiswaDTO;
import com.test.rizky.exeption.ErrorApp;
import com.test.rizky.mapper.MahasiswaMapper;
import com.test.rizky.repository.MahasiswaRepository;
import com.test.rizky.service.MahasiswaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.test.rizky.constant.constant.ErrorCode.DUPLICATE_ENTRY;
import static com.test.rizky.shared.util.ObjectUtil.isExist;
import static com.test.rizky.shared.util.ValidatorUtil.validateField;

@Slf4j
@Service
public class MahasiswaServiceImpl implements MahasiswaService {
    private final MahasiswaRepository mahasiswaRepository;
    private final MahasiswaMapper mahasiswaMapper;

    public MahasiswaServiceImpl(MahasiswaRepository mahasiswaRepository, MahasiswaMapper mahasiswaMapper) {
        this.mahasiswaRepository = mahasiswaRepository;
        this.mahasiswaMapper = mahasiswaMapper;
    }

    @Override
    public MahasiswaDTO addData(MahasiswaDTO dto) {
        log.info("param request. data {}", dto.toString());
        validateField(dto.getName(), "Name");
        validateField(dto.getNim(), "Nim");
        validateField(dto.getMajor(), "Major");

        Mahasiswa mahasiswa = mahasiswaRepository.findByNim(dto.getNim());
        log.info("param request. response get data by nim {}", mahasiswa);

        try {
            if (!isExist(mahasiswa)) {
                mahasiswa = mahasiswaMapper.convertToEntity(dto);
                mahasiswa = mahasiswaRepository.save(mahasiswa);
                return isExist(mahasiswa) ? mahasiswaMapper.convertToDto(mahasiswa) : null;
            } else {
                throw new ErrorApp(DUPLICATE_ENTRY, "Data Duplicate");
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ErrorApp(DUPLICATE_ENTRY, e.getMessage());
        }


    }

    @Override
    public List<MahasiswaDTO> getData() {
        List<Mahasiswa> mahasiswa = (List<Mahasiswa>) mahasiswaRepository.findAll();
        log.info("param request. response get all data {}", mahasiswa.toString());
        return isExist(mahasiswa) ? mahasiswaMapper.convertToDto(mahasiswa) : null;
    }

    @Override
    public MahasiswaDTO getDetailMahasiswa(String nim) {
        Mahasiswa mahasiswa = mahasiswaRepository.findByNim(nim);
        log.info("param request. response get one data {}", mahasiswa.toString());
        return isExist(mahasiswa) ? mahasiswaMapper.convertToDto(mahasiswa) : null;
    }


}
