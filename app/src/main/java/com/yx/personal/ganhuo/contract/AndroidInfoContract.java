package com.yx.personal.ganhuo.contract;

import com.yx.personal.ganhuo.GetDataListener;
import com.yx.personal.ganhuo.bean.DataInfoBean;

/**
 * Created by YX on 2016/11/29.
 */

public class AndroidInfoContract {
public interface View{
    void setRefresh(boolean isRefresh);
    void showData(DataInfoBean dataInfoBean);
    void showExceptionView(boolean isShow);

}

public interface Presenter{
    void getDataFromNet(int page);
}

public interface Model{
    void getAndroidInfo(int page,GetDataListener getDataListener);
}


}