package com.test.events.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.LayoutInflater
import android.view.View
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.test.events.R

class MapUtil {
    companion object {
        fun createCustomMarkerIcon(context: Context): BitmapDescriptor {
            val customMarkerView =
                LayoutInflater.from(context).inflate(R.layout.view_map_marker, null)

            customMarkerView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
            customMarkerView.layout(
                0,
                0,
                customMarkerView.measuredWidth,
                customMarkerView.measuredHeight
            )

            val customMarkerBitmap = Bitmap.createBitmap(
                customMarkerView.measuredWidth,
                customMarkerView.measuredHeight,
                Bitmap.Config.ARGB_8888
            )

            val canvas = Canvas(customMarkerBitmap)
            customMarkerView.draw(canvas)

            return BitmapDescriptorFactory.fromBitmap(customMarkerBitmap)
        }
    }
}