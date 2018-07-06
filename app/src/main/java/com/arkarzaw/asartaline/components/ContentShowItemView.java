package com.arkarzaw.asartaline.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.arkarzaw.asartaline.R;
import com.arkarzaw.asartaline.adapters.MainRcAdapter;
import com.arkarzaw.asartaline.controllers.ShowItemClickListener;
import com.arkarzaw.asartaline.datas.vos.WarDeeVO;
import com.arkarzaw.asartaline.mvp.presenter.ShowItemsPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContentShowItemView extends NestedScrollView {

    @BindView(R.id.mainRc)
    RecyclerView mainRc;
    MainRcAdapter adapter;




    public ContentShowItemView(@NonNull Context context) {super(context);    }

    public ContentShowItemView(@NonNull Context context, @Nullable AttributeSet attrs) {super(context, attrs);    }

    public ContentShowItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {super(context, attrs, defStyleAttr);    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    public void setUpRecycler(ShowItemClickListener cListener) {
        mainRc.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        adapter = new MainRcAdapter(getContext(),cListener);
        mainRc.setAdapter(adapter);
    }

    public void setDatas(List<WarDeeVO> warDeeVOS){
        adapter.appendNewData(warDeeVOS);
    }


}
