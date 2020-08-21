package com.islamicappsworld.kidskalma;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class User {

	private static final String USER_PREFS = "user_preferences";

	public static final String LANGUAGE = "0";
	public static final String LanguageSelected = "LanguageSelected";

	public static boolean clear(Context context) {
		Editor editor = context.getSharedPreferences(USER_PREFS,
				Context.MODE_PRIVATE).edit();
		editor.clear();
		return editor.commit();
	}

	public static boolean setString(String key, String value, Context context) {
		Editor editor = context.getSharedPreferences(USER_PREFS,
				Context.MODE_PRIVATE).edit();
		editor.putString(key, value);
		return editor.commit();
	}

	public static String getString(String key, String defaultValue,
			Context context) {
		SharedPreferences prefs = context.getSharedPreferences(USER_PREFS,
				Context.MODE_PRIVATE);
		return prefs.getString(key, defaultValue);
	}

	public static boolean saveBooleean(String key, boolean value,
			Context context) {
		Editor editor = context.getSharedPreferences(USER_PREFS,
				Context.MODE_PRIVATE).edit();
		editor.putBoolean(key, value);
		return editor.commit();
	}

	public static boolean getBooleean(String key, boolean defaultValue,
			Context context) {
		SharedPreferences prefs = context.getSharedPreferences(USER_PREFS,
				Context.MODE_PRIVATE);
		return prefs.getBoolean(key, defaultValue);
	}

	public static boolean saveInt(String key, int value, Context context) {
		Editor editor = context.getSharedPreferences(USER_PREFS,
				Context.MODE_PRIVATE).edit();
		editor.putInt(key, value);
		return editor.commit();
	}

	public static int getInt(String key, int defaultValue, Context context) {
		SharedPreferences prefs = context.getSharedPreferences(USER_PREFS,
				Context.MODE_PRIVATE);
		return prefs.getInt(key, defaultValue);
	}

}
