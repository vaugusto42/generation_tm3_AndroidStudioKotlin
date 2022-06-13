package com.generation.todoapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// essa notação diz que o Hilt está habilitado no app
@HiltAndroidApp
class TodoApplication : Application() {
}