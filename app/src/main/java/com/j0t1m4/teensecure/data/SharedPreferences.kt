package com.j0t1m4.teensecure.data

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import javax.inject.Singleton

@Singleton
class SharedPreferences(applicationContext: Context) {
    private val config: SharedPreferences = EncryptedSharedPreferences.create(
        applicationContext,
        CONFIG_NAME,
        MasterKey.Builder(applicationContext, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    var userIsTeen: Boolean
        get() = config.getBoolean(KEY_USER_IS_TEEN, true)
        set(value) = config.edit().putBoolean(KEY_USER_IS_TEEN, value).apply()

    var currentScore: Int
        get() = config.getInt(KEY_CURRENT_SCORE, 0)
        set(value) = config.edit().putInt(KEY_CURRENT_SCORE, value).apply()

    var currentLevelTS: Int
        get() = config.getInt(KEY_CURRENT_LEVEL_TS, 1)
        set(value) = config.edit().putInt(KEY_CURRENT_LEVEL_TS, value).apply()

    var currentLevelRW: Int
        get() = config.getInt(KEY_CURRENT_LEVEL_RW, 1)
        set(value) = config.edit().putInt(KEY_CURRENT_LEVEL_RW, value).apply()

    var username: String?
        get() = config.getString(KEY_USERNAME, null)
        set(value) = config.edit().putString(KEY_USERNAME, value).apply()

    var currentGame: String?
        get() = config.getString(KEY_CURRENT_GAME, null)
        set(value) = config.edit().putString(KEY_CURRENT_GAME, value).apply()

    var currentTopic: String?
        get() = config.getString(KEY_CURRENT_TOPIC, null)
        set(value) = config.edit().putString(KEY_CURRENT_TOPIC, value).apply()

    fun clearAllStoredData() {
        config.edit().clear().apply()
    }


    companion object {
        private const val CONFIG_NAME = "config"
        private const val KEY_USER_IS_TEEN = "key_user_is_teen"
        private const val KEY_CURRENT_SCORE = "key_user_current_score"
        private const val KEY_CURRENT_LEVEL_TS = "key_user_current_level_teen_secure"
        private const val KEY_CURRENT_LEVEL_RW = "key_user_current_level_ransom_wrangler"
        private const val KEY_USERNAME = "key_user_username"
        private const val KEY_CURRENT_GAME = "key_user_current_game"
        private const val KEY_CURRENT_TOPIC = "key_user_current_topic"
    }
}