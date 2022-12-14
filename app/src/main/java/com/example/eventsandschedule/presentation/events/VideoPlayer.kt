package com.example.eventsandschedule.presentation.events

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

@Composable
fun VideoPlayer(eventVideoUrl: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val mContext = LocalContext.current

        val mExoPlayer = remember(mContext) {
            ExoPlayer.Builder(mContext).build().apply {
                val dataSourceFactory = DefaultDataSourceFactory(
                    mContext,
                    Util.getUserAgent(mContext, mContext.packageName)
                )
                val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(Uri.parse(eventVideoUrl))
                prepare(source)
            }
        }

        AndroidView(factory = { context ->
            PlayerView(context).apply {
                player = mExoPlayer
            }
        })
    }
}