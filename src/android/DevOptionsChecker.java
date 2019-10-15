package com.plugin.dev;

import android.provider.Settings;
import android.content.ContentResolver;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DevOptionsChecker extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("check")) {
            ContentResolver resolver = cordova.getActivity().getContentResolver();

            callbackContext.success(new JSONObject().put(
                "devOptionsEnabled",
                android.os.Build.VERSION.SDK_INT < 18
                    ? Settings.Secure.getString(resolver, Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED).equals("1")
                    : Settings.Global.getString(resolver, Settings.Global.DEVELOPMENT_SETTINGS_ENABLED).equals("1")
            ));
            
            return true;
        }

        return false;
    }
}
