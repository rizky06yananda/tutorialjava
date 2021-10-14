package com.test.rizky.repository;

import com.test.rizky.domain.Mahasiswa;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface MahasiswaRepository extends PagingAndSortingRepository<Mahasiswa, String> {
    Mahasiswa findByNim (String nim);
}
