package com.github.higman.java_syntax_barrier

/**
 *
 */
class SyntaxVerifierBuilder {
    /**
     * Javaコードを検証するための構文検証クラスSyntaxVerifierを生成するメソッド<br>
     */
    fun create(): SyntaxVerifier {
        return SyntaxVerifier(mutableListOf())
    }
}