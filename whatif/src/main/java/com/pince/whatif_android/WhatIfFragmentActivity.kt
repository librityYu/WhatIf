/*
 * Designed and developed by 2019 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pince.whatif_android


import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.pince.whatif.WhatIfInlineOnly
import com.pince.whatif.whatIfNotNullAs

/**
 * @author skydoves (Jaewoong Eum)
 *
 * An expression for invoking [whatIf] when the [FragmentActivity] has an attached fragment [T].
 *
 * @param id A fragment currently on the back stack associated with this ID resource.
 * @param whatIf An executable lambda function if the [FragmentActivity] has a fragment [T].
 */
@JvmSynthetic
@WhatIfInlineOnly
inline fun <reified T : Fragment> FragmentActivity.whatIfFindFragment(
  @IdRes id: Int,
  whatIf: (T) -> Unit
) {
  whatIfFindFragment(id, whatIf, {})
}

/**
 * @author skydoves (Jaewoong Eum)
 *
 * An expression for invoking [whatIf] when the [FragmentActivity] has an attached fragment [T].
 * If [FragmentActivity] has not an attached fragment [T], [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param id A fragment currently on the back stack associated with this ID resource.
 * @param whatIf An executable lambda function if the [FragmentActivity] has a fragment [T].
 * @param whatIfNot An executable lambda function if the [FragmentActivity] has not an attached fragment [T].
 */
@JvmSynthetic
@WhatIfInlineOnly
inline fun <reified T : Fragment> FragmentActivity.whatIfFindFragment(
  @IdRes id: Int,
  whatIf: (T) -> Unit,
  whatIfNot: () -> Unit
) {
  supportFragmentManager.findFragmentById(id).whatIfNotNullAs(whatIf, whatIfNot)
}

/**
 * @author skydoves (Jaewoong Eum)
 *
 * An expression for invoking [whatIf] when the [FragmentActivity] has an attached fragment [T].
 *
 * @param id A fragment currently on the back stack associated with this tag name.
 * @param whatIf An executable lambda function if the [FragmentActivity] has a fragment [T].
 */
@JvmSynthetic
@WhatIfInlineOnly
inline fun <reified T : Fragment> FragmentActivity.whatIfFindFragment(
  tag: String?,
  whatIf: (T) -> Unit
) {
  whatIfFindFragment(tag, whatIf, {})
}

/**
 * @author skydoves (Jaewoong Eum)
 *
 * An expression for invoking [whatIf] when the [FragmentActivity] has an attached fragment [T].
 * If [FragmentActivity] has not an attached fragment [T], [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param tag A fragment currently on the back stack associated with this tag name.
 * @param whatIf An executable lambda function if the [FragmentActivity] has a fragment [T].
 * @param whatIfNot An executable lambda function if the [FragmentActivity] has not an attached fragment [T].
 */
@JvmSynthetic
@WhatIfInlineOnly
inline fun <reified T : Fragment> FragmentActivity.whatIfFindFragment(
  tag: String?,
  whatIf: (T) -> Unit,
  whatIfNot: () -> Unit
) {
  supportFragmentManager.findFragmentByTag(tag).whatIfNotNullAs(whatIf, whatIfNot)
}
