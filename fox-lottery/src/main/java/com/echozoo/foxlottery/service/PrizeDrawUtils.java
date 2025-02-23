package com.echozoo.foxlottery.service;

import com.alibaba.fastjson.JSON;
import com.echozoo.foxlottery.po.LotteryBO;
import com.echozoo.foxlottery.po.LotteryDTO;
import com.echozoo.foxlottery.po.Prize;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 孙忠帅
 * @version 1.0
 * @date 2022/10/17
 */
@Slf4j
public class PrizeDrawUtils {


    protected static final BigDecimal PROBABILITY_BASE = new BigDecimal(10000);

    /**
     * 封装奖品的成随机概率实体
     *
     * @param lotteryPrizes 奖品列表
     * @return P
     */
    public static LotteryBO getRandomDrawRegion(List<Prize> lotteryPrizes) {
        final List<LotteryDTO> randomDrawRegionBOList = new ArrayList<>(lotteryPrizes.size());
        //不会中奖的比例-也作为计算偏移量
        int notWin = 0;
        int begin = 0;
        List<String> awardsIds = new ArrayList<>();
        //获取比例最大值(即不会中奖的概率)
        for (Prize e : lotteryPrizes) {
            Integer probability = BigDecimal.valueOf(e.getProbability()).multiply(PROBABILITY_BASE)
                    .intValue();
            if (!awardsIds.contains(e.getId())) {
                //换算后
                LotteryDTO dto = new LotteryDTO();
                dto.setProbability(probability);
                dto.setFrom(begin);
                dto.setTo(begin + probability);
                dto.setPrizeId(e.getId());
                randomDrawRegionBOList.add(dto);
                //设置不会中奖的比例
                notWin += probability;
            }
        }
        return new LotteryBO(notWin, randomDrawRegionBOList);
    }


    public static Long find(List<LotteryDTO> randomDrawRegionBOList, int randomInt) {
        int low = BigDecimal.ZERO.intValue();
        int high = randomDrawRegionBOList.size() - BigDecimal.ONE.intValue();
        while (low <= high) {
            int mid = (high + low) >>> BigDecimal.ONE.intValue();
            LotteryDTO randomDrawRegionBO = randomDrawRegionBOList.get(mid);
            if (randomInt >= randomDrawRegionBO.getFrom()
                    && randomInt < randomDrawRegionBO.getTo()) {
                return randomDrawRegionBO.getPrizeId();

            }
            if (randomDrawRegionBO.getTo() > randomInt) {
                high = mid - BigDecimal.ONE.intValue();
            }
            if (randomDrawRegionBO.getFrom() < randomInt) {
                low = mid + BigDecimal.ONE.intValue();
            }
        }
        return null;
    }


    /**
     * 获取随机值
     *
     * @param random_size
     * @return
     */
    private static int getNextInt(int random_size) {
        return ThreadLocalRandom.current().nextInt(random_size);
    }

    private static final int randomInt = 1000000;

    public static Long findPrize(List<Prize> lotteryPrizes) {
        int nextInt = getNextInt(randomInt);
        LotteryBO randomDrawRegionCache = getRandomDrawRegion(lotteryPrizes);
        log.info("随机数是：{}，奖品情况是：{}", nextInt, JSON.toJSONString(randomDrawRegionCache));
        int notWin = randomDrawRegionCache.getNotWin();
        List<LotteryDTO> randomDrawRegionBOList = randomDrawRegionCache.getLotteryDTOList();
        //不会中奖
        if (nextInt > notWin) {
            return null;
        }
        //中奖的使用二分查找法
        return find(randomDrawRegionBOList, randomInt);
    }
}
