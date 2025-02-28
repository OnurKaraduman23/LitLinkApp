package com.onuryasarkaraduman.ui

object SplashContract {

    sealed interface UiEffect{
        data object NavigateOnboarding: UiEffect
        data object NavigateLogin: UiEffect
        data object NavigateHome: UiEffect
    }
}