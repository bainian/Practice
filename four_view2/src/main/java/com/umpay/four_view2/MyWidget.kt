package com.umpay.four_view2

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Bundle
import android.widget.RemoteViews
import org.jetbrains.anko.doAsync

/**
 * Created by sage on 16-9-9.
 */
class MyWidget : AppWidgetProvider() {

    override fun onAppWidgetOptionsChanged(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetId: Int, newOptions: Bundle?) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions)
        log("onAppWidgetOptionsChanged")
    }

    override fun onDeleted(context: Context?, appWidgetIds: IntArray?) {
        super.onDeleted(context, appWidgetIds)
        log("onDeleted")
    }

    override fun onDisabled(context: Context?) {
        super.onDisabled(context)
        log("onDisable")

    }

    override fun onEnabled(context: Context?) {
        super.onEnabled(context)
        log("onEnable")
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        log("onReceive")
        if (intent.action.equals("com.fnz.widget.click")) {
            doAsync {
                val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.coding)
                val instance = AppWidgetManager.getInstance(context)
                for (i in 0..37) {
                    val degree = (i * 10) % 360
                    val remoteView = RemoteViews(context.packageName, R.layout.my_widget)
                    remoteView.setImageViewBitmap(R.id.imageView, rotateBitmap(context, bitmap, degree))
                    val intent = Intent()
                    intent.action = "com.fnz.widget.click"
                    val pendIntent = PendingIntent.getBroadcast(context, 0, intent, 0)
                    remoteView.setOnClickPendingIntent(R.id.imageView, pendIntent)
                    instance.updateAppWidget(ComponentName(context, MyWidget::class.java), remoteView)
//                    SystemClock.sleep(30)
                }
            }
        }
    }
//
//    override fun onRestored(context: Context?, oldWidgetIds: IntArray?, newWidgetIds: IntArray?) {
//        super.onRestored(context, oldWidgetIds, newWidgetIds)
//        log("onRestored")
//    }

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        val size = appWidgetIds.size
        log("onUpdate count $size")
        for (i in 0..size - 1) {
            val id = appWidgetIds[i]

            val remoteView = RemoteViews(context.packageName, R.layout.my_widget)
            val intent = Intent()
            intent.action = "com.fnz.widget.click"
            val pendIntent = PendingIntent.getBroadcast(context, 0, intent, 0)
            remoteView.setOnClickPendingIntent(R.id.imageView, pendIntent)
            context.sendBroadcast(intent)
            appWidgetManager.updateAppWidget(id, remoteView)
        }

    }

    fun rotateBitmap(context: Context, bitmap: Bitmap, degree: Int): Bitmap {
        val matrix = Matrix()
        matrix.reset()
        matrix.setRotate(degree.toFloat())
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)

    }


}