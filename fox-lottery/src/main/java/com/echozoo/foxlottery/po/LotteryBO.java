package com.echozoo.foxlottery.po;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description: TODO
 * @Author: ddd
 * @Date: 2023/11/13
 */
@Data
@AllArgsConstructor
public class LotteryBO {

    Integer notWin;
    List<LotteryDTO> lotteryDTOList;
}
