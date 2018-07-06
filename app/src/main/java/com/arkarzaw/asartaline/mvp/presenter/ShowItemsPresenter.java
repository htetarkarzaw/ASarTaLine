package com.arkarzaw.asartaline.mvp.presenter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.arkarzaw.asartaline.controllers.ShowItemClickListener;
import com.arkarzaw.asartaline.datas.models.WarDeeModel;
import com.arkarzaw.asartaline.datas.vos.WarDeeVO;
import com.arkarzaw.asartaline.mvp.views.ShowItemsView;

import java.util.List;

public class ShowItemsPresenter extends BasePresenter<ShowItemsView> implements ShowItemClickListener{

    private MutableLiveData<List<WarDeeVO>> mWarDeeVOS;

    @Override
    public void initPresenter(ShowItemsView view) {
        super.initPresenter(view);
        mWarDeeVOS = new MutableLiveData<>();
        WarDeeModel.getInstance().startLoadingWarDee(mWarDeeVOS,mErrorLD);
    }

    public LiveData<List<WarDeeVO>> getWarDeeVOS(){
        return mWarDeeVOS;
    }

    @Override
    public void onShowItemClick(String warDeeId) {
        mView.lunchItemDetail(warDeeId);
    }
}
