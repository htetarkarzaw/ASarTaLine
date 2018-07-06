package com.arkarzaw.asartaline.mvp.presenter;

import com.arkarzaw.asartaline.datas.models.WarDeeModel;
import com.arkarzaw.asartaline.datas.vos.WarDeeVO;
import com.arkarzaw.asartaline.mvp.views.ShowItemDetailView;

public class ShowItemDetailPresenter extends BasePresenter<ShowItemDetailView> {

    @Override
    public void initPresenter(ShowItemDetailView view) {
        super.initPresenter(view);
    }

    public void getWarDeeVO(String warDeeId){
         mView.showItemDetail(WarDeeModel.getInstance().getWarDeeVO(warDeeId));
    }

}
