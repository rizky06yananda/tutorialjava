package com.test.rizky.shared;

import com.test.rizky.domain.Mahasiswa;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface EntityDTOMapper<Entity, DTO> {
    DTO convertToDto(Entity entity);
    List<DTO> convertToDto(List<Entity> entities);
    Entity convertToEntity(DTO dto);
    List<Entity>convertToEntity(List<DTO> dtos);
}
