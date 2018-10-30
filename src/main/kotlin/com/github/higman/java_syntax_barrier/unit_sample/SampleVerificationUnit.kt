package com.github.higman.java_syntax_barrier.unit_sample

import com.github.higman.java_syntax_barrier.VerificationUnit
import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.visitor.GenericVisitorAdapter

class SampleVerificationUnit : VerificationUnit() {
    override fun verifyProcess(parser: CompilationUnit): Boolean {
        val result = parser.accept(object : GenericVisitorAdapter<ClassOrInterfaceDeclaration, String>() {
            override fun visit(n: ClassOrInterfaceDeclaration, arg: String): ClassOrInterfaceDeclaration? {
                return if (n.isAbstract && n.extendedTypes.any { it.nameAsString == "A" }) n else super.visit(n, arg)
            }
        }, "")
        return result != null
    }

}