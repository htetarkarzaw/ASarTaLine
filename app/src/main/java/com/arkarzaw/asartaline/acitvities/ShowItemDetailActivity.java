package com.arkarzaw.asartaline.acitvities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arkarzaw.asartaline.R;
import com.arkarzaw.asartaline.datas.vos.WarDeeVO;
import com.arkarzaw.asartaline.mvp.presenter.ShowItemDetailPresenter;
import com.arkarzaw.asartaline.mvp.views.ShowItemDetailView;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowItemDetailActivity extends BaseAcitvity implements ShowItemDetailView {

    private String warDeeId;

    @BindView(R.id.ivItem)
    ImageView ivItem;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvCost)
    TextView tvCost;

    @BindView(R.id.tvDesc)
    TextView tvDesc;

    ShowItemDetailPresenter mPresenter;

    public static void getInstance(Context context, String warDeeId) {
        Intent i = new Intent(context, ShowItemDetailActivity.class);
        i.putExtra("WARDEEID", warDeeId);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item_detail);
        ButterKnife.bind(this,this);
        mPresenter = ViewModelProviders.of(this).get(ShowItemDetailPresenter.class);
        mPresenter.initPresenter(this);

        if (getIntent().hasExtra("WARDEEID")) {
            warDeeId = getIntent().getStringExtra("WARDEEID");
        }

        mPresenter.getWarDeeVO(warDeeId);
    }


    @Override
    public void displayErrorMsg(String errMessage) {

    }

    @Override
    public void showItemDetail(WarDeeVO warDeeVO) {
        tvTitle.setText(warDeeVO.getName());
        tvDesc.setText(warDeeVO.getGeneralTasteVOS().get(0).getTasteDesc());
        tvCost.setText(warDeeVO.getPriceRangeMin()+"");
        Glide.with(this)
                .load(warDeeVO.getImages().get(0))
                .into(ivItem);
    }
}
