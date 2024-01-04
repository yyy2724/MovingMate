package com.example.MovingMate.service;

import com.example.MovingMate.dto.MoveDto;
import com.example.MovingMate.dto.company.CompanyDto;
import com.example.MovingMate.entity.MoveEntity.MoveEntity;
import com.example.MovingMate.entity.company.CompanyEntity;
import com.example.MovingMate.repository.MoveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
                    .price(moveDto.getPrice())
                    .build();

//            System.out.println(moveRepository.save(moveEntity).getId());
            moveRepository.save(moveEntity);
            System.out.println("dk" + moveEntity.getId());
            return moveEntity;
        } else {
            return null;
        }

    }


    public Optional<MoveEntity> searchOrder(Long id) {

        Optional<MoveEntity> optionalMoveDto = moveRepository.findById(id);

        return optionalMoveDto;

    }

    public Page<MoveDto> movePageList(Pageable pageable, String subject, String search) {
        Page<MoveEntity> moveEntities = null;

        if (subject == null) {
            moveEntities = moveRepository.findMoveAll(pageable);
        } else if (subject.equals("id")) {
            moveEntities = moveRepository.findByIdContains(pageable, search);
        } else if (subject.equals("moveWriter")) {
            moveEntities = moveRepository.findByMoveWriterContains(pageable, search);
        } else if (subject.equals("firstAddress")) {
            moveEntities = moveRepository.findByFirstAddressContains(pageable, search); // 주소
        } else if (subject.equals("moveType")) {
            moveEntities = moveRepository.findByMoveTypeContains(pageable, search);
        } else {
            moveEntities = moveRepository.findAll(pageable);
        }

        Page<MoveDto> moveDtos = moveEntities.map(MoveDto::toMoveDto);

        return  moveDtos;

    }


    public int updatePrice(MoveDto moveDto) {
        MoveEntity moveEntity = moveRepository.findById(moveDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID"));


        MoveEntity moveEntity1 =MoveEntity.builder()
                .id(moveDto.getId())
                .moveWriter(moveDto.getMoveWriter())
                .phone(moveDto.getPhone())
                .firstAddress(moveDto.getFirstAddress())
                .endAddress(moveDto.getEndAddress())
                .moveType(moveDto.getMoveType())
                .start(moveDto.getStart())
                .price(moveDto.getPrice())
                .build();

        Long moveId = moveRepository.save(moveEntity1).getId();

        moveRepository.findById(moveId).orElseThrow();


        return 1;

    }


    public int payUpdate(MoveDto moveDto) {
        MoveEntity moveEntity = moveRepository.findById(moveDto.getId()).orElseThrow(()->{
            throw new IllegalArgumentException("존재하지 않음");
        });

        MoveEntity moveEntity1 = moveEntity.builder()
                .id(moveDto.getId())
                .moveWriter(moveDto.getMoveWriter())
                .phone(moveDto.getPhone())
                .firstAddress(moveDto.getFirstAddress())
                .endAddress(moveDto.getEndAddress())
                .moveType(moveDto.getMoveType())
                .start(moveDto.getStart())
                .price(moveDto.getPrice())
                .build();

        Long id = moveRepository.save(moveEntity1).getId();
        moveRepository.findById(id).orElseThrow();

        return 1;
    }
}



