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


//    public Long moveSave(MoveDto moveDto) {
//
//        Optional<MoveDto> optionalMoveDto
//                = Optional.ofNullable(Optional.ofNullable(moveDto).orElseThrow(() -> new IllegalArgumentException("값이 없다")));
//
//        if (optionalMoveDto.isPresent()) {
//
//            MoveEntity moveEntity = MoveEntity.builder()
//                    .moveWriter(moveDto.getName())
//                    .moveType(moveDto.getMoveType())
//                    .phone(moveDto.getPhone())
//                    .firstAddress(moveDto.getFirstAddress())
//                    .endAddress(moveDto.getEndAddress())
//                    .build();
//
//            System.out.println(moveRepository.save(moveEntity).getId());
//            return moveRepository.save(moveEntity).getId();
//        }else {
//            return 0L;
//        }
//
//    }
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


    public List<MoveDto> calendarListAll() {
        List<MoveDto> calendarDtoList = new ArrayList<>();
        List<MoveEntity> calendarEntityList = moveRepository.findAll();

        for (MoveEntity calendarEntity : calendarEntityList){
            MoveDto calendarDto = MoveDto.builder()
                    .id(calendarEntity.getId())
                    .moveWriter(calendarEntity.getMoveWriter())
                    .phone(calendarEntity.getPhone())
                    .firstAddress(calendarEntity.getFirstAddress())
                    .endAddress(calendarEntity.getEndAddress())
                    .moveType(calendarEntity.getMoveType())
                    .build();
            calendarDtoList.add(calendarDto);
        }

        return calendarDtoList;
    }
}
