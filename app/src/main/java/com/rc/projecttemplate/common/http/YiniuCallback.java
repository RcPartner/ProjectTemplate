package com.rc.projecttemplate.common.http;

import android.text.TextUtils;

import com.rc.framework.service.JsonServiceCallback;
import com.rc.projecttemplate.model.resopnse.BaseResponse;

import org.json.JSONObject;

import java.lang.reflect.Field;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-07-14 15:18
 */
public abstract class YiniuCallback<T> extends JsonServiceCallback<T> {

    @Override
    protected T parserResponse(String responseStr) {
        T entity = super.parserResponse(responseStr);
        if (entity == null) {
            entity = parserBaseResponse(responseStr);
        }
        return entity;
    }

    /**
     * 把json格式的字符串转成BaseResponse类型的对象
     *
     * @param responseStr json格式的字符串
     * @return 成功：BaseResponse类型的对象，失败：null
     */
    private T parserBaseResponse(String responseStr) {
        if (!TextUtils.isEmpty(responseStr)) {
            try {
                JSONObject jsonObject = new JSONObject(responseStr);
                int status = jsonObject.getInt("status");
                int errCode = jsonObject.getInt("errCode");
                String error = jsonObject.getString("error");
                T response = (T) (((Class) getSuperclassTypeParameter()).newInstance());
                Field cstatus = BaseResponse.class.getField("status");
                cstatus.set(response, status);
                Field cerrCode = BaseResponse.class.getField("errCode");
                cerrCode.set(response, errCode);
                Field cerror = BaseResponse.class.getField("error");
                cerror.set(response, error);
                return response;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
