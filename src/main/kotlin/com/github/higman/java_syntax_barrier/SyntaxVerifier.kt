package com.github.higman.java_syntax_barrier

class SyntaxVerifier internal constructor(private val verificationUnits: List<VerificationUnit>): Verifier {
    override fun verify(code: JavaCodeData): Boolean {
        return verificationUnits.all { it.result(code) }
    }
}
