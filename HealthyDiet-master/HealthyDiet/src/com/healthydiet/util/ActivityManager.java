/**
 * 管理activity
 */
package com.healthydiet.util;

import java.util.ArrayList;
import android.app.Activity;
import com.healthydiet.BaseActivity;

//管理activity
public class ActivityManager {

	private ArrayList<BaseActivity> activityList = new ArrayList<BaseActivity>();
	private static ActivityManager instance;

	private ActivityManager() {
	}

	//实例化对象
	public static ActivityManager getInstance() {
		if (instance == null) {
			instance = new ActivityManager();
		}
		return instance;

	}

	//添加activity
	public void addActivity(BaseActivity activity) {
		activityList.add(activity);
	}

	//退出清空链表中activity
	public void exit() {
		for (Activity activity : activityList) {
			activity.finish();
		}
		System.exit(0);
	}

	public void remove(Class<? extends BaseActivity> c) {
		for (Activity activity : activityList) {
			if (activity.getClass() == c) {
				activity.finish();
			}
		}
	}

	public void finishAll() {
		for (BaseActivity activity : activityList) {
			activity.finish();
		}
		activityList.clear();
	}

	public boolean isActivityExit(Class<? extends BaseActivity> c) {
		for (BaseActivity activity : activityList) {
			if (activity.getClass() == c) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<BaseActivity> getActivityList() {
		return activityList;
	}
}
