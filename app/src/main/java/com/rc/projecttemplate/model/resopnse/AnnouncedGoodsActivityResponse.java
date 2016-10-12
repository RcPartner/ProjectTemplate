
package com.rc.projecttemplate.model.resopnse;

import com.rc.projecttemplate.model.entity.AnnouncedGoodsActivityEntity;

import java.util.ArrayList;

public class AnnouncedGoodsActivityResponse extends BaseResponse<AnnouncedGoodsActivityResponse.AnnouncedGoodsActivityResponseData> {
    /**
     *
     */
    private static final long serialVersionUID = 1371273277181650982L;

    public class AnnouncedGoodsActivityResponseData {
        public ArrayList<AnnouncedGoodsActivityEntity> list;

        public int total;
    }
}
