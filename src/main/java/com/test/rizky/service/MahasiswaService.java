package com.test.rizky.service;

import com.test.rizky.dto.MahasiswaDTO;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public interface MahasiswaService {
    MahasiswaDTO addData (MahasiswaDTO dto);
    List<MahasiswaDTO> getData ();
    MahasiswaDTO getDetailMahasiswa (String nim);
}
