package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class Fulltext() {
  public var all_Words: String? = null

  public var any_Words: String? = null

  public var without_Words: String? = null

  public var wordgroup: String? = null

  public var withBlobs: WithBlobs? = null

  public var near_by_Span: Int? = 0

  public var thesaurus: List<String>? = null

  public var use_Synonyms: Use_Synonyms? = null

  public var use_Broader_Terms: Use_Broader_Terms? = null

  public var use_Narrow_Terms: Use_Narrow_Terms? = null

  public var entity: List<String>? = null

  public var relation: List<String>? = null

  public constructor(
      all_Words: String?,
      any_Words: String?,
      without_Words: String?,
      wordgroup: String?,
      withBlobs: WithBlobs?,
      near_by_Span: Int?,
      thesaurus: List<String>?,
      use_Synonyms: Use_Synonyms?,
      use_Broader_Terms: Use_Broader_Terms?,
      use_Narrow_Terms: Use_Narrow_Terms?,
      entity: List<String>?,
      relation: List<String>?
  ) : this() {
    this.all_Words = all_Words
    this.any_Words = any_Words
    this.without_Words = without_Words
    this.wordgroup = wordgroup
    this.withBlobs = withBlobs
    this.near_by_Span = near_by_Span
    this.thesaurus = thesaurus
    this.use_Synonyms = use_Synonyms
    this.use_Broader_Terms = use_Broader_Terms
    this.use_Narrow_Terms = use_Narrow_Terms
    this.entity = entity
    this.relation = relation
  }
}
