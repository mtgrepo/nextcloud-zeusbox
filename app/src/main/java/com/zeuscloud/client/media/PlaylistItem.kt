package com.zeuscloud.client.media

import com.zeuscloud.client.account.User
import com.owncloud.android.datamodel.OCFile

data class PlaylistItem(val file: OCFile, val startPositionMs: Long, val autoPlay: Boolean, val user: User)
