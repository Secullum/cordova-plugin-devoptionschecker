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

            int androidSdkVersion = android.os.Build.VERSION.SDK_INT;

            try {
                callbackContext.success(new JSONObject().put(
                    "devOptionsEnabled",
                    Settings.Secure.getInt(resolver,
                        androidSdkVersion < 16 ?
                        Settings.Secure.ADB_ENABLED :
                        androidSdkVersion == 16 ?
                        Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED :
                        Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0) != 0
                ));
            } catch (Exception e) {
                callbackContext.success(new JSONObject().put(
                    "devOptionsEnabled", false));
            }
            return true;
        }
        return false;
    }
}