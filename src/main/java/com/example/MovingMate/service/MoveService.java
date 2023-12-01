package com.example.MovingMate.service;

import com.example.MovingMate.entity.MoveEntity;
import com.example.MovingMate.dto.MoveDto;
import com.example.MovingMate.repository.MoveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoveService {

    private final MoveRepository moveRepository;


    public Long moveSave(MoveDto moveDto) {

        Optional<MoveDto> optionalMoveDto = Optional.ofNullable(Optional.ofNullable(moveDto).orElseThrow(() -> new IllegalArgumentException("값이 없다")));

        if (optionalMoveDto.isEmpty()) {

            MoveEntity moveEntity = MoveEntity.builder()
                    .moveWriter(moveDto.getName())
                    .moveType(moveDto.getMoveType())
                    .phone(moveDto.getPhone())
                    .firstAddress(moveDto.getFirstAddress())
                    .endAddress(moveDto.getEndAddress())
                    .build();

            return moveRepository.save(moveEntity).getId();
        }else {
            return 0L;
        }

    }
}
