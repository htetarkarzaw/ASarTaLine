package com.arkarzaw.asartaline.datas.models;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.arkarzaw.asartaline.AppConstants;
import com.arkarzaw.asartaline.datas.WarDeeResponse;
import com.arkarzaw.asartaline.datas.vos.WarDeeVO;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WarDeeModel extends BaseModel {

    public static WarDeeModel objInstance;

    public List<WarDeeVO> warDeeVOList;

    protected WarDeeModel(Context context) {
        super(context);
        warDeeVOList = new ArrayList<>();
    }

    public static void initAppModel(Context context) {
        objInstance = new WarDeeModel(context);
    }

    public static WarDeeModel getInstance() {
        if (objInstance == null) {
            throw new RuntimeException("SimpleHabitsModel is being invoked before initializing.");
        }
        return objInstance;
    }

    public void startLoadingWarDee(final MutableLiveData<List<WarDeeVO>> mWarDeeVOSLD , final MutableLiveData<String> mErrorLD){
        theApi.getWarDeeItems(AppConstants.ACCESS_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WarDeeResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WarDeeResponse warDeeResponse) {
                        if(warDeeResponse != null){
                            warDeeVOList=warDeeResponse.getWarDeeVOS();
                            mWarDeeVOSLD.setValue(warDeeVOList);
                        }else {
                            Log.e("zzzz", "onNext:NODataResponse " );
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("zzzz", "onNext:ErrorMsg " +e.getMessage());
                        mErrorLD.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public WarDeeVO getWarDeeVO(String warDeeId){
        if(!warDeeVOList.isEmpty()){
            for(WarDeeVO warDeeVO:warDeeVOList){
                if(warDeeVO.getWarDeeId().equals(warDeeId)){
                    return warDeeVO;
                }
            }
        }return null;
    }
}
