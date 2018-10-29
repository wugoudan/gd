package com.goudanbase.lib.irecyclerview.universaladapter.abslistview;

public interface MultiItemTypeSupport<T>
{
	int getLayoutId(int position, T t);

	int getViewTypeCount();

	int getItemViewType(int position, T t);
}