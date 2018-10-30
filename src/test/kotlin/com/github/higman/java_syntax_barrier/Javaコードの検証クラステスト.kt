package com.github.higman.java_syntax_barrier

import com.github.higman.java_syntax_barrier.unit_sample.SampleVerificationUnit
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class Javaコードの検証クラステスト {

    private lateinit var syntaxVerifierBuilder: SyntaxVerifierBuilder

    private val sampleCode = """
            class A {
                int a = 10;
            }

            class B extends A {
                int b = 10;
                var aa = 12;
            }

            abstract class C extends A { }

            """.trimIndent()

    @BeforeEach
    fun setUp() {
        syntaxVerifierBuilder = SyntaxVerifierBuilder()
    }

    @Test
    fun SyntaxVerifierBuilderによる検証インスタンスの生成() {
        val syntaxVerifier = try {
            syntaxVerifierBuilder.register(SampleVerificationUnit()).build()
        } catch (e: NullPointerException) {
            fail<SyntaxVerifier>("NullPointerException発生")
        }
        assertNotNull(syntaxVerifier)
        assertTrue(syntaxVerifier.verify(JavaCodeData(sampleCode)))
    }
}