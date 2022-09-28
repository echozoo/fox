package com.echozoo.fox.convert;

import com.echozoo.fox.model.FooDTO;
import com.echozoo.fox.model.FooPO;
import com.echozoo.fox.model.FooVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Foo mapper
 *
 * @author dujf
 * @version 1.0
 * @date 2022/9/28 11:10
 */
@Mapper(componentModel = "spring")
public interface FooMapper {

    /**
     * TODO
     *
     * @param po
     * @return com.echozoo.fox.model.FooDTO
     * @author dujf
     * @date 2022/9/28 11:12
     * @since java 11
     */
    @Mapping(source = "_id", target = "id")
    @Mapping(source = "createUserID", target = "createUserId")
    FooDTO toDto(FooPO po);

    /**
     * TODO
     *
     * @param dto
     * @return com.echozoo.fox.model.FooVO
     * @author dujf
     * @date 2022/9/28 11:14
     * @since java 11
     */
    @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    FooVO toVo(FooDTO dto);
}
