package com.arkarzaw.asartaline.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkarzaw.asartaline.R;
import com.arkarzaw.asartaline.controllers.ShowItemClickListener;
import com.arkarzaw.asartaline.datas.vos.WarDeeVO;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewHolderFoodItem extends BaseViewHolder<WarDeeVO> {

    @BindView(R.id.tvRating)
    TextView tvRating;

    @BindView(R.id.ivWarDeeImage)
    ImageView ivWarDeeImage;

    @BindView(R.id.tvName)
    TextView tvName;

    @BindView(R.id.tvTastes)
    TextView tvTastes;

    @BindView(R.id.tvCost)
    TextView tvCost;

    ShowItemClickListener clickListener;
    WarDeeVO warDeeVO;
    public ViewHolderFoodItem(View itemView,ShowItemClickListener cListener) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        clickListener=cListener;
    }

    @Override
    public void setData(WarDeeVO data) {
        warDeeVO = data;
        tvName.setText(data.getName());
        tvTastes.setText(data.getGeneralTasteVOS().get(0).getTaste());
        tvCost.setText(data.getPriceRangeMin()+" - "+data.getPriceRangeMax());
        if(!data.getImages().isEmpty()) {
            Glide.with(ivWarDeeImage.getContext())
                    .load(data.getImages().get(0))
                    .into(ivWarDeeImage);
        }else {
            Glide.with(ivWarDeeImage.getContext())
                    .load(R.drawable.restaurant)
                    .into(ivWarDeeImage);
        }
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        clickListener.onShowItemClick(warDeeVO.getWarDeeId());
    }
}
