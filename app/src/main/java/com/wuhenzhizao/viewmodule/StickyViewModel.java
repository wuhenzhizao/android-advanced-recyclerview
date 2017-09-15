package com.wuhenzhizao.viewmodule;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gomeos.mvvm.viewmodel.LifecycleViewModel;
import com.wuhenzhizao.callback.ItemHeaderClickListener;
import com.wuhenzhizao.model.Address;
import com.wuhenzhizao.view.ui.StickyActivity;
import com.wuhenzhizao.viewmodule.viewbean.StickyTestViewBean;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wuhenzhizao on 2017/9/14.
 */

public class StickyViewModel extends LifecycleViewModel {
    private List<StickyTestViewBean> itemList;
    private int mode;

    public void setMode(int mode) {
        this.mode = mode;
    }

    public List<StickyTestViewBean> getItemList() {
        return itemList;
    }

    public ItemHeaderClickListener getHeaderClickListener() {
        return new ItemHeaderClickListener() {
            @Override
            public void onHeaderClick(View clickView, int position, long headerId) {
                StickyTestViewBean viewBean = itemList.get(position);
                viewBean.setCollect(!viewBean.isCollect());
                notifyChange();

                Toast.makeText(getContext(), "Header " + viewBean.getTitle() + " clicked", Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void onCreate(Bundle bundle) {
        itemList = new LinkedList<>();
        for (int i = 0; i < Address.provinces.length; i++) {
            for (int j = 0; j < Address.citys[i].length; j++) {
                StickyTestViewBean viewBean = new StickyTestViewBean(true);
                viewBean.setHeadId(i + 1);
                viewBean.setTitle(Address.provinces[i]);
                viewBean.setName(Address.citys[i][j]);
                if (mode == StickyActivity.MODE_SINGLE) {
                    viewBean.setStickyTheme(1);
                } else {
                    if (i % 2 == 0) {
                        viewBean.setStickyTheme(1);
                    } else {
                        viewBean.setStickyTheme(0);
                        viewBean.setCollect(true);
                    }
                }
                itemList.add(viewBean);
            }
        }
        notifyChange();
    }
}
