package com.version_hit.Mapping;

import com.version_hit.PO.HitPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HitMapping {
    List<HitPO> getRuleList();

    Integer findDevice_Id(String target);
    List<String> getDevice_Id();
}
