package com.arch.shared.annotations

@Target(
    AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION
)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class UseCase()
