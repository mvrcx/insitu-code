package p20.insitu.db.documentation

import android.content.Context
import co.touchlab.kermit.Logger
import com.couchbase.lite.*

const val DATABASE_LOCAL_NAME: String = "local"
const val DATABASE_CLOUD_NAME: String = "Test"
const val DATABASE_DEMO_CLOUD_NAME: String = "demo"

class CouchbaseLogger(private val log: Logger, logLevel: LogLevel = LogLevel.DEBUG): com.couchbase.lite.Logger {
    private val level: LogLevel = logLevel

    override fun getLevel(): LogLevel {
        return level
    }

    override fun log(level: LogLevel, domain: LogDomain, message: String) {
        // this method will never be called if param level < this.level
        // handle the message, for example piping it to a third party framework
        when (level) {
            LogLevel.DEBUG -> log.d(message)
            LogLevel.ERROR -> log.e(message)
            LogLevel.INFO -> log.i(message)
            LogLevel.WARNING -> log.w(message)
            else -> log.d(message)
        }
    }
}

fun provideDatabase(
    context: Context,
    log: Logger
    //cryptographyHandler: ICryptographyHandler,
    //encryptedPreferencesHandler: EncryptedPreferencesHandler
): Database? {
    var database: Database? = null
    try {
        CouchbaseLite.init(context)
        val config = DatabaseConfiguration()
        //config.encryptionKey = EncryptionKey(cryptographyHandler.getMasterKeyAlias())
        database = Database(DATABASE_CLOUD_NAME, config)
//            when {
//            encryptedPreferencesHandler.isServerConnectionCloud() -> {
//                log.debug("Local database (${DATABASE_CLOUD_NAME}) for cloud sync is used.")
//                Database(DATABASE_CLOUD_NAME, config)
//            }
//            encryptedPreferencesHandler.isServerConnectionDemoCloud() -> {
//                log.debug("Local database (${DATABASE_DEMO_CLOUD_NAME}) is used.")
//                Database(DATABASE_DEMO_CLOUD_NAME, config)
//            }
//            else -> {
//                log.debug("Local database (${DATABASE_LOCAL_NAME}) is used.")
//                Database(DATABASE_LOCAL_NAME, config)
//            }
//        }
        Database.log.custom = CouchbaseLogger(log)


        database.createIndex(
            "ix_objectType",
            IndexBuilder.valueIndex(
                ValueIndexItem.property(entityType)
            )
        )

        database.createIndex(
            "ix_objectType_targetId_sourceId",
            IndexBuilder.valueIndex(
                ValueIndexItem.property(entityType),
                ValueIndexItem.property(targetId),
                ValueIndexItem.property(sourceId)
            )
        )

        database.createIndex(
            "ix_targetId",
            IndexBuilder.valueIndex(
                ValueIndexItem.property(targetId)
            )
        )

        database.createIndex(
            "ix_sourceId",
            IndexBuilder.valueIndex(
                ValueIndexItem.property(sourceId)
            )
        )

        database.createIndex(
            "ix_targetType",
            IndexBuilder.valueIndex(
                ValueIndexItem.property(targetType)
            )
        )

        database.createIndex(
            "ix_sourceType",
            IndexBuilder.valueIndex(
                ValueIndexItem.property(sourceType)
            )
        )
    } catch (ex: CouchbaseLiteException) {
        log.e("Failed to initialize Database: ${ex.localizedMessage}",  ex)
    } catch (ex: NullPointerException) {
        log.e("Failed to initialize Database: ${ex.localizedMessage}", ex)
    }
    return database
}