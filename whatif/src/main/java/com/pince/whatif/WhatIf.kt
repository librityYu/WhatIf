package com.pince.whatif

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> T.whatIf(given: (T) -> Boolean?, whatIf: () -> Unit): T {
    if (given(this) == true) {
        whatIf()
    }
    return this
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> T.whatIf(
    given: (T) -> Boolean?,
    whatIf: () -> Unit,
    whatIfNot: () -> Unit
): T {
    if (given(this) == true) {
        whatIf()
    } else {
        whatIfNot()
    }
    return this
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> T.whatIf(given: Boolean?, whatIf: T.() -> Unit): T {
    if (given == true) {
        this.apply { whatIf() }
    }
    return this
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> T.whatIf(
    given: Boolean?,
    whatIf: T.() -> Unit,
    whatIfNot: T.() -> Unit
): T {

    if (given == true) {
        this.apply { whatIf() }
    } else {
        this.apply { whatIfNot() }
    }
    return this
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> T.whatIf(
    given: () -> Boolean?,
    whatIfDo: T.() -> Unit
): T {

    return this.whatIf(
        given = given,
        whatIfDo = whatIfDo,
        whatIfNot = { }
    )
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> T.whatIf(
    given: () -> Boolean?,
    whatIfDo: T.() -> Unit,
    whatIfNot: T.() -> Unit
): T {

    if (given() == true) {
        this.whatIfDo()
    } else {
        this.whatIfNot()
    }
    return this
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T, R> T.whatIfMap(
    default: R,
    whatIf: (T) -> R
): R {

    return this.whatIfMap(
        whatIf = whatIf,
        whatIfNot = { default }
    )
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T, R> T.whatIfMap(
    whatIf: (T) -> R,
    whatIfNot: (T) -> R
): R {

    if (this != null) {
        return whatIf(this)
    }
    return whatIfNot(this)
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T, R> T.whatIfMap(
    given: Boolean?,
    default: R,
    whatIf: (T) -> R
): R {

    return this.whatIfMap(
        given = given,
        whatIf = whatIf,
        whatIfNot = { default }
    )
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T, R> T.whatIfMap(
    given: Boolean?,
    whatIf: (T) -> R,
    whatIfNot: (T) -> R
): R {

    if (given == true) {
        return whatIf(this)
    }
    return whatIfNot(this)
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T, R> T.whatIfLet(
    given: Boolean?,
    whatIf: (T) -> R,
    whatIfNot: (T) -> R
): R {

    if (given == true) {
        return whatIf(this)
    }
    return whatIfNot(this)
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> T?.whatIfNotNull(
    whatIf: (T) -> Unit
): T? {

    return this.whatIfNotNull(
        whatIf = whatIf,
        whatIfNot = { }
    )
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T> T?.whatIfNotNull(
    whatIf: (T) -> Unit,
    whatIfNot: () -> Unit
): T? {

    if (this != null) {
        whatIf(this)
        return this
    }
    whatIfNot()
    return this
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <reified R> Any?.whatIfNotNullAs(
    whatIf: (R) -> Unit
): Any? {

    return whatIfNotNullAs(
        whatIf = whatIf,
        whatIfNot = { }
    )
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <reified R> Any?.whatIfNotNullAs(
    whatIf: (R) -> Unit,
    whatIfNot: () -> Unit
): Any? {

    if (this != null && this is R) {
        whatIf(this as R)
        return this
    }
    whatIfNot()
    return this
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun <T, R> T?.whatIfNotNullWith(
    whatIf: (T) -> R,
    whatIfNot: (T?) -> R
): R {

    if (this != null) {
        return whatIf(this)
    }
    return whatIfNot(this)
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun Boolean?.whatIf(
    whatIf: () -> Unit
): Boolean? {

    return this.whatIf(
        whatIf = whatIf,
        whatIfNot = { }
    )
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun Boolean?.whatIf(
    whatIf: () -> Unit,
    whatIfNot: () -> Unit
): Boolean? {

    if (this == true) {
        whatIf()
    } else {
        whatIfNot()
    }
    return this
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun Boolean?.whatIfElse(
    whatIf: () -> Unit
): Boolean? {

    if (this == false) {
        whatIf()
    }
    return this
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun Boolean?.whatIfAnd(
    predicate: Boolean?,
    whatIf: () -> Unit
): Boolean? {

    if (this == true && predicate == true) {
        whatIf()
    }
    return this
}

@JvmSynthetic
@WhatIfInlineOnly
public inline fun Boolean?.whatIfOr(
    predicate: Boolean?,
    whatIf: () -> Unit
): Boolean? {

    if (this == true || predicate == true) {
        whatIf()
    }
    return this
}
