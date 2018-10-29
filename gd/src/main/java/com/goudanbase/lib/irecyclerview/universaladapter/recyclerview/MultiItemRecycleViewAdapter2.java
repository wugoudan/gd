package com.goudanbase.lib.irecyclerview.universaladapter.recyclerview;

import android.content.Context;
import android.view.ViewGroup;

import com.goudanbase.lib.irecyclerview.universaladapter.ViewHolderHelper;

import java.util.List;

/**
 * Conpany:null
 * Auth:goudan
 * Date:{2018/9/29}
 * Mail:wulog@outlook.com
 * Effect:
 */
public abstract class MultiItemRecycleViewAdapter2<T> extends CommonRecycleViewAdapter<T> {
    public MultiItemRecycleViewAdapter2(Context context, List<T> mdatas) {
        super(context, -1, mdatas);
    }

    public MultiItemRecycleViewAdapter2(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public int getItemViewType(int position) {
        if (mDatas != null && mDatas.size() > 0) {
            return getItemViewType(position, mDatas.get(position));
        }
        return super.getItemViewType(position);
    }

    @Override
    public ViewHolderHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mDatas != null && mDatas.size() > 0) {
            int layoutId = getLayoutId(viewType);
            ViewHolderHelper helper = ViewHolderHelper.get(mContext, null, parent, layoutId, -1);
            setListener(parent, helper, viewType);
            return helper;
        } else {
            return super.onCreateViewHolder(parent, viewType);
        }

    }

    public abstract int getLayoutId(int type);

    public abstract int getItemViewType(int position, T t);
}
