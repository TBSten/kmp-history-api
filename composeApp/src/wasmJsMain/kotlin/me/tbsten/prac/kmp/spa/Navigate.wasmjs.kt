package me.tbsten.prac.kmp.spa

import kotlinx.browser.window

actual fun navigate(path: String) {
    window.history.pushState(null, "", path)
}
