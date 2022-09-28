package com.echozoo.fox.dao;

import com.echozoo.fox.convert.FooMapper;
import com.echozoo.fox.model.FooDTO;
import com.echozoo.fox.model.FooPO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * foo repo
 *
 * @author dujf
 * @version 1.0
 * @date 2022/9/28 11:03
 */
@Component
public class FooRepository {

    @Resource
    private FooMapper mapper;

    public List<FooDTO> list() {
        final List<FooPO> poList = new ArrayList<>() {{
            add(FooPO.buildPO());
            add(FooPO.buildPO());
            add(FooPO.buildPO());
        }};
        return poList.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public FooDTO detail() {
        return mapper.toDto(FooPO.buildPO());
    }
}
