package com.example.MovingMate.dto;
import com.example.MovingMate.entity.MoveEntity.MoveEntity;
import lombok.*;
import java.time.LocalDateTime;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoveDto {

    private Long id;

    private String moveWriter;

    private String phone;

    private String firstAddress;

    private String endAddress;

    private String moveType;

    private String start;

    private int price;   // 업체에서 제시한 금액
    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    public static MoveDto toMoveDto(MoveEntity moveEntity){

        MoveDto moveDto = new MoveDto();
        moveDto.setId(moveEntity.getId());
        moveDto.setMoveWriter(moveEntity.getMoveWriter());
        moveDto.setPhone(moveEntity.getPhone());
        moveDto.setFirstAddress(moveEntity.getFirstAddress());
        moveDto.setEndAddress(moveEntity.getEndAddress());
        moveDto.setMoveType(moveEntity.getMoveType());
        moveDto.setStart(moveEntity.getStart());
        moveDto.setPrice(moveEntity.getPrice());

        return moveDto;

    }

}
