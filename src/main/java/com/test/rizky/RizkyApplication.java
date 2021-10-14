package com.test.rizky;

import com.test.rizky.dto.MahasiswaDTO;
import com.test.rizky.dto.response.ResponseDTO;
import com.test.rizky.service.MahasiswaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Serializable;

@SpringBootApplication
@RestController
public class RizkyApplication {
    private final MahasiswaService mahasiswaService;


    public RizkyApplication(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RizkyApplication.class, args);
    }

    @PostMapping(value = "/add/mahasiswa")
    @ApiOperation("Api to get data")
    public ResponseDTO addMahasiswa(@RequestBody MahasiswaDTO dto) {
        return ResponseDTO.SUCCESS(mahasiswaService.addData(dto));
    }

    @GetMapping(value = "/get/all/mahasiswa")
    @ApiOperation("Api to get data")
    public ResponseDTO getDataMahasiswa() {
        return ResponseDTO.SUCCESS((Serializable) mahasiswaService.getData());
    }

    @GetMapping(value = "/detail/mahasiswa/{nim}")
    @ApiOperation("Api to get data")
    public ResponseDTO getDetailMahasiswa(@PathVariable ("nim") String nim) {
        return ResponseDTO.SUCCESS(mahasiswaService.getDetailMahasiswa(nim));
    }


}
