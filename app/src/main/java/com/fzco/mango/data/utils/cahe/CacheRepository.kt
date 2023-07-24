package com.fzco.mango.data.utils.cahe

import android.content.Context
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

abstract class CacheRepository(
    context: Context
) {

    open val cachePrefKey: String = this::class.java.simpleName + "PrefKey"

    protected val preferences = context.getSharedPreferences(
        cachePrefKey,
        Context.MODE_PRIVATE
    )

    fun prefString(
        default: String = "",
        throwOnDefaultOrNull: Boolean = false
    ) = object : ReadWriteProperty<CacheRepository, String> {

        override fun getValue(thisRef: CacheRepository, property: KProperty<*>): String {
            val prefValue = preferences.getString(property.name, default) ?: default
            if (throwOnDefaultOrNull && prefValue == default) {
                throw java.lang.IllegalStateException("Preference value is default")
            }
            return prefValue
        }

        override fun setValue(thisRef: CacheRepository, property: KProperty<*>, value: String) {
            preferences.edit {
                putString(property.name, value)
            }
        }
    }

    fun prefBoolean(
        default: Boolean = false,
        throwOnDefault: Boolean = false
    ) = object : ReadWriteProperty<CacheRepository, Boolean> {

        override fun getValue(thisRef: CacheRepository, property: KProperty<*>): Boolean {
            val prefValue = preferences.getBoolean(property.name, default)
            if (throwOnDefault && prefValue == default) {
                throw java.lang.IllegalStateException("Preference value is default")
            }
            return prefValue
        }


        override fun setValue(thisRef: CacheRepository, property: KProperty<*>, value: Boolean) {
            preferences.edit {
                putBoolean(property.name, value)
            }
        }
    }

    fun prefInt(
        default: Int = -1,
        throwOnDefault: Boolean = false
    ) = object : ReadWriteProperty<CacheRepository, Int> {

        override fun getValue(thisRef: CacheRepository, property: KProperty<*>): Int {
            val prefValue = preferences.getInt(property.name, default)
            if (throwOnDefault && prefValue == default) {
                throw java.lang.IllegalStateException("Preference value is default")
            }
            return prefValue
        }


        override fun setValue(thisRef: CacheRepository, property: KProperty<*>, value: Int) {
            preferences.edit {
                putInt(property.name, value)
            }
        }
    }
}
