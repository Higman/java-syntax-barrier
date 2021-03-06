package com.github.higman.java_syntax_barrier

import com.github.javaparser.JavaParser
import com.github.javaparser.ParseProblemException
import com.github.javaparser.ParseStart.COMPILATION_UNIT
import com.github.javaparser.Providers.provider
import com.github.javaparser.ast.CompilationUnit

/**
 * Javaコードの検証ユニット<br>
 * SyntaxVerifierクラスで
 * @see SyntaxVerifier
 */
abstract class VerificationUnit {

    /**
     * Javaコードの検証結果を取得するメソッド<br>
     * verifyProcessメソッドを呼び出し、コードの検証を行う。<br>
     * @param javaCodeData Javaコード情報
     * @exception ParseProblemException 指定したJavaコードの構文解析が失敗した際に発生
     * @return Javaコードの構文が正しければTrue、誤っていればFalseを返却する
     */
    @Throws(ParseProblemException::class)
    fun result(javaCodeData: JavaCodeData): Boolean {
        // 抽象構文木情報
        val parser = JavaParser.parse(javaCodeData.code)
        return verifyProcess(parser.clone())
    }

    /**
     * Javaコードの検証処理を行うメソッド<br>
     * 引数の抽象構文木を元に、Javaコードの検証を行う。<br>
     * @param parser 検証するJavaコードの抽象構文木情報
     * @return Javaコードの構文が正しければTrue、誤っていればFalseを返却する
     */
    abstract fun verifyProcess(parser: CompilationUnit): Boolean
}
