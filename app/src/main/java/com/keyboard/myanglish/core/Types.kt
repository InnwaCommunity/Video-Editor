package com.keyboard.myanglish.core

data class InputMethodSubMode(val name: String, val label: String, val icon: String) {
    constructor() : this("", "", "")
}

data class InputMethodEntry(
    val uniqueName: String,
    val name: String,
    val icon: String,
    val nativeName: String,
    val label: String,
    val languageCode: String,
    val isConfigurable: Boolean,
    val subMode: InputMethodSubMode
) {
    constructor(
        uniqueName: String,
        name: String,
        icon: String,
        nativeName: String,
        label: String,
        languageCode: String,
        isConfigurable: Boolean
    ) : this(
        uniqueName,
        name,
        icon,
        nativeName,
        label,
        languageCode,
        isConfigurable,
        InputMethodSubMode()
    )

    constructor(
        uniqueName: String,
        name: String,
        icon: String,
        nativeName: String,
        label: String,
        languageCode: String,
        isConfigurable: Boolean,
        subMode: String,
        subModeLabel: String,
        subModeIcon: String
    ) : this(
        uniqueName,
        name,
        icon,
        nativeName,
        label,
        languageCode,
        isConfigurable,
        InputMethodSubMode(subMode, subModeLabel, subModeIcon)
    )

    constructor(name: String) : this("", name, "", "", "×", "", false)

    val displayName: String
        get() = name.ifEmpty { uniqueName }
}

enum class AddonCategory {
    InputMethod, Frontend, Loader, Module, UI;

    companion object {
        private val Values = values()
        fun fromInt(i: Int) = Values[i]
    }
}

data class AddonInfo(
    val uniqueName: String,
    val name: String,
    val comment: String,
    val category: AddonCategory,
    val isConfigurable: Boolean,
    val enabled: Boolean,
    val defaultEnabled: Boolean,
    val onDemand: Boolean,
    val dependencies: Array<String> = arrayOf(),
    val optionalDependencies: Array<String> = arrayOf(),
) {
    constructor(
        uniqueName: String,
        name: String,
        comment: String,
        category: Int,
        isConfigurable: Boolean,
        enabled: Boolean,
        defaultEnabled: Boolean,
        onDemand: Boolean,
        dependencies: Array<String>,
        optionalDependencies: Array<String>,
    ) : this(
        uniqueName,
        name,
        comment,
        AddonCategory.fromInt(category),
        isConfigurable,
        enabled,
        defaultEnabled,
        onDemand,
        dependencies,
        optionalDependencies
    )

    val displayName: String
        get() = name.ifEmpty { uniqueName }

    /**
     * generated by Android Studio
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AddonInfo

        if (uniqueName != other.uniqueName) return false
        if (name != other.name) return false
        if (comment != other.comment) return false
        if (category != other.category) return false
        if (isConfigurable != other.isConfigurable) return false
        if (enabled != other.enabled) return false
        if (defaultEnabled != other.defaultEnabled) return false
        if (onDemand != other.onDemand) return false
        if (!dependencies.contentEquals(other.dependencies)) return false
        if (!optionalDependencies.contentEquals(other.optionalDependencies)) return false

        return true
    }

    /**
     * generated by Android Studio
     */
    override fun hashCode(): Int {
        var result = uniqueName.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + comment.hashCode()
        result = 31 * result + category.hashCode()
        result = 31 * result + isConfigurable.hashCode()
        result = 31 * result + enabled.hashCode()
        result = 31 * result + defaultEnabled.hashCode()
        result = 31 * result + onDemand.hashCode()
        result = 31 * result + dependencies.contentHashCode()
        result = 31 * result + optionalDependencies.contentHashCode()
        return result
    }
}