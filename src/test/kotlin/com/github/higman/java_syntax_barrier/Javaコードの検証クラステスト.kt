package com.github.higman.java_syntax_barrier

import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Javaコードの検証クラステスト {

    private lateinit var syntaxVerifierBuilder: SyntaxVerifierBuilder

    @BeforeEach
    fun setUp() {
        syntaxVerifierBuilder = SyntaxVerifierBuilder()
    }

    @Test
    fun SyntaxVerifierBuilderによる検証インスタンスの生成() {
        val syntaxVerifier = syntaxVerifierBuilder.create()
        assertNotNull(syntaxVerifier)
    }
}