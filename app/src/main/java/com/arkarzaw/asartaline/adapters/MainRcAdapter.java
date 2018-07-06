package com.arkarzaw.asartaline.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.arkarzaw.asartaline.R;
import com.arkarzaw.asartaline.datas.vos.BaseVO;
import com.arkarzaw.asartaline.viewholders.BaseViewHolder;
import com.arkarzaw.asartaline.viewholders.FoodTypeViewHolder;

public class MainRcAdapter extends BaseRecyclerAdapter<BaseViewHolder,BaseVO> {

    public MainRcAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder bHolder = null;
        View v= mLayoutInflator.inflate(R.layout.viewholder_choose_food_type,parent,false);
        bHolder= new FoodTypeViewHolder(v);
        return bHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
