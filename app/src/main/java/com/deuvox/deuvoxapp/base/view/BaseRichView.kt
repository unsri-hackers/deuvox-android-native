package com.deuvox.deuvoxapp.base.view

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.FrameLayout
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable


abstract class BaseRichView<Binding> : FrameLayout {
    open val binding: Binding by lazy {
        getViewBinding()
    }

    constructor(@NotNull context: Context) : super(context) {
        init(context, null)
    }

    constructor(@NotNull context: Context, @Nullable attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(
        @NotNull context: Context,
        @Nullable attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        @NotNull context: Context,
        @Nullable attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(context, attrs)
    }

    @SuppressLint("ResourceType")
    private fun init(context: Context, attrs: AttributeSet?) {
        parseAttrs(context, attrs)
        setup()
    }

    abstract fun getViewBinding(): Binding

    protected open fun setup() {
        // Override to Setup View
    }

    protected open fun parseAttrs(context: Context, attrs: AttributeSet?) {
        // Override to Parse Attrs
    }
}