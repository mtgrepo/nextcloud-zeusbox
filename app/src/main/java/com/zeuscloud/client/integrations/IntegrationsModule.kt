package com.zeuscloud.client.integrations

import android.content.Context
import android.content.pm.PackageManager
import com.zeuscloud.client.integrations.deck.DeckApi
import com.zeuscloud.client.integrations.deck.DeckApiImpl
import dagger.Module
import dagger.Provides

@Module
class IntegrationsModule {
    @Provides
    fun deckApi(context: Context, packageManager: PackageManager): DeckApi {
        return DeckApiImpl(context, packageManager)
    }
}
