package com.example.MovingMate.service;

import com.example.MovingMate.dto.MoveDto;
import com.example.MovingMate.entity.MoveEntity.MoveEntity;
import com.example.MovingMate.repository.MoveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoveService {

    private final MoveRepository moveRepository;


    public MoveEntity moveSave(MoveDto moveDto) {

        Optional<MoveDto> optionalMoveDto
                = Optional.ofNullable(Optional.ofNullable(moveDto).orElseThrow(() -> new IllegalArgumentException("값이 없다")));

        if (optionalMoveDto.isPresent()) {

            MoveEntity moveEntity = MoveEntity.builder()
                    .id(moveDto.getId())
                    .moveWriter(moveDto.getMoveWriter())
                    .moveType(moveDto.getMoveType())
                    .phone(moveDto.getPhone())
                    .firstAddress(moveDto.getFirstAddress())
                    .endAddress(moveDto.getEndAddress())
                    .build();

//            System.out.println(moveRepository.save(moveEntity).getId());
            moveRepository.save(moveEntity);
            System.out.println("dk"+moveEntity.getId());
            return moveEntity;
        }else {
            return null;
        }

    }


}
