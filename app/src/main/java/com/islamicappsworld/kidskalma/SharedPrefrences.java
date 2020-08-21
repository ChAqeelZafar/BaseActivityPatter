//package com.islamicappsworld.kidskalma;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.content.SharedPreferences.Editor;
//
//public class SharedPrefrences  {
//	private static final String USER_PREFS = "user_preferences";
////	public static final String DISTANCE_DEFAULT = "7"; // String
////
////	public static final String ID = "id";// String
//	public static final String SOUND = "name";// String
////	public static final String EMAIL = "email";// String
////	public static final String PASSWORD = "user_password";// String
////	public static final String IMAGE_PATH = "image_path";// String
////	public static final String DISTANCE = "distance"; // String
////	public static final String PUSH_NOTIFICATION = "push_notification";// boolean
////	public static final String KEEP_ME_LOGED_IN = "keep_me_looged_in";// boolean
////	public static final String IS_USER_ITS_TIME_LOGIN = "is_user_its_time_login";// boolean
////	public static final String EMAIL_NOTIFICATION = "email_notification";// boolean
////	public static final String LOG_IN_FROM = "log_in_from";// int
////	public static final String LATITUDE = "latitude";
////	public static final String LONGITUDE = "longitude";
//
//	public static final String LanguageSelected = "language";// String
//	
//	public static boolean clear(Context context) {
//		Editor editor = context.getSharedPreferences(USER_PREFS,
//				Context.MODE_PRIVATE).edit();
//		editor.clear();
//		return editor.commit();
//	}
//
//	public static boolean setString(String key, String value, Context context) {
//		Editor editor = context.getSharedPreferences(USER_PREFS,
//				Context.MODE_PRIVATE).edit();
//		editor.putString(key, value);
//		return editor.commit();
//	}
//
//	public static String getString(String key, String defaultValue,
//			Context context) {
//		SharedPreferences prefs = context.getSharedPreferences(USER_PREFS,
//				Context.MODE_PRIVATE);
//		return prefs.getString(key, defaultValue);
//	}
//
//	public static boolean setBooleean(String key, boolean value, Context context) {
//		Editor editor = context.getSharedPreferences(USER_PREFS,
//				Context.MODE_PRIVATE).edit();
//		editor.putBoolean(key, value);
//		return editor.commit();
//	}
//
//	public static boolean getBooleean(String key, boolean defaultValue,
//			Context context) {
//		SharedPreferences prefs = context.getSharedPreferences(USER_PREFS,
//				Context.MODE_PRIVATE);
//		return prefs.getBoolean(key, defaultValue);
//	}
//
//	public static boolean setInt(String key, int value, Context context) {
//		Editor editor = context.getSharedPreferences(USER_PREFS,
//				Context.MODE_PRIVATE).edit();
//		editor.putInt(key, value);
//		return editor.commit();
//	}
//
//	public static int getInt(String key, int defaultValue, Context context) {
//		SharedPreferences prefs = context.getSharedPreferences(USER_PREFS,
//				Context.MODE_PRIVATE);
//		return prefs.getInt(key, defaultValue);
//	}
//
//	//
//	// public static void saveId(Context context, String jsonString) {
//	// if (jsonString == null)
//	// return;
//	//
//	// JSONObject obj;
//	// try {
//	// obj = new JSONObject(jsonString);
//	// saveString(ID, obj.optString("id"), context);
//	// } catch (JSONException e) {
//	// e.printStackTrace();
//	// }
//	// }
//
//	// public static void saveUser(Context context, String id,
//	// String display_name, String fb_id, String fb_auth_token,
//	// String gp_id, String gp_auth_token, int age, String sex,
//	// String city, String country) {
//	//
//	// saveString(ID, id, context);
//	// }
//
////	public static boolean isLoggedIn(Context context) {
////		return getString(ID, null, context) != null;
////	}
//}
//
