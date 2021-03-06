package com.yx.personal.ganhuo.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.yx.personal.ganhuo.R;
import com.yx.personal.ganhuo.utils.AppManager;

/**
 * activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    private ActionBar actionBar;
    private TextView toolbar_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentView());

        initActionBar();

        AppManager.getAppManager().addActivity(this);
    }

    /**
     * 获取当前activity的布局文件
     * @return
     */
    protected abstract int getContentView();
    protected abstract void setToolbar();

    /**
     * 初始化toolbar
     */
    protected  void initActionBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.empty);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        if(toolbar!=null){
            setSupportActionBar(toolbar);
            actionBar = getSupportActionBar();
            if(actionBar!=null ){
                //设置返回按钮
//                actionBar.setHomeAsUpIndicator(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
                actionBar.setDisplayHomeAsUpEnabled(false);
            }
        }
        //设置状态栏颜色
        //see {https://github.com/jgilfelt/SystemBarTint}
//        SystemBarTintManager tintManager = new SystemBarTintManager(this);
//        tintManager.setStatusBarTintEnabled(true);
//        tintManager.setNavigationBarTintEnabled(true);
//        tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
        setToolbar();
    }

    protected void setIsShowBack(boolean isShow) {
        actionBar.setDisplayHomeAsUpEnabled(isShow);
    }

    protected Toolbar getToolBar() {
        return toolbar;
    }

    /**
     * toolbar设置标题
     * @param title
     */
    @Override
    public void setTitle(CharSequence title) {
        if(toolbar!=null){
            toolbar_title.setText(title);
        }else{
            toolbar_title.setText(title);
        }

    }

    /**
     * 隐藏toolbar
     */
    public void hideToolBar() {
        if(toolbar!=null){
            toolbar.setVisibility(View.GONE);
        }
    }

    /**
     * 隐藏toolbar
     */
    public void showToolBar() {
        if(toolbar!=null){
            toolbar.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 加载对话框
     */
    private MaterialDialog mProgressDialog;
    protected void showProgress(String content) {
        if (null == mProgressDialog) {
            mProgressDialog = new MaterialDialog.Builder(this)
                    .content(content)
                    .progress(true, 0)
                    .show();
        } else {
            mProgressDialog.setContent(content);
            mProgressDialog.show();
        }
    }

    /**
     * 隐藏对话框
     */
    protected void hiddenProgress() {
        if (null != mProgressDialog && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                AppManager.getAppManager().finishActivity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
