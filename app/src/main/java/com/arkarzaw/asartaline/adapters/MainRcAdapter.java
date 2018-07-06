package com.arkarzaw.asartaline.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.arkarzaw.asartaline.R;
import com.arkarzaw.asartaline.controllers.ShowItemClickListener;
import com.arkarzaw.asartaline.datas.vos.BaseVO;
import com.arkarzaw.asartaline.datas.vos.WarDeeVO;
import com.arkarzaw.asartaline.viewholders.BaseViewHolder;
import com.arkarzaw.asartaline.viewholders.ViewHolderFoodItem;

public class MainRcAdapter extends BaseRecyclerAdapter<BaseViewHolder,WarDeeVO> {

    ShowItemClickListener cListener;
    public MainRcAdapter(Context context , ShowItemClickListener cListener) {
        super(context);
        this.cListener = cListener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder bHolder = null;
        View v= mLayoutInflator.inflate(R.layout.viewholder_show_food_item,parent,false);
        bHolder= new ViewHolderFoodItem(v,cListener);
        return bHolder;
    }


}
