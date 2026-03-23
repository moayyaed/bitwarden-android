package com.x8bit.bitwarden.data.billing.manager

import com.bitwarden.core.data.manager.model.FlagKey
import kotlinx.coroutines.flow.StateFlow

/**
 * Manages the consolidated eligibility state for the Premium upgrade banner.
 *
 * Combines multiple upstream signals (Premium status, billing support, feature flag,
 * banner dismissal, account age, and vault item count) into a single observable flow.
 */
interface PremiumStateManager {

    /**
     * Emits `true` when the current user is eligible to see the Premium upgrade banner,
     * or `false` otherwise.
     */
    val isPremiumUpgradeBannerEligibleFlow: StateFlow<Boolean>

    /**
     * Emits `true` when the in-app upgrade flow is available (i.e., in-app billing is
     * supported and the [FlagKey.MobilePremiumUpgrade] feature flag is enabled),
     * or `false` otherwise.
     */
    val isInAppUpgradeAvailableFlow: StateFlow<Boolean>

    /**
     * Marks the Premium upgrade banner as dismissed for the current user.
     */
    fun dismissPremiumUpgradeBanner()
}
