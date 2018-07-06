package com.arkarzaw.asartaline.acitvities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.arkarzaw.asartaline.components.ContentShowItemView;
import com.arkarzaw.asartaline.R;
import com.arkarzaw.asartaline.datas.models.WarDeeModel;
import com.arkarzaw.asartaline.datas.vos.WarDeeVO;
import com.arkarzaw.asartaline.mvp.presenter.ShowItemsPresenter;
import com.arkarzaw.asartaline.mvp.views.ShowItemsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowItemsActivity extends BaseAcitvity implements ShowItemsView {

    @BindView(R.id.contentShowItems)
    ContentShowItemView contentShowItems;

    ShowItemsPresenter mPersenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_items);
        ButterKnife.bind(this,this);
        mPersenter = ViewModelProviders.of(this).get(ShowItemsPresenter.class);
        mPersenter.initPresenter(this);
        contentShowItems.setUpRecycler(mPersenter);
        mPersenter.getWarDeeVOS().observe(this, new Observer<List<WarDeeVO>>() {
            @Override
            public void onChanged(@Nullable List<WarDeeVO> warDeeVOS) {
                contentShowItems.setDatas(warDeeVOS);
            }
        });
        Log.e("zzzzzz", "onCreate: "+WarDeeModel.getInstance().warDeeVOList.size());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void displayErrorMsg(String errMessage) {
        Toast.makeText(this, errMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void lunchItemDetail(String warDeeId) {
        ShowItemDetailActivity.getInstance(getApplicationContext(),warDeeId);
    }
}
