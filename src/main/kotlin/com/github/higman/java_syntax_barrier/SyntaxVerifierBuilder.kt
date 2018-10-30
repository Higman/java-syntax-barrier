package com.github.higman.java_syntax_barrier

import java.nio.file.Files
import java.nio.file.Path

/**
 *
 */
class SyntaxVerifierBuilder {

    private var units: List<VerificationUnit>? = null

    /**
     * 検証条件の登録メソッド<br>
     * SyntaxVerifierインスタンスで利用される、検証条件を登録する。<br>
     * 検証条件を引数で指定する（可変長引数）。<br>
     *
     * @param vers 登録する検証条件群
     * @return 登録後のSyntaxVerifierBuilderインスタンス
     */
    fun register(vararg vers: VerificationUnit): SyntaxVerifierBuilder {
        units = vers.toList()
        return this
    }

    /**
     * 検証条件の登録メソッド<br>
     * SyntaxVerifierインスタンスで利用される、検証条件を登録する。<br>
     * 検証条件はXMLフォーマットで指定する。検証条件が記述されたXMLファイルのパスを引数で指定する。
     * @param xmlFile 読み込む検証条件を記述したXMLファイルのパス
     * @exception IllegalArgumentException 指定したXMLファイルのパスが不適切なら発生
     * @return 登録後のSyntaxVerifierBuilderインスタンス
     * @deprecated 未実装
     */
    fun register(xmlFile: Path): SyntaxVerifierBuilder {
        throw UnsupportedOperationException("未実装です。")
        if (!Files.exists(xmlFile)) throw IllegalArgumentException("不適切な引数です(ファイルが存在しません)。")
        if (Files.isRegularFile(xmlFile)) throw IllegalArgumentException("不適切な引数です(適切なファイルではありません)。")
        if (!xmlFile.endsWith(".xml")) throw IllegalArgumentException("不適切な引数です(拡張子がxmlではありません)。")

        // TODO: XMLファイルによる検証条件読み込み機能を実装
        return this
    }

    /**
     * Javaコードを検証するための構文検証クラスSyntaxVerifierを生成するメソッド<br>
     * @throws NullPointerException registerメソッドで検証条件を登録してない場合、発生
     * @return 生成したSyntaxVerifierインスタンスを生成
     */
    @Throws(NullPointerException::class)
    fun build(): SyntaxVerifier {
        return units?.let { SyntaxVerifier(it) } ?: throw NullPointerException("registerメソッドで検証条件を登録してください。")
    }
}